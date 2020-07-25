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

package com.liferay.sb.test.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Todo}.
 * </p>
 *
 * @author "diegofurtado"
 * @see Todo
 * @generated
 */
public class TodoWrapper
	extends BaseModelWrapper<Todo> implements ModelWrapper<Todo>, Todo {

	public TodoWrapper(Todo todo) {
		super(todo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("todoId", getTodoId());
		attributes.put("title", getTitle());
		attributes.put("todoBooleanStat", isTodoBooleanStat());
		attributes.put("todoDateTime", getTodoDateTime());
		attributes.put("todoDocumentLibrary", getTodoDocumentLibrary());
		attributes.put("todoDouble", getTodoDouble());
		attributes.put("todoInteger", getTodoInteger());
		attributes.put("todoRichText", getTodoRichText());
		attributes.put("todoText", getTodoText());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("todoTitleName", getTodoTitleName());
		attributes.put("todoSummaryName", getTodoSummaryName());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long todoId = (Long)attributes.get("todoId");

		if (todoId != null) {
			setTodoId(todoId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Boolean todoBooleanStat = (Boolean)attributes.get("todoBooleanStat");

		if (todoBooleanStat != null) {
			setTodoBooleanStat(todoBooleanStat);
		}

		Date todoDateTime = (Date)attributes.get("todoDateTime");

		if (todoDateTime != null) {
			setTodoDateTime(todoDateTime);
		}

		String todoDocumentLibrary = (String)attributes.get(
			"todoDocumentLibrary");

		if (todoDocumentLibrary != null) {
			setTodoDocumentLibrary(todoDocumentLibrary);
		}

		Double todoDouble = (Double)attributes.get("todoDouble");

		if (todoDouble != null) {
			setTodoDouble(todoDouble);
		}

		Integer todoInteger = (Integer)attributes.get("todoInteger");

		if (todoInteger != null) {
			setTodoInteger(todoInteger);
		}

		String todoRichText = (String)attributes.get("todoRichText");

		if (todoRichText != null) {
			setTodoRichText(todoRichText);
		}

		String todoText = (String)attributes.get("todoText");

		if (todoText != null) {
			setTodoText(todoText);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
		}

		String todoTitleName = (String)attributes.get("todoTitleName");

		if (todoTitleName != null) {
			setTodoTitleName(todoTitleName);
		}

		String todoSummaryName = (String)attributes.get("todoSummaryName");

		if (todoSummaryName != null) {
			setTodoSummaryName(todoSummaryName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	 * Returns the company ID of this todo.
	 *
	 * @return the company ID of this todo
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this todo.
	 *
	 * @return the create date of this todo
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this todo.
	 *
	 * @return the group ID of this todo
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this todo.
	 *
	 * @return the modified date of this todo
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this todo.
	 *
	 * @return the mvcc version of this todo
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this todo.
	 *
	 * @return the primary key of this todo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this todo.
	 *
	 * @return the status of this todo
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this todo.
	 *
	 * @return the status by user ID of this todo
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this todo.
	 *
	 * @return the status by user name of this todo
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this todo.
	 *
	 * @return the status by user uuid of this todo
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this todo.
	 *
	 * @return the status date of this todo
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this todo.
	 *
	 * @return the title of this todo
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the todo boolean stat of this todo.
	 *
	 * @return the todo boolean stat of this todo
	 */
	@Override
	public boolean getTodoBooleanStat() {
		return model.getTodoBooleanStat();
	}

	/**
	 * Returns the todo date time of this todo.
	 *
	 * @return the todo date time of this todo
	 */
	@Override
	public Date getTodoDateTime() {
		return model.getTodoDateTime();
	}

	/**
	 * Returns the todo document library of this todo.
	 *
	 * @return the todo document library of this todo
	 */
	@Override
	public String getTodoDocumentLibrary() {
		return model.getTodoDocumentLibrary();
	}

	/**
	 * Returns the todo double of this todo.
	 *
	 * @return the todo double of this todo
	 */
	@Override
	public double getTodoDouble() {
		return model.getTodoDouble();
	}

	/**
	 * Returns the todo ID of this todo.
	 *
	 * @return the todo ID of this todo
	 */
	@Override
	public long getTodoId() {
		return model.getTodoId();
	}

	/**
	 * Returns the todo integer of this todo.
	 *
	 * @return the todo integer of this todo
	 */
	@Override
	public int getTodoInteger() {
		return model.getTodoInteger();
	}

	/**
	 * Returns the todo rich text of this todo.
	 *
	 * @return the todo rich text of this todo
	 */
	@Override
	public String getTodoRichText() {
		return model.getTodoRichText();
	}

	/**
	 * Returns the todo summary name of this todo.
	 *
	 * @return the todo summary name of this todo
	 */
	@Override
	public String getTodoSummaryName() {
		return model.getTodoSummaryName();
	}

	/**
	 * Returns the todo text of this todo.
	 *
	 * @return the todo text of this todo
	 */
	@Override
	public String getTodoText() {
		return model.getTodoText();
	}

	/**
	 * Returns the todo title name of this todo.
	 *
	 * @return the todo title name of this todo
	 */
	@Override
	public String getTodoTitleName() {
		return model.getTodoTitleName();
	}

	/**
	 * Returns the trash entry created when this todo was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this todo.
	 *
	 * @return the trash entry created when this todo was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this todo.
	 *
	 * @return the class primary key of the trash entry for this todo
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this todo.
	 *
	 * @return the trash handler for this todo
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the url title of this todo.
	 *
	 * @return the url title of this todo
	 */
	@Override
	public String getUrlTitle() {
		return model.getUrlTitle();
	}

	/**
	 * Returns the user ID of this todo.
	 *
	 * @return the user ID of this todo
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this todo.
	 *
	 * @return the user name of this todo
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this todo.
	 *
	 * @return the user uuid of this todo
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this todo.
	 *
	 * @return the uuid of this todo
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this todo is approved.
	 *
	 * @return <code>true</code> if this todo is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this todo is denied.
	 *
	 * @return <code>true</code> if this todo is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this todo is a draft.
	 *
	 * @return <code>true</code> if this todo is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this todo is expired.
	 *
	 * @return <code>true</code> if this todo is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this todo is inactive.
	 *
	 * @return <code>true</code> if this todo is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this todo is incomplete.
	 *
	 * @return <code>true</code> if this todo is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this todo is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this todo is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this todo is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this todo is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	/**
	 * Returns <code>true</code> if this todo is pending.
	 *
	 * @return <code>true</code> if this todo is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this todo is scheduled.
	 *
	 * @return <code>true</code> if this todo is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * Returns <code>true</code> if this todo is todo boolean stat.
	 *
	 * @return <code>true</code> if this todo is todo boolean stat; <code>false</code> otherwise
	 */
	@Override
	public boolean isTodoBooleanStat() {
		return model.isTodoBooleanStat();
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a todo model instance should use the <code>Todo</code> interface instead.
	 */
	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this todo.
	 *
	 * @param companyId the company ID of this todo
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this todo.
	 *
	 * @param createDate the create date of this todo
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this todo.
	 *
	 * @param groupId the group ID of this todo
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this todo.
	 *
	 * @param modifiedDate the modified date of this todo
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this todo.
	 *
	 * @param mvccVersion the mvcc version of this todo
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this todo.
	 *
	 * @param primaryKey the primary key of this todo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this todo.
	 *
	 * @param status the status of this todo
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this todo.
	 *
	 * @param statusByUserId the status by user ID of this todo
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this todo.
	 *
	 * @param statusByUserName the status by user name of this todo
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this todo.
	 *
	 * @param statusByUserUuid the status by user uuid of this todo
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this todo.
	 *
	 * @param statusDate the status date of this todo
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this todo.
	 *
	 * @param title the title of this todo
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets whether this todo is todo boolean stat.
	 *
	 * @param todoBooleanStat the todo boolean stat of this todo
	 */
	@Override
	public void setTodoBooleanStat(boolean todoBooleanStat) {
		model.setTodoBooleanStat(todoBooleanStat);
	}

	/**
	 * Sets the todo date time of this todo.
	 *
	 * @param todoDateTime the todo date time of this todo
	 */
	@Override
	public void setTodoDateTime(Date todoDateTime) {
		model.setTodoDateTime(todoDateTime);
	}

	/**
	 * Sets the todo document library of this todo.
	 *
	 * @param todoDocumentLibrary the todo document library of this todo
	 */
	@Override
	public void setTodoDocumentLibrary(String todoDocumentLibrary) {
		model.setTodoDocumentLibrary(todoDocumentLibrary);
	}

	/**
	 * Sets the todo double of this todo.
	 *
	 * @param todoDouble the todo double of this todo
	 */
	@Override
	public void setTodoDouble(double todoDouble) {
		model.setTodoDouble(todoDouble);
	}

	/**
	 * Sets the todo ID of this todo.
	 *
	 * @param todoId the todo ID of this todo
	 */
	@Override
	public void setTodoId(long todoId) {
		model.setTodoId(todoId);
	}

	/**
	 * Sets the todo integer of this todo.
	 *
	 * @param todoInteger the todo integer of this todo
	 */
	@Override
	public void setTodoInteger(int todoInteger) {
		model.setTodoInteger(todoInteger);
	}

	/**
	 * Sets the todo rich text of this todo.
	 *
	 * @param todoRichText the todo rich text of this todo
	 */
	@Override
	public void setTodoRichText(String todoRichText) {
		model.setTodoRichText(todoRichText);
	}

	/**
	 * Sets the todo summary name of this todo.
	 *
	 * @param todoSummaryName the todo summary name of this todo
	 */
	@Override
	public void setTodoSummaryName(String todoSummaryName) {
		model.setTodoSummaryName(todoSummaryName);
	}

	/**
	 * Sets the todo text of this todo.
	 *
	 * @param todoText the todo text of this todo
	 */
	@Override
	public void setTodoText(String todoText) {
		model.setTodoText(todoText);
	}

	/**
	 * Sets the todo title name of this todo.
	 *
	 * @param todoTitleName the todo title name of this todo
	 */
	@Override
	public void setTodoTitleName(String todoTitleName) {
		model.setTodoTitleName(todoTitleName);
	}

	/**
	 * Sets the url title of this todo.
	 *
	 * @param urlTitle the url title of this todo
	 */
	@Override
	public void setUrlTitle(String urlTitle) {
		model.setUrlTitle(urlTitle);
	}

	/**
	 * Sets the user ID of this todo.
	 *
	 * @param userId the user ID of this todo
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this todo.
	 *
	 * @param userName the user name of this todo
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this todo.
	 *
	 * @param userUuid the user uuid of this todo
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this todo.
	 *
	 * @param uuid the uuid of this todo
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected TodoWrapper wrap(Todo todo) {
		return new TodoWrapper(todo);
	}

}