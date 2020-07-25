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

package com.liferay.sb.test.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.sb.test.model.Todo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Todo in entity cache.
 *
 * @author "diegofurtado"
 * @generated
 */
public class TodoCacheModel
	implements CacheModel<Todo>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TodoCacheModel)) {
			return false;
		}

		TodoCacheModel todoCacheModel = (TodoCacheModel)obj;

		if ((todoId == todoCacheModel.todoId) &&
			(mvccVersion == todoCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, todoId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", todoId=");
		sb.append(todoId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", todoBooleanStat=");
		sb.append(todoBooleanStat);
		sb.append(", todoDateTime=");
		sb.append(todoDateTime);
		sb.append(", todoDocumentLibrary=");
		sb.append(todoDocumentLibrary);
		sb.append(", todoDouble=");
		sb.append(todoDouble);
		sb.append(", todoInteger=");
		sb.append(todoInteger);
		sb.append(", todoRichText=");
		sb.append(todoRichText);
		sb.append(", todoText=");
		sb.append(todoText);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", urlTitle=");
		sb.append(urlTitle);
		sb.append(", todoTitleName=");
		sb.append(todoTitleName);
		sb.append(", todoSummaryName=");
		sb.append(todoSummaryName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Todo toEntityModel() {
		TodoImpl todoImpl = new TodoImpl();

		todoImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			todoImpl.setUuid("");
		}
		else {
			todoImpl.setUuid(uuid);
		}

		todoImpl.setTodoId(todoId);

		if (title == null) {
			todoImpl.setTitle("");
		}
		else {
			todoImpl.setTitle(title);
		}

		todoImpl.setTodoBooleanStat(todoBooleanStat);

		if (todoDateTime == Long.MIN_VALUE) {
			todoImpl.setTodoDateTime(null);
		}
		else {
			todoImpl.setTodoDateTime(new Date(todoDateTime));
		}

		if (todoDocumentLibrary == null) {
			todoImpl.setTodoDocumentLibrary("");
		}
		else {
			todoImpl.setTodoDocumentLibrary(todoDocumentLibrary);
		}

		todoImpl.setTodoDouble(todoDouble);
		todoImpl.setTodoInteger(todoInteger);

		if (todoRichText == null) {
			todoImpl.setTodoRichText("");
		}
		else {
			todoImpl.setTodoRichText(todoRichText);
		}

		if (todoText == null) {
			todoImpl.setTodoText("");
		}
		else {
			todoImpl.setTodoText(todoText);
		}

		todoImpl.setGroupId(groupId);
		todoImpl.setCompanyId(companyId);
		todoImpl.setUserId(userId);

		if (userName == null) {
			todoImpl.setUserName("");
		}
		else {
			todoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			todoImpl.setCreateDate(null);
		}
		else {
			todoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			todoImpl.setModifiedDate(null);
		}
		else {
			todoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (urlTitle == null) {
			todoImpl.setUrlTitle("");
		}
		else {
			todoImpl.setUrlTitle(urlTitle);
		}

		if (todoTitleName == null) {
			todoImpl.setTodoTitleName("");
		}
		else {
			todoImpl.setTodoTitleName(todoTitleName);
		}

		if (todoSummaryName == null) {
			todoImpl.setTodoSummaryName("");
		}
		else {
			todoImpl.setTodoSummaryName(todoSummaryName);
		}

		todoImpl.setStatus(status);
		todoImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			todoImpl.setStatusByUserName("");
		}
		else {
			todoImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			todoImpl.setStatusDate(null);
		}
		else {
			todoImpl.setStatusDate(new Date(statusDate));
		}

		todoImpl.resetOriginalValues();

		return todoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		todoId = objectInput.readLong();
		title = objectInput.readUTF();

		todoBooleanStat = objectInput.readBoolean();
		todoDateTime = objectInput.readLong();
		todoDocumentLibrary = objectInput.readUTF();

		todoDouble = objectInput.readDouble();

		todoInteger = objectInput.readInt();
		todoRichText = objectInput.readUTF();
		todoText = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		urlTitle = objectInput.readUTF();
		todoTitleName = objectInput.readUTF();
		todoSummaryName = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(todoId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeBoolean(todoBooleanStat);
		objectOutput.writeLong(todoDateTime);

		if (todoDocumentLibrary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(todoDocumentLibrary);
		}

		objectOutput.writeDouble(todoDouble);

		objectOutput.writeInt(todoInteger);

		if (todoRichText == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(todoRichText);
		}

		if (todoText == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(todoText);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (urlTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(urlTitle);
		}

		if (todoTitleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(todoTitleName);
		}

		if (todoSummaryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(todoSummaryName);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long mvccVersion;
	public String uuid;
	public long todoId;
	public String title;
	public boolean todoBooleanStat;
	public long todoDateTime;
	public String todoDocumentLibrary;
	public double todoDouble;
	public int todoInteger;
	public String todoRichText;
	public String todoText;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String urlTitle;
	public String todoTitleName;
	public String todoSummaryName;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}