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

package com.liferay.sb.test.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.sb.test.constants.TodoPortletKeys;
import com.liferay.sb.test.exception.TodoValidateException;
import com.liferay.sb.test.model.Todo;
import com.liferay.sb.test.service.TodoService;
import com.liferay.sb.test.web.constants.TodoWebKeys;
import com.liferay.sb.test.web.internal.security.permission.resource.TodoEntryPermission;
import com.liferay.sb.test.web.upload.TodoItemSelectorHelper;

// //
//  //

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * CRUD Render
 *
 * @author diegofurtado
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TodoPortletKeys.TODO,
		"mvc.command.name=/todo/crud"
	},
	service = MVCRenderCommand.class
)
public class TodoCrudMVCRenderCommand implements MVCRenderCommand {

	/**
	 * Edit Page JSP file
	 */
	public String getEditPageJSP() {
		return TodoWebKeys.EDIT_JSP;
	}

	/**
	 * View Page JSP file
	 */
	public String getViewPageJSP() {
		return TodoWebKeys.VIEW_JSP;
	}

	/**
	 * View Record JSP file
	 */
	public String getViewRecordPageJSP() {
		return TodoWebKeys.VIEW_RECORD_JSP;
	}

	@Override
	public String render(RenderRequest request, RenderResponse response)
		throws PortletException {

		String renderJSP = getViewPageJSP();

		// Fetch command

		String cmd = ParamUtil.getString(request, Constants.CMD);

		// Fetch primary key

		long primaryKey = ParamUtil.getLong(request, "resourcePrimKey", 0);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			if (cmd.equalsIgnoreCase(Constants.UPDATE)) {
				renderJSP = update(request, themeDisplay, primaryKey);
			}
			else if (cmd.equalsIgnoreCase(Constants.VIEW)) {
				renderJSP = view(request, themeDisplay, primaryKey);
			}
			else {
				renderJSP = add(request, themeDisplay, primaryKey);
			}
		}
		catch (PortalException pe) {
			throw new PortletException(pe.getMessage());
		}

//  //
// //
		
		request.setAttribute(
			TodoWebKeys.TODO_ITEM_SELECTOR_HELPER,
			_todoItemSelectorHelper);

		return renderJSP;
	}

	/**
	 * Add record
	 *
	 * @param request
	 * @param themeDisplay
	 * @param primaryKey
	 * @return JSP file path
	 * @throws PortalException
	 * @throws TodoValidateException
	 * @throws PortletException
	 */
	protected String add(
			RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
		throws PortalException, PortletException, TodoValidateException {

		Todo record = null;

		if (Validator.isNull(request.getParameter("addErrors"))) {
			record = _todoService.getInitializedTodo(
				primaryKey, request);
		}
		else {
			record = _todoService.getTodoFromRequest(
				primaryKey, request);
		}

		request.setAttribute("todo", record);

		return getEditPageJSP();
	}

	/**
	 * Update record
	 *
	 * @param request
	 * @param themeDisplay
	 * @param primaryKey
	 * @return JSP file path to open
	 * @throws PortalException
	 * @throws TodoValidateException
	 */
	protected String update(
			RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
		throws PortalException, TodoValidateException {

		Todo record = _todoService.getTodo(primaryKey);

		if (!TodoEntryPermission.contains(
				themeDisplay.getPermissionChecker(), record,
				ActionKeys.UPDATE)) {

			List<String> error = new ArrayList<>();
			error.add("permission-error");

			throw new TodoValidateException(error);
		}

		request.setAttribute("todo", record);

		return getEditPageJSP();
	}

	/**
	 * View record
	 *
	 * @param request
	 * @param themeDisplay
	 * @param primaryKey
	 * @return
	 * @throws PortalException
	 * @throws TodoValidateException
	 */
	protected String view(
			RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
		throws PortalException, TodoValidateException {

		Todo record = _todoService.getTodo(primaryKey);

		if (!TodoEntryPermission.contains(
				themeDisplay.getPermissionChecker(), record, ActionKeys.VIEW)) {

			List<String> error = new ArrayList<>();
			error.add("permission-error");

			throw new TodoValidateException(error);
		}

		request.setAttribute("todo", record);

		return getViewRecordPageJSP();
	}

	@Reference
	private TodoService _todoService;

//  //
// //

	@Reference
	private TodoItemSelectorHelper _todoItemSelectorHelper;

}
