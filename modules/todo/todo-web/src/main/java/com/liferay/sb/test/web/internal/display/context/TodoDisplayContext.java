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
package com.liferay.sb.test.web.internal.display.context;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.sb.test.constants.TodoPortletKeys;
import com.liferay.sb.test.model.Todo;
import com.liferay.sb.test.web.internal.security.permission.resource.TodoEntryPermission;
import com.liferay.sb.test.web.util.TodoViewHelper;
import com.liferay.trash.TrashHelper;

import java.text.ParseException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * Todo Display Context
 *
 * @author diegofurtado
 */
public class TodoDisplayContext {

	public TodoDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse, TrashHelper trashHelper,
		TodoViewHelper todoViewHelper) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_trashHelper = trashHelper;

		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
			liferayPortletRequest);

		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();
		_todoViewHelper = todoViewHelper;
	}

	public List<String> getAvailableActions(Todo entry)
		throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)_httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		if (TodoEntryPermission.contains(
				themeDisplay.getPermissionChecker(), entry,
				ActionKeys.DELETE)) {

			return Collections.singletonList("deleteEntries");
		}

		return Collections.emptyList();
	}

	public Map<String, Object> getComponentContext() throws PortalException {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)_httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		return new HashMap<String, Object>() {
			{
				put(
					"trashEnabled",
					_trashHelper.isTrashEnabled(
						themeDisplay.getScopeGroupId()));
			}
		};
	}

	public String getDisplayStyle() {
		String displayStyle = ParamUtil.getString(
			_httpServletRequest, "displayStyle");

		if (Validator.isNull(displayStyle)) {
			return _portalPreferences.getValue(
				TodoPortletKeys.TODO_ADMIN, "entries-display-style",
				"icon");
		}

		_portalPreferences.setValue(
			TodoPortletKeys.TODO_ADMIN, "entries-display-style",
			displayStyle);

		_httpServletRequest.setAttribute(
			WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);

		return displayStyle;
	}

	public SearchContainer<Todo> getSearchContainer()
		throws ParseException, PortalException, PortletException {

		PortletURL navigationPortletURL =
			_liferayPortletResponse.createRenderURL();

		String keywords = ParamUtil.getString(
			_httpServletRequest, DisplayTerms.KEYWORDS);
		int cur = ParamUtil.getInteger(
			_httpServletRequest, SearchContainer.DEFAULT_CUR_PARAM);
		String orderByCol = ParamUtil.getString(
			_httpServletRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM,
			"todoId");
		String orderByType = ParamUtil.getString(
			_httpServletRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM,
			"asc");

		navigationPortletURL.setParameter(DisplayTerms.KEYWORDS, keywords);
		navigationPortletURL.setParameter(
			SearchContainer.DEFAULT_CUR_PARAM, String.valueOf(cur));
		navigationPortletURL.setParameter(
			"mvcRenderCommandName", "/todo/view");
		navigationPortletURL.setParameter(
			SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, orderByCol);
		navigationPortletURL.setParameter(
			SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, orderByType);

		SearchContainer<Todo> _searchContainer = new SearchContainer<>(
			_liferayPortletRequest,
			PortletURLUtil.clone(navigationPortletURL, _liferayPortletResponse),
			null, "no-records-were-found");

		_searchContainer.setId("entryList");
		_searchContainer.setDeltaConfigurable(true);

		_searchContainer.setOrderByCol(orderByCol);
		_searchContainer.setOrderByType(orderByType);

		SearchContainerResults<Todo> searchContainerResults = null;

		if (Validator.isNull(keywords)) {
			searchContainerResults = _todoViewHelper.getListFromDB(
				_liferayPortletRequest, _searchContainer,
				new int[] {WorkflowConstants.STATUS_APPROVED});
		}
		else {
			searchContainerResults = _todoViewHelper.getListFromIndex(
				_liferayPortletRequest, _searchContainer,
				WorkflowConstants.STATUS_APPROVED);
		}

		_searchContainer.setTotal(searchContainerResults.getTotal());
		_searchContainer.setResults(searchContainerResults.getResults());

		return _searchContainer;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		TodoDisplayContext.class);

	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;
	private TodoViewHelper _todoViewHelper;
	private final TrashHelper _trashHelper;

}