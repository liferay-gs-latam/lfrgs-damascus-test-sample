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
import com.liferay.sb.test.service.TodoServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>TodoServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.sb.test.model.TodoSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.sb.test.model.Todo</code>, that is translated to a
 * <code>com.liferay.sb.test.model.TodoSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author "diegofurtado"
 * @see TodoServiceHttp
 * @generated
 */
public class TodoServiceSoap {

	/**
	 * Add Entry
	 *
	 * @param orgEntry       Todo model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception TodoValidateException
	 * @return created Todo model.
	 */
	public static com.liferay.sb.test.model.TodoSoap addEntry(
			com.liferay.sb.test.model.TodoSoap orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.Todo returnValue =
				TodoServiceUtil.addEntry(
					com.liferay.sb.test.model.impl.TodoModelImpl.toModel(
						orgEntry),
					serviceContext);

			return com.liferay.sb.test.model.TodoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return Todo
	 * @throws PortalException
	 */
	public static void deleteEntry(long primaryKey) throws RemoteException {
		try {
			TodoServiceUtil.deleteEntry(primaryKey);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public static com.liferay.sb.test.model.TodoSoap getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.Todo returnValue =
				TodoServiceUtil.getNewObject(primaryKey, serviceContext);

			return com.liferay.sb.test.model.TodoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Returns the todo with the primary key.
	 *
	 * @param todoId the primary key of the sample sb
	 * @return the todo
	 * @throws PortalException if a todo with the primary key could not be found
	 */
	public static com.liferay.sb.test.model.TodoSoap getTodo(long primaryKey)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.Todo returnValue =
				TodoServiceUtil.getTodo(primaryKey);

			return com.liferay.sb.test.model.TodoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Returns the todo
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public static com.liferay.sb.test.model.TodoSoap getTodo(
			long groupId, String urlTitle)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.Todo returnValue =
				TodoServiceUtil.getTodo(groupId, urlTitle);

			return com.liferay.sb.test.model.TodoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return Todo
	 * @throws PortalException
	 */
	public static com.liferay.sb.test.model.TodoSoap moveEntryToTrash(
			long entryId)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.Todo returnValue =
				TodoServiceUtil.moveEntryToTrash(entryId);

			return com.liferay.sb.test.model.TodoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
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
	public static com.liferay.sb.test.model.TodoSoap updateEntry(
			com.liferay.sb.test.model.TodoSoap orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.Todo returnValue =
				TodoServiceUtil.updateEntry(
					com.liferay.sb.test.model.impl.TodoModelImpl.toModel(
						orgEntry),
					serviceContext);

			return com.liferay.sb.test.model.TodoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TodoServiceSoap.class);

}