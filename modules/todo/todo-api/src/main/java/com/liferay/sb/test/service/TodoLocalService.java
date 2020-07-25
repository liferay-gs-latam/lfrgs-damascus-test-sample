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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.sb.test.exception.TodoValidateException;
import com.liferay.sb.test.model.Todo;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Todo. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author "diegofurtado"
 * @see TodoLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TodoLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TodoLocalServiceUtil} to access the todo local service. Add custom service methods to <code>com.liferay.sb.test.service.impl.TodoLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	@Indexable(type = IndexableType.REINDEX)
	public Todo addEntry(Todo orgEntry, ServiceContext serviceContext)
		throws PortalException, TodoValidateException;

	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(
			long entryId, ModelPermissions modelPermissions)
		throws PortalException;

	public void addEntryResources(
			Todo entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(Todo entry, ModelPermissions modelPermissions)
		throws PortalException;

	/**
	 * Adds the todo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param todo the todo
	 * @return the todo that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Todo addTodo(Todo todo);

	public int countAllInGroup(long groupId);

	public int countAllInGroup(long groupId, int[] status);

	public int countAllInUser(long userId);

	public int countAllInUser(long userId, int[] status);

	public int countAllInUserAndGroup(long userId, long groupId);

	public int countAllInUserAndGroup(long userId, long groupId, int[] status);

	/**
	 * Creates a new todo with the primary key. Does not add the todo to the database.
	 *
	 * @param todoId the primary key for the new todo
	 * @return the new todo
	 */
	@Transactional(enabled = false)
	public Todo createTodo(long todoId);

	/**
	 * Delete entry
	 */
	public Todo deleteEntry(long primaryKey) throws PortalException;

	/**
	 * Delete entry
	 *
	 * @param entry Todo
	 * @return Todo oject
	 * @exception PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public Todo deleteEntry(Todo entry) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo that was removed
	 * @throws PortalException if a todo with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Todo deleteTodo(long todoId) throws PortalException;

	/**
	 * Deletes the todo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todo the todo
	 * @return the todo that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Todo deleteTodo(Todo todo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo fetchTodo(long todoId);

	/**
	 * Returns the todo matching the UUID and group.
	 *
	 * @param uuid the todo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo fetchTodoByUuidAndGroupId(String uuid, long groupId);

	public List<Todo> findAllInGroup(long groupId);

	public List<Todo> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator);

	public List<Todo> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator, int[] status);

	public List<Todo> findAllInGroup(long groupId, int[] status);

	public List<Todo> findAllInGroup(
		long groupId, OrderByComparator<Todo> orderByComparator);

	public List<Todo> findAllInUser(long userId);

	public List<Todo> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<Todo> orderByComparator);

	public List<Todo> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<Todo> orderByComparator, int[] status);

	public List<Todo> findAllInUser(long userId, int[] status);

	public List<Todo> findAllInUser(
		long userId, OrderByComparator<Todo> orderByComparator);

	public List<Todo> findAllInUserAndGroup(long userId, long groupId);

	public List<Todo> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator);

	public List<Todo> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator, int[] status);

	public List<Todo> findAllInUserAndGroup(
		long userId, long groupId, int[] status);

	public List<Todo> findAllInUserAndGroup(
		long userId, long groupId, OrderByComparator<Todo> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Todo> getCompanyEntries(
		long companyId, int status, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Todo> getCompanyEntries(
		long companyId, int status, int start, int end,
		OrderByComparator<Todo> obc);

	/**
	 * Get Company entries counts
	 *
	 * @param companyId
	 * @param status
	 * @return
	 * @throws SystemException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCompanyEntriesCount(long companyId, int status);

	/**
	 * Converte Date Time into Date()
	 *
	 * @param request PortletRequest
	 * @param prefix  Prefix of the parameter
	 * @return Date object
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Date getDateTimeFromRequest(PortletRequest request, String prefix);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getInitializedTodo(long primaryKey, PortletRequest request)
		throws PortletException;

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return Todo object
	 * @throws PortletException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getNewObject(long primaryKey);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Get STATUS_ANY for DB
	 *
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int[] getStatusAny();

	/**
	 * Returns the todo with the primary key.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo
	 * @throws PortalException if a todo with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getTodo(long todoId) throws PortalException;

	/**
	 * Get Entity
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getTodo(long groupId, String urlTitle) throws PortalException;

	/**
	 * Returns the todo matching the UUID and group.
	 *
	 * @param uuid the todo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching todo
	 * @throws PortalException if a matching todo could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getTodoByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 * @throws TodoValidateException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Todo getTodoFromRequest(long primaryKey, PortletRequest request)
		throws PortletException, TodoValidateException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Todo> getTodos(int start, int end);

	/**
	 * Returns all the todos matching the UUID and company.
	 *
	 * @param uuid the UUID of the todos
	 * @param companyId the primary key of the company
	 * @return the matching todos, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Todo> getTodosByUuidAndCompanyId(String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Todo> getTodosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Todo> orderByComparator);

	/**
	 * Returns the number of todos.
	 *
	 * @return the number of todos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTodosCount();

	public Todo moveEntryToTrash(long userId, long entryId)
		throws PortalException;

	/**
	 * Moves the entry to the recycle bin.
	 *
	 * Social activity counters for this entry get disabled.
	 *
	 * @param userId the primary key of the user moving the entry
	 * @param entry  the entry to be moved
	 * @return the moved entry
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Todo moveEntryToTrash(long userId, Todo entry)
		throws PortalException;

	/**
	 * Restores the entry with the ID from the recycle bin. Social activity counters
	 * for this entry get activated.
	 *
	 * @param userId  the primary key of the user restoring the entry
	 * @param entryId the primary key of the entry to be restored
	 * @return the restored entry from the recycle bin
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Todo restoreEntryFromTrash(long userId, long entryId)
		throws PortalException;

	public void updateAsset(
			long userId, Todo entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException;

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       Todo model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception TodoValidateException
	 * @return updated Todo model.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Todo updateEntry(Todo orgEntry, ServiceContext serviceContext)
		throws PortalException, TodoValidateException;

	public void updateEntryResources(
			Todo entry, String[] groupPermissions, String[] guestPermissions)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public Todo updateStatus(
			long userId, long entryId, int status,
			ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException;

	/**
	 * Updates the todo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param todo the todo
	 * @return the todo that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Todo updateTodo(Todo todo);

}