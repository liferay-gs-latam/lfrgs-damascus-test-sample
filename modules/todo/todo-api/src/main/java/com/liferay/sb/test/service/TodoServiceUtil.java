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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Todo. This utility wraps
 * <code>com.liferay.sb.test.service.impl.TodoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author "diegofurtado"
 * @see TodoService
 * @generated
 */
public class TodoServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sb.test.service.impl.TodoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Add Entry
	 *
	 * @param orgEntry       Todo model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception TodoValidateException
	 * @return created Todo model.
	 */
	public static com.liferay.sb.test.model.Todo addEntry(
			com.liferay.sb.test.model.Todo orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.TodoValidateException {

		return getService().addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return Todo
	 * @throws PortalException
	 */
	public static void deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteEntry(primaryKey);
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
	public static com.liferay.sb.test.model.Todo getInitializedTodo(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return getService().getInitializedTodo(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public static com.liferay.sb.test.model.Todo getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getNewObject(primaryKey, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Returns the todo with the primary key.
	 *
	 * @param todoId the primary key of the sample sb
	 * @return the todo
	 * @throws PortalException if a todo with the primary key could not be found
	 */
	public static com.liferay.sb.test.model.Todo getTodo(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTodo(primaryKey);
	}

	/**
	 * Returns the todo
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public static com.liferay.sb.test.model.Todo getTodo(
			long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTodo(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	public static com.liferay.sb.test.model.Todo getTodoFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return getService().getTodoFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return Todo
	 * @throws PortalException
	 */
	public static com.liferay.sb.test.model.Todo moveEntryToTrash(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().moveEntryToTrash(entryId);
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
	public static com.liferay.sb.test.model.Todo updateEntry(
			com.liferay.sb.test.model.Todo orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.TodoValidateException {

		return getService().updateEntry(orgEntry, serviceContext);
	}

	public static TodoService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TodoService, TodoService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TodoService.class);

		ServiceTracker<TodoService, TodoService> serviceTracker =
			new ServiceTracker<TodoService, TodoService>(
				bundle.getBundleContext(), TodoService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}