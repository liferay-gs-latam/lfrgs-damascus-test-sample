package com.liferay.damascus.unit.test;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.sb.test.model.Todo;
import com.liferay.sb.test.model.impl.TodoImpl;
import com.liferay.sb.test.service.base.TodoLocalServiceBaseImpl;
import com.liferay.sb.test.service.persistence.TodoPersistence;

public class ToDoLocalServiceImplTest {

	@Test
	public void addToDoOnTheList_shouldPass() throws PortalException {

		Assert.assertNotNull(_todoServiceImpl.addEntry(createAddToDo(), getServiceContext()));
	}

	private ServiceContext getServiceContext() {

		_serviceContext.setCompanyId(COMPANY_ID);
		_serviceContext.setScopeGroupId(GROUP_ID);
		_serviceContext.setUserId(USER_ID);
		_serviceContext.setAddGroupPermissions(false);
		_serviceContext.setAddGuestPermissions(false);
		_serviceContext.setUuid(UUID.randomUUID().toString());
		_serviceContext.setCommand("add");

		return _serviceContext;
	}

	private Todo createAddToDo() throws PortalException {

		_toDo.setTitle(TITLE_NAME);
		_toDo.setGroupId(GROUP_ID);
		_toDo.setUserId(USER_ID);
		_toDo.setCompanyId(COMPANY_ID);
		_toDo.setTodoId(TODO_ID);
		_toDo.setUserName(USER_NAME);
		_toDo.setTodoDateTime(new Date().from(Instant.now()));

		mock_setCounterLocalService_increment();
		mock_setTodoPersistence_createAndUpdate(_toDo);
		mock_setUserLocalService_getUser();
		mock_setClassNameLocalService_getClassNameId();
		mock_getUniqueUrlTitle(_toDo, getServiceContext());

		return _toDo;
	}

	private void mock_setCounterLocalService_increment() {

		Mockito.when(_counterLocalService.increment(Todo.class.getName())).thenReturn(TODO_ID);
		_todoServiceImpl.setCounterLocalService(_counterLocalService);
	}

	private void mock_setTodoPersistence_createAndUpdate(Todo toDo) {

		Mockito.when(_todoPersistence.create(TODO_ID)).thenReturn(toDo);
		Mockito.when(_todoPersistence.update(toDo)).thenReturn(toDo);
		_todoServiceImpl.setTodoPersistence(_todoPersistence);
	}

	private void mock_setUserLocalService_getUser() throws PortalException {

		Mockito.when(_user.getUserId()).thenReturn(USER_ID);
		Mockito.when(_userLocalService.getUser(USER_ID)).thenReturn(_user);
		_todoServiceImpl.setUserLocalService(_userLocalService);
	}

	private void mock_setClassNameLocalService_getClassNameId() {

		Mockito.when(classNameLocalService.getClassNameId(Todo.class)).thenReturn(34901L);
		_todoServiceImpl.setClassNameLocalService(classNameLocalService);
		_todoclassNameLocal.setclassNameLocalService(classNameLocalService);
	}

	private void mock_getUniqueUrlTitle(Todo toDo, ServiceContext serviceContext) {

		Mockito.when(_friendlyURLEntryLocalService.getUniqueUrlTitle(GROUP_ID, 34901, 2701, "2701")).thenReturn("2701");
		_todoServiceImpl.setFriendlyURLEntryLocalService(_friendlyURLEntryLocalService);
	}

	@Before
	public void init() {

		_toDo = new TodoImpl();
		_serviceContext = new ServiceContext();
		_todoServiceImpl = new ToDoLocalServiceImplStub();

		_user = Mockito.mock(User.class);
		_todoPersistence = Mockito.mock(TodoPersistence.class);
		_userLocalService = Mockito.mock(UserLocalService.class);
		_userLocalService = Mockito.mock(UserLocalService.class);
		_counterLocalService = Mockito.mock(CounterLocalService.class);
		classNameLocalService = Mockito.mock(ClassNameLocalService.class);
		_todoclassNameLocal = Mockito.mock(TodoLocalServiceBaseImpl.class);
		_friendlyURLEntryLocalService = Mockito.mock(FriendlyURLEntryLocalService.class);
	}

	private static final long COMPANY_ID = 20101;
	private static final long GROUP_ID = 20124;
	private static final long USER_ID = 20130L;
	private static final long TODO_ID = 2701L;
	private static final String USER_NAME = "Test Test";
	private static final String TITLE_NAME = "Testing";

	private User _user;
	private Todo _toDo;
	private ServiceContext _serviceContext;
	private TodoPersistence _todoPersistence;
	private UserLocalService _userLocalService;
	private CounterLocalService _counterLocalService;
	private ClassNameLocalService classNameLocalService;
	private TodoLocalServiceBaseImpl _todoclassNameLocal;
	private FriendlyURLEntryLocalService _friendlyURLEntryLocalService;

	ToDoLocalServiceImplStub _todoServiceImpl;
}