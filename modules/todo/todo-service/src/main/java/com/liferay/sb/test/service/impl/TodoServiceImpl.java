// 
/*   */ 
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
/*  */ 


package com.liferay.sb.test.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.sb.test.constants.TodoConstants;
import com.liferay.sb.test.exception.TodoValidateException;
import com.liferay.sb.test.model.Todo;
import com.liferay.sb.test.service.base.TodoServiceBaseImpl;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * The implementation of the Todo remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sb.test.service.TodoService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author diegofurtado
 * @see TodoServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=todo",
		"json.web.service.context.path=Todo"
	},
	service = AopService.class
)
public class TodoServiceImpl extends TodoServiceBaseImpl {

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
	public Todo addEntry(Todo orgEntry, ServiceContext serviceContext)
		throws PortalException, TodoValidateException {

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return todoLocalService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return Todo
	 * @throws PortalException
	 */
	public void deleteEntry(long primaryKey) throws PortalException {
		_todoModelResourcePermission.check(
			getPermissionChecker(), primaryKey, ActionKeys.DELETE);

		todoLocalService.deleteEntry(primaryKey);
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
	public Todo getInitializedTodo(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return todoLocalService.getNewObject(primaryKey);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public Todo getNewObject(long primaryKey, ServiceContext serviceContext)
		throws PrincipalException {

		primaryKey = (primaryKey <= 0) ? 0 :
		counterLocalService.increment(Todo.class.getName());

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.UPDATE);

		return todoLocalService.getNewObject(primaryKey);
	}

	/**
	 * Returns the todo with the primary key.
	 *
	 * @param todoId the primary key of the sample sb
	 * @return the todo
	 * @throws PortalException if a todo with the primary key could not be found
	 */
	@Override
	public Todo getTodo(long primaryKey) throws PortalException {
		_todoModelResourcePermission.check(
			getPermissionChecker(), primaryKey, ActionKeys.VIEW);

		return todoLocalService.getTodo(primaryKey);
	}

	/**
	 * Returns the todo
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public Todo getTodo(long groupId, String urlTitle)
		throws PortalException {

		Todo entry = todoLocalService.getTodo(groupId, urlTitle);

		_todoModelResourcePermission.check(
			getPermissionChecker(), entry, ActionKeys.VIEW);

		return entry;
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	public Todo getTodoFromRequest(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.VIEW);

		return todoLocalService.getTodoFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return Todo
	 * @throws PortalException
	 */
	public Todo moveEntryToTrash(long entryId) throws PortalException {
		_todoModelResourcePermission.check(
			getPermissionChecker(), entryId, ActionKeys.DELETE);

		return todoLocalService.moveEntryToTrash(getUserId(), entryId);
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
	public Todo updateEntry(
			Todo orgEntry, ServiceContext serviceContext)
		throws PortalException, TodoValidateException {

		_todoModelResourcePermission.check(
			getPermissionChecker(), orgEntry.getPrimaryKey(),
			ActionKeys.UPDATE);

		return todoLocalService.updateEntry(orgEntry, serviceContext);
	}

	private static volatile ModelResourcePermission<Todo>
		_todoModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				TodoServiceImpl.class, "_todoModelResourcePermission",
				Todo.class);

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(resource.name=" + TodoConstants.RESOURCE_NAME + ")"
	)
	private volatile PortletResourcePermission _portletResourcePermission;

}