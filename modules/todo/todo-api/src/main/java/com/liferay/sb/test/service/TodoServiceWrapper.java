/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sb.test.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TodoService}.
 *
 * @author "diegofurtado"
 * @see TodoService
 * @generated
 */
public class TodoServiceWrapper
	implements ServiceWrapper<TodoService>, TodoService {

	public TodoServiceWrapper(TodoService todoService) {
		_todoService = todoService;
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       Todo model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception TodoValidateException
	 * @return created Todo model.
	 */
	@Override
	public com.liferay.sb.test.model.Todo addEntry(
			com.liferay.sb.test.model.Todo orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.TodoValidateException {

		return _todoService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return Todo
	 * @throws PortalException
	 */
	@Override
	public void deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		_todoService.deleteEntry(primaryKey);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public com.liferay.sb.test.model.Todo getInitializedTodo(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _todoService.getInitializedTodo(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	@Override
	public com.liferay.sb.test.model.Todo getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _todoService.getNewObject(primaryKey, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _todoService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the todo with the primary key.
	 *
	 * @param todoId the primary key of the sample sb
	 * @return the todo
	 * @throws PortalException if a todo with the primary key could not be found
	 */
	@Override
	public com.liferay.sb.test.model.Todo getTodo(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoService.getTodo(primaryKey);
	}

	/**
	 * Returns the todo
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@Override
	public com.liferay.sb.test.model.Todo getTodo(long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoService.getTodo(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public com.liferay.sb.test.model.Todo getTodoFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _todoService.getTodoFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return Todo
	 * @throws PortalException
	 */
	@Override
	public com.liferay.sb.test.model.Todo moveEntryToTrash(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoService.moveEntryToTrash(entryId);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       Todo model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception TodoValidateException
	 * @return updated Todo model.
	 */
	@Override
	public com.liferay.sb.test.model.Todo updateEntry(
			com.liferay.sb.test.model.Todo orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.TodoValidateException {

		return _todoService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public TodoService getWrappedService() {
		return _todoService;
	}

	@Override
	public void setWrappedService(TodoService todoService) {
		_todoService = todoService;
	}

	private TodoService _todoService;

}