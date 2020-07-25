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

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.sb.test.constants.TodoPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * PanelApp
 *
 * This class is used to display a portet in the product menu
 *
 * @author diegofurtado
 */
@Component(
    immediate = true,
    property = {
        "panel.app.order:Integer=100", //TODO : this number determin the order in the panel
        "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
    },
    service = PanelApp.class
)
public class TodoPanelApp extends BasePanelApp  {

	@Override
	public String getPortletId() {
		return TodoPortletKeys.TODO_ADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + TodoPortletKeys.TODO_ADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}