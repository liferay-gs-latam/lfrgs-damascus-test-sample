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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.sb.test.exception.TodoValidateException;
import com.liferay.sb.test.model.Todo;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Todo. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author "diegofurtado"
 * @see TodoServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TodoService extends BaseService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TodoServiceUtil} to access the todo remote service. Add custom service methods to <code>com.liferay.sb.test.service.impl.TodoServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	public Todo addEntry(Todo orgEntry, ServiceContext serviceContext)
		throws PortalException, TodoValidateException;

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return Todo
	 * @throws PortalException
	 */
	public void deleteEntry(long primaryKey) throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getInitializedTodo(long primaryKey, PortletRequest request)
		throws PortalException, PortletException;

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getNewObject(long primaryKey, ServiceContext serviceContext)
		throws PrincipalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Returns the todo with the primary key.
	 *
	 * @param todoId the primary key of the sample sb
	 * @return the todo
	 * @throws PortalException if a todo with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getTodo(long primaryKey) throws PortalException;

	/**
	 * Returns the todo
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getTodo(long groupId, String urlTitle) throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getTodoFromRequest(long primaryKey, PortletRequest request)
		throws PortalException, PortletException;

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return Todo
	 * @throws PortalException
	 */
	public Todo moveEntryToTrash(long entryId) throws PortalException;

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       Todo model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception TodoValidateException
	 * @return updated Todo model.
	 */
	public Todo updateEntry(Todo orgEntry, ServiceContext serviceContext)
		throws PortalException, TodoValidateException;

}