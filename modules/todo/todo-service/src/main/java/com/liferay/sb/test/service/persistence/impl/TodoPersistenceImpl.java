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

package com.liferay.sb.test.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.sb.test.exception.NoSuchTodoException;
import com.liferay.sb.test.model.Todo;
import com.liferay.sb.test.model.impl.TodoImpl;
import com.liferay.sb.test.model.impl.TodoModelImpl;
import com.liferay.sb.test.service.persistence.TodoPersistence;
import com.liferay.sb.test.service.persistence.impl.constants.TodoPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the todo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "diegofurtado"
 * @generated
 */
@Component(service = TodoPersistence.class)
public class TodoPersistenceImpl
	extends BasePersistenceImpl<Todo> implements TodoPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TodoUtil</code> to access the todo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TodoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the todos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Todo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (!uuid.equals(todo.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByUuid_First(
			String uuid, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByUuid_First(uuid, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByUuid_First(
		String uuid, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByUuid_Last(
			String uuid, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByUuid_Last(uuid, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByUuid_Last(
		String uuid, OrderByComparator<Todo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByUuid_PrevAndNext(
			long todoId, String uuid, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		uuid = Objects.toString(uuid, "");

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, todo, uuid, orderByComparator, true);

			array[1] = todo;

			array[2] = getByUuid_PrevAndNext(
				session, todo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByUuid_PrevAndNext(
		Session session, Todo todo, String uuid,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Todo todo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching todos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "todo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(todo.uuid IS NULL OR todo.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the todo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByUUID_G(String uuid, long groupId)
		throws NoSuchTodoException {

		Todo todo = fetchByUUID_G(uuid, groupId);

		if (todo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTodoException(msg.toString());
		}

		return todo;
	}

	/**
	 * Returns the todo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the todo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Todo) {
			Todo todo = (Todo)result;

			if (!Objects.equals(uuid, todo.getUuid()) ||
				(groupId != todo.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TODO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Todo> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Todo todo = list.get(0);

					result = todo;

					cacheResult(todo);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Todo)result;
		}
	}

	/**
	 * Removes the todo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the todo that was removed
	 */
	@Override
	public Todo removeByUUID_G(String uuid, long groupId)
		throws NoSuchTodoException {

		Todo todo = findByUUID_G(uuid, groupId);

		return remove(todo);
	}

	/**
	 * Returns the number of todos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching todos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TODO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"todo.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(todo.uuid IS NULL OR todo.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"todo.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the todos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Todo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (!uuid.equals(todo.getUuid()) ||
						(companyId != todo.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Todo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Todo> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByUuid_C_PrevAndNext(
			long todoId, String uuid, long companyId,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		uuid = Objects.toString(uuid, "");

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, todo, uuid, companyId, orderByComparator, true);

			array[1] = todo;

			array[2] = getByUuid_C_PrevAndNext(
				session, todo, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByUuid_C_PrevAndNext(
		Session session, Todo todo, String uuid, long companyId,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Todo todo :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching todos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TODO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"todo.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(todo.uuid IS NULL OR todo.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"todo.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_S;
	private FinderPath _finderPathWithoutPaginationFindByC_S;
	private FinderPath _finderPathCountByC_S;
	private FinderPath _finderPathWithPaginationCountByC_S;

	/**
	 * Returns all the todos where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByC_S(long companyId, int status) {
		return findByC_S(
			companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByC_S(
		long companyId, int status, int start, int end) {

		return findByC_S(companyId, status, start, end, null);
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
	@Override
	public List<Todo> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByC_S(
			companyId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_S;
				finderArgs = new Object[] {companyId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_S;
			finderArgs = new Object[] {
				companyId, status, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((companyId != todo.getCompanyId()) ||
						(status != todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Todo findByC_S_First(
			long companyId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByC_S_First(companyId, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByC_S_First(
		long companyId, int status, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByC_S(companyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo findByC_S_Last(
			long companyId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByC_S_Last(companyId, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByC_S_Last(
		long companyId, int status, OrderByComparator<Todo> orderByComparator) {

		int count = countByC_S(companyId, status);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByC_S(
			companyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByC_S_PrevAndNext(
			long todoId, long companyId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByC_S_PrevAndNext(
				session, todo, companyId, status, orderByComparator, true);

			array[1] = todo;

			array[2] = getByC_S_PrevAndNext(
				session, todo, companyId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByC_S_PrevAndNext(
		Session session, Todo todo, long companyId, int status,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_C_S_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<Todo> findByC_S(long companyId, int[] statuses) {
		return findByC_S(
			companyId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByC_S(
		long companyId, int[] statuses, int start, int end) {

		return findByC_S(companyId, statuses, start, end, null);
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
	@Override
	public List<Todo> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByC_S(
			companyId, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByC_S(
				companyId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					companyId, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				companyId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				_finderPathWithPaginationFindByC_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((companyId != todo.getCompanyId()) ||
						!ArrayUtil.contains(statuses, todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_C_S_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByC_S, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByC_S, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the todos where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	@Override
	public void removeByC_S(long companyId, int status) {
		for (Todo todo :
				findByC_S(
					companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	@Override
	public int countByC_S(long companyId, int status) {
		FinderPath finderPath = _finderPathCountByC_S;

		Object[] finderArgs = new Object[] {companyId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	@Override
	public int countByC_S(long companyId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			companyId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByC_S, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_C_S_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByC_S, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByC_S, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_S_COMPANYID_2 =
		"todo.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_STATUS_2 = "todo.status = ?";

	private static final String _FINDER_COLUMN_C_S_STATUS_7 =
		"todo.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;
	private FinderPath _finderPathWithPaginationCountByG_S;

	/**
	 * Returns all the todos where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByG_S(long groupId, int status, int start, int end) {
		return findByG_S(groupId, status, start, end, null);
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
	@Override
	public List<Todo> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((groupId != todo.getGroupId()) ||
						(status != todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Todo findByG_S_First(
			long groupId, int status, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByG_S_First(groupId, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByG_S_First(
		long groupId, int status, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByG_S(groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo findByG_S_Last(
			long groupId, int status, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByG_S_Last(groupId, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByG_S_Last(
		long groupId, int status, OrderByComparator<Todo> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByG_S_PrevAndNext(
			long todoId, long groupId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, todo, groupId, status, orderByComparator, true);

			array[1] = todo;

			array[2] = getByG_S_PrevAndNext(
				session, todo, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByG_S_PrevAndNext(
		Session session, Todo todo, long groupId, int status,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching todos that the user has permission to view
	 */
	@Override
	public List<Todo> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
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
	@Override
	public List<Todo> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(status);

			return (List<Todo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Todo[] filterFindByG_S_PrevAndNext(
			long todoId, long groupId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				todoId, groupId, status, orderByComparator);
		}

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, todo, groupId, status, orderByComparator, true);

			array[1] = todo;

			array[2] = filterGetByG_S_PrevAndNext(
				session, todo, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo filterGetByG_S_PrevAndNext(
		Session session, Todo todo, long groupId, int status,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching todos that the user has permission to view
	 */
	@Override
	public List<Todo> filterFindByG_S(long groupId, int[] statuses) {
		return filterFindByG_S(
			groupId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> filterFindByG_S(
		long groupId, int[] statuses, int start, int end) {

		return filterFindByG_S(groupId, statuses, start, end, null);
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
	@Override
	public List<Todo> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, statuses, start, end, orderByComparator);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler query = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		if (statuses.length > 0) {
			query.append("(");

			query.append(_FINDER_COLUMN_G_S_STATUS_7);

			query.append(StringUtil.merge(statuses));

			query.append(")");

			query.append(")");
		}

		query.setStringAt(
			removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Todo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public List<Todo> findByG_S(long groupId, int[] statuses) {
		return findByG_S(
			groupId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByG_S(
		long groupId, int[] statuses, int start, int end) {

		return findByG_S(groupId, statuses, start, end, null);
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
	@Override
	public List<Todo> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByG_S(
			groupId, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByG_S(
				groupId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {groupId, StringUtil.merge(statuses)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				_finderPathWithPaginationFindByG_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((groupId != todo.getGroupId()) ||
						!ArrayUtil.contains(statuses, todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_G_S_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_S, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByG_S, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the todos where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (Todo todo :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	@Override
	public int countByG_S(long groupId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			groupId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_S, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_G_S_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_S, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByG_S, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching todos that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TODO_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching todos that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int[] statuses) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, statuses);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler query = new StringBundler();

		query.append(_FILTER_SQL_COUNT_TODO_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		if (statuses.length > 0) {
			query.append("(");

			query.append(_FINDER_COLUMN_G_S_STATUS_7);

			query.append(StringUtil.merge(statuses));

			query.append(")");

			query.append(")");
		}

		query.setStringAt(
			removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"todo.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 = "todo.status = ?";

	private static final String _FINDER_COLUMN_G_S_STATUS_7 =
		"todo.status IN (";

	private FinderPath _finderPathWithPaginationFindByC_U_S;
	private FinderPath _finderPathWithoutPaginationFindByC_U_S;
	private FinderPath _finderPathCountByC_U_S;
	private FinderPath _finderPathWithPaginationCountByC_U_S;

	/**
	 * Returns all the todos where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByC_U_S(long companyId, long userId, int status) {
		return findByC_U_S(
			companyId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Todo> findByC_U_S(
		long companyId, long userId, int status, int start, int end) {

		return findByC_U_S(companyId, userId, status, start, end, null);
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
	@Override
	public List<Todo> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByC_U_S(
			companyId, userId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_U_S;
				finderArgs = new Object[] {companyId, userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_U_S;
			finderArgs = new Object[] {
				companyId, userId, status, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((companyId != todo.getCompanyId()) ||
						(userId != todo.getUserId()) ||
						(status != todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_U_S_USERID_2);

			query.append(_FINDER_COLUMN_C_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				qPos.add(status);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Todo findByC_U_S_First(
			long companyId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByC_U_S_First(
			companyId, userId, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
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
	@Override
	public Todo fetchByC_U_S_First(
		long companyId, long userId, int status,
		OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByC_U_S(
			companyId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo findByC_U_S_Last(
			long companyId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByC_U_S_Last(
			companyId, userId, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
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
	@Override
	public Todo fetchByC_U_S_Last(
		long companyId, long userId, int status,
		OrderByComparator<Todo> orderByComparator) {

		int count = countByC_U_S(companyId, userId, status);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByC_U_S(
			companyId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByC_U_S_PrevAndNext(
			long todoId, long companyId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByC_U_S_PrevAndNext(
				session, todo, companyId, userId, status, orderByComparator,
				true);

			array[1] = todo;

			array[2] = getByC_U_S_PrevAndNext(
				session, todo, companyId, userId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByC_U_S_PrevAndNext(
		Session session, Todo todo, long companyId, long userId, int status,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_U_S_USERID_2);

		query.append(_FINDER_COLUMN_C_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<Todo> findByC_U_S(long companyId, long userId, int[] statuses) {
		return findByC_U_S(
			companyId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end) {

		return findByC_U_S(companyId, userId, statuses, start, end, null);
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
	@Override
	public List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByC_U_S(
				companyId, userId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					companyId, userId, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				companyId, userId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				_finderPathWithPaginationFindByC_U_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((companyId != todo.getCompanyId()) ||
						(userId != todo.getUserId()) ||
						!ArrayUtil.contains(statuses, todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_U_S_USERID_2);

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_C_U_S_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByC_U_S, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByC_U_S, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the todos where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByC_U_S(long companyId, long userId, int status) {
		for (Todo todo :
				findByC_U_S(
					companyId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	@Override
	public int countByC_U_S(long companyId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByC_U_S;

		Object[] finderArgs = new Object[] {companyId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_U_S_USERID_2);

			query.append(_FINDER_COLUMN_C_U_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	@Override
	public int countByC_U_S(long companyId, long userId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			companyId, userId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByC_U_S, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_U_S_USERID_2);

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_C_U_S_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByC_U_S, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByC_U_S, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_U_S_COMPANYID_2 =
		"todo.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_USERID_2 =
		"todo.userId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_2 =
		"todo.status = ?";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_7 =
		"todo.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_U_S;
	private FinderPath _finderPathWithoutPaginationFindByG_U_S;
	private FinderPath _finderPathCountByG_U_S;
	private FinderPath _finderPathWithPaginationCountByG_U_S;

	/**
	 * Returns all the todos where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByG_U_S(long groupId, long userId, int status) {
		return findByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Todo> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return findByG_U_S(groupId, userId, status, start, end, null);
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
	@Override
	public List<Todo> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByG_U_S(
			groupId, userId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_U_S;
				finderArgs = new Object[] {groupId, userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_U_S;
			finderArgs = new Object[] {
				groupId, userId, status, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((groupId != todo.getGroupId()) ||
						(userId != todo.getUserId()) ||
						(status != todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_S_USERID_2);

			query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(status);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Todo findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
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
	@Override
	public Todo fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByG_U_S(
			groupId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
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
	@Override
	public Todo fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<Todo> orderByComparator) {

		int count = countByG_U_S(groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByG_U_S(
			groupId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByG_U_S_PrevAndNext(
			long todoId, long groupId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByG_U_S_PrevAndNext(
				session, todo, groupId, userId, status, orderByComparator,
				true);

			array[1] = todo;

			array[2] = getByG_U_S_PrevAndNext(
				session, todo, groupId, userId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByG_U_S_PrevAndNext(
		Session session, Todo todo, long groupId, long userId, int status,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_S_USERID_2);

		query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos that the user has permission to view
	 */
	@Override
	public List<Todo> filterFindByG_U_S(long groupId, long userId, int status) {
		return filterFindByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Todo> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return filterFindByG_U_S(groupId, userId, status, start, end, null);
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
	@Override
	public List<Todo> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S(
				groupId, userId, status, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_S_USERID_2);

		query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(userId);

			qPos.add(status);

			return (List<Todo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Todo[] filterFindByG_U_S_PrevAndNext(
			long todoId, long groupId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S_PrevAndNext(
				todoId, groupId, userId, status, orderByComparator);
		}

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = filterGetByG_U_S_PrevAndNext(
				session, todo, groupId, userId, status, orderByComparator,
				true);

			array[1] = todo;

			array[2] = filterGetByG_U_S_PrevAndNext(
				session, todo, groupId, userId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo filterGetByG_U_S_PrevAndNext(
		Session session, Todo todo, long groupId, long userId, int status,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_S_USERID_2);

		query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching todos that the user has permission to view
	 */
	@Override
	public List<Todo> filterFindByG_U_S(
		long groupId, long userId, int[] statuses) {

		return filterFindByG_U_S(
			groupId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Todo> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return filterFindByG_U_S(groupId, userId, statuses, start, end, null);
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
	@Override
	public List<Todo> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S(
				groupId, userId, statuses, start, end, orderByComparator);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler query = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_S_USERID_2);

		if (statuses.length > 0) {
			query.append("(");

			query.append(_FINDER_COLUMN_G_U_S_STATUS_7);

			query.append(StringUtil.merge(statuses));

			query.append(")");

			query.append(")");
		}

		query.setStringAt(
			removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(userId);

			return (List<Todo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public List<Todo> findByG_U_S(long groupId, long userId, int[] statuses) {
		return findByG_U_S(
			groupId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return findByG_U_S(groupId, userId, statuses, start, end, null);
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
	@Override
	public List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByG_U_S(
				groupId, userId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					groupId, userId, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, userId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				_finderPathWithPaginationFindByG_U_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((groupId != todo.getGroupId()) ||
						(userId != todo.getUserId()) ||
						!ArrayUtil.contains(statuses, todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_S_USERID_2);

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_G_U_S_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_U_S, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByG_U_S, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the todos where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByG_U_S(long groupId, long userId, int status) {
		for (Todo todo :
				findByG_U_S(
					groupId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	@Override
	public int countByG_U_S(long groupId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByG_U_S;

		Object[] finderArgs = new Object[] {groupId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_S_USERID_2);

			query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	@Override
	public int countByG_U_S(long groupId, long userId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			groupId, userId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_U_S, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_S_USERID_2);

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_G_U_S_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_U_S, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByG_U_S, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos that the user has permission to view
	 */
	@Override
	public int filterCountByG_U_S(long groupId, long userId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U_S(groupId, userId, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_TODO_WHERE);

		query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_S_USERID_2);

		query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(userId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos that the user has permission to view
	 */
	@Override
	public int filterCountByG_U_S(long groupId, long userId, int[] statuses) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U_S(groupId, userId, statuses);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler query = new StringBundler();

		query.append(_FILTER_SQL_COUNT_TODO_WHERE);

		query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_S_USERID_2);

		if (statuses.length > 0) {
			query.append("(");

			query.append(_FINDER_COLUMN_G_U_S_STATUS_7);

			query.append(StringUtil.merge(statuses));

			query.append(")");

			query.append(")");
		}

		query.setStringAt(
			removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(userId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_U_S_GROUPID_2 =
		"todo.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_USERID_2 =
		"todo.userId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_2 =
		"todo.status = ?";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_7 =
		"todo.status IN (";

	private FinderPath _finderPathWithPaginationFindByU_S;
	private FinderPath _finderPathWithoutPaginationFindByU_S;
	private FinderPath _finderPathCountByU_S;
	private FinderPath _finderPathWithPaginationCountByU_S;

	/**
	 * Returns all the todos where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByU_S(long userId, int status) {
		return findByU_S(
			userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByU_S(long userId, int status, int start, int end) {
		return findByU_S(userId, status, start, end, null);
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
	@Override
	public List<Todo> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByU_S(userId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByU_S;
				finderArgs = new Object[] {userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByU_S;
			finderArgs = new Object[] {
				userId, status, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((userId != todo.getUserId()) ||
						(status != todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_U_S_USERID_2);

			query.append(_FINDER_COLUMN_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(status);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Todo findByU_S_First(
			long userId, int status, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByU_S_First(userId, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByU_S_First(
		long userId, int status, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByU_S(userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo findByU_S_Last(
			long userId, int status, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByU_S_Last(userId, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByU_S_Last(
		long userId, int status, OrderByComparator<Todo> orderByComparator) {

		int count = countByU_S(userId, status);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByU_S(
			userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByU_S_PrevAndNext(
			long todoId, long userId, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByU_S_PrevAndNext(
				session, todo, userId, status, orderByComparator, true);

			array[1] = todo;

			array[2] = getByU_S_PrevAndNext(
				session, todo, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByU_S_PrevAndNext(
		Session session, Todo todo, long userId, int status,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_U_S_USERID_2);

		query.append(_FINDER_COLUMN_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<Todo> findByU_S(long userId, int[] statuses) {
		return findByU_S(
			userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByU_S(
		long userId, int[] statuses, int start, int end) {

		return findByU_S(userId, statuses, start, end, null);
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
	@Override
	public List<Todo> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByU_S(userId, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByU_S(
				userId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {userId, StringUtil.merge(statuses)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				userId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				_finderPathWithPaginationFindByU_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((userId != todo.getUserId()) ||
						!ArrayUtil.contains(statuses, todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_U_S_USERID_2);

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_U_S_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByU_S, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByU_S, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the todos where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByU_S(long userId, int status) {
		for (Todo todo :
				findByU_S(
					userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching todos
	 */
	@Override
	public int countByU_S(long userId, int status) {
		FinderPath finderPath = _finderPathCountByU_S;

		Object[] finderArgs = new Object[] {userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_U_S_USERID_2);

			query.append(_FINDER_COLUMN_U_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	@Override
	public int countByU_S(long userId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {userId, StringUtil.merge(statuses)};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByU_S, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_U_S_USERID_2);

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_U_S_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByU_S, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByU_S, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_S_USERID_2 =
		"todo.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_S_STATUS_2 = "todo.status = ?";

	private static final String _FINDER_COLUMN_U_S_STATUS_7 =
		"todo.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_UT_ST;
	private FinderPath _finderPathWithoutPaginationFindByG_UT_ST;
	private FinderPath _finderPathCountByG_UT_ST;
	private FinderPath _finderPathWithPaginationCountByG_UT_ST;

	/**
	 * Returns all the todos where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByG_UT_ST(long groupId, String urlTitle, int status) {
		return findByG_UT_ST(
			groupId, urlTitle, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return findByG_UT_ST(groupId, urlTitle, status, start, end, null);
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
	@Override
	public List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_UT_ST;
				finderArgs = new Object[] {groupId, urlTitle, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_UT_ST;
			finderArgs = new Object[] {
				groupId, urlTitle, status, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((groupId != todo.getGroupId()) ||
						!urlTitle.equals(todo.getUrlTitle()) ||
						(status != todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			query.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				qPos.add(status);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Todo findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", urlTitle=");
		msg.append(urlTitle);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
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
	@Override
	public Todo fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByG_UT_ST(
			groupId, urlTitle, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", urlTitle=");
		msg.append(urlTitle);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
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
	@Override
	public Todo fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		OrderByComparator<Todo> orderByComparator) {

		int count = countByG_UT_ST(groupId, urlTitle, status);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByG_UT_ST(
			groupId, urlTitle, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByG_UT_ST_PrevAndNext(
			long todoId, long groupId, String urlTitle, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		urlTitle = Objects.toString(urlTitle, "");

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByG_UT_ST_PrevAndNext(
				session, todo, groupId, urlTitle, status, orderByComparator,
				true);

			array[1] = todo;

			array[2] = getByG_UT_ST_PrevAndNext(
				session, todo, groupId, urlTitle, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByG_UT_ST_PrevAndNext(
		Session session, Todo todo, long groupId, String urlTitle, int status,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		query.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindUrlTitle) {
			qPos.add(urlTitle);
		}

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching todos that the user has permission to view
	 */
	@Override
	public List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return filterFindByG_UT_ST(groupId, urlTitle, status, start, end, null);
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
	@Override
	public List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST(
				groupId, urlTitle, status, start, end, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		query.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindUrlTitle) {
				qPos.add(urlTitle);
			}

			qPos.add(status);

			return (List<Todo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Todo[] filterFindByG_UT_ST_PrevAndNext(
			long todoId, long groupId, String urlTitle, int status,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST_PrevAndNext(
				todoId, groupId, urlTitle, status, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = filterGetByG_UT_ST_PrevAndNext(
				session, todo, groupId, urlTitle, status, orderByComparator,
				true);

			array[1] = todo;

			array[2] = filterGetByG_UT_ST_PrevAndNext(
				session, todo, groupId, urlTitle, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo filterGetByG_UT_ST_PrevAndNext(
		Session session, Todo todo, long groupId, String urlTitle, int status,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		query.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindUrlTitle) {
			qPos.add(urlTitle);
		}

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching todos that the user has permission to view
	 */
	@Override
	public List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end, null);
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
	@Override
	public List<Todo> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST(
				groupId, urlTitle, statuses, start, end, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler query = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		if (statuses.length > 0) {
			query.append("(");

			query.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

			query.append(StringUtil.merge(statuses));

			query.append(")");

			query.append(")");
		}

		query.setStringAt(
			removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindUrlTitle) {
				qPos.add(urlTitle);
			}

			return (List<Todo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return findByG_UT_ST(
			groupId, urlTitle, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return findByG_UT_ST(groupId, urlTitle, statuses, start, end, null);
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
	@Override
	public List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByG_UT_ST(
				groupId, urlTitle, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					groupId, urlTitle, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, urlTitle, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				_finderPathWithPaginationFindByG_UT_ST, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((groupId != todo.getGroupId()) ||
						!urlTitle.equals(todo.getUrlTitle()) ||
						!ArrayUtil.contains(statuses, todo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_UT_ST, finderArgs,
						list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByG_UT_ST, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the todos where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	@Override
	public void removeByG_UT_ST(long groupId, String urlTitle, int status) {
		for (Todo todo :
				findByG_UT_ST(
					groupId, urlTitle, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching todos
	 */
	@Override
	public int countByG_UT_ST(long groupId, String urlTitle, int status) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByG_UT_ST;

		Object[] finderArgs = new Object[] {groupId, urlTitle, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			query.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching todos
	 */
	@Override
	public int countByG_UT_ST(long groupId, String urlTitle, int[] statuses) {
		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			groupId, urlTitle, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_UT_ST, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			if (statuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

				query.append(StringUtil.merge(statuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_UT_ST, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByG_UT_ST, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching todos that the user has permission to view
	 */
	@Override
	public int filterCountByG_UT_ST(long groupId, String urlTitle, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_UT_ST(groupId, urlTitle, status);
		}

		urlTitle = Objects.toString(urlTitle, "");

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_TODO_WHERE);

		query.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		query.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindUrlTitle) {
				qPos.add(urlTitle);
			}

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching todos that the user has permission to view
	 */
	@Override
	public int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_UT_ST(groupId, urlTitle, statuses);
		}

		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler query = new StringBundler();

		query.append(_FILTER_SQL_COUNT_TODO_WHERE);

		query.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			query.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		if (statuses.length > 0) {
			query.append("(");

			query.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

			query.append(StringUtil.merge(statuses));

			query.append(")");

			query.append(")");
		}

		query.setStringAt(
			removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindUrlTitle) {
				qPos.add(urlTitle);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_UT_ST_GROUPID_2 =
		"todo.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_URLTITLE_2 =
		"todo.urlTitle = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_URLTITLE_3 =
		"(todo.urlTitle IS NULL OR todo.urlTitle = '') AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_STATUS_2 =
		"todo.status = ?";

	private static final String _FINDER_COLUMN_G_UT_ST_STATUS_7 =
		"todo.status IN (";

	private FinderPath _finderPathFetchByG_UT;
	private FinderPath _finderPathCountByG_UT;

	/**
	 * Returns the todo where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByG_UT(long groupId, String urlTitle)
		throws NoSuchTodoException {

		Todo todo = fetchByG_UT(groupId, urlTitle);

		if (todo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", urlTitle=");
			msg.append(urlTitle);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTodoException(msg.toString());
		}

		return todo;
	}

	/**
	 * Returns the todo where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByG_UT(long groupId, String urlTitle) {
		return fetchByG_UT(groupId, urlTitle, true);
	}

	/**
	 * Returns the todo where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache) {

		urlTitle = Objects.toString(urlTitle, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, urlTitle};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_UT, finderArgs, this);
		}

		if (result instanceof Todo) {
			Todo todo = (Todo)result;

			if ((groupId != todo.getGroupId()) ||
				!Objects.equals(urlTitle, todo.getUrlTitle())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_UT_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				query.append(_FINDER_COLUMN_G_UT_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_UT_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				List<Todo> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_UT, finderArgs, list);
					}
				}
				else {
					Todo todo = list.get(0);

					result = todo;

					cacheResult(todo);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByG_UT, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Todo)result;
		}
	}

	/**
	 * Removes the todo where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the todo that was removed
	 */
	@Override
	public Todo removeByG_UT(long groupId, String urlTitle)
		throws NoSuchTodoException {

		Todo todo = findByG_UT(groupId, urlTitle);

		return remove(todo);
	}

	/**
	 * Returns the number of todos where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching todos
	 */
	@Override
	public int countByG_UT(long groupId, String urlTitle) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByG_UT;

		Object[] finderArgs = new Object[] {groupId, urlTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_G_UT_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				query.append(_FINDER_COLUMN_G_UT_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_UT_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_UT_GROUPID_2 =
		"todo.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_URLTITLE_2 =
		"todo.urlTitle = ?";

	private static final String _FINDER_COLUMN_G_UT_URLTITLE_3 =
		"(todo.urlTitle IS NULL OR todo.urlTitle = '')";

	private FinderPath _finderPathFetchByURLTitle;
	private FinderPath _finderPathCountByURLTitle;

	/**
	 * Returns the todo where urlTitle = &#63; or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByURLTitle(String urlTitle) throws NoSuchTodoException {
		Todo todo = fetchByURLTitle(urlTitle);

		if (todo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("urlTitle=");
			msg.append(urlTitle);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTodoException(msg.toString());
		}

		return todo;
	}

	/**
	 * Returns the todo where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByURLTitle(String urlTitle) {
		return fetchByURLTitle(urlTitle, true);
	}

	/**
	 * Returns the todo where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByURLTitle(String urlTitle, boolean useFinderCache) {
		urlTitle = Objects.toString(urlTitle, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {urlTitle};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByURLTitle, finderArgs, this);
		}

		if (result instanceof Todo) {
			Todo todo = (Todo)result;

			if (!Objects.equals(urlTitle, todo.getUrlTitle())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TODO_WHERE);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				query.append(_FINDER_COLUMN_URLTITLE_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_URLTITLE_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				List<Todo> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByURLTitle, finderArgs, list);
					}
				}
				else {
					Todo todo = list.get(0);

					result = todo;

					cacheResult(todo);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByURLTitle, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Todo)result;
		}
	}

	/**
	 * Removes the todo where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the todo that was removed
	 */
	@Override
	public Todo removeByURLTitle(String urlTitle) throws NoSuchTodoException {
		Todo todo = findByURLTitle(urlTitle);

		return remove(todo);
	}

	/**
	 * Returns the number of todos where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching todos
	 */
	@Override
	public int countByURLTitle(String urlTitle) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByURLTitle;

		Object[] finderArgs = new Object[] {urlTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				query.append(_FINDER_COLUMN_URLTITLE_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_URLTITLE_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_2 =
		"todo.urlTitle = ?";

	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_3 =
		"(todo.urlTitle IS NULL OR todo.urlTitle = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the todos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Todo> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (groupId != todo.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByGroupId_First(
			long groupId, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByGroupId_First(groupId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByGroupId_First(
		long groupId, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByGroupId_Last(
			long groupId, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByGroupId_Last(groupId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByGroupId_Last(
		long groupId, OrderByComparator<Todo> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByGroupId_PrevAndNext(
			long todoId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, todo, groupId, orderByComparator, true);

			array[1] = todo;

			array[2] = getByGroupId_PrevAndNext(
				session, todo, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByGroupId_PrevAndNext(
		Session session, Todo todo, long groupId,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the todos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching todos that the user has permission to view
	 */
	@Override
	public List<Todo> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> filterFindByGroupId(long groupId, int start, int end) {
		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<Todo> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Todo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Todo[] filterFindByGroupId_PrevAndNext(
			long todoId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				todoId, groupId, orderByComparator);
		}

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, todo, groupId, orderByComparator, true);

			array[1] = todo;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, todo, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo filterGetByGroupId_PrevAndNext(
		Session session, Todo todo, long groupId,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Todo todo :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching todos
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching todos that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TODO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"todo.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserIdGroupId;
	private FinderPath _finderPathWithoutPaginationFindByUserIdGroupId;
	private FinderPath _finderPathCountByUserIdGroupId;

	/**
	 * Returns all the todos where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByUserIdGroupId(long userId, long groupId) {
		return findByUserIdGroupId(
			userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return findByUserIdGroupId(userId, groupId, start, end, null);
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
	@Override
	public List<Todo> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserIdGroupId;
				finderArgs = new Object[] {userId, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserIdGroupId;
			finderArgs = new Object[] {
				userId, groupId, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if ((userId != todo.getUserId()) ||
						(groupId != todo.getGroupId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Todo findByUserIdGroupId_First(
			long userId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByUserIdGroupId_First(
			userId, groupId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByUserIdGroupId_First(
		long userId, long groupId, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByUserIdGroupId(
			userId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo findByUserIdGroupId_Last(
			long userId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByUserIdGroupId_Last(
			userId, groupId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByUserIdGroupId_Last(
		long userId, long groupId, OrderByComparator<Todo> orderByComparator) {

		int count = countByUserIdGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByUserIdGroupId(
			userId, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByUserIdGroupId_PrevAndNext(
			long todoId, long userId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByUserIdGroupId_PrevAndNext(
				session, todo, userId, groupId, orderByComparator, true);

			array[1] = todo;

			array[2] = getByUserIdGroupId_PrevAndNext(
				session, todo, userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByUserIdGroupId_PrevAndNext(
		Session session, Todo todo, long userId, long groupId,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the todos that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching todos that the user has permission to view
	 */
	@Override
	public List<Todo> filterFindByUserIdGroupId(long userId, long groupId) {
		return filterFindByUserIdGroupId(
			userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return filterFindByUserIdGroupId(userId, groupId, start, end, null);
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
	@Override
	public List<Todo> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId(
				userId, groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(groupId);

			return (List<Todo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Todo[] filterFindByUserIdGroupId_PrevAndNext(
			long todoId, long userId, long groupId,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId_PrevAndNext(
				todoId, userId, groupId, orderByComparator);
		}

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = filterGetByUserIdGroupId_PrevAndNext(
				session, todo, userId, groupId, orderByComparator, true);

			array[1] = todo;

			array[2] = filterGetByUserIdGroupId_PrevAndNext(
				session, todo, userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo filterGetByUserIdGroupId_PrevAndNext(
		Session session, Todo todo, long userId, long groupId,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByUserIdGroupId(long userId, long groupId) {
		for (Todo todo :
				findByUserIdGroupId(
					userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching todos
	 */
	@Override
	public int countByUserIdGroupId(long userId, long groupId) {
		FinderPath finderPath = _finderPathCountByUserIdGroupId;

		Object[] finderArgs = new Object[] {userId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of todos that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching todos that the user has permission to view
	 */
	@Override
	public int filterCountByUserIdGroupId(long userId, long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByUserIdGroupId(userId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TODO_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), Todo.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_USERIDGROUPID_USERID_2 =
		"todo.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 =
		"todo.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the todos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<Todo> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (userId != todo.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByUserId_First(
			long userId, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByUserId_First(userId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByUserId_First(
		long userId, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByUserId_Last(
			long userId, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByUserId_Last(userId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByUserId_Last(
		long userId, OrderByComparator<Todo> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByUserId_PrevAndNext(
			long todoId, long userId, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, todo, userId, orderByComparator, true);

			array[1] = todo;

			array[2] = getByUserId_PrevAndNext(
				session, todo, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByUserId_PrevAndNext(
		Session session, Todo todo, long userId,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (Todo todo :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching todos
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"todo.userId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the todos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByCompanyId(long companyId, int start, int end) {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<Todo> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyId;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (companyId != todo.getCompanyId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByCompanyId_First(
			long companyId, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByCompanyId_First(companyId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByCompanyId_First(
		long companyId, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByCompanyId_Last(
			long companyId, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByCompanyId_Last(companyId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByCompanyId_Last(
		long companyId, OrderByComparator<Todo> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByCompanyId_PrevAndNext(
			long todoId, long companyId,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, todo, companyId, orderByComparator, true);

			array[1] = todo;

			array[2] = getByCompanyId_PrevAndNext(
				session, todo, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByCompanyId_PrevAndNext(
		Session session, Todo todo, long companyId,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (Todo todo :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching todos
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"todo.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTodoId;
	private FinderPath _finderPathWithoutPaginationFindByTodoId;
	private FinderPath _finderPathCountByTodoId;

	/**
	 * Returns all the todos where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByTodoId(long todoId) {
		return findByTodoId(todoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByTodoId(long todoId, int start, int end) {
		return findByTodoId(todoId, start, end, null);
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
	@Override
	public List<Todo> findByTodoId(
		long todoId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByTodoId(todoId, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByTodoId(
		long todoId, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTodoId;
				finderArgs = new Object[] {todoId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTodoId;
			finderArgs = new Object[] {todoId, start, end, orderByComparator};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (todoId != todo.getTodoId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_TODOID_TODOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(todoId);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoId_First(
			long todoId, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoId_First(todoId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoId=");
		msg.append(todoId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoId_First(
		long todoId, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByTodoId(todoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoId_Last(
			long todoId, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoId_Last(todoId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoId=");
		msg.append(todoId);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoId_Last(
		long todoId, OrderByComparator<Todo> orderByComparator) {

		int count = countByTodoId(todoId);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByTodoId(
			todoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the todos where todoId = &#63; from the database.
	 *
	 * @param todoId the todo ID
	 */
	@Override
	public void removeByTodoId(long todoId) {
		for (Todo todo :
				findByTodoId(
					todoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where todoId = &#63;.
	 *
	 * @param todoId the todo ID
	 * @return the number of matching todos
	 */
	@Override
	public int countByTodoId(long todoId) {
		FinderPath finderPath = _finderPathCountByTodoId;

		Object[] finderArgs = new Object[] {todoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_TODOID_TODOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(todoId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TODOID_TODOID_2 =
		"todo.todoId = ?";

	private FinderPath _finderPathWithPaginationFindByTitle;
	private FinderPath _finderPathWithoutPaginationFindByTitle;
	private FinderPath _finderPathCountByTitle;

	/**
	 * Returns all the todos where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByTitle(String title) {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByTitle(String title, int start, int end) {
		return findByTitle(title, start, end, null);
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
	@Override
	public List<Todo> findByTitle(
		String title, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByTitle(title, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByTitle(
		String title, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		title = Objects.toString(title, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTitle;
				finderArgs = new Object[] {title};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTitle;
			finderArgs = new Object[] {title, start, end, orderByComparator};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (!title.equals(todo.getTitle())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTitle_First(
			String title, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTitle_First(title, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTitle_First(
		String title, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTitle_Last(
			String title, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTitle_Last(title, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTitle_Last(
		String title, OrderByComparator<Todo> orderByComparator) {

		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByTitle(
			title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByTitle_PrevAndNext(
			long todoId, String title,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		title = Objects.toString(title, "");

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByTitle_PrevAndNext(
				session, todo, title, orderByComparator, true);

			array[1] = todo;

			array[2] = getByTitle_PrevAndNext(
				session, todo, title, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByTitle_PrevAndNext(
		Session session, Todo todo, String title,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		boolean bindTitle = false;

		if (title.isEmpty()) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_TITLE_TITLE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTitle) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	@Override
	public void removeByTitle(String title) {
		for (Todo todo :
				findByTitle(
					title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching todos
	 */
	@Override
	public int countByTitle(String title) {
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathCountByTitle;

		Object[] finderArgs = new Object[] {title};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "todo.title = ?";

	private static final String _FINDER_COLUMN_TITLE_TITLE_3 =
		"(todo.title IS NULL OR todo.title = '')";

	private FinderPath _finderPathWithPaginationFindByTodoBooleanStat;
	private FinderPath _finderPathWithoutPaginationFindByTodoBooleanStat;
	private FinderPath _finderPathCountByTodoBooleanStat;

	/**
	 * Returns all the todos where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByTodoBooleanStat(boolean todoBooleanStat) {
		return findByTodoBooleanStat(
			todoBooleanStat, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByTodoBooleanStat(
		boolean todoBooleanStat, int start, int end) {

		return findByTodoBooleanStat(todoBooleanStat, start, end, null);
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
	@Override
	public List<Todo> findByTodoBooleanStat(
		boolean todoBooleanStat, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByTodoBooleanStat(
			todoBooleanStat, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByTodoBooleanStat(
		boolean todoBooleanStat, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTodoBooleanStat;
				finderArgs = new Object[] {todoBooleanStat};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTodoBooleanStat;
			finderArgs = new Object[] {
				todoBooleanStat, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (todoBooleanStat != todo.isTodoBooleanStat()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_TODOBOOLEANSTAT_TODOBOOLEANSTAT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(todoBooleanStat);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoBooleanStat_First(
			boolean todoBooleanStat, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoBooleanStat_First(
			todoBooleanStat, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoBooleanStat=");
		msg.append(todoBooleanStat);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoBooleanStat_First(
		boolean todoBooleanStat, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByTodoBooleanStat(
			todoBooleanStat, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoBooleanStat_Last(
			boolean todoBooleanStat, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoBooleanStat_Last(
			todoBooleanStat, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoBooleanStat=");
		msg.append(todoBooleanStat);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoBooleanStat_Last(
		boolean todoBooleanStat, OrderByComparator<Todo> orderByComparator) {

		int count = countByTodoBooleanStat(todoBooleanStat);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByTodoBooleanStat(
			todoBooleanStat, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByTodoBooleanStat_PrevAndNext(
			long todoId, boolean todoBooleanStat,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByTodoBooleanStat_PrevAndNext(
				session, todo, todoBooleanStat, orderByComparator, true);

			array[1] = todo;

			array[2] = getByTodoBooleanStat_PrevAndNext(
				session, todo, todoBooleanStat, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByTodoBooleanStat_PrevAndNext(
		Session session, Todo todo, boolean todoBooleanStat,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_TODOBOOLEANSTAT_TODOBOOLEANSTAT_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(todoBooleanStat);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where todoBooleanStat = &#63; from the database.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 */
	@Override
	public void removeByTodoBooleanStat(boolean todoBooleanStat) {
		for (Todo todo :
				findByTodoBooleanStat(
					todoBooleanStat, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where todoBooleanStat = &#63;.
	 *
	 * @param todoBooleanStat the todo boolean stat
	 * @return the number of matching todos
	 */
	@Override
	public int countByTodoBooleanStat(boolean todoBooleanStat) {
		FinderPath finderPath = _finderPathCountByTodoBooleanStat;

		Object[] finderArgs = new Object[] {todoBooleanStat};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_TODOBOOLEANSTAT_TODOBOOLEANSTAT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(todoBooleanStat);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_TODOBOOLEANSTAT_TODOBOOLEANSTAT_2 =
			"todo.todoBooleanStat = ?";

	private FinderPath _finderPathWithPaginationFindByTodoDateTime;
	private FinderPath _finderPathWithoutPaginationFindByTodoDateTime;
	private FinderPath _finderPathCountByTodoDateTime;

	/**
	 * Returns all the todos where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByTodoDateTime(Date todoDateTime) {
		return findByTodoDateTime(
			todoDateTime, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByTodoDateTime(
		Date todoDateTime, int start, int end) {

		return findByTodoDateTime(todoDateTime, start, end, null);
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
	@Override
	public List<Todo> findByTodoDateTime(
		Date todoDateTime, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByTodoDateTime(
			todoDateTime, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByTodoDateTime(
		Date todoDateTime, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTodoDateTime;
				finderArgs = new Object[] {_getTime(todoDateTime)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTodoDateTime;
			finderArgs = new Object[] {
				_getTime(todoDateTime), start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (!Objects.equals(todoDateTime, todo.getTodoDateTime())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			boolean bindTodoDateTime = false;

			if (todoDateTime == null) {
				query.append(_FINDER_COLUMN_TODODATETIME_TODODATETIME_1);
			}
			else {
				bindTodoDateTime = true;

				query.append(_FINDER_COLUMN_TODODATETIME_TODODATETIME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTodoDateTime) {
					qPos.add(new Timestamp(todoDateTime.getTime()));
				}

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoDateTime_First(
			Date todoDateTime, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoDateTime_First(todoDateTime, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoDateTime=");
		msg.append(todoDateTime);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoDateTime_First(
		Date todoDateTime, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByTodoDateTime(
			todoDateTime, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoDateTime_Last(
			Date todoDateTime, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoDateTime_Last(todoDateTime, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoDateTime=");
		msg.append(todoDateTime);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoDateTime_Last(
		Date todoDateTime, OrderByComparator<Todo> orderByComparator) {

		int count = countByTodoDateTime(todoDateTime);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByTodoDateTime(
			todoDateTime, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByTodoDateTime_PrevAndNext(
			long todoId, Date todoDateTime,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByTodoDateTime_PrevAndNext(
				session, todo, todoDateTime, orderByComparator, true);

			array[1] = todo;

			array[2] = getByTodoDateTime_PrevAndNext(
				session, todo, todoDateTime, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByTodoDateTime_PrevAndNext(
		Session session, Todo todo, Date todoDateTime,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		boolean bindTodoDateTime = false;

		if (todoDateTime == null) {
			query.append(_FINDER_COLUMN_TODODATETIME_TODODATETIME_1);
		}
		else {
			bindTodoDateTime = true;

			query.append(_FINDER_COLUMN_TODODATETIME_TODODATETIME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTodoDateTime) {
			qPos.add(new Timestamp(todoDateTime.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where todoDateTime = &#63; from the database.
	 *
	 * @param todoDateTime the todo date time
	 */
	@Override
	public void removeByTodoDateTime(Date todoDateTime) {
		for (Todo todo :
				findByTodoDateTime(
					todoDateTime, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where todoDateTime = &#63;.
	 *
	 * @param todoDateTime the todo date time
	 * @return the number of matching todos
	 */
	@Override
	public int countByTodoDateTime(Date todoDateTime) {
		FinderPath finderPath = _finderPathCountByTodoDateTime;

		Object[] finderArgs = new Object[] {_getTime(todoDateTime)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			boolean bindTodoDateTime = false;

			if (todoDateTime == null) {
				query.append(_FINDER_COLUMN_TODODATETIME_TODODATETIME_1);
			}
			else {
				bindTodoDateTime = true;

				query.append(_FINDER_COLUMN_TODODATETIME_TODODATETIME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTodoDateTime) {
					qPos.add(new Timestamp(todoDateTime.getTime()));
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TODODATETIME_TODODATETIME_1 =
		"todo.todoDateTime IS NULL";

	private static final String _FINDER_COLUMN_TODODATETIME_TODODATETIME_2 =
		"todo.todoDateTime = ?";

	private FinderPath _finderPathWithPaginationFindByTodoDocumentLibrary;
	private FinderPath _finderPathWithoutPaginationFindByTodoDocumentLibrary;
	private FinderPath _finderPathCountByTodoDocumentLibrary;

	/**
	 * Returns all the todos where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByTodoDocumentLibrary(String todoDocumentLibrary) {
		return findByTodoDocumentLibrary(
			todoDocumentLibrary, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary, int start, int end) {

		return findByTodoDocumentLibrary(todoDocumentLibrary, start, end, null);
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
	@Override
	public List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByTodoDocumentLibrary(
			todoDocumentLibrary, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByTodoDocumentLibrary(
		String todoDocumentLibrary, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		todoDocumentLibrary = Objects.toString(todoDocumentLibrary, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTodoDocumentLibrary;
				finderArgs = new Object[] {todoDocumentLibrary};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTodoDocumentLibrary;
			finderArgs = new Object[] {
				todoDocumentLibrary, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (!todoDocumentLibrary.equals(
							todo.getTodoDocumentLibrary())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			boolean bindTodoDocumentLibrary = false;

			if (todoDocumentLibrary.isEmpty()) {
				query.append(
					_FINDER_COLUMN_TODODOCUMENTLIBRARY_TODODOCUMENTLIBRARY_3);
			}
			else {
				bindTodoDocumentLibrary = true;

				query.append(
					_FINDER_COLUMN_TODODOCUMENTLIBRARY_TODODOCUMENTLIBRARY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTodoDocumentLibrary) {
					qPos.add(todoDocumentLibrary);
				}

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoDocumentLibrary_First(
			String todoDocumentLibrary,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoDocumentLibrary_First(
			todoDocumentLibrary, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoDocumentLibrary=");
		msg.append(todoDocumentLibrary);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoDocumentLibrary_First(
		String todoDocumentLibrary, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByTodoDocumentLibrary(
			todoDocumentLibrary, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoDocumentLibrary_Last(
			String todoDocumentLibrary,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoDocumentLibrary_Last(
			todoDocumentLibrary, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoDocumentLibrary=");
		msg.append(todoDocumentLibrary);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoDocumentLibrary_Last(
		String todoDocumentLibrary, OrderByComparator<Todo> orderByComparator) {

		int count = countByTodoDocumentLibrary(todoDocumentLibrary);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByTodoDocumentLibrary(
			todoDocumentLibrary, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByTodoDocumentLibrary_PrevAndNext(
			long todoId, String todoDocumentLibrary,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		todoDocumentLibrary = Objects.toString(todoDocumentLibrary, "");

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByTodoDocumentLibrary_PrevAndNext(
				session, todo, todoDocumentLibrary, orderByComparator, true);

			array[1] = todo;

			array[2] = getByTodoDocumentLibrary_PrevAndNext(
				session, todo, todoDocumentLibrary, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByTodoDocumentLibrary_PrevAndNext(
		Session session, Todo todo, String todoDocumentLibrary,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		boolean bindTodoDocumentLibrary = false;

		if (todoDocumentLibrary.isEmpty()) {
			query.append(
				_FINDER_COLUMN_TODODOCUMENTLIBRARY_TODODOCUMENTLIBRARY_3);
		}
		else {
			bindTodoDocumentLibrary = true;

			query.append(
				_FINDER_COLUMN_TODODOCUMENTLIBRARY_TODODOCUMENTLIBRARY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTodoDocumentLibrary) {
			qPos.add(todoDocumentLibrary);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where todoDocumentLibrary = &#63; from the database.
	 *
	 * @param todoDocumentLibrary the todo document library
	 */
	@Override
	public void removeByTodoDocumentLibrary(String todoDocumentLibrary) {
		for (Todo todo :
				findByTodoDocumentLibrary(
					todoDocumentLibrary, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where todoDocumentLibrary = &#63;.
	 *
	 * @param todoDocumentLibrary the todo document library
	 * @return the number of matching todos
	 */
	@Override
	public int countByTodoDocumentLibrary(String todoDocumentLibrary) {
		todoDocumentLibrary = Objects.toString(todoDocumentLibrary, "");

		FinderPath finderPath = _finderPathCountByTodoDocumentLibrary;

		Object[] finderArgs = new Object[] {todoDocumentLibrary};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			boolean bindTodoDocumentLibrary = false;

			if (todoDocumentLibrary.isEmpty()) {
				query.append(
					_FINDER_COLUMN_TODODOCUMENTLIBRARY_TODODOCUMENTLIBRARY_3);
			}
			else {
				bindTodoDocumentLibrary = true;

				query.append(
					_FINDER_COLUMN_TODODOCUMENTLIBRARY_TODODOCUMENTLIBRARY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTodoDocumentLibrary) {
					qPos.add(todoDocumentLibrary);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_TODODOCUMENTLIBRARY_TODODOCUMENTLIBRARY_2 =
			"todo.todoDocumentLibrary = ?";

	private static final String
		_FINDER_COLUMN_TODODOCUMENTLIBRARY_TODODOCUMENTLIBRARY_3 =
			"(todo.todoDocumentLibrary IS NULL OR todo.todoDocumentLibrary = '')";

	private FinderPath _finderPathWithPaginationFindByTodoDouble;
	private FinderPath _finderPathWithoutPaginationFindByTodoDouble;
	private FinderPath _finderPathCountByTodoDouble;

	/**
	 * Returns all the todos where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByTodoDouble(double todoDouble) {
		return findByTodoDouble(
			todoDouble, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByTodoDouble(double todoDouble, int start, int end) {
		return findByTodoDouble(todoDouble, start, end, null);
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
	@Override
	public List<Todo> findByTodoDouble(
		double todoDouble, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByTodoDouble(
			todoDouble, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByTodoDouble(
		double todoDouble, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTodoDouble;
				finderArgs = new Object[] {todoDouble};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTodoDouble;
			finderArgs = new Object[] {
				todoDouble, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (todoDouble != todo.getTodoDouble()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_TODODOUBLE_TODODOUBLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(todoDouble);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoDouble_First(
			double todoDouble, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoDouble_First(todoDouble, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoDouble=");
		msg.append(todoDouble);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoDouble_First(
		double todoDouble, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByTodoDouble(todoDouble, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoDouble_Last(
			double todoDouble, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoDouble_Last(todoDouble, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoDouble=");
		msg.append(todoDouble);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoDouble_Last(
		double todoDouble, OrderByComparator<Todo> orderByComparator) {

		int count = countByTodoDouble(todoDouble);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByTodoDouble(
			todoDouble, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByTodoDouble_PrevAndNext(
			long todoId, double todoDouble,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByTodoDouble_PrevAndNext(
				session, todo, todoDouble, orderByComparator, true);

			array[1] = todo;

			array[2] = getByTodoDouble_PrevAndNext(
				session, todo, todoDouble, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByTodoDouble_PrevAndNext(
		Session session, Todo todo, double todoDouble,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_TODODOUBLE_TODODOUBLE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(todoDouble);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where todoDouble = &#63; from the database.
	 *
	 * @param todoDouble the todo double
	 */
	@Override
	public void removeByTodoDouble(double todoDouble) {
		for (Todo todo :
				findByTodoDouble(
					todoDouble, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where todoDouble = &#63;.
	 *
	 * @param todoDouble the todo double
	 * @return the number of matching todos
	 */
	@Override
	public int countByTodoDouble(double todoDouble) {
		FinderPath finderPath = _finderPathCountByTodoDouble;

		Object[] finderArgs = new Object[] {todoDouble};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_TODODOUBLE_TODODOUBLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(todoDouble);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TODODOUBLE_TODODOUBLE_2 =
		"todo.todoDouble = ?";

	private FinderPath _finderPathWithPaginationFindByTodoInteger;
	private FinderPath _finderPathWithoutPaginationFindByTodoInteger;
	private FinderPath _finderPathCountByTodoInteger;

	/**
	 * Returns all the todos where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByTodoInteger(int todoInteger) {
		return findByTodoInteger(
			todoInteger, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByTodoInteger(int todoInteger, int start, int end) {
		return findByTodoInteger(todoInteger, start, end, null);
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
	@Override
	public List<Todo> findByTodoInteger(
		int todoInteger, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByTodoInteger(
			todoInteger, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByTodoInteger(
		int todoInteger, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTodoInteger;
				finderArgs = new Object[] {todoInteger};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTodoInteger;
			finderArgs = new Object[] {
				todoInteger, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (todoInteger != todo.getTodoInteger()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_TODOINTEGER_TODOINTEGER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(todoInteger);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoInteger_First(
			int todoInteger, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoInteger_First(todoInteger, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoInteger=");
		msg.append(todoInteger);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoInteger_First(
		int todoInteger, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByTodoInteger(
			todoInteger, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoInteger_Last(
			int todoInteger, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoInteger_Last(todoInteger, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoInteger=");
		msg.append(todoInteger);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoInteger_Last(
		int todoInteger, OrderByComparator<Todo> orderByComparator) {

		int count = countByTodoInteger(todoInteger);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByTodoInteger(
			todoInteger, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByTodoInteger_PrevAndNext(
			long todoId, int todoInteger,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByTodoInteger_PrevAndNext(
				session, todo, todoInteger, orderByComparator, true);

			array[1] = todo;

			array[2] = getByTodoInteger_PrevAndNext(
				session, todo, todoInteger, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByTodoInteger_PrevAndNext(
		Session session, Todo todo, int todoInteger,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_TODOINTEGER_TODOINTEGER_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(todoInteger);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where todoInteger = &#63; from the database.
	 *
	 * @param todoInteger the todo integer
	 */
	@Override
	public void removeByTodoInteger(int todoInteger) {
		for (Todo todo :
				findByTodoInteger(
					todoInteger, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where todoInteger = &#63;.
	 *
	 * @param todoInteger the todo integer
	 * @return the number of matching todos
	 */
	@Override
	public int countByTodoInteger(int todoInteger) {
		FinderPath finderPath = _finderPathCountByTodoInteger;

		Object[] finderArgs = new Object[] {todoInteger};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_TODOINTEGER_TODOINTEGER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(todoInteger);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TODOINTEGER_TODOINTEGER_2 =
		"todo.todoInteger = ?";

	private FinderPath _finderPathWithPaginationFindByTodoRichText;
	private FinderPath _finderPathWithoutPaginationFindByTodoRichText;
	private FinderPath _finderPathCountByTodoRichText;

	/**
	 * Returns all the todos where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByTodoRichText(String todoRichText) {
		return findByTodoRichText(
			todoRichText, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByTodoRichText(
		String todoRichText, int start, int end) {

		return findByTodoRichText(todoRichText, start, end, null);
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
	@Override
	public List<Todo> findByTodoRichText(
		String todoRichText, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByTodoRichText(
			todoRichText, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByTodoRichText(
		String todoRichText, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		todoRichText = Objects.toString(todoRichText, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTodoRichText;
				finderArgs = new Object[] {todoRichText};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTodoRichText;
			finderArgs = new Object[] {
				todoRichText, start, end, orderByComparator
			};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (!todoRichText.equals(todo.getTodoRichText())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			boolean bindTodoRichText = false;

			if (todoRichText.isEmpty()) {
				query.append(_FINDER_COLUMN_TODORICHTEXT_TODORICHTEXT_3);
			}
			else {
				bindTodoRichText = true;

				query.append(_FINDER_COLUMN_TODORICHTEXT_TODORICHTEXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTodoRichText) {
					qPos.add(todoRichText);
				}

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoRichText_First(
			String todoRichText, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoRichText_First(todoRichText, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoRichText=");
		msg.append(todoRichText);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoRichText_First(
		String todoRichText, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByTodoRichText(
			todoRichText, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoRichText_Last(
			String todoRichText, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoRichText_Last(todoRichText, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoRichText=");
		msg.append(todoRichText);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoRichText_Last(
		String todoRichText, OrderByComparator<Todo> orderByComparator) {

		int count = countByTodoRichText(todoRichText);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByTodoRichText(
			todoRichText, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByTodoRichText_PrevAndNext(
			long todoId, String todoRichText,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		todoRichText = Objects.toString(todoRichText, "");

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByTodoRichText_PrevAndNext(
				session, todo, todoRichText, orderByComparator, true);

			array[1] = todo;

			array[2] = getByTodoRichText_PrevAndNext(
				session, todo, todoRichText, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByTodoRichText_PrevAndNext(
		Session session, Todo todo, String todoRichText,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		boolean bindTodoRichText = false;

		if (todoRichText.isEmpty()) {
			query.append(_FINDER_COLUMN_TODORICHTEXT_TODORICHTEXT_3);
		}
		else {
			bindTodoRichText = true;

			query.append(_FINDER_COLUMN_TODORICHTEXT_TODORICHTEXT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTodoRichText) {
			qPos.add(todoRichText);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where todoRichText = &#63; from the database.
	 *
	 * @param todoRichText the todo rich text
	 */
	@Override
	public void removeByTodoRichText(String todoRichText) {
		for (Todo todo :
				findByTodoRichText(
					todoRichText, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where todoRichText = &#63;.
	 *
	 * @param todoRichText the todo rich text
	 * @return the number of matching todos
	 */
	@Override
	public int countByTodoRichText(String todoRichText) {
		todoRichText = Objects.toString(todoRichText, "");

		FinderPath finderPath = _finderPathCountByTodoRichText;

		Object[] finderArgs = new Object[] {todoRichText};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			boolean bindTodoRichText = false;

			if (todoRichText.isEmpty()) {
				query.append(_FINDER_COLUMN_TODORICHTEXT_TODORICHTEXT_3);
			}
			else {
				bindTodoRichText = true;

				query.append(_FINDER_COLUMN_TODORICHTEXT_TODORICHTEXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTodoRichText) {
					qPos.add(todoRichText);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TODORICHTEXT_TODORICHTEXT_2 =
		"todo.todoRichText = ?";

	private static final String _FINDER_COLUMN_TODORICHTEXT_TODORICHTEXT_3 =
		"(todo.todoRichText IS NULL OR todo.todoRichText = '')";

	private FinderPath _finderPathWithPaginationFindByTodoText;
	private FinderPath _finderPathWithoutPaginationFindByTodoText;
	private FinderPath _finderPathCountByTodoText;

	/**
	 * Returns all the todos where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @return the matching todos
	 */
	@Override
	public List<Todo> findByTodoText(String todoText) {
		return findByTodoText(
			todoText, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByTodoText(String todoText, int start, int end) {
		return findByTodoText(todoText, start, end, null);
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
	@Override
	public List<Todo> findByTodoText(
		String todoText, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findByTodoText(todoText, start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findByTodoText(
		String todoText, int start, int end,
		OrderByComparator<Todo> orderByComparator, boolean useFinderCache) {

		todoText = Objects.toString(todoText, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTodoText;
				finderArgs = new Object[] {todoText};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTodoText;
			finderArgs = new Object[] {todoText, start, end, orderByComparator};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Todo todo : list) {
					if (!todoText.equals(todo.getTodoText())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			boolean bindTodoText = false;

			if (todoText.isEmpty()) {
				query.append(_FINDER_COLUMN_TODOTEXT_TODOTEXT_3);
			}
			else {
				bindTodoText = true;

				query.append(_FINDER_COLUMN_TODOTEXT_TODOTEXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTodoText) {
					qPos.add(todoText);
				}

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoText_First(
			String todoText, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoText_First(todoText, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoText=");
		msg.append(todoText);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the first todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoText_First(
		String todoText, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = findByTodoText(todoText, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	@Override
	public Todo findByTodoText_Last(
			String todoText, OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		Todo todo = fetchByTodoText_Last(todoText, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("todoText=");
		msg.append(todoText);

		msg.append("}");

		throw new NoSuchTodoException(msg.toString());
	}

	/**
	 * Returns the last todo in the ordered set where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	@Override
	public Todo fetchByTodoText_Last(
		String todoText, OrderByComparator<Todo> orderByComparator) {

		int count = countByTodoText(todoText);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByTodoText(
			todoText, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByTodoText_PrevAndNext(
			long todoId, String todoText,
			OrderByComparator<Todo> orderByComparator)
		throws NoSuchTodoException {

		todoText = Objects.toString(todoText, "");

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByTodoText_PrevAndNext(
				session, todo, todoText, orderByComparator, true);

			array[1] = todo;

			array[2] = getByTodoText_PrevAndNext(
				session, todo, todoText, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByTodoText_PrevAndNext(
		Session session, Todo todo, String todoText,
		OrderByComparator<Todo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		boolean bindTodoText = false;

		if (todoText.isEmpty()) {
			query.append(_FINDER_COLUMN_TODOTEXT_TODOTEXT_3);
		}
		else {
			bindTodoText = true;

			query.append(_FINDER_COLUMN_TODOTEXT_TODOTEXT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTodoText) {
			qPos.add(todoText);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(todo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where todoText = &#63; from the database.
	 *
	 * @param todoText the todo text
	 */
	@Override
	public void removeByTodoText(String todoText) {
		for (Todo todo :
				findByTodoText(
					todoText, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(todo);
		}
	}

	/**
	 * Returns the number of todos where todoText = &#63;.
	 *
	 * @param todoText the todo text
	 * @return the number of matching todos
	 */
	@Override
	public int countByTodoText(String todoText) {
		todoText = Objects.toString(todoText, "");

		FinderPath finderPath = _finderPathCountByTodoText;

		Object[] finderArgs = new Object[] {todoText};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TODO_WHERE);

			boolean bindTodoText = false;

			if (todoText.isEmpty()) {
				query.append(_FINDER_COLUMN_TODOTEXT_TODOTEXT_3);
			}
			else {
				bindTodoText = true;

				query.append(_FINDER_COLUMN_TODOTEXT_TODOTEXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTodoText) {
					qPos.add(todoText);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TODOTEXT_TODOTEXT_2 =
		"todo.todoText = ?";

	private static final String _FINDER_COLUMN_TODOTEXT_TODOTEXT_3 =
		"(todo.todoText IS NULL OR todo.todoText = '')";

	public TodoPersistenceImpl() {
		setModelClass(Todo.class);

		setModelImplClass(TodoImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the todo in the entity cache if it is enabled.
	 *
	 * @param todo the todo
	 */
	@Override
	public void cacheResult(Todo todo) {
		entityCache.putResult(
			entityCacheEnabled, TodoImpl.class, todo.getPrimaryKey(), todo);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {todo.getUuid(), todo.getGroupId()}, todo);

		finderCache.putResult(
			_finderPathFetchByG_UT,
			new Object[] {todo.getGroupId(), todo.getUrlTitle()}, todo);

		finderCache.putResult(
			_finderPathFetchByURLTitle, new Object[] {todo.getUrlTitle()},
			todo);

		todo.resetOriginalValues();
	}

	/**
	 * Caches the todos in the entity cache if it is enabled.
	 *
	 * @param todos the todos
	 */
	@Override
	public void cacheResult(List<Todo> todos) {
		for (Todo todo : todos) {
			if (entityCache.getResult(
					entityCacheEnabled, TodoImpl.class, todo.getPrimaryKey()) ==
						null) {

				cacheResult(todo);
			}
			else {
				todo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all todos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TodoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the todo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Todo todo) {
		entityCache.removeResult(
			entityCacheEnabled, TodoImpl.class, todo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TodoModelImpl)todo, true);
	}

	@Override
	public void clearCache(List<Todo> todos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Todo todo : todos) {
			entityCache.removeResult(
				entityCacheEnabled, TodoImpl.class, todo.getPrimaryKey());

			clearUniqueFindersCache((TodoModelImpl)todo, true);
		}
	}

	protected void cacheUniqueFindersCache(TodoModelImpl todoModelImpl) {
		Object[] args = new Object[] {
			todoModelImpl.getUuid(), todoModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, todoModelImpl, false);

		args = new Object[] {
			todoModelImpl.getGroupId(), todoModelImpl.getUrlTitle()
		};

		finderCache.putResult(
			_finderPathCountByG_UT, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_UT, args, todoModelImpl, false);

		args = new Object[] {todoModelImpl.getUrlTitle()};

		finderCache.putResult(
			_finderPathCountByURLTitle, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByURLTitle, args, todoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TodoModelImpl todoModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				todoModelImpl.getUuid(), todoModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((todoModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				todoModelImpl.getOriginalUuid(),
				todoModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				todoModelImpl.getGroupId(), todoModelImpl.getUrlTitle()
			};

			finderCache.removeResult(_finderPathCountByG_UT, args);
			finderCache.removeResult(_finderPathFetchByG_UT, args);
		}

		if ((todoModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_UT.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				todoModelImpl.getOriginalGroupId(),
				todoModelImpl.getOriginalUrlTitle()
			};

			finderCache.removeResult(_finderPathCountByG_UT, args);
			finderCache.removeResult(_finderPathFetchByG_UT, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {todoModelImpl.getUrlTitle()};

			finderCache.removeResult(_finderPathCountByURLTitle, args);
			finderCache.removeResult(_finderPathFetchByURLTitle, args);
		}

		if ((todoModelImpl.getColumnBitmask() &
			 _finderPathFetchByURLTitle.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {todoModelImpl.getOriginalUrlTitle()};

			finderCache.removeResult(_finderPathCountByURLTitle, args);
			finderCache.removeResult(_finderPathFetchByURLTitle, args);
		}
	}

	/**
	 * Creates a new todo with the primary key. Does not add the todo to the database.
	 *
	 * @param todoId the primary key for the new todo
	 * @return the new todo
	 */
	@Override
	public Todo create(long todoId) {
		Todo todo = new TodoImpl();

		todo.setNew(true);
		todo.setPrimaryKey(todoId);

		String uuid = PortalUUIDUtil.generate();

		todo.setUuid(uuid);

		todo.setCompanyId(CompanyThreadLocal.getCompanyId());

		return todo;
	}

	/**
	 * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo that was removed
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	@Override
	public Todo remove(long todoId) throws NoSuchTodoException {
		return remove((Serializable)todoId);
	}

	/**
	 * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the todo
	 * @return the todo that was removed
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	@Override
	public Todo remove(Serializable primaryKey) throws NoSuchTodoException {
		Session session = null;

		try {
			session = openSession();

			Todo todo = (Todo)session.get(TodoImpl.class, primaryKey);

			if (todo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTodoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(todo);
		}
		catch (NoSuchTodoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Todo removeImpl(Todo todo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(todo)) {
				todo = (Todo)session.get(
					TodoImpl.class, todo.getPrimaryKeyObj());
			}

			if (todo != null) {
				session.delete(todo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (todo != null) {
			clearCache(todo);
		}

		return todo;
	}

	@Override
	public Todo updateImpl(Todo todo) {
		boolean isNew = todo.isNew();

		if (!(todo instanceof TodoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(todo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(todo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in todo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Todo implementation " +
					todo.getClass());
		}

		TodoModelImpl todoModelImpl = (TodoModelImpl)todo;

		if (Validator.isNull(todo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			todo.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (todo.getCreateDate() == null)) {
			if (serviceContext == null) {
				todo.setCreateDate(now);
			}
			else {
				todo.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!todoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				todo.setModifiedDate(now);
			}
			else {
				todo.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (todo.isNew()) {
				session.save(todo);

				todo.setNew(false);
			}
			else {
				todo = (Todo)session.merge(todo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {todoModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				todoModelImpl.getUuid(), todoModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				todoModelImpl.getCompanyId(), todoModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByC_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_S, args);

			args = new Object[] {
				todoModelImpl.getGroupId(), todoModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S, args);

			args = new Object[] {
				todoModelImpl.getCompanyId(), todoModelImpl.getUserId(),
				todoModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByC_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_U_S, args);

			args = new Object[] {
				todoModelImpl.getGroupId(), todoModelImpl.getUserId(),
				todoModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_U_S, args);

			args = new Object[] {
				todoModelImpl.getUserId(), todoModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByU_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByU_S, args);

			args = new Object[] {
				todoModelImpl.getGroupId(), todoModelImpl.getUrlTitle(),
				todoModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_UT_ST, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_UT_ST, args);

			args = new Object[] {todoModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				todoModelImpl.getUserId(), todoModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUserIdGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserIdGroupId, args);

			args = new Object[] {todoModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {todoModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompanyId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompanyId, args);

			args = new Object[] {todoModelImpl.getTodoId()};

			finderCache.removeResult(_finderPathCountByTodoId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTodoId, args);

			args = new Object[] {todoModelImpl.getTitle()};

			finderCache.removeResult(_finderPathCountByTitle, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTitle, args);

			args = new Object[] {todoModelImpl.isTodoBooleanStat()};

			finderCache.removeResult(_finderPathCountByTodoBooleanStat, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTodoBooleanStat, args);

			args = new Object[] {todoModelImpl.getTodoDateTime()};

			finderCache.removeResult(_finderPathCountByTodoDateTime, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTodoDateTime, args);

			args = new Object[] {todoModelImpl.getTodoDocumentLibrary()};

			finderCache.removeResult(
				_finderPathCountByTodoDocumentLibrary, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTodoDocumentLibrary, args);

			args = new Object[] {todoModelImpl.getTodoDouble()};

			finderCache.removeResult(_finderPathCountByTodoDouble, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTodoDouble, args);

			args = new Object[] {todoModelImpl.getTodoInteger()};

			finderCache.removeResult(_finderPathCountByTodoInteger, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTodoInteger, args);

			args = new Object[] {todoModelImpl.getTodoRichText()};

			finderCache.removeResult(_finderPathCountByTodoRichText, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTodoRichText, args);

			args = new Object[] {todoModelImpl.getTodoText()};

			finderCache.removeResult(_finderPathCountByTodoText, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTodoText, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {todoModelImpl.getOriginalUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {todoModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalUuid(),
					todoModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					todoModelImpl.getUuid(), todoModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalCompanyId(),
					todoModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByC_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_S, args);

				args = new Object[] {
					todoModelImpl.getCompanyId(), todoModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByC_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_S, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalGroupId(),
					todoModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);

				args = new Object[] {
					todoModelImpl.getGroupId(), todoModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_U_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalCompanyId(),
					todoModelImpl.getOriginalUserId(),
					todoModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByC_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_U_S, args);

				args = new Object[] {
					todoModelImpl.getCompanyId(), todoModelImpl.getUserId(),
					todoModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByC_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_U_S, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_U_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalGroupId(),
					todoModelImpl.getOriginalUserId(),
					todoModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U_S, args);

				args = new Object[] {
					todoModelImpl.getGroupId(), todoModelImpl.getUserId(),
					todoModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U_S, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByU_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalUserId(),
					todoModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByU_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_S, args);

				args = new Object[] {
					todoModelImpl.getUserId(), todoModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByU_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_S, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_UT_ST.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalGroupId(),
					todoModelImpl.getOriginalUrlTitle(),
					todoModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_UT_ST, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_UT_ST, args);

				args = new Object[] {
					todoModelImpl.getGroupId(), todoModelImpl.getUrlTitle(),
					todoModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_UT_ST, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_UT_ST, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {todoModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserIdGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalUserId(),
					todoModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByUserIdGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserIdGroupId, args);

				args = new Object[] {
					todoModelImpl.getUserId(), todoModelImpl.getGroupId()
				};

				finderCache.removeResult(_finderPathCountByUserIdGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserIdGroupId, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {todoModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompanyId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId, args);

				args = new Object[] {todoModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTodoId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalTodoId()
				};

				finderCache.removeResult(_finderPathCountByTodoId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoId, args);

				args = new Object[] {todoModelImpl.getTodoId()};

				finderCache.removeResult(_finderPathCountByTodoId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoId, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTitle.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {todoModelImpl.getOriginalTitle()};

				finderCache.removeResult(_finderPathCountByTitle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTitle, args);

				args = new Object[] {todoModelImpl.getTitle()};

				finderCache.removeResult(_finderPathCountByTitle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTitle, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTodoBooleanStat.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalTodoBooleanStat()
				};

				finderCache.removeResult(
					_finderPathCountByTodoBooleanStat, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoBooleanStat, args);

				args = new Object[] {todoModelImpl.isTodoBooleanStat()};

				finderCache.removeResult(
					_finderPathCountByTodoBooleanStat, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoBooleanStat, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTodoDateTime.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalTodoDateTime()
				};

				finderCache.removeResult(_finderPathCountByTodoDateTime, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoDateTime, args);

				args = new Object[] {todoModelImpl.getTodoDateTime()};

				finderCache.removeResult(_finderPathCountByTodoDateTime, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoDateTime, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTodoDocumentLibrary.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalTodoDocumentLibrary()
				};

				finderCache.removeResult(
					_finderPathCountByTodoDocumentLibrary, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoDocumentLibrary,
					args);

				args = new Object[] {todoModelImpl.getTodoDocumentLibrary()};

				finderCache.removeResult(
					_finderPathCountByTodoDocumentLibrary, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoDocumentLibrary,
					args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTodoDouble.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalTodoDouble()
				};

				finderCache.removeResult(_finderPathCountByTodoDouble, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoDouble, args);

				args = new Object[] {todoModelImpl.getTodoDouble()};

				finderCache.removeResult(_finderPathCountByTodoDouble, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoDouble, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTodoInteger.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalTodoInteger()
				};

				finderCache.removeResult(_finderPathCountByTodoInteger, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoInteger, args);

				args = new Object[] {todoModelImpl.getTodoInteger()};

				finderCache.removeResult(_finderPathCountByTodoInteger, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoInteger, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTodoRichText.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalTodoRichText()
				};

				finderCache.removeResult(_finderPathCountByTodoRichText, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoRichText, args);

				args = new Object[] {todoModelImpl.getTodoRichText()};

				finderCache.removeResult(_finderPathCountByTodoRichText, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoRichText, args);
			}

			if ((todoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTodoText.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					todoModelImpl.getOriginalTodoText()
				};

				finderCache.removeResult(_finderPathCountByTodoText, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoText, args);

				args = new Object[] {todoModelImpl.getTodoText()};

				finderCache.removeResult(_finderPathCountByTodoText, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTodoText, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TodoImpl.class, todo.getPrimaryKey(), todo,
			false);

		clearUniqueFindersCache(todoModelImpl, false);
		cacheUniqueFindersCache(todoModelImpl);

		todo.resetOriginalValues();

		return todo;
	}

	/**
	 * Returns the todo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the todo
	 * @return the todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	@Override
	public Todo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTodoException {

		Todo todo = fetchByPrimaryKey(primaryKey);

		if (todo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTodoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return todo;
	}

	/**
	 * Returns the todo with the primary key or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	@Override
	public Todo findByPrimaryKey(long todoId) throws NoSuchTodoException {
		return findByPrimaryKey((Serializable)todoId);
	}

	/**
	 * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo, or <code>null</code> if a todo with the primary key could not be found
	 */
	@Override
	public Todo fetchByPrimaryKey(long todoId) {
		return fetchByPrimaryKey((Serializable)todoId);
	}

	/**
	 * Returns all the todos.
	 *
	 * @return the todos
	 */
	@Override
	public List<Todo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Todo> findAll(
		int start, int end, OrderByComparator<Todo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Todo> findAll(
		int start, int end, OrderByComparator<Todo> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Todo> list = null;

		if (useFinderCache) {
			list = (List<Todo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TODO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TODO;

				sql = sql.concat(TodoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Todo>)QueryUtil.list(q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the todos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Todo todo : findAll()) {
			remove(todo);
		}
	}

	/**
	 * Returns the number of todos.
	 *
	 * @return the number of todos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TODO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "todoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TODO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TodoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the todo persistence.
	 */
	@Activate
	public void activate() {
		TodoModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TodoModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			TodoModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			TodoModelImpl.UUID_COLUMN_BITMASK |
			TodoModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			TodoModelImpl.UUID_COLUMN_BITMASK |
			TodoModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			TodoModelImpl.COMPANYID_COLUMN_BITMASK |
			TodoModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationCountByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			TodoModelImpl.GROUPID_COLUMN_BITMASK |
			TodoModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByC_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			TodoModelImpl.COMPANYID_COLUMN_BITMASK |
			TodoModelImpl.USERID_COLUMN_BITMASK |
			TodoModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByC_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationCountByC_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			TodoModelImpl.GROUPID_COLUMN_BITMASK |
			TodoModelImpl.USERID_COLUMN_BITMASK |
			TodoModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationCountByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			TodoModelImpl.USERID_COLUMN_BITMASK |
			TodoModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationCountByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByG_UT_ST = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_UT_ST = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			TodoModelImpl.GROUPID_COLUMN_BITMASK |
			TodoModelImpl.URLTITLE_COLUMN_BITMASK |
			TodoModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_UT_ST = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationCountByG_UT_ST = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

		_finderPathFetchByG_UT = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_UT",
			new String[] {Long.class.getName(), String.class.getName()},
			TodoModelImpl.GROUPID_COLUMN_BITMASK |
			TodoModelImpl.URLTITLE_COLUMN_BITMASK);

		_finderPathCountByG_UT = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_UT",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByURLTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByURLTitle",
			new String[] {String.class.getName()},
			TodoModelImpl.URLTITLE_COLUMN_BITMASK);

		_finderPathCountByURLTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByURLTitle",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			TodoModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserIdGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserIdGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdGroupId",
			new String[] {Long.class.getName(), Long.class.getName()},
			TodoModelImpl.USERID_COLUMN_BITMASK |
			TodoModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUserIdGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdGroupId",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			TodoModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()},
			TodoModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByCompanyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByTodoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTodoId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTodoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTodoId",
			new String[] {Long.class.getName()},
			TodoModelImpl.TODOID_COLUMN_BITMASK);

		_finderPathCountByTodoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTodoId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitle",
			new String[] {String.class.getName()},
			TodoModelImpl.TITLE_COLUMN_BITMASK);

		_finderPathCountByTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitle",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTodoBooleanStat = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTodoBooleanStat",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTodoBooleanStat = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTodoBooleanStat",
			new String[] {Boolean.class.getName()},
			TodoModelImpl.TODOBOOLEANSTAT_COLUMN_BITMASK);

		_finderPathCountByTodoBooleanStat = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTodoBooleanStat",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByTodoDateTime = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTodoDateTime",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTodoDateTime = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTodoDateTime",
			new String[] {Date.class.getName()},
			TodoModelImpl.TODODATETIME_COLUMN_BITMASK);

		_finderPathCountByTodoDateTime = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTodoDateTime",
			new String[] {Date.class.getName()});

		_finderPathWithPaginationFindByTodoDocumentLibrary = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTodoDocumentLibrary",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTodoDocumentLibrary = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTodoDocumentLibrary", new String[] {String.class.getName()},
			TodoModelImpl.TODODOCUMENTLIBRARY_COLUMN_BITMASK);

		_finderPathCountByTodoDocumentLibrary = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTodoDocumentLibrary",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTodoDouble = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTodoDouble",
			new String[] {
				Double.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTodoDouble = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTodoDouble",
			new String[] {Double.class.getName()},
			TodoModelImpl.TODODOUBLE_COLUMN_BITMASK);

		_finderPathCountByTodoDouble = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTodoDouble",
			new String[] {Double.class.getName()});

		_finderPathWithPaginationFindByTodoInteger = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTodoInteger",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTodoInteger = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTodoInteger",
			new String[] {Integer.class.getName()},
			TodoModelImpl.TODOINTEGER_COLUMN_BITMASK);

		_finderPathCountByTodoInteger = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTodoInteger",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByTodoRichText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTodoRichText",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTodoRichText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTodoRichText",
			new String[] {String.class.getName()},
			TodoModelImpl.TODORICHTEXT_COLUMN_BITMASK);

		_finderPathCountByTodoRichText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTodoRichText",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTodoText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTodoText",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTodoText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTodoText",
			new String[] {String.class.getName()},
			TodoModelImpl.TODOTEXT_COLUMN_BITMASK);

		_finderPathCountByTodoText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTodoText",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TodoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = TodoPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.sb.test.model.Todo"),
			true);
	}

	@Override
	@Reference(
		target = TodoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TodoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_TODO = "SELECT todo FROM Todo todo";

	private static final String _SQL_SELECT_TODO_WHERE =
		"SELECT todo FROM Todo todo WHERE ";

	private static final String _SQL_COUNT_TODO =
		"SELECT COUNT(todo) FROM Todo todo";

	private static final String _SQL_COUNT_TODO_WHERE =
		"SELECT COUNT(todo) FROM Todo todo WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"todo.todoId";

	private static final String _FILTER_SQL_SELECT_TODO_WHERE =
		"SELECT DISTINCT {todo.*} FROM Todo_Todo todo WHERE ";

	private static final String
		_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {Todo_Todo.*} FROM (SELECT DISTINCT todo.todoId FROM Todo_Todo todo WHERE ";

	private static final String
		_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN Todo_Todo ON TEMP_TABLE.todoId = Todo_Todo.todoId";

	private static final String _FILTER_SQL_COUNT_TODO_WHERE =
		"SELECT COUNT(DISTINCT todo.todoId) AS COUNT_VALUE FROM Todo_Todo todo WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "todo";

	private static final String _FILTER_ENTITY_TABLE = "Todo_Todo";

	private static final String _ORDER_BY_ENTITY_ALIAS = "todo.";

	private static final String _ORDER_BY_ENTITY_TABLE = "Todo_Todo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Todo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Todo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TodoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(TodoPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}