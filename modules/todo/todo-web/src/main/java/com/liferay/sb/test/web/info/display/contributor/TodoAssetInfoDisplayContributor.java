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
package com.liferay.sb.test.web.info.display.contributor;

import com.liferay.asset.info.display.contributor.BaseAssetInfoDisplayContributor;
import com.liferay.info.display.contributor.InfoDisplayContributor;
import com.liferay.sb.test.model.Todo;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * Todo Asset Info Display Contributor
 * 
 * @author diegofurtado
 *
 */
@Component(immediate = true, service = InfoDisplayContributor.class)
public class TodoAssetInfoDisplayContributor extends BaseAssetInfoDisplayContributor<Todo> {

	@Override
	public String getClassName() {
		return Todo.class.getName();
	}

	@Override
	public String getInfoURLSeparator() {
		return "/todo/";
	}

	@Override
	protected Map<String, Object> getClassTypeValues(Todo assetEntryObject, Locale locale) {
		return new HashMap<>();
	}

}
