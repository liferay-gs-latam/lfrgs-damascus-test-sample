// 
/*   */
/**
*  Copyright (C) 2020 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
/*  */ 

package com.liferay.sb.test.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.exportimport.kernel.lar.ExportImportThreadLocal;
import com.liferay.friendly.url.exception.DuplicateFriendlyURLEntryException;
import com.liferay.friendly.url.model.FriendlyURLEntry;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.comment.CommentManagerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.sb.test.exception.TodoValidateException;
import com.liferay.sb.test.model.Todo;
import com.liferay.sb.test.service.base.TodoLocalServiceBaseImpl;
import com.liferay.sb.test.service.util.TodoValidator;
import com.liferay.trash.exception.RestoreEntryException;
import com.liferay.trash.exception.TrashEntryException;
import com.liferay.trash.model.TrashEntry;
import com.liferay.trash.service.TrashEntryLocalService;

import java.io.Serializable;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the Todo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.sb.test.service.TodoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author diegofurtado
 * @see TodoLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.sb.test.model.Todo",
	service = AopService.class
)
public class TodoLocalServiceImpl extends TodoLocalServiceBaseImpl {

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
	@Override
	public Todo addEntry(Todo orgEntry, ServiceContext serviceContext)
		throws PortalException, TodoValidateException {

		long userId = serviceContext.getUserId();

		// Validation

		ModelValidator<Todo> modelValidator = new TodoValidator();
		modelValidator.validate(orgEntry);

		Todo entry = _addEntry(orgEntry, serviceContext);

		// Resources

		if (serviceContext.isAddGroupPermissions() ||
			serviceContext.isAddGuestPermissions()) {

			addEntryResources(
				entry, serviceContext.isAddGroupPermissions(),
				serviceContext.isAddGuestPermissions());
		}

		// Workflow

		return startWorkflowInstance(userId, entry, serviceContext);
	}

	@Override
	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException {

		Todo entry = todoPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId, ModelPermissions modelPermissions)
		throws PortalException {

		Todo entry = todoPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, modelPermissions);
	}

	@Override
	public void addEntryResources(
			Todo entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException {

		resourceLocalService.addResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			Todo.class.getName(), entry.getPrimaryKey(), false,
			addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			Todo entry, ModelPermissions modelPermissions)
		throws PortalException {

		resourceLocalService.addModelResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			Todo.class.getName(), entry.getPrimaryKey(), modelPermissions);
	}

	public int countAllInGroup(long groupId) {
		int count = todoPersistence.countByGroupId(groupId);

		return count;
	}

	public int countAllInGroup(long groupId, int[] status) {
		int count = todoPersistence.countByG_S(groupId, status);

		return count;
	}

	public int countAllInUser(long userId) {
		int count = todoPersistence.countByUserId(userId);

		return count;
	}

	public int countAllInUser(long userId, int[] status) {
		int count = todoPersistence.countByU_S(userId, status);

		return count;
	}

	public int countAllInUserAndGroup(long userId, long groupId) {
		int count = todoPersistence.countByUserIdGroupId(userId, groupId);

		return count;
	}

	public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
		int count = todoPersistence.countByG_U_S(groupId, userId, status);

		return count;
	}

	/**
	 * Delete entry
	 */
	public Todo deleteEntry(long primaryKey) throws PortalException {
		Todo entry = getTodo(primaryKey);

		return deleteEntry(entry);
	}

	/**
	 * Delete entry
	 *
	 * @param entry Todo
	 * @return Todo oject
	 * @exception PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public Todo deleteEntry(Todo entry) throws PortalException {

		// Entry

		todoPersistence.remove(entry);

		// Resources

		resourceLocalService.deleteResource(
			entry.getCompanyId(), Todo.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, entry.getPrimaryKey());

		// Asset

		assetEntryLocalService.deleteEntry(
			Todo.class.getName(), entry.getPrimaryKey());

		// Comment

		deleteDiscussion(entry);

		// Friendly URL

		_friendlyURLEntryLocalService.deleteFriendlyURLEntry(
			entry.getGroupId(), Todo.class, entry.getPrimaryKey());	

		// Trash

		_trashEntryLocalService.deleteEntry(
			Todo.class.getName(), entry.getPrimaryKey());

		// Workflow

		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			entry.getCompanyId(), entry.getGroupId(), Todo.class.getName(),
			entry.getPrimaryKey());

		return entry;
	}

	public List<Todo> findAllInGroup(long groupId) {
		List<Todo> list = (List<Todo>)todoPersistence.findByGroupId(
			groupId);

		return list;
	}

	public List<Todo> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		return findAllInGroup(
			groupId, start, end, orderByComparator,
			new int[] {WorkflowConstants.STATUS_APPROVED});
	}

	public List<Todo> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator, int[] status) {

		List<Todo> list = (List<Todo>)todoPersistence.findByG_S(
			groupId, status, start, end, orderByComparator);

		return list;
	}

	public List<Todo> findAllInGroup(long groupId, int[] status) {
		List<Todo> list = (List<Todo>)todoPersistence.findByG_S(
			groupId, status);

		return list;
	}

	public List<Todo> findAllInGroup(
		long groupId, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = (List<Todo>)findAllInGroup(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		return list;
	}

	public List<Todo> findAllInUser(long userId) {
		List<Todo> list = (List<Todo>)todoPersistence.findByUserId(
			userId);

		return list;
	}

	public List<Todo> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = (List<Todo>)todoPersistence.findByUserId(
			userId, start, end, orderByComparator);

		return list;
	}

	public List<Todo> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<Todo> orderByComparator, int[] status) {

		List<Todo> list = (List<Todo>)todoPersistence.findByU_S(
			userId, status, start, end, orderByComparator);

		return list;
	}

	public List<Todo> findAllInUser(long userId, int[] status) {
		List<Todo> list = (List<Todo>)todoPersistence.findByU_S(
			userId, status);

		return list;
	}

	public List<Todo> findAllInUser(
		long userId, OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = (List<Todo>)findAllInUser(
			userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		return list;
	}

	public List<Todo> findAllInUserAndGroup(long userId, long groupId) {
		List<Todo> list =
			(List<Todo>)todoPersistence.findByUserIdGroupId(
				userId, groupId);

		return list;
	}

	public List<Todo> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator) {

		List<Todo> list =
			(List<Todo>)todoPersistence.findByUserIdGroupId(
				groupId, userId, start, end, orderByComparator);

		return list;
	}

	public List<Todo> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<Todo> orderByComparator, int[] status) {

		List<Todo> list = (List<Todo>)todoPersistence.findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);

		return list;
	}

	public List<Todo> findAllInUserAndGroup(
		long userId, long groupId, int[] status) {

		List<Todo> list = (List<Todo>)todoPersistence.findByG_U_S(
			groupId, userId, status);

		return list;
	}

	public List<Todo> findAllInUserAndGroup(
		long userId, long groupId,
		OrderByComparator<Todo> orderByComparator) {

		List<Todo> list = (List<Todo>)findAllInUserAndGroup(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			orderByComparator);

		return list;
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
	public List<Todo> getCompanyEntries(
		long companyId, int status, int start, int end) {

		if (status == WorkflowConstants.STATUS_ANY) {
			return todoPersistence.findByCompanyId(companyId, start, end);
		}

		return todoPersistence.findByC_S(companyId, status, start, end);
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
	public List<Todo> getCompanyEntries(
		long companyId, int status, int start, int end,
		OrderByComparator<Todo> obc) {

		if (status == WorkflowConstants.STATUS_ANY) {
			return todoPersistence.findByCompanyId(
				companyId, start, end, obc);
		}

		return todoPersistence.findByC_S(
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
	public int getCompanyEntriesCount(long companyId, int status) {
		if (status == WorkflowConstants.STATUS_ANY) {
			return todoPersistence.countByCompanyId(companyId);
		}

		return todoPersistence.countByC_S(companyId, status);
	}

	/**
	 * Converte Date Time into Date()
	 *
	 * @param request PortletRequest
	 * @param prefix  Prefix of the parameter
	 * @return Date object
	 */
	public Date getDateTimeFromRequest(PortletRequest request, String prefix) {
		int Year = ParamUtil.getInteger(request, prefix + "Year");
		int Month = ParamUtil.getInteger(request, prefix + "Month") + 1;
		int Day = ParamUtil.getInteger(request, prefix + "Day");
		int Hour = ParamUtil.getInteger(request, prefix + "Hour");
		int Minute = ParamUtil.getInteger(request, prefix + "Minute");
		int AmPm = ParamUtil.getInteger(request, prefix + "AmPm");

		if (AmPm == Calendar.PM) {
			Hour += 12;
		}

		LocalDateTime ldt;

		try {
			ldt = LocalDateTime.of(Year, Month, Day, Hour, Minute, 0);
		}
		catch (Exception e) {
			_log.error(
				"Unnable get date data. Initialize with current date", e);
			Date in = new Date();

			Instant instant = in.toInstant();

			return Date.from(instant);
		}

		return Date.from(
			ldt.atZone(
				ZoneId.systemDefault()
			).toInstant());
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 */
	public Todo getInitializedTodo(
			long primaryKey, PortletRequest request)
		throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		// Create or fetch existing data

		Todo entry = getNewObject(primaryKey);

/*   */
                    entry.setTodoId(primaryKey);
                entry.setTitle("");
                entry.setTodoBooleanStat(true);
                entry.setTodoDateTime(new Date());
                entry.setTodoDocumentLibrary("");
                entry.setTodoDouble(0.0);
                entry.setTodoInteger(0);
                entry.setTodoRichText("");
                entry.setTodoText("");
/*  */
		entry.setTodoTitleName("");
		entry.setTodoSummaryName("");

		entry.setCompanyId(themeDisplay.getCompanyId());
		entry.setGroupId(themeDisplay.getScopeGroupId());
		entry.setUserId(themeDisplay.getUserId());
		
		return entry;
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return Todo object
	 * @throws PortletException
	 */
	public Todo getNewObject(long primaryKey) {
		primaryKey = (primaryKey <= 0) ? 0 :
		counterLocalService.increment(Todo.class.getName());

		return createTodo(primaryKey);
	}

	/**
	 * Get Entity
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public Todo getTodo(long groupId, String urlTitle)
		throws PortalException {

		FriendlyURLEntry friendlyURLEntry =
			_friendlyURLEntryLocalService.fetchFriendlyURLEntry(
				groupId, Todo.class, urlTitle);

		if (friendlyURLEntry != null) {
			return todoPersistence.findByPrimaryKey(
				friendlyURLEntry.getClassPK());
		}

		return todoPersistence.findByG_UT(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Todo Object
	 * @throws PortletException
	 * @throws TodoValidateException
	 */
	public Todo getTodoFromRequest(
			long primaryKey, PortletRequest request)
		throws PortletException, TodoValidateException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		// Create or fetch existing data

		Todo entry;

		if (primaryKey <= 0) {
			entry = getNewObject(primaryKey);
		}
		else {
			entry = fetchTodo(primaryKey);
		}

		try {
/*   */
            entry.setTodoId(primaryKey);
            entry.setTitle(ParamUtil.getString(request, "title"));
            entry.setTodoBooleanStat(ParamUtil.getBoolean(request, "todoBooleanStat"));
            entry.setTodoDateTime(getDateTimeFromRequest(request, "todoDateTime"));
            entry.setTodoDocumentLibrary(ParamUtil.getString(request, "todoDocumentLibrary"));
            entry.setTodoDouble(ParamUtil.getDouble(request, "todoDouble"));
            entry.setTodoInteger(ParamUtil.getInteger(request, "todoInteger"));
            entry.setTodoRichText(ParamUtil.getString(request, "todoRichText"));
            entry.setTodoText(ParamUtil.getString(request, "todoText"));
/*  */		

			entry.setTodoTitleName(
				ParamUtil.getString(request, "todoTitleName"));
			entry.setTodoSummaryName(
				ParamUtil.getString(request, "todoSummaryName"));

			entry.setCompanyId(themeDisplay.getCompanyId());
			entry.setGroupId(themeDisplay.getScopeGroupId());
			entry.setUserId(themeDisplay.getUserId());
		}
		catch (Exception e) {
			_log.error("Errors occur while populating the model", e);
			List<String> error = new ArrayList<>();
			error.add("value-convert-error");

			throw new TodoValidateException(error);
		}

		return entry;
	}

	/**
	 * Get STATUS_ANY for DB
	 *
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	public int[] getStatusAny() {
		return STATUS_ANY;
	}

	public Todo moveEntryToTrash(long userId, long entryId)
		throws PortalException {

		Todo entry = todoPersistence.findByPrimaryKey(entryId);

		return moveEntryToTrash(userId, entry);
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Todo moveEntryToTrash(long userId, Todo entry)
		throws PortalException {

		// Entry

		if (entry.isInTrash()) {
			throw new TrashEntryException();
		}

		int oldStatus = entry.getStatus();

		if (oldStatus == WorkflowConstants.STATUS_PENDING) {
			entry.setStatus(WorkflowConstants.STATUS_DRAFT);

			todoPersistence.update(entry);
		}

		entry = updateStatus(
			userId, entry.getPrimaryKey(), WorkflowConstants.STATUS_IN_TRASH,
			new ServiceContext(), new HashMap<String, Serializable>());

		// Workflow

		if (oldStatus == WorkflowConstants.STATUS_PENDING) {
			workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(
				entry.getCompanyId(), entry.getGroupId(),
				Todo.class.getName(), entry.getPrimaryKey());
		}

		return entry;
	}

	/**
	 * Restores the entry with the ID from the recycle bin. Social activity counters
	 * for this entry get activated.
	 *
	 * @param userId  the primary key of the user restoring the entry
	 * @param entryId the primary key of the entry to be restored
	 * @return the restored entry from the recycle bin
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Todo restoreEntryFromTrash(long userId, long entryId)
		throws PortalException {

		// Entry

		Todo entry = todoPersistence.findByPrimaryKey(entryId);

		if (!entry.isInTrash()) {
			throw new RestoreEntryException(
				RestoreEntryException.INVALID_STATUS);
		}

		TrashEntry trashEntry = _trashEntryLocalService.getEntry(
			Todo.class.getName(), entryId);

		updateStatus(
			userId, entryId, trashEntry.getStatus(), new ServiceContext(),
			new HashMap<String, Serializable>());

		return entry;
	}

	@Override
	public void updateAsset(
			long userId, Todo entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException {

		boolean visible = false;

		if (entry.isApproved()) {
			visible = true;
		}

		String summary = HtmlUtil.extractText(
			StringUtil.shorten(entry.getTodoSummaryName(), 500));

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
			userId, entry.getGroupId(), entry.getCreateDate(),
			entry.getModifiedDate(), Todo.class.getName(),
			entry.getPrimaryKey(), entry.getUuid(), 0, assetCategoryIds,
			assetTagNames, true, visible, null, null, null, null,
			ContentTypes.TEXT_HTML, entry.getTodoTitleName(), null, summary,
			null, null, 0, 0, priority);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(), assetLinkEntryIds,
			AssetLinkConstants.TYPE_RELATED);
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Todo updateEntry(
			Todo orgEntry, ServiceContext serviceContext)
		throws PortalException, TodoValidateException {

		User user = userLocalService.getUser(orgEntry.getUserId());

		// Validation

		ModelValidator<Todo> modelValidator = new TodoValidator();
		modelValidator.validate(orgEntry);

		// Update entry

		Todo entry = _updateEntry(
			orgEntry.getPrimaryKey(), orgEntry, serviceContext);

		if (!entry.isPending() && !entry.isDraft()) {
			entry.setStatus(WorkflowConstants.STATUS_DRAFT);
		}

		Todo updatedEntry = todoPersistence.update(entry);

		// Asset

		updateAsset(
			updatedEntry.getUserId(), updatedEntry,
			serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(),
			serviceContext.getAssetLinkEntryIds(),
			serviceContext.getAssetPriority());

		updatedEntry = startWorkflowInstance(
			user.getUserId(), updatedEntry, serviceContext);

		return updatedEntry;
	}

	@Override
	public void updateEntryResources(
			Todo entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException {

		resourceLocalService.updateResources(
			entry.getCompanyId(), entry.getGroupId(), Todo.class.getName(),
			entry.getPrimaryKey(), groupPermissions, guestPermissions);
	}

	@Indexable(type = IndexableType.REINDEX)
	public Todo updateStatus(
			long userId, long entryId, int status,
			ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		// Entry

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		Todo entry = todoPersistence.findByPrimaryKey(entryId);

		int oldStatus = entry.getStatus();

		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setStatus(status);
		entry.setStatusByUserId(user.getUserId());
		entry.setStatusByUserName(user.getFullName());
		entry.setStatusDate(serviceContext.getModifiedDate(now));

		todoPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
			Todo.class.getName(), entryId);

		if ((assetEntry == null) || (assetEntry.getPublishDate() == null)) {
			serviceContext.setCommand(Constants.ADD);
		}

		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("title", entry.getTodoTitleName());

		if (status == WorkflowConstants.STATUS_APPROVED) {

			// Asset

			assetEntryLocalService.updateEntry(
				Todo.class.getName(), entryId, entry.getModifiedDate(),
				null, true, true);

			// Trash

			if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
				CommentManagerUtil.restoreDiscussionFromTrash(
					Todo.class.getName(), entryId);

				_trashEntryLocalService.deleteEntry(
					Todo.class.getName(), entryId);
			}
		}
		else {

			// Asset

			assetEntryLocalService.updateVisible(
				Todo.class.getName(), entryId, false);

			// Trash

			if (status == WorkflowConstants.STATUS_IN_TRASH) {
				CommentManagerUtil.moveDiscussionToTrash(
					Todo.class.getName(), entryId);
				_trashEntryLocalService.addTrashEntry(
					userId, entry.getGroupId(), Todo.class.getName(),
					entry.getPrimaryKey(), entry.getUuid(), null, oldStatus,
					null, null);
			}
			else if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
				CommentManagerUtil.restoreDiscussionFromTrash(
					Todo.class.getName(), entryId);

				_trashEntryLocalService.deleteEntry(
					Todo.class.getName(), entryId);
			}
		}

		return entry;
	}

	/**
	 * Copy models at add entry
	 *
	 * To process storing a record into database, copy the model passed into a new
	 * model object here.
	 *
	 * @param entry          model object
	 * @param serviceContext ServiceContext
	 * @return
	 * @throws PortalException
	 */
	public Todo _addEntry(Todo entry, ServiceContext serviceContext)
		throws PortalException {

		long id = counterLocalService.increment(Todo.class.getName());

		Todo newEntry = todoPersistence.create(id);

		User user = userLocalService.getUser(entry.getUserId());

		Date now = new Date();
		newEntry.setCompanyId(entry.getCompanyId());
		newEntry.setGroupId(entry.getGroupId());
		newEntry.setUserId(user.getUserId());
		newEntry.setUserName(user.getFullName());
		newEntry.setCreateDate(now);
		newEntry.setModifiedDate(now);

		newEntry.setUuid(serviceContext.getUuid());

		// Friendly URLs
		String urlTitle = getUniqueUrlTitle(newEntry, entry.getTodoTitleName());
//		urlTitle = updateFriendlyURLs(newEntry, urlTitle, serviceContext);
		newEntry.setUrlTitle(urlTitle);

		newEntry.setTodoTitleName(entry.getTodoTitleName());
		newEntry.setTodoSummaryName(entry.getTodoSummaryName());

/*   */
        newEntry.setTitle(entry.getTitle());
        newEntry.setTodoBooleanStat(entry.getTodoBooleanStat());
        newEntry.setTodoDateTime(entry.getTodoDateTime());
        newEntry.setTodoDocumentLibrary(entry.getTodoDocumentLibrary());
        newEntry.setTodoDouble(entry.getTodoDouble());
        newEntry.setTodoInteger(entry.getTodoInteger());
        newEntry.setTodoRichText(entry.getTodoRichText());
        newEntry.setTodoText(entry.getTodoText());
/*  */	

		return todoPersistence.update(newEntry);
	}

	/**
	 * Copy models at update entry
	 *
	 * To process storing a record into database, copy the model passed into a new
	 * model object here.
	 *
	 * @param primaryKey     Primary key
	 * @param entry          model object
	 * @param serviceContext ServiceContext
	 * @return updated entry
	 * @throws PortalException
	 */
	protected Todo _updateEntry(
			long primaryKey, Todo entry, ServiceContext serviceContext)
		throws PortalException {

		Todo updateEntry = fetchTodo(primaryKey);

		User user = userLocalService.getUser(entry.getUserId());

		Date now = new Date();
		updateEntry.setCompanyId(entry.getCompanyId());
		updateEntry.setGroupId(entry.getGroupId());
		updateEntry.setUserId(user.getUserId());
		updateEntry.setUserName(user.getFullName());
		updateEntry.setCreateDate(entry.getCreateDate());
		updateEntry.setModifiedDate(now);

		updateEntry.setUuid(entry.getUuid());
		String urlTitle = entry.getTodoTitleName();
		if (Validator.isNotNull(urlTitle)) {
			long classNameId = _classNameLocalService.getClassNameId(
				Todo.class);

			try{
				_friendlyURLEntryLocalService.validate(
				entry.getGroupId(), classNameId, primaryKey, entry.getTodoTitleName());
			} catch(DuplicateFriendlyURLEntryException e) {
				List<String> error = new ArrayList<String>();
				error.add("duplicated-url-title");
				throw new TodoValidateException(error);
			}
		}
		else {
			urlTitle = getUniqueUrlTitle(entry, urlTitle);
		}

		if (!urlTitle.equals(entry.getUrlTitle())) {
			urlTitle = updateFriendlyURLs(entry, urlTitle, serviceContext);
		}

		updateEntry.setUrlTitle(
			getUniqueUrlTitle(updateEntry, urlTitle));

		updateEntry.setTodoTitleName(entry.getTodoTitleName());
		updateEntry.setTodoSummaryName(entry.getTodoSummaryName());

/*   */
        updateEntry.setTodoId(entry.getTodoId());
        updateEntry.setTitle(entry.getTitle());
        updateEntry.setTodoBooleanStat(entry.getTodoBooleanStat());
        updateEntry.setTodoDateTime(entry.getTodoDateTime());
        updateEntry.setTodoDocumentLibrary(entry.getTodoDocumentLibrary());
        updateEntry.setTodoDouble(entry.getTodoDouble());
        updateEntry.setTodoInteger(entry.getTodoInteger());
        updateEntry.setTodoRichText(entry.getTodoRichText());
        updateEntry.setTodoText(entry.getTodoText());
/*  */ 

		return updateEntry;
	}

	/**
	* Update Friendly URLs
	*
	* @param entry Todo
	* @param urlTitle
	* @param serviceContext
	* @return string
	* @throws PortalException
	*/
	public String updateFriendlyURLs(
		Todo entry, String urlTitle,
		ServiceContext serviceContext)
		throws PortalException {

		if (ExportImportThreadLocal.isImportInProcess() ||
			ExportImportThreadLocal.isStagingInProcess()) {

			return urlTitle;
		}
		
		long classNameId = _classNameLocalService.getClassNameId(
				Todo.class);

		List<FriendlyURLEntry> friendlyURLEntries =
		_friendlyURLEntryLocalService.getFriendlyURLEntries(
			entry.getGroupId(),
			classNameId,
			entry.getPrimaryKey());

		FriendlyURLEntry newFriendlyURLEntry =
			_friendlyURLEntryLocalService.addFriendlyURLEntry(
				entry.getGroupId(),
				classNameId,
				entry.getPrimaryKey(), urlTitle, serviceContext);

		for (FriendlyURLEntry friendlyURLEntry : friendlyURLEntries) {
			if (newFriendlyURLEntry.getFriendlyURLEntryId() ==
				friendlyURLEntry.getFriendlyURLEntryId()) {

				continue;
			}

			_friendlyURLEntryLocalService.deleteFriendlyURLEntry(friendlyURLEntry);
		}

		return newFriendlyURLEntry.getUrlTitle();
	}

	/**
	 * Delete discussion (comments)
	 *
	 * @param entry
	 * @throws PortalException
	 */
	protected void deleteDiscussion(Todo entry) throws PortalException {
		CommentManagerUtil.deleteDiscussion(
			Todo.class.getName(), entry.getPrimaryKey());
	}

	/**
	 * Generating a unique URL for asset
	 */
	public String getUniqueUrlTitle(Todo entry, String newTitle) {
		long entryId = entry.getPrimaryKey();

		String urlTitle = null;

		if (newTitle == null || newTitle.equals("")) {
			urlTitle = String.valueOf(entryId);
		}
		else {
			urlTitle = StringUtil.toLowerCase(newTitle.trim());

			if (Validator.isNull(urlTitle) || Validator.isNumber(urlTitle) ||
				urlTitle.equals("rss")) {

				urlTitle = String.valueOf(entryId);
			}
			else {
				urlTitle =
					FriendlyURLNormalizerUtil.normalizeWithPeriodsAndSlashes(
						urlTitle);
			}

			urlTitle = ModelHintsUtil.trimString(
				Todo.class.getName(), "urlTitle", urlTitle);
		}

		long classNameId = _classNameLocalService.getClassNameId(
			Todo.class);

		return _friendlyURLEntryLocalService.getUniqueUrlTitle(
			entry.getGroupId(), classNameId, entry.getPrimaryKey(), urlTitle);
	}

	/**
	 * Generating URL Title for unique URL
	 *
	 * @param entryId primaryKey of the model
	 * @param title   title for the asset
	 * @return URL title string
	 */
	protected String getUrlTitle(long entryId, String title) {
		if (title == null) {
			return String.valueOf(entryId);
		}

		title = StringUtil.toLowerCase(title.trim());

		if (Validator.isNull(title) || Validator.isNumber(title)) {
			title = String.valueOf(entryId);
		}
		else {
			title = FriendlyURLNormalizerUtil.normalizeWithPeriodsAndSlashes(
				title);
		}

		return ModelHintsUtil.trimString(
			Todo.class.getName(), "urlTitle", title);
	}

	/**
	 * Start workflow
	 *
	 * @param userId         User id of this model's owner
	 * @param entry          model object
	 * @param serviceContext ServiceContext
	 * @return model with workflow configrations.
	 * @throws PortalException
	 */
	protected Todo startWorkflowInstance(
			long userId, Todo entry, ServiceContext serviceContext)
		throws PortalException {

		Map<String, Serializable> workflowContext = new HashMap<>();

		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;

		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUser(userId);

			userPortraitURL = user.getPortraitURL(
				serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		workflowContext.put(
			WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
		workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(
			entry.getCompanyId(), entry.getGroupId(), userId,
			Todo.class.getName(), entry.getPrimaryKey(), entry,
			serviceContext, workflowContext);
	}

	private static final int[] STATUS_ANY = {
		WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_DENIED,
		WorkflowConstants.STATUS_DRAFT, WorkflowConstants.STATUS_EXPIRED,
		WorkflowConstants.STATUS_IN_TRASH, WorkflowConstants.STATUS_INACTIVE,
		WorkflowConstants.STATUS_INCOMPLETE, WorkflowConstants.STATUS_PENDING,
		WorkflowConstants.STATUS_SCHEDULED
	};

	private static Log _log = LogFactoryUtil.getLog(
		TodoLocalServiceImpl.class);

	@Reference
	private ClassNameLocalService _classNameLocalService;
	
	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setClassNameLocalService(
			ClassNameLocalService classNameLocalService) {
		this._classNameLocalService = classNameLocalService;
	}

	@Reference
	private FriendlyURLEntryLocalService _friendlyURLEntryLocalService;
	
	/**
	 * Sets the user local service.
	 *
	 * @param friendlyURLEntryLocalService the user local service
	 */
	public void setFriendlyURLEntryLocalService(
			FriendlyURLEntryLocalService friendlyURLEntryLocalService) {
		this._friendlyURLEntryLocalService = friendlyURLEntryLocalService;
	}

	@Reference
	private Portal _portal;

	@Reference
	private TrashEntryLocalService _trashEntryLocalService;

}
