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
 * Provides a wrapper for {@link TodoLocalService}.
 *
 * @author "diegofurtado"
 * @see TodoLocalService
 * @generated
 */
public class TodoLocalServiceWrapper
	implements ServiceWrapper<TodoLocalService>, TodoLocalService {

	public TodoLocalServiceWrapper(TodoLocalService todoLocalService) {
		_todoLocalService = todoLocalService;
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

		return _todoLocalService.addEntry(orgEntry, serviceContext);
	}

	@Override
	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_todoLocalService.addEntryResources(
			entryId, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_todoLocalService.addEntryResources(entryId, modelPermissions);
	}

	@Override
	public void addEntryResources(
			com.liferay.sb.test.model.Todo entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_todoLocalService.addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			com.liferay.sb.test.model.Todo entry,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_todoLocalService.addEntryResources(entry, modelPermissions);
	}

	/**
	 * Adds the todo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param todo the todo
	 * @return the todo that was added
	 */
	@Override
	public com.liferay.sb.test.model.Todo addTodo(
		com.liferay.sb.test.model.Todo todo) {

		return _todoLocalService.addTodo(todo);
	}

	@Override
	public int countAllInGroup(long groupId) {
		return _todoLocalService.countAllInGroup(groupId);
	}

	@Override
	public int countAllInGroup(long groupId, int[] status) {
		return _todoLocalService.countAllInGroup(groupId, status);
	}

	@Override
	public int countAllInUser(long userId) {
		return _todoLocalService.countAllInUser(userId);
	}

	@Override
	public int countAllInUser(long userId, int[] status) {
		return _todoLocalService.countAllInUser(userId, status);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId) {
		return _todoLocalService.countAllInUserAndGroup(userId, groupId);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
		return _todoLocalService.countAllInUserAndGroup(
			userId, groupId, status);
	}

	/**
	 * Creates a new todo with the primary key. Does not add the todo to the database.
	 *
	 * @param todoId the primary key for the new todo
	 * @return the new todo
	 */
	@Override
	public com.liferay.sb.test.model.Todo createTodo(long todoId) {
		return _todoLocalService.createTodo(todoId);
	}

	/**
	 * Delete entry
	 */
	@Override
	public com.liferay.sb.test.model.Todo deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.deleteEntry(primaryKey);
	}

	/**
	 * Delete entry
	 *
	 * @param entry Todo
	 * @return Todo oject
	 * @exception PortalException
	 */
	@Override
	public com.liferay.sb.test.model.Todo deleteEntry(
			com.liferay.sb.test.model.Todo entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.deleteEntry(entry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo that was removed
	 * @throws PortalException if a todo with the primary key could not be found
	 */
	@Override
	public com.liferay.sb.test.model.Todo deleteTodo(long todoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.deleteTodo(todoId);
	}

	/**
	 * Deletes the todo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todo the todo
	 * @return the todo that was removed
	 */
	@Override
	public com.liferay.sb.test.model.Todo deleteTodo(
		com.liferay.sb.test.model.Todo todo) {

		return _todoLocalService.deleteTodo(todo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _todoLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _todoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sb.test.model.impl.TodoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _todoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sb.test.model.impl.TodoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _todoLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _todoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _todoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.sb.test.model.Todo fetchTodo(long todoId) {
		return _todoLocalService.fetchTodo(todoId);
	}

	/**
	 * Returns the todo matching the UUID and group.
	 *
	 * @param uuid the todo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public com.liferay.sb.test.model.Todo fetchTodoByUuidAndGroupId(
		String uuid, long groupId) {

		return _todoLocalService.fetchTodoByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInGroup(
		long groupId) {

		return _todoLocalService.findAllInGroup(groupId);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.Todo> orderByComparator) {

		return _todoLocalService.findAllInGroup(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.Todo> orderByComparator,
		int[] status) {

		return _todoLocalService.findAllInGroup(
			groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInGroup(
		long groupId, int[] status) {

		return _todoLocalService.findAllInGroup(groupId, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInGroup(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.Todo> orderByComparator) {

		return _todoLocalService.findAllInGroup(groupId, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInUser(
		long userId) {

		return _todoLocalService.findAllInUser(userId);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.Todo> orderByComparator) {

		return _todoLocalService.findAllInUser(
			userId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.Todo> orderByComparator,
		int[] status) {

		return _todoLocalService.findAllInUser(
			userId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInUser(
		long userId, int[] status) {

		return _todoLocalService.findAllInUser(userId, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInUser(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.Todo> orderByComparator) {

		return _todoLocalService.findAllInUser(userId, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInUserAndGroup(
		long userId, long groupId) {

		return _todoLocalService.findAllInUserAndGroup(userId, groupId);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.Todo> orderByComparator) {

		return _todoLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.Todo> orderByComparator,
		int[] status) {

		return _todoLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInUserAndGroup(
		long userId, long groupId, int[] status) {

		return _todoLocalService.findAllInUserAndGroup(userId, groupId, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> findAllInUserAndGroup(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.Todo> orderByComparator) {

		return _todoLocalService.findAllInUserAndGroup(
			userId, groupId, orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _todoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Get Company entries
	 *
	 * @param companyId Company Id
	 * @param status    Workflow status
	 * @param start     start index of entries
	 * @param end       end index of entries
	 * @return
	 * @throws SystemException
	 */
	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> getCompanyEntries(
		long companyId, int status, int start, int end) {

		return _todoLocalService.getCompanyEntries(
			companyId, status, start, end);
	}

	/**
	 * Get Company entries
	 *
	 * @param companyId Company Id
	 * @param status    Workflow status
	 * @param start     start index of entries
	 * @param end       end index of entries
	 * @param obc       Comparator for the order
	 * @return List of entries
	 * @throws SystemException
	 */
	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> getCompanyEntries(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.Todo> obc) {

		return _todoLocalService.getCompanyEntries(
			companyId, status, start, end, obc);
	}

	/**
	 * Get Company entries counts
	 *
	 * @param companyId
	 * @param status
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int getCompanyEntriesCount(long companyId, int status) {
		return _todoLocalService.getCompanyEntriesCount(companyId, status);
	}

	/**
	 * Converte Date Time into Date()
	 *
	 * @param request PortletRequest
	 * @param prefix  Prefix of the parameter
	 * @return Date object
	 */
	@Override
	public java.util.Date getDateTimeFromRequest(
		javax.portlet.PortletRequest request, String prefix) {

		return _todoLocalService.getDateTimeFromRequest(request, prefix);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _todoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _todoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 */
	@Override
	public com.liferay.sb.test.model.Todo getInitializedTodo(
			long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException {

		return _todoLocalService.getInitializedTodo(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return Todo object
	 * @throws PortletException
	 */
	@Override
	public com.liferay.sb.test.model.Todo getNewObject(long primaryKey) {
		return _todoLocalService.getNewObject(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _todoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Get STATUS_ANY for DB
	 *
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	@Override
	public int[] getStatusAny() {
		return _todoLocalService.getStatusAny();
	}

	/**
	 * Returns the todo with the primary key.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo
	 * @throws PortalException if a todo with the primary key could not be found
	 */
	@Override
	public com.liferay.sb.test.model.Todo getTodo(long todoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.getTodo(todoId);
	}

	/**
	 * Get Entity
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@Override
	public com.liferay.sb.test.model.Todo getTodo(long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.getTodo(groupId, urlTitle);
	}

	/**
	 * Returns the todo matching the UUID and group.
	 *
	 * @param uuid the todo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching todo
	 * @throws PortalException if a matching todo could not be found
	 */
	@Override
	public com.liferay.sb.test.model.Todo getTodoByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.getTodoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 * @throws TodoValidateException
	 */
	@Override
	public com.liferay.sb.test.model.Todo getTodoFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.sb.test.exception.TodoValidateException,
			   javax.portlet.PortletException {

		return _todoLocalService.getTodoFromRequest(primaryKey, request);
	}

	/**
	 * Returns a range of all the todos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sb.test.model.impl.TodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of todos
	 */
	@Override
	public java.util.List<com.liferay.sb.test.model.Todo> getTodos(
		int start, int end) {

		return _todoLocalService.getTodos(start, end);
	}

	/**
	 * Returns all the todos matching the UUID and company.
	 *
	 * @param uuid the UUID of the todos
	 * @param companyId the primary key of the company
	 * @return the matching todos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.sb.test.model.Todo>
		getTodosByUuidAndCompanyId(String uuid, long companyId) {

		return _todoLocalService.getTodosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of todos matching the UUID and company.
	 *
	 * @param uuid the UUID of the todos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching todos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.sb.test.model.Todo>
		getTodosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.sb.test.model.Todo> orderByComparator) {

		return _todoLocalService.getTodosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of todos.
	 *
	 * @return the number of todos
	 */
	@Override
	public int getTodosCount() {
		return _todoLocalService.getTodosCount();
	}

	@Override
	public com.liferay.sb.test.model.Todo moveEntryToTrash(
			long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.moveEntryToTrash(userId, entryId);
	}

	/**
	 * Moves the entry to the recycle bin.
	 *
	 * Social activity counters for this entry get disabled.
	 *
	 * @param userId the primary key of the user moving the entry
	 * @param entry  the entry to be moved
	 * @return the moved entry
	 */
	@Override
	public com.liferay.sb.test.model.Todo moveEntryToTrash(
			long userId, com.liferay.sb.test.model.Todo entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.moveEntryToTrash(userId, entry);
	}

	/**
	 * Restores the entry with the ID from the recycle bin. Social activity counters
	 * for this entry get activated.
	 *
	 * @param userId  the primary key of the user restoring the entry
	 * @param entryId the primary key of the entry to be restored
	 * @return the restored entry from the recycle bin
	 */
	@Override
	public com.liferay.sb.test.model.Todo restoreEntryFromTrash(
			long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.restoreEntryFromTrash(userId, entryId);
	}

	@Override
	public void updateAsset(
			long userId, com.liferay.sb.test.model.Todo entry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws com.liferay.portal.kernel.exception.PortalException {

		_todoLocalService.updateAsset(
			userId, entry, assetCategoryIds, assetTagNames, assetLinkEntryIds,
			priority);
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

		return _todoLocalService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public void updateEntryResources(
			com.liferay.sb.test.model.Todo entry, String[] groupPermissions,
			String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_todoLocalService.updateEntryResources(
			entry, groupPermissions, guestPermissions);
	}

	@Override
	public com.liferay.sb.test.model.Todo updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoLocalService.updateStatus(
			userId, entryId, status, serviceContext, workflowContext);
	}

	/**
	 * Updates the todo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param todo the todo
	 * @return the todo that was updated
	 */
	@Override
	public com.liferay.sb.test.model.Todo updateTodo(
		com.liferay.sb.test.model.Todo todo) {

		return _todoLocalService.updateTodo(todo);
	}

	@Override
	public TodoLocalService getWrappedService() {
		return _todoLocalService;
	}

	@Override
	public void setWrappedService(TodoLocalService todoLocalService) {
		_todoLocalService = todoLocalService;
	}

	private TodoLocalService _todoLocalService;

}