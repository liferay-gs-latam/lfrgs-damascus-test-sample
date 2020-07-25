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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.sb.test.exception.NoSuchTodoException;
import com.liferay.sb.test.model.Todo;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the todo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "diegofurtado"
 * @see TodoUtil
 * @generated
 */
@ProviderType
public interface TodoPersistence extends BasePersistence<Todo> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TodoUtil} to access the todo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the todos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByUuid(String uuid);

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
	public java.util.List<Todo> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Todo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where uuid = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByUuid_PrevAndNext(
			long todoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of todos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching todos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the todo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByUUID_G(String uuid, long groupId)
		throws NoSuchTodoException;

	/**
	 * Returns the todo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the todo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the todo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the todo that was removed
	 */
	public Todo removeByUUID_G(String uuid, long groupId)
		throws NoSuchTodoException;

	/**
	 * Returns the number of todos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching todos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the todos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Todo> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Todo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] findByUuid_C_PrevAndNext(
			long todoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of todos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching todos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the todos where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByC_S(long companyId, int status);

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
	public java.util.List<Todo> findByC_S(
		long companyId, int status, int start, int end);

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
	public java.util.List<Todo> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByC_S_First(
			long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByC_S_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByC_S_Last(
			long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByC_S_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] findByC_S_PrevAndNext(
			long todoId, long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

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
	public java.util.List<Todo> findByC_S(long companyId, int[] statuses);

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
	public java.util.List<Todo> findByC_S(
		long companyId, int[] statuses, int start, int end);

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
	public java.util.List<Todo> findByC_S(
		long companyId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByC_S(
		long companyId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the todos where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	public void removeByC_S(long companyId, int status);

	/**
	 * Returns the number of todos where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	public int countByC_S(long companyId, int status);

	/**
	 * Returns the number of todos where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public int countByC_S(long companyId, int[] statuses);

	/**
	 * Returns all the todos where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByG_S(long groupId, int status);

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
	public java.util.List<Todo> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<Todo> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] findByG_S_PrevAndNext(
			long todoId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching todos that the user has permission to view
	 */
	public java.util.List<Todo> filterFindByG_S(long groupId, int status);

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
	public java.util.List<Todo> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<Todo> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] filterFindByG_S_PrevAndNext(
			long todoId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching todos that the user has permission to view
	 */
	public java.util.List<Todo> filterFindByG_S(long groupId, int[] statuses);

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
	public java.util.List<Todo> filterFindByG_S(
		long groupId, int[] statuses, int start, int end);

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
	public java.util.List<Todo> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByG_S(long groupId, int[] statuses);

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
	public java.util.List<Todo> findByG_S(
		long groupId, int[] statuses, int start, int end);

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
	public java.util.List<Todo> findByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the todos where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of todos where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of todos where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public int countByG_S(long groupId, int[] statuses);

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching todos that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching todos that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int[] statuses);

	/**
	 * Returns all the todos where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByC_U_S(
		long companyId, long userId, int status);

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
	public java.util.List<Todo> findByC_U_S(
		long companyId, long userId, int status, int start, int end);

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
	public java.util.List<Todo> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

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
	public Todo findByC_U_S_First(
			long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByC_U_S_First(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo findByC_U_S_Last(
			long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByC_U_S_Last(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] findByC_U_S_PrevAndNext(
			long todoId, long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

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
	public java.util.List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses);

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
	public java.util.List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the todos where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByC_U_S(long companyId, long userId, int status);

	/**
	 * Returns the number of todos where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	public int countByC_U_S(long companyId, long userId, int status);

	/**
	 * Returns the number of todos where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public int countByC_U_S(long companyId, long userId, int[] statuses);

	/**
	 * Returns all the todos where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<Todo> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<Todo> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

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
	public Todo findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] findByG_U_S_PrevAndNext(
			long todoId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos that the user has permission to view
	 */
	public java.util.List<Todo> filterFindByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<Todo> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<Todo> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] filterFindByG_U_S_PrevAndNext(
			long todoId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching todos that the user has permission to view
	 */
	public java.util.List<Todo> filterFindByG_U_S(
		long groupId, long userId, int[] statuses);

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
	public java.util.List<Todo> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<Todo> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses);

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
	public java.util.List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the todos where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of todos where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of todos where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public int countByG_U_S(long groupId, long userId, int[] statuses);

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int[] statuses);

	/**
	 * Returns all the todos where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByU_S(long userId, int status);

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
	public java.util.List<Todo> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<Todo> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] findByU_S_PrevAndNext(
			long todoId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

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
	public java.util.List<Todo> findByU_S(long userId, int[] statuses);

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
	public java.util.List<Todo> findByU_S(
		long userId, int[] statuses, int start, int end);

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
	public java.util.List<Todo> findByU_S(
		long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByU_S(
		long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the todos where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of todos where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns the number of todos where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public int countByU_S(long userId, int[] statuses);

	/**
	 * Returns all the todos where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status);

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
	public java.util.List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end);

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
	public java.util.List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

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
	public Todo findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] findByG_UT_ST_PrevAndNext(
			long todoId, long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching todos that the user has permission to view
	 */
	public java.util.List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status);

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
	public java.util.List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end);

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
	public java.util.List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] filterFindByG_UT_ST_PrevAndNext(
			long todoId, long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching todos that the user has permission to view
	 */
	public java.util.List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

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
	public java.util.List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end);

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
	public java.util.List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

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
	public java.util.List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end);

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
	public java.util.List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the todos where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	public void removeByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of todos where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching todos
	 */
	public int countByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of todos where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	public int countByG_UT_ST(long groupId, String urlTitle, int[] statuses);

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching todos that the user has permission to view
	 */
	public int filterCountByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching todos that the user has permission to view
	 */
	public int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

	/**
	 * Returns the todo where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByG_UT(long groupId, String urlTitle)
		throws NoSuchTodoException;

	/**
	 * Returns the todo where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByG_UT(long groupId, String urlTitle);

	/**
	 * Returns the todo where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache);

	/**
	 * Removes the todo where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the todo that was removed
	 */
	public Todo removeByG_UT(long groupId, String urlTitle)
		throws NoSuchTodoException;

	/**
	 * Returns the number of todos where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching todos
	 */
	public int countByG_UT(long groupId, String urlTitle);

	/**
	 * Returns the todo where urlTitle = &#63; or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByURLTitle(String urlTitle) throws NoSuchTodoException;

	/**
	 * Returns the todo where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByURLTitle(String urlTitle);

	/**
	 * Returns the todo where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByURLTitle(String urlTitle, boolean useFinderCache);

	/**
	 * Removes the todo where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the todo that was removed
	 */
	public Todo removeByURLTitle(String urlTitle) throws NoSuchTodoException;

	/**
	 * Returns the number of todos where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching todos
	 */
	public int countByURLTitle(String urlTitle);

	/**
	 * Returns all the todos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByGroupId(long groupId);

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
	public java.util.List<Todo> findByGroupId(long groupId, int start, int end);

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
	public java.util.List<Todo> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where groupId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByGroupId_PrevAndNext(
			long todoId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching todos that the user has permission to view
	 */
	public java.util.List<Todo> filterFindByGroupId(long groupId);

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
	public java.util.List<Todo> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Todo> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set of todos that the user has permission to view where groupId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] filterFindByGroupId_PrevAndNext(
			long todoId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of todos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching todos
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching todos that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the todos where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByUserIdGroupId(long userId, long groupId);

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
	public java.util.List<Todo> findByUserIdGroupId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<Todo> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByUserIdGroupId_First(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByUserIdGroupId_Last(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] findByUserIdGroupId_PrevAndNext(
			long todoId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns all the todos that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching todos that the user has permission to view
	 */
	public java.util.List<Todo> filterFindByUserIdGroupId(
		long userId, long groupId);

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
	public java.util.List<Todo> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<Todo> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public Todo[] filterFindByUserIdGroupId_PrevAndNext(
			long todoId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public void removeByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns the number of todos where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching todos
	 */
	public int countByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns the number of todos that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching todos that the user has permission to view
	 */
	public int filterCountByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns all the todos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByUserId(long userId);

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
	public java.util.List<Todo> findByUserId(long userId, int start, int end);

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
	public java.util.List<Todo> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where userId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByUserId_PrevAndNext(
			long todoId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of todos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching todos
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the todos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByCompanyId(long companyId);

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
	public java.util.List<Todo> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<Todo> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where companyId = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByCompanyId_PrevAndNext(
			long todoId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of todos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching todos
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the todos where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByTodoId(long todoId);

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
	public java.util.List<Todo> findByTodoId(long todoId, int start, int end);

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
	public java.util.List<Todo> findByTodoId(
		long todoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByTodoId(
		long todoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoId_First(
			long todoId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoId_First(
		long todoId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoId_Last(
			long todoId,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoId_Last(
		long todoId,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Removes all the todos where todoId = &#63; from the database.
	 *
	 * @param todoId the todo ID
	 */
	public void removeByTodoId(long todoId);

	/**
	 * Returns the number of todos where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @return the number of matching todos
	 */
	public int countByTodoId(long todoId);

	/**
	 * Returns all the todos where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByTitle(String title);

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
	public java.util.List<Todo> findByTitle(String title, int start, int end);

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
	public java.util.List<Todo> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where title = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByTitle_PrevAndNext(
			long todoId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of todos where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching todos
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the todos where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByTodoBooleanStat(boolean todoBooleanStat);

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
	public java.util.List<Todo> findByTodoBooleanStat(
		boolean todoBooleanStat, int start, int end);

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
	public java.util.List<Todo> findByTodoBooleanStat(
		boolean todoBooleanStat, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByTodoBooleanStat(
		boolean todoBooleanStat, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoBooleanStat_First(
			boolean todoBooleanStat,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoBooleanStat_First(
		boolean todoBooleanStat,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoBooleanStat_Last(
			boolean todoBooleanStat,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoBooleanStat_Last(
		boolean todoBooleanStat,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByTodoBooleanStat_PrevAndNext(
			long todoId, boolean todoBooleanStat,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where todoBooleanStat = &#63; from the database.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 */
	public void removeByTodoBooleanStat(boolean todoBooleanStat);

	/**
	 * Returns the number of todos where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @return the number of matching todos
	 */
	public int countByTodoBooleanStat(boolean todoBooleanStat);

	/**
	 * Returns all the todos where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByTodoDateTime(Date todoDateTime);

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
	public java.util.List<Todo> findByTodoDateTime(
		Date todoDateTime, int start, int end);

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
	public java.util.List<Todo> findByTodoDateTime(
		Date todoDateTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByTodoDateTime(
		Date todoDateTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoDateTime_First(
			Date todoDateTime,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoDateTime_First(
		Date todoDateTime,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoDateTime_Last(
			Date todoDateTime,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoDateTime_Last(
		Date todoDateTime,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByTodoDateTime_PrevAndNext(
			long todoId, Date todoDateTime,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where todoDateTime = &#63; from the database.
	 *
	 * @param todoDateTime the todo date time
	 */
	public void removeByTodoDateTime(Date todoDateTime);

	/**
	 * Returns the number of todos where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @return the number of matching todos
	 */
	public int countByTodoDateTime(Date todoDateTime);

	/**
	 * Returns all the todos where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary);

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
	public java.util.List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary, int start, int end);

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
	public java.util.List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoDocumentLibrary_First(
			String todoDocumentLibrary,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoDocumentLibrary_First(
		String todoDocumentLibrary,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoDocumentLibrary_Last(
			String todoDocumentLibrary,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoDocumentLibrary_Last(
		String todoDocumentLibrary,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByTodoDocumentLibrary_PrevAndNext(
			long todoId, String todoDocumentLibrary,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where todoDocumentLibrary = &#63; from the database.
	 *
	 * @param todoDocumentLibrary the todo document library
	 */
	public void removeByTodoDocumentLibrary(String todoDocumentLibrary);

	/**
	 * Returns the number of todos where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @return the number of matching todos
	 */
	public int countByTodoDocumentLibrary(String todoDocumentLibrary);

	/**
	 * Returns all the todos where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByTodoDouble(double todoDouble);

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
	public java.util.List<Todo> findByTodoDouble(
		double todoDouble, int start, int end);

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
	public java.util.List<Todo> findByTodoDouble(
		double todoDouble, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByTodoDouble(
		double todoDouble, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoDouble_First(
			double todoDouble,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoDouble_First(
		double todoDouble,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoDouble_Last(
			double todoDouble,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoDouble_Last(
		double todoDouble,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByTodoDouble_PrevAndNext(
			long todoId, double todoDouble,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where todoDouble = &#63; from the database.
	 *
	 * @param todoDouble the todo double
	 */
	public void removeByTodoDouble(double todoDouble);

	/**
	 * Returns the number of todos where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @return the number of matching todos
	 */
	public int countByTodoDouble(double todoDouble);

	/**
	 * Returns all the todos where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByTodoInteger(int todoInteger);

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
	public java.util.List<Todo> findByTodoInteger(
		int todoInteger, int start, int end);

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
	public java.util.List<Todo> findByTodoInteger(
		int todoInteger, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByTodoInteger(
		int todoInteger, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoInteger_First(
			int todoInteger,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoInteger_First(
		int todoInteger,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoInteger_Last(
			int todoInteger,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoInteger_Last(
		int todoInteger,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByTodoInteger_PrevAndNext(
			long todoId, int todoInteger,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where todoInteger = &#63; from the database.
	 *
	 * @param todoInteger the todo integer
	 */
	public void removeByTodoInteger(int todoInteger);

	/**
	 * Returns the number of todos where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @return the number of matching todos
	 */
	public int countByTodoInteger(int todoInteger);

	/**
	 * Returns all the todos where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByTodoRichText(String todoRichText);

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
	public java.util.List<Todo> findByTodoRichText(
		String todoRichText, int start, int end);

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
	public java.util.List<Todo> findByTodoRichText(
		String todoRichText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByTodoRichText(
		String todoRichText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoRichText_First(
			String todoRichText,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoRichText_First(
		String todoRichText,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoRichText_Last(
			String todoRichText,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoRichText_Last(
		String todoRichText,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByTodoRichText_PrevAndNext(
			long todoId, String todoRichText,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where todoRichText = &#63; from the database.
	 *
	 * @param todoRichText the todo rich text
	 */
	public void removeByTodoRichText(String todoRichText);

	/**
	 * Returns the number of todos where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @return the number of matching todos
	 */
	public int countByTodoRichText(String todoRichText);

	/**
	 * Returns all the todos where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByTodoText(String todoText);

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
	public java.util.List<Todo> findByTodoText(
		String todoText, int start, int end);

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
	public java.util.List<Todo> findByTodoText(
		String todoText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findByTodoText(
		String todoText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoText_First(
			String todoText,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoText_First(
		String todoText,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByTodoText_Last(
			String todoText,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByTodoText_Last(
		String todoText,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoId the primary key of the current todo
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByTodoText_PrevAndNext(
			long todoId, String todoText,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where todoText = &#63; from the database.
	 *
	 * @param todoText the todo text
	 */
	public void removeByTodoText(String todoText);

	/**
	 * Returns the number of todos where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @return the number of matching todos
	 */
	public int countByTodoText(String todoText);

	/**
	 * Caches the todo in the entity cache if it is enabled.
	 *
	 * @param todo the todo
	 */
	public void cacheResult(Todo todo);

	/**
	 * Caches the todos in the entity cache if it is enabled.
	 *
	 * @param todos the todos
	 */
	public void cacheResult(java.util.List<Todo> todos);

	/**
	 * Creates a new todo with the primary key. Does not add the todo to the database.
	 *
	 * @param todoId the primary key for the new todo
	 * @return the new todo
	 */
	public Todo create(long todoId);

	/**
	 * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo that was removed
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo remove(long todoId) throws NoSuchTodoException;

	public Todo updateImpl(Todo todo);

	/**
	 * Returns the todo with the primary key or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo findByPrimaryKey(long todoId) throws NoSuchTodoException;

	/**
	 * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo, or <code>null</code> if a todo with the primary key could not be found
	 */
	public Todo fetchByPrimaryKey(long todoId);

	/**
	 * Returns all the todos.
	 *
	 * @return the todos
	 */
	public java.util.List<Todo> findAll();

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
	public java.util.List<Todo> findAll(int start, int end);

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
	public java.util.List<Todo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

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
	public java.util.List<Todo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the todos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of todos.
	 *
	 * @return the number of todos
	 */
	public int countAll();

}