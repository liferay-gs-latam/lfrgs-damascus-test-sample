package com.liferay.damascus.unit.test;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import com.liferay.sb.test.model.Todo;
import com.liferay.sb.test.service.impl.TodoLocalServiceImpl;

public class ToDoLocalServiceImplStub extends TodoLocalServiceImpl {

	protected Todo startWorkflowInstance(long userId, Todo toDo, ServiceContext serviceContext) throws PortalException {
		return toDo;
	}
}
