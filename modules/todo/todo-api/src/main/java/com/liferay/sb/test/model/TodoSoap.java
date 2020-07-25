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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.sb.test.service.http.TodoServiceSoap}.
 *
 * @author "diegofurtado"
 * @generated
 */
public class TodoSoap implements Serializable {

	public static TodoSoap toSoapModel(Todo model) {
		TodoSoap soapModel = new TodoSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setTodoId(model.getTodoId());
		soapModel.setTitle(model.getTitle());
		soapModel.setTodoBooleanStat(model.isTodoBooleanStat());
		soapModel.setTodoDateTime(model.getTodoDateTime());
		soapModel.setTodoDocumentLibrary(model.getTodoDocumentLibrary());
		soapModel.setTodoDouble(model.getTodoDouble());
		soapModel.setTodoInteger(model.getTodoInteger());
		soapModel.setTodoRichText(model.getTodoRichText());
		soapModel.setTodoText(model.getTodoText());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUrlTitle(model.getUrlTitle());
		soapModel.setTodoTitleName(model.getTodoTitleName());
		soapModel.setTodoSummaryName(model.getTodoSummaryName());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static TodoSoap[] toSoapModels(Todo[] models) {
		TodoSoap[] soapModels = new TodoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TodoSoap[][] toSoapModels(Todo[][] models) {
		TodoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TodoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TodoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TodoSoap[] toSoapModels(List<Todo> models) {
		List<TodoSoap> soapModels = new ArrayList<TodoSoap>(models.size());

		for (Todo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TodoSoap[soapModels.size()]);
	}

	public TodoSoap() {
	}

	public long getPrimaryKey() {
		return _todoId;
	}

	public void setPrimaryKey(long pk) {
		setTodoId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTodoId() {
		return _todoId;
	}

	public void setTodoId(long todoId) {
		_todoId = todoId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public boolean getTodoBooleanStat() {
		return _todoBooleanStat;
	}

	public boolean isTodoBooleanStat() {
		return _todoBooleanStat;
	}

	public void setTodoBooleanStat(boolean todoBooleanStat) {
		_todoBooleanStat = todoBooleanStat;
	}

	public Date getTodoDateTime() {
		return _todoDateTime;
	}

	public void setTodoDateTime(Date todoDateTime) {
		_todoDateTime = todoDateTime;
	}

	public String getTodoDocumentLibrary() {
		return _todoDocumentLibrary;
	}

	public void setTodoDocumentLibrary(String todoDocumentLibrary) {
		_todoDocumentLibrary = todoDocumentLibrary;
	}

	public double getTodoDouble() {
		return _todoDouble;
	}

	public void setTodoDouble(double todoDouble) {
		_todoDouble = todoDouble;
	}

	public int getTodoInteger() {
		return _todoInteger;
	}

	public void setTodoInteger(int todoInteger) {
		_todoInteger = todoInteger;
	}

	public String getTodoRichText() {
		return _todoRichText;
	}

	public void setTodoRichText(String todoRichText) {
		_todoRichText = todoRichText;
	}

	public String getTodoText() {
		return _todoText;
	}

	public void setTodoText(String todoText) {
		_todoText = todoText;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getUrlTitle() {
		return _urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;
	}

	public String getTodoTitleName() {
		return _todoTitleName;
	}

	public void setTodoTitleName(String todoTitleName) {
		_todoTitleName = todoTitleName;
	}

	public String getTodoSummaryName() {
		return _todoSummaryName;
	}

	public void setTodoSummaryName(String todoSummaryName) {
		_todoSummaryName = todoSummaryName;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _todoId;
	private String _title;
	private boolean _todoBooleanStat;
	private Date _todoDateTime;
	private String _todoDocumentLibrary;
	private double _todoDouble;
	private int _todoInteger;
	private String _todoRichText;
	private String _todoText;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _urlTitle;
	private String _todoTitleName;
	private String _todoSummaryName;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

}