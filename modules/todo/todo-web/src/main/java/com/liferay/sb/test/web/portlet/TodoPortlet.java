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
package com.liferay.sb.test.web.portlet;

import aQute.bnd.annotation.metatype.Configurable;

import com.liferay.asset.constants.AssetWebKeys;
import com.liferay.asset.util.AssetHelper;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.sb.test.constants.TodoPortletKeys;
import com.liferay.sb.test.web.portlet.action.TodoConfiguration;
import com.liferay.trash.TrashHelper;
import com.liferay.trash.util.TrashWebKeys;

import java.io.IOException;

import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * Portlet
 *
 * @author yasuflatland
 */
@Component(
	configurationPid = TodoPortletKeys.TODO_CONFIG, immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.application-type=full-page-application",
		"com.liferay.portlet.application-type=widget",
		"com.liferay.portlet.css-class-wrapper=portlet-todo",
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/todo/css/main.css",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.struts-path=todo",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Todo",
		"javax.portlet.init-param.mvc-command-names-default-views=/todo/view",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.always-display-default-configuration-icons=true",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.name=" + TodoPortletKeys.TODO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user"
	},
	service = Portlet.class
)
public class TodoPortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderRequest.setAttribute(AssetWebKeys.ASSET_HELPER, _assetHelper);
		renderRequest.setAttribute(TrashWebKeys.TRASH_HELPER, _trashHelper);
		renderRequest.setAttribute(
			TodoConfiguration.class.getName(), _todoConfiguration);

		super.render(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_todoConfiguration = Configurable.createConfigurable(
			TodoConfiguration.class, properties);
	}

	@Override
	protected void doDispatch(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderRequest.setAttribute(
			TodoConfiguration.class.getName(), _todoConfiguration);

		super.doDispatch(renderRequest, renderResponse);
	}

	@Reference
	private AssetHelper _assetHelper;

	private volatile TodoConfiguration _todoConfiguration;

	@Reference
	private TrashHelper _trashHelper;

}