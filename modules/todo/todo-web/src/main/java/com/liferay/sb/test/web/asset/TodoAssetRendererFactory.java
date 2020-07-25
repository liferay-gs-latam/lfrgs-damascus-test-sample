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
package com.liferay.sb.test.web.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;
import com.liferay.sb.test.constants.TodoConstants;
import com.liferay.sb.test.constants.TodoPortletKeys;
import com.liferay.sb.test.model.Todo;
import com.liferay.sb.test.service.TodoLocalService;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Todo Asset Renderer Factory
 *
 * @author diegofurtado
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + TodoPortletKeys.TODO,
	service = AssetRendererFactory.class
)
public class TodoAssetRendererFactory
	extends BaseAssetRendererFactory<Todo> {

	public static final String SYMBOLIC_NAME =
		TodoConstants.RESOURCE_NAME + ".web";

	public static final String TYPE = "todo";

	public TodoAssetRendererFactory() {
		setClassName(Todo.class.getName());
		setCategorizable(true);
		setPortletId(TodoPortletKeys.TODO);
		setLinkable(true);
		setSearchable(true);
		setSelectable(true);
	}

	@Override
	public AssetRenderer<Todo> getAssetRenderer(long classPK, int type)
		throws PortalException {

		TodoAssetRenderer todoAssetRenderer = new TodoAssetRenderer(
			_todoLocalService.getTodo(classPK),
			ResourceBundleLoaderUtil.
				getResourceBundleLoaderByBundleSymbolicName(SYMBOLIC_NAME));

		todoAssetRenderer.setAssetRendererType(type);
		todoAssetRenderer.setServletContext(_servletContext);

		return todoAssetRenderer;
	}

	@Override
	public AssetRenderer<Todo> getAssetRenderer(
			long groupId, String urlTitle)
		throws PortalException {

		Todo entry = _todoLocalService.getTodo(groupId, urlTitle);

		TodoAssetRenderer todoAssetRenderer = new TodoAssetRenderer(
			entry,
			ResourceBundleLoaderUtil.
				getResourceBundleLoaderByBundleSymbolicName(SYMBOLIC_NAME));

		todoAssetRenderer.setServletContext(_servletContext);

		return todoAssetRenderer;
	}

	@Override
	public String getClassName() {
		return Todo.class.getName();
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public PortletURL getURLAdd(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse, long classTypeId) {

		PortletURL portletURL = _portal.getControlPanelPortletURL(
			liferayPortletRequest, getGroup(liferayPortletRequest),
			TodoPortletKeys.TODO_ADMIN, 0, 0,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcRenderCommandName", "/todo/crud");
		portletURL.setParameter(Constants.CMD, Constants.ADD);
		portletURL.setParameter("fromAsset", StringPool.TRUE);

		return portletURL;
	}

	@Override
	public PortletURL getURLView(
		LiferayPortletResponse liferayPortletResponse,
		WindowState windowState) {

		LiferayPortletURL liferayPortletURL =
			liferayPortletResponse.createLiferayPortletURL(
				TodoPortletKeys.TODO_ADMIN,
				PortletRequest.RENDER_PHASE);

		liferayPortletURL.setParameter(
			"mvcRenderCommandName", "/todo/view");
		liferayPortletURL.setParameter(Constants.CMD, Constants.VIEW);
		liferayPortletURL.setParameter("fromAsset", StringPool.TRUE);

		try {
			liferayPortletURL.setWindowState(windowState);
		}
		catch (WindowStateException wse) {
			_log.error("Windos state is not valid. Skip.", wse);
		}

		return liferayPortletURL;
	}

	@Override
	public boolean hasAddPermission(
			PermissionChecker permissionChecker, long groupId, long classTypeId)
		throws Exception {

		if (_portletResourcePermission.contains(
				permissionChecker, groupId, ActionKeys.VIEW)) {

			return false;
		}

		return _portletResourcePermission.contains(
			permissionChecker, groupId, ActionKeys.ADD_ENTRY);
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return _todoModelResourcePermission.contains(
			permissionChecker, classPK, actionId);
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.sb.test.web)", unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		TodoAssetRendererFactory.class);

	@Reference
	private Portal _portal;

	@Reference(
		target = "(resource.name=" + TodoConstants.RESOURCE_NAME + ")"
	)
	private PortletResourcePermission _portletResourcePermission;

	@Reference
	private TodoLocalService _todoLocalService;

	@Reference(target = "(model.class.name=com.liferay.sb.test.model.Todo)")
	private ModelResourcePermission<Todo> _todoModelResourcePermission;

	@Reference(target = "(osgi.web.symbolicname=" + SYMBOLIC_NAME + ")")
	private ServletContext _servletContext;

}