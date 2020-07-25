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

package com.liferay.sb.test.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.sb.test.model.Todo;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the todo service. This utility wraps <code>com.liferay.sb.test.service.persistence.impl.TodoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "diegofurtado"
 * @see TodoPersistence
 * @generated
 */
public class TodoUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Todo todo) {
		getPersistence().clearCache(todo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Todo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Todo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Todo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Todo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Todo update(Todo todo) {
		return getPersistence().update(todo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Todo update(Todo todo, ServiceContext serviceContext) {
		return getPersistence().update(todo, serviceContext);
	}

	/**
	 * Returns all the todos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching todos
	 */
	public static List<Todo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the todos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByUuid_First(
			String uuid, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByUuid_First(
		String uuid, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByUuid_Last(
			String uuid, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByUuid_Last(
		String uuid, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where uuid = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByUuid_PrevAndNext(
			long todoId, String uuid, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUuid_PrevAndNext(
			todoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the todos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of todos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching todos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the todo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByUUID_G(String uuid, long groupId)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the todo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the todo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the todo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the todo that was removed
	 */
	public static Todo removeByUUID_G(String uuid, long groupId)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of todos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching todos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the todos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching todos
	 */
	public static List<Todo> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the todos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByUuid_C_PrevAndNext(
			long todoId, String uuid, long companyId,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			todoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the todos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of todos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching todos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the todos where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching todos
	 */
	public static List<Todo> findByC_S(long companyId, int status) {
		return getPersistence().findByC_S(companyId, status);
	}

	/**
	 * Returns a range of all the todos where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByC_S(
		long companyId, int status, int start, int end) {

		return getPersistence().findByC_S(companyId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByC_S(
			companyId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_S(
			companyId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByC_S_First(
			long companyId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByC_S_First(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByC_S_First(
		long companyId, int status, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByC_S_First(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByC_S_Last(
			long companyId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByC_S_Last(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByC_S_Last(
		long companyId, int status, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByC_S_Last(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByC_S_PrevAndNext(
			long todoId, long companyId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByC_S_PrevAndNext(
			todoId, companyId, status, orderByComparator);
	}

	/**
	 * Returns all the todos where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the matching todos
	 */
	public static List<Todo> findByC_S(long companyId, int[] statuses) {
		return getPersistence().findByC_S(companyId, statuses);
	}

	/**
	 * Returns a range of all the todos where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByC_S(
		long companyId, int[] statuses, int start, int end) {

		return getPersistence().findByC_S(companyId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByC_S(
			companyId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where companyId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_S(
			companyId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the todos where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	public static void removeByC_S(long companyId, int status) {
		getPersistence().removeByC_S(companyId, status);
	}

	/**
	 * Returns the number of todos where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	public static int countByC_S(long companyId, int status) {
		return getPersistence().countByC_S(companyId, status);
	}

	/**
	 * Returns the number of todos where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public static int countByC_S(long companyId, int[] statuses) {
		return getPersistence().countByC_S(companyId, statuses);
	}

	/**
	 * Returns all the todos where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching todos
	 */
	public static List<Todo> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the todos where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByG_S_First(
			long groupId, int status, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByG_S_First(
		long groupId, int status, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByG_S_Last(
			long groupId, int status, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByG_S_Last(
		long groupId, int status, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByG_S_PrevAndNext(
			long todoId, long groupId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByG_S_PrevAndNext(
			todoId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the todos that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the todos that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set of todos that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] filterFindByG_S_PrevAndNext(
			long todoId, long groupId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			todoId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_S(long groupId, int[] statuses) {
		return getPersistence().filterFindByG_S(groupId, statuses);
	}

	/**
	 * Returns a range of all the todos that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_S(
		long groupId, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the todos that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the todos where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching todos
	 */
	public static List<Todo> findByG_S(long groupId, int[] statuses) {
		return getPersistence().findByG_S(groupId, statuses);
	}

	/**
	 * Returns a range of all the todos where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByG_S(
		long groupId, int[] statuses, int start, int end) {

		return getPersistence().findByG_S(groupId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the todos where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of todos where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of todos where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public static int countByG_S(long groupId, int[] statuses) {
		return getPersistence().countByG_S(groupId, statuses);
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching todos that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching todos that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int[] statuses) {
		return getPersistence().filterCountByG_S(groupId, statuses);
	}

	/**
	 * Returns all the todos where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos
	 */
	public static List<Todo> findByC_U_S(
		long companyId, long userId, int status) {

		return getPersistence().findByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns a range of all the todos where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByC_U_S(
		long companyId, long userId, int status, int start, int end) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByC_U_S_First(
			long companyId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByC_U_S_First(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByC_U_S_First(
		long companyId, long userId, int status,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByC_U_S_First(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByC_U_S_Last(
			long companyId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByC_U_S_Last(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByC_U_S_Last(
		long companyId, long userId, int status,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByC_U_S_Last(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByC_U_S_PrevAndNext(
			long todoId, long companyId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByC_U_S_PrevAndNext(
			todoId, companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the todos where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching todos
	 */
	public static List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses) {

		return getPersistence().findByC_U_S(companyId, userId, statuses);
	}

	/**
	 * Returns a range of all the todos where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where companyId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the todos where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByC_U_S(long companyId, long userId, int status) {
		getPersistence().removeByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns the number of todos where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	public static int countByC_U_S(long companyId, long userId, int status) {
		return getPersistence().countByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns the number of todos where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public static int countByC_U_S(
		long companyId, long userId, int[] statuses) {

		return getPersistence().countByC_U_S(companyId, userId, statuses);
	}

	/**
	 * Returns all the todos where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos
	 */
	public static List<Todo> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the todos where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByG_U_S_PrevAndNext(
			long todoId, long groupId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByG_U_S_PrevAndNext(
			todoId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the todos that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set of todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] filterFindByG_U_S_PrevAndNext(
			long todoId, long groupId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().filterFindByG_U_S_PrevAndNext(
			todoId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().filterFindByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns a range of all the todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the todos where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching todos
	 */
	public static List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().findByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns a range of all the todos where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the todos where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of todos where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of todos where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public static int countByG_U_S(long groupId, long userId, int[] statuses) {
		return getPersistence().countByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().filterCountByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns all the todos where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos
	 */
	public static List<Todo> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the todos where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByU_S_First(
			long userId, int status, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByU_S_First(
		long userId, int status, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByU_S_Last(
			long userId, int status, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByU_S_Last(
		long userId, int status, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByU_S_PrevAndNext(
			long todoId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByU_S_PrevAndNext(
			todoId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the todos where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching todos
	 */
	public static List<Todo> findByU_S(long userId, int[] statuses) {
		return getPersistence().findByU_S(userId, statuses);
	}

	/**
	 * Returns a range of all the todos where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByU_S(
		long userId, int[] statuses, int start, int end) {

		return getPersistence().findByU_S(userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByU_S(
			userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the todos where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of todos where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns the number of todos where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public static int countByU_S(long userId, int[] statuses) {
		return getPersistence().countByU_S(userId, statuses);
	}

	/**
	 * Returns all the todos where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching todos
	 */
	public static List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().findByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns a range of all the todos where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByG_UT_ST_PrevAndNext(
			long todoId, long groupId, String urlTitle, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByG_UT_ST_PrevAndNext(
			todoId, groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().filterFindByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns a range of all the todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, status, start, end);
	}

	/**
	 * Returns an ordered range of all the todos that the user has permissions to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set of todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] filterFindByG_UT_ST_PrevAndNext(
			long todoId, long groupId, String urlTitle, int status,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().filterFindByG_UT_ST_PrevAndNext(
			todoId, groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses);
	}

	/**
	 * Returns a range of all the todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the todos where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching todos
	 */
	public static List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().findByG_UT_ST(groupId, urlTitle, statuses);
	}

	/**
	 * Returns a range of all the todos where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63; and urlTitle = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the todos where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	public static void removeByG_UT_ST(
		long groupId, String urlTitle, int status) {

		getPersistence().removeByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of todos where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching todos
	 */
	public static int countByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().countByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of todos where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public static int countByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().countByG_UT_ST(groupId, urlTitle, statuses);
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching todos that the user has permission to view
	 */
	public static int filterCountByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().filterCountByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching todos that the user has permission to view
	 */
	public static int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().filterCountByG_UT_ST(
			groupId, urlTitle, statuses);
	}

	/**
	 * Returns the todo where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByG_UT(long groupId, String urlTitle)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the todo where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByG_UT(long groupId, String urlTitle) {
		return getPersistence().fetchByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the todo where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache) {

		return getPersistence().fetchByG_UT(groupId, urlTitle, useFinderCache);
	}

	/**
	 * Removes the todo where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the todo that was removed
	 */
	public static Todo removeByG_UT(long groupId, String urlTitle)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().removeByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the number of todos where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching todos
	 */
	public static int countByG_UT(long groupId, String urlTitle) {
		return getPersistence().countByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the todo where urlTitle = &#63; or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByURLTitle(String urlTitle)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByURLTitle(urlTitle);
	}

	/**
	 * Returns the todo where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByURLTitle(String urlTitle) {
		return getPersistence().fetchByURLTitle(urlTitle);
	}

	/**
	 * Returns the todo where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByURLTitle(
		String urlTitle, boolean useFinderCache) {

		return getPersistence().fetchByURLTitle(urlTitle, useFinderCache);
	}

	/**
	 * Removes the todo where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the todo that was removed
	 */
	public static Todo removeByURLTitle(String urlTitle)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().removeByURLTitle(urlTitle);
	}

	/**
	 * Returns the number of todos where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching todos
	 */
	public static int countByURLTitle(String urlTitle) {
		return getPersistence().countByURLTitle(urlTitle);
	}

	/**
	 * Returns all the todos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching todos
	 */
	public static List<Todo> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the todos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByGroupId_First(
			long groupId, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByGroupId_First(
		long groupId, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByGroupId_Last(
			long groupId, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByGroupId_Last(
		long groupId, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where groupId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByGroupId_PrevAndNext(
			long todoId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByGroupId_PrevAndNext(
			todoId, groupId, orderByComparator);
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the todos that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the todos that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set of todos that the user has permission to view where groupId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] filterFindByGroupId_PrevAndNext(
			long todoId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			todoId, groupId, orderByComparator);
	}

	/**
	 * Removes all the todos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of todos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching todos
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching todos that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the todos where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching todos
	 */
	public static List<Todo> findByUserIdGroupId(long userId, long groupId) {
		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the todos where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByUserIdGroupId_First(
			long userId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUserIdGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByUserIdGroupId_First(
		long userId, long groupId, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByUserIdGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByUserIdGroupId_Last(
			long userId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUserIdGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByUserIdGroupId_Last(
		long userId, long groupId, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByUserIdGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByUserIdGroupId_PrevAndNext(
			long todoId, long userId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUserIdGroupId_PrevAndNext(
			todoId, userId, groupId, orderByComparator);
	}

	/**
	 * Returns all the todos that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByUserIdGroupId(
		long userId, long groupId) {

		return getPersistence().filterFindByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the todos that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().filterFindByUserIdGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the todos that the user has permissions to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos that the user has permission to view
	 */
	public static List<Todo> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().filterFindByUserIdGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set of todos that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] filterFindByUserIdGroupId_PrevAndNext(
			long todoId, long userId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().filterFindByUserIdGroupId_PrevAndNext(
			todoId, userId, groupId, orderByComparator);
	}

	/**
	 * Removes all the todos where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public static void removeByUserIdGroupId(long userId, long groupId) {
		getPersistence().removeByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns the number of todos where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching todos
	 */
	public static int countByUserIdGroupId(long userId, long groupId) {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns the number of todos that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching todos that the user has permission to view
	 */
	public static int filterCountByUserIdGroupId(long userId, long groupId) {
		return getPersistence().filterCountByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns all the todos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching todos
	 */
	public static List<Todo> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the todos where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByUserId_First(
			long userId, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByUserId_First(
		long userId, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByUserId_Last(
			long userId, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByUserId_Last(
		long userId, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where userId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByUserId_PrevAndNext(
			long todoId, long userId, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByUserId_PrevAndNext(
			todoId, userId, orderByComparator);
	}

	/**
	 * Removes all the todos where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of todos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching todos
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the todos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching todos
	 */
	public static List<Todo> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the todos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByCompanyId_First(
			long companyId, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByCompanyId_First(
		long companyId, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByCompanyId_Last(
			long companyId, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByCompanyId_Last(
		long companyId, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where companyId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByCompanyId_PrevAndNext(
			long todoId, long companyId,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByCompanyId_PrevAndNext(
			todoId, companyId, orderByComparator);
	}

	/**
	 * Removes all the todos where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of todos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching todos
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the todos where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @return the matching todos
	 */
	public static List<Todo> findByTodoId(long todoId) {
		return getPersistence().findByTodoId(todoId);
	}

	/**
	 * Returns a range of all the todos where todoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoId the todo ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByTodoId(long todoId, int start, int end) {
		return getPersistence().findByTodoId(todoId, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where todoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoId the todo ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoId(
		long todoId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByTodoId(
			todoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where todoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoId the todo ID
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoId(
		long todoId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTodoId(
			todoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoId_First(
			long todoId, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoId_First(todoId, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoId_First(
		long todoId, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoId_First(todoId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoId_Last(
			long todoId, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoId_Last(todoId, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoId_Last(
		long todoId, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoId_Last(todoId, orderByComparator);
	}

	/**
	 * Removes all the todos where todoId = &#63; from the database.
	 *
	 * @param todoId the todo ID
	 */
	public static void removeByTodoId(long todoId) {
		getPersistence().removeByTodoId(todoId);
	}

	/**
	 * Returns the number of todos where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @return the number of matching todos
	 */
	public static int countByTodoId(long todoId) {
		return getPersistence().countByTodoId(todoId);
	}

	/**
	 * Returns all the todos where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching todos
	 */
	public static List<Todo> findByTitle(String title) {
		return getPersistence().findByTitle(title);
	}

	/**
	 * Returns a range of all the todos where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByTitle(String title, int start, int end) {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTitle(
		String title, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTitle(
		String title, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTitle_First(
			String title, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTitle_First(
		String title, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTitle_Last(
			String title, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTitle_Last(
		String title, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where title = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByTitle_PrevAndNext(
			long todoId, String title,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTitle_PrevAndNext(
			todoId, title, orderByComparator);
	}

	/**
	 * Removes all the todos where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeByTitle(String title) {
		getPersistence().removeByTitle(title);
	}

	/**
	 * Returns the number of todos where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching todos
	 */
	public static int countByTitle(String title) {
		return getPersistence().countByTitle(title);
	}

	/**
	 * Returns all the todos where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @return the matching todos
	 */
	public static List<Todo> findByTodoBooleanStat(boolean todoBooleanStat) {
		return getPersistence().findByTodoBooleanStat(todoBooleanStat);
	}

	/**
	 * Returns a range of all the todos where todoBooleanStat = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByTodoBooleanStat(
		boolean todoBooleanStat, int start, int end) {

		return getPersistence().findByTodoBooleanStat(
			todoBooleanStat, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where todoBooleanStat = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoBooleanStat(
		boolean todoBooleanStat, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByTodoBooleanStat(
			todoBooleanStat, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where todoBooleanStat = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoBooleanStat(
		boolean todoBooleanStat, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTodoBooleanStat(
			todoBooleanStat, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoBooleanStat_First(
			boolean todoBooleanStat, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoBooleanStat_First(
			todoBooleanStat, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoBooleanStat_First(
		boolean todoBooleanStat, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoBooleanStat_First(
			todoBooleanStat, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoBooleanStat_Last(
			boolean todoBooleanStat, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoBooleanStat_Last(
			todoBooleanStat, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoBooleanStat_Last(
		boolean todoBooleanStat, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoBooleanStat_Last(
			todoBooleanStat, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByTodoBooleanStat_PrevAndNext(
			long todoId, boolean todoBooleanStat,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoBooleanStat_PrevAndNext(
			todoId, todoBooleanStat, orderByComparator);
	}

	/**
	 * Removes all the todos where todoBooleanStat = &#63; from the database.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 */
	public static void removeByTodoBooleanStat(boolean todoBooleanStat) {
		getPersistence().removeByTodoBooleanStat(todoBooleanStat);
	}

	/**
	 * Returns the number of todos where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @return the number of matching todos
	 */
	public static int countByTodoBooleanStat(boolean todoBooleanStat) {
		return getPersistence().countByTodoBooleanStat(todoBooleanStat);
	}

	/**
	 * Returns all the todos where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @return the matching todos
	 */
	public static List<Todo> findByTodoDateTime(Date todoDateTime) {
		return getPersistence().findByTodoDateTime(todoDateTime);
	}

	/**
	 * Returns a range of all the todos where todoDateTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoDateTime the todo date time
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByTodoDateTime(
		Date todoDateTime, int start, int end) {

		return getPersistence().findByTodoDateTime(todoDateTime, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where todoDateTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoDateTime the todo date time
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoDateTime(
		Date todoDateTime, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByTodoDateTime(
			todoDateTime, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where todoDateTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoDateTime the todo date time
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoDateTime(
		Date todoDateTime, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTodoDateTime(
			todoDateTime, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoDateTime_First(
			Date todoDateTime, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoDateTime_First(
			todoDateTime, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoDateTime_First(
		Date todoDateTime, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoDateTime_First(
			todoDateTime, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoDateTime_Last(
			Date todoDateTime, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoDateTime_Last(
			todoDateTime, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoDateTime_Last(
		Date todoDateTime, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoDateTime_Last(
			todoDateTime, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByTodoDateTime_PrevAndNext(
			long todoId, Date todoDateTime,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoDateTime_PrevAndNext(
			todoId, todoDateTime, orderByComparator);
	}

	/**
	 * Removes all the todos where todoDateTime = &#63; from the database.
	 *
	 * @param todoDateTime the todo date time
	 */
	public static void removeByTodoDateTime(Date todoDateTime) {
		getPersistence().removeByTodoDateTime(todoDateTime);
	}

	/**
	 * Returns the number of todos where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @return the number of matching todos
	 */
	public static int countByTodoDateTime(Date todoDateTime) {
		return getPersistence().countByTodoDateTime(todoDateTime);
	}

	/**
	 * Returns all the todos where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @return the matching todos
	 */
	public static List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary) {

		return getPersistence().findByTodoDocumentLibrary(todoDocumentLibrary);
	}

	/**
	 * Returns a range of all the todos where todoDocumentLibrary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary, int start, int end) {

		return getPersistence().findByTodoDocumentLibrary(
			todoDocumentLibrary, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where todoDocumentLibrary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByTodoDocumentLibrary(
			todoDocumentLibrary, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where todoDocumentLibrary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTodoDocumentLibrary(
			todoDocumentLibrary, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoDocumentLibrary_First(
			String todoDocumentLibrary,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoDocumentLibrary_First(
			todoDocumentLibrary, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoDocumentLibrary_First(
		String todoDocumentLibrary, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoDocumentLibrary_First(
			todoDocumentLibrary, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoDocumentLibrary_Last(
			String todoDocumentLibrary,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoDocumentLibrary_Last(
			todoDocumentLibrary, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoDocumentLibrary_Last(
		String todoDocumentLibrary, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoDocumentLibrary_Last(
			todoDocumentLibrary, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByTodoDocumentLibrary_PrevAndNext(
			long todoId, String todoDocumentLibrary,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoDocumentLibrary_PrevAndNext(
			todoId, todoDocumentLibrary, orderByComparator);
	}

	/**
	 * Removes all the todos where todoDocumentLibrary = &#63; from the database.
	 *
	 * @param todoDocumentLibrary the todo document library
	 */
	public static void removeByTodoDocumentLibrary(String todoDocumentLibrary) {
		getPersistence().removeByTodoDocumentLibrary(todoDocumentLibrary);
	}

	/**
	 * Returns the number of todos where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @return the number of matching todos
	 */
	public static int countByTodoDocumentLibrary(String todoDocumentLibrary) {
		return getPersistence().countByTodoDocumentLibrary(todoDocumentLibrary);
	}

	/**
	 * Returns all the todos where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @return the matching todos
	 */
	public static List<Todo> findByTodoDouble(double todoDouble) {
		return getPersistence().findByTodoDouble(todoDouble);
	}

	/**
	 * Returns a range of all the todos where todoDouble = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoDouble the todo double
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByTodoDouble(
		double todoDouble, int start, int end) {

		return getPersistence().findByTodoDouble(todoDouble, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where todoDouble = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoDouble the todo double
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoDouble(
		double todoDouble, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByTodoDouble(
			todoDouble, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where todoDouble = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoDouble the todo double
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoDouble(
		double todoDouble, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTodoDouble(
			todoDouble, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoDouble_First(
			double todoDouble, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoDouble_First(
			todoDouble, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoDouble_First(
		double todoDouble, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoDouble_First(
			todoDouble, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoDouble_Last(
			double todoDouble, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoDouble_Last(
			todoDouble, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoDouble_Last(
		double todoDouble, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoDouble_Last(
			todoDouble, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByTodoDouble_PrevAndNext(
			long todoId, double todoDouble,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoDouble_PrevAndNext(
			todoId, todoDouble, orderByComparator);
	}

	/**
	 * Removes all the todos where todoDouble = &#63; from the database.
	 *
	 * @param todoDouble the todo double
	 */
	public static void removeByTodoDouble(double todoDouble) {
		getPersistence().removeByTodoDouble(todoDouble);
	}

	/**
	 * Returns the number of todos where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @return the number of matching todos
	 */
	public static int countByTodoDouble(double todoDouble) {
		return getPersistence().countByTodoDouble(todoDouble);
	}

	/**
	 * Returns all the todos where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @return the matching todos
	 */
	public static List<Todo> findByTodoInteger(int todoInteger) {
		return getPersistence().findByTodoInteger(todoInteger);
	}

	/**
	 * Returns a range of all the todos where todoInteger = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoInteger the todo integer
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByTodoInteger(
		int todoInteger, int start, int end) {

		return getPersistence().findByTodoInteger(todoInteger, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where todoInteger = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoInteger the todo integer
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoInteger(
		int todoInteger, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByTodoInteger(
			todoInteger, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where todoInteger = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoInteger the todo integer
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoInteger(
		int todoInteger, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTodoInteger(
			todoInteger, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoInteger_First(
			int todoInteger, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoInteger_First(
			todoInteger, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoInteger_First(
		int todoInteger, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoInteger_First(
			todoInteger, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoInteger_Last(
			int todoInteger, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoInteger_Last(
			todoInteger, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoInteger_Last(
		int todoInteger, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoInteger_Last(
			todoInteger, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByTodoInteger_PrevAndNext(
			long todoId, int todoInteger,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoInteger_PrevAndNext(
			todoId, todoInteger, orderByComparator);
	}

	/**
	 * Removes all the todos where todoInteger = &#63; from the database.
	 *
	 * @param todoInteger the todo integer
	 */
	public static void removeByTodoInteger(int todoInteger) {
		getPersistence().removeByTodoInteger(todoInteger);
	}

	/**
	 * Returns the number of todos where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @return the number of matching todos
	 */
	public static int countByTodoInteger(int todoInteger) {
		return getPersistence().countByTodoInteger(todoInteger);
	}

	/**
	 * Returns all the todos where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @return the matching todos
	 */
	public static List<Todo> findByTodoRichText(String todoRichText) {
		return getPersistence().findByTodoRichText(todoRichText);
	}

	/**
	 * Returns a range of all the todos where todoRichText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoRichText the todo rich text
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByTodoRichText(
		String todoRichText, int start, int end) {

		return getPersistence().findByTodoRichText(todoRichText, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where todoRichText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoRichText the todo rich text
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoRichText(
		String todoRichText, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByTodoRichText(
			todoRichText, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where todoRichText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoRichText the todo rich text
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoRichText(
		String todoRichText, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTodoRichText(
			todoRichText, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoRichText_First(
			String todoRichText, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoRichText_First(
			todoRichText, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoRichText_First(
		String todoRichText, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoRichText_First(
			todoRichText, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoRichText_Last(
			String todoRichText, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoRichText_Last(
			todoRichText, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoRichText_Last(
		String todoRichText, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoRichText_Last(
			todoRichText, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByTodoRichText_PrevAndNext(
			long todoId, String todoRichText,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoRichText_PrevAndNext(
			todoId, todoRichText, orderByComparator);
	}

	/**
	 * Removes all the todos where todoRichText = &#63; from the database.
	 *
	 * @param todoRichText the todo rich text
	 */
	public static void removeByTodoRichText(String todoRichText) {
		getPersistence().removeByTodoRichText(todoRichText);
	}

	/**
	 * Returns the number of todos where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @return the number of matching todos
	 */
	public static int countByTodoRichText(String todoRichText) {
		return getPersistence().countByTodoRichText(todoRichText);
	}

	/**
	 * Returns all the todos where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @return the matching todos
	 */
	public static List<Todo> findByTodoText(String todoText) {
		return getPersistence().findByTodoText(todoText);
	}

	/**
	 * Returns a range of all the todos where todoText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoText the todo text
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public static List<Todo> findByTodoText(
		String todoText, int start, int end) {

		return getPersistence().findByTodoText(todoText, start, end);
	}

	/**
	 * Returns an ordered range of all the todos where todoText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoText the todo text
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoText(
		String todoText, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findByTodoText(
			todoText, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos where todoText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param todoText the todo text
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public static List<Todo> findByTodoText(
		String todoText, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTodoText(
			todoText, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoText_First(
			String todoText, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoText_First(
			todoText, orderByComparator);
	}

	/**
	 * Returns the first todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoText_First(
		String todoText, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoText_First(
			todoText, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public static Todo findByTodoText_Last(
			String todoText, OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoText_Last(
			todoText, orderByComparator);
	}

	/**
	 * Returns the last todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public static Todo fetchByTodoText_Last(
		String todoText, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().fetchByTodoText_Last(
			todoText, orderByComparator);
	}

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo[] findByTodoText_PrevAndNext(
			long todoId, String todoText,
			OrderByComparator<Todo> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByTodoText_PrevAndNext(
			todoId, todoText, orderByComparator);
	}

	/**
	 * Removes all the todos where todoText = &#63; from the database.
	 *
	 * @param todoText the todo text
	 */
	public static void removeByTodoText(String todoText) {
		getPersistence().removeByTodoText(todoText);
	}

	/**
	 * Returns the number of todos where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @return the number of matching todos
	 */
	public static int countByTodoText(String todoText) {
		return getPersistence().countByTodoText(todoText);
	}

	/**
	 * Caches the todo in the entity cache if it is enabled.
	 *
	 * @param todo the todo
	 */
	public static void cacheResult(Todo todo) {
		getPersistence().cacheResult(todo);
	}

	/**
	 * Caches the todos in the entity cache if it is enabled.
	 *
	 * @param todos the todos
	 */
	public static void cacheResult(List<Todo> todos) {
		getPersistence().cacheResult(todos);
	}

	/**
	 * Creates a new todo with the primary key. Does not add the todo to the database.
	 *
	 * @param todoId the primary key for the new todo
	 * @return the new todo
	 */
	public static Todo create(long todoId) {
		return getPersistence().create(todoId);
	}

	/**
	 * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo that was removed
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo remove(long todoId)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().remove(todoId);
	}

	public static Todo updateImpl(Todo todo) {
		return getPersistence().updateImpl(todo);
	}

	/**
	 * Returns the todo with the primary key or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public static Todo findByPrimaryKey(long todoId)
		throws com.liferay.sb.test.exception.NoSuchTodoException {

		return getPersistence().findByPrimaryKey(todoId);
	}

	/**
	 * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo, or <code>null</code> if a todo with the primary key could not be found
	 */
	public static Todo fetchByPrimaryKey(long todoId) {
		return getPersistence().fetchByPrimaryKey(todoId);
	}

	/**
	 * Returns all the todos.
	 *
	 * @return the todos
	 */
	public static List<Todo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the todos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of todos
	 */
	public static List<Todo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the todos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of todos
	 */
	public static List<Todo> findAll(
		int start, int end, OrderByComparator<Todo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of todos
	 */
	public static List<Todo> findAll(
		int start, int end, OrderByComparator<Todo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the todos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of todos.
	 *
	 * @return the number of todos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TodoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TodoPersistence, TodoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TodoPersistence.class);

		ServiceTracker<TodoPersistence, TodoPersistence> serviceTracker =
			new ServiceTracker<TodoPersistence, TodoPersistence>(
				bundle.getBundleContext(), TodoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}