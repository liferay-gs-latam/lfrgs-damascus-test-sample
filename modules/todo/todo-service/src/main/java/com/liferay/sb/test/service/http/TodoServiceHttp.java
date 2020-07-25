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

package com.liferay.sb.test.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.sb.test.service.TodoServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>TodoServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author "diegofurtado"
 * @see TodoServiceSoap
 * @generated
 */
public class TodoServiceHttp {

	public static com.liferay.sb.test.model.Todo addEntry(
			HttpPrincipal httpPrincipal,
			com.liferay.sb.test.model.Todo orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.TodoValidateException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoServiceUtil.class, "addEntry", _addEntryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, orgEntry, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				if (e instanceof
						com.liferay.sb.test.exception.TodoValidateException) {

					throw (com.liferay.sb.test.exception.TodoValidateException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.sb.test.model.Todo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void deleteEntry(HttpPrincipal httpPrincipal, long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoServiceUtil.class, "deleteEntry",
				_deleteEntryParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.sb.test.model.Todo getInitializedTodo(
			HttpPrincipal httpPrincipal, long primaryKey,
			javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoServiceUtil.class, "getInitializedTodo",
				_getInitializedTodoParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey, request);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				if (e instanceof javax.portlet.PortletException) {
					throw (javax.portlet.PortletException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.sb.test.model.Todo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.sb.test.model.Todo getNewObject(
			HttpPrincipal httpPrincipal, long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoServiceUtil.class, "getNewObject",
				_getNewObjectParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.security.auth.
							PrincipalException) {

					throw (com.liferay.portal.kernel.security.auth.
						PrincipalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.sb.test.model.Todo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.sb.test.model.Todo getTodo(
			HttpPrincipal httpPrincipal, long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoServiceUtil.class, "getTodo", _getTodoParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.sb.test.model.Todo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.sb.test.model.Todo getTodo(
			HttpPrincipal httpPrincipal, long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoServiceUtil.class, "getTodo", _getTodoParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, urlTitle);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.sb.test.model.Todo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.sb.test.model.Todo getTodoFromRequest(
			HttpPrincipal httpPrincipal, long primaryKey,
			javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoServiceUtil.class, "getTodoFromRequest",
				_getTodoFromRequestParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey, request);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				if (e instanceof javax.portlet.PortletException) {
					throw (javax.portlet.PortletException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.sb.test.model.Todo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.sb.test.model.Todo moveEntryToTrash(
			HttpPrincipal httpPrincipal, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoServiceUtil.class, "moveEntryToTrash",
				_moveEntryToTrashParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, entryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.sb.test.model.Todo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.sb.test.model.Todo updateEntry(
			HttpPrincipal httpPrincipal,
			com.liferay.sb.test.model.Todo orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.TodoValidateException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoServiceUtil.class, "updateEntry",
				_updateEntryParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, orgEntry, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				if (e instanceof
						com.liferay.sb.test.exception.TodoValidateException) {

					throw (com.liferay.sb.test.exception.TodoValidateException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.sb.test.model.Todo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TodoServiceHttp.class);

	private static final Class<?>[] _addEntryParameterTypes0 = new Class[] {
		com.liferay.sb.test.model.Todo.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteEntryParameterTypes1 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getInitializedTodoParameterTypes2 =
		new Class[] {long.class, javax.portlet.PortletRequest.class};
	private static final Class<?>[] _getNewObjectParameterTypes3 = new Class[] {
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getTodoParameterTypes4 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getTodoParameterTypes5 = new Class[] {
		long.class, String.class
	};
	private static final Class<?>[] _getTodoFromRequestParameterTypes6 =
		new Class[] {long.class, javax.portlet.PortletRequest.class};
	private static final Class<?>[] _moveEntryToTrashParameterTypes7 =
		new Class[] {long.class};
	private static final Class<?>[] _updateEntryParameterTypes8 = new Class[] {
		com.liferay.sb.test.model.Todo.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};

}