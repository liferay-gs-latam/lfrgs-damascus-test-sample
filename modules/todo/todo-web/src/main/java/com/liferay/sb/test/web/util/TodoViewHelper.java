// 
//  //
/**
*  Copyright (C) 2020 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
//  //
package com.liferay.sb.test.web.util;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.sb.test.model.Todo;
import com.liferay.sb.test.service.TodoLocalServiceUtil;
import com.liferay.sb.test.web.portlet.action.TodoConfiguration;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * View Helper
 *
 * @author diegofurtado
 */
@Component(immediate = true, service = TodoViewHelper.class)
public class TodoViewHelper {

	/**
	 * Get Data list from Database
	 *
	 * @param request     PortletRequest
	 * @param start       int
	 * @param end         int
	 * @param orderByCol  String
	 * @param orderByType String
	 * @return SearchContainerResults<Todo>
	 * @throws ParseException
	 */
	public SearchContainerResults<Todo> getListFromDB(
			PortletRequest request, int start, int end, String orderByCol,
			String orderByType, int[] state)
		throws ParseException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);
		PortletPreferences portletPreferences = request.getPreferences();

		// Filter type

		String prefsViewType = portletPreferences.getValue(
			TodoConfiguration.CONF_PREFS_VIEW_TYPE,
			TodoConfiguration.PREFS_VIEW_TYPE_DEFAULT);

		long groupId = themeDisplay.getScopeGroupId();
		int containerStart = start;
		int containerEnd = end;

		List<Todo> results = new ArrayList<>();

		int total = 0;

		// Get Order

		OrderByComparator<Todo> orderByComparator = getOrderByComparator(
			orderByCol, orderByType);

		if (prefsViewType.equals(
				TodoConfiguration.PREFS_VIEW_TYPE_DEFAULT)) {

			results = TodoLocalServiceUtil.findAllInGroup(
				groupId, containerStart, containerEnd, orderByComparator,
				state);
			total = TodoLocalServiceUtil.countAllInGroup(groupId, state);
		}
		else if (prefsViewType.equals(
					TodoConfiguration.PREFS_VIEW_TYPE_USER)) {

			results = TodoLocalServiceUtil.findAllInUser(
				themeDisplay.getUserId(), containerStart, containerEnd,
				orderByComparator, state);
			total = TodoLocalServiceUtil.countAllInUser(
				themeDisplay.getUserId(), state);
		}
		else {
			results = TodoLocalServiceUtil.findAllInUserAndGroup(
				themeDisplay.getUserId(), groupId, containerStart, containerEnd,
				orderByComparator, state);
			total = TodoLocalServiceUtil.countAllInUserAndGroup(
				themeDisplay.getUserId(), groupId, state);
		}

		return new SearchContainerResults<>(results, total);
	}

	/**
	 * Get Data list from Database
	 *
	 * @param request         PortletRequest
	 * @param searchContainer SearchContainer<?>
	 * @return SearchContainerResults<Todo>
	 * @throws ParseException
	 */
	public SearchContainerResults<Todo> getListFromDB(
			PortletRequest request, SearchContainer<?> searchContainer,
			int[] state)
		throws ParseException {

		return getListFromDB(
			request, searchContainer.getStart(), searchContainer.getEnd(),
			searchContainer.getOrderByCol(), searchContainer.getOrderByType(),
			state);
	}

	/**
	 * Get Data list from Index
	 *
	 * @param request PortletRequest
	 * @param start   int
	 * @param end     int
	 * @throws SearchException
	 */
	public SearchContainerResults<Todo> getListFromIndex(
			PortletRequest request, int start, int end, int state)
		throws SearchException {

		// Search Key

		String searchFilter = ParamUtil.getString(
			request, DisplayTerms.KEYWORDS);

		Indexer<Todo> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			Todo.class);

		SearchContext searchContext = SearchContextFactory.getInstance(
			PortalUtil.getHttpServletRequest(request));

		// TODO : When WorkflowConstants.STATUS_ANY, this parameter should be set to
		// display all records in the list
		// searchContext.setAndSearch(true);

		searchContext.setAttribute(Field.STATUS, state);

		searchContext.setKeywords(searchFilter);
		searchContext.setStart(start);
		searchContext.setEnd(end);

		// Search in index

		Hits results = indexer.search(searchContext);

		// Initialize return values

		int total = results.getLength();
		List<Todo> tempResults = new ArrayList<>();

		for (int i = 0; i < results.getDocs().length; i++) {
			Document doc = results.doc(i);

			Todo resReg = null;

			// Entry

			long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

			try {
				resReg = TodoLocalServiceUtil.getTodo(entryId);

				resReg = resReg.toEscapedModel();

				tempResults.add(resReg);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Todo search index is stale and contains entry " +
							entryId);
				}

				continue;
			}
		}

		return new SearchContainerResults<>(tempResults, total);
	}

	/**
	 * Get Data list from Index
	 *
	 * @param request PortletRequest
	 * @return searchContainer SearchContainer<?>
	 * @throws SearchException
	 */
	public SearchContainerResults<Todo> getListFromIndex(
			PortletRequest request, SearchContainer<?> searchContainer,
			int state)
		throws SearchException {

		return getListFromIndex(
			request, searchContainer.getStart(), searchContainer.getEnd(),
			state);
	}

	/**
	 *
	 * Order Comparetor
	 *
	 * @param searchContainer
	 * @return OrderByComparator
	 */
	public OrderByComparator<Todo> getOrderByComparator(
		SearchContainer<?> searchContainer) {

		return getOrderByComparator(
			searchContainer.getOrderByCol(), searchContainer.getOrderByType());
	}

	/**
	 *
	 * Order Comparetor
	 *
	 * @param orderByCol
	 * @param orderByType
	 * @return OrderByComparator
	 */
	public OrderByComparator<Todo> getOrderByComparator(
		String orderByCol, String orderByType) {

		if (_log.isDebugEnabled()) {
			_log.debug(
				"searchContainer.getOrderByCol()" +
					(null != orderByCol ? orderByCol : "null"));
			_log.debug(
				"searchContainer.getOrderByType()" +
					(null != orderByType ? orderByType : "null"));
		}

		return OrderByComparatorFactoryUtil.create(
			"Todo_Todo", orderByCol, getOrder(orderByType));
	}

	/**
	 * Order string to boolean
	 *
	 * @param order
	 * @return if true if order is "asc" or false
	 */
	protected boolean getOrder(String order) {
		if ("asc".equalsIgnoreCase(order)) {
			return true;
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(TodoViewHelper.class);

}