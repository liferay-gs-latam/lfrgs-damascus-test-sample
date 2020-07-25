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

package com.liferay.sb.test.service.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.sb.test.exception.TodoValidateException;
import com.liferay.sb.test.model.Todo;

/*   */
/*  */ 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Todo Validator 
 * 
 * @author diegofurtado
 *
 */
public class TodoValidator implements ModelValidator<Todo> {

	@Override
	public void validate(Todo entry) throws PortalException {
/*   */
        // Field todoId
        validateTodoId(entry.getTodoId());

        // Field title
        validateTitle(entry.getTitle());

        // Field todoBooleanStat
        validateTodoBooleanStat(entry.getTodoBooleanStat());

        // Field todoDateTime
        validateTodoDateTime(entry.getTodoDateTime());

        // Field todoDocumentLibrary
        validateTodoDocumentLibrary(entry.getTodoDocumentLibrary());

        // Field todoDouble
        validateTodoDouble(entry.getTodoDouble());

        // Field todoInteger
        validateTodoInteger(entry.getTodoInteger());

        // Field todoRichText
        validateTodoRichText(entry.getTodoRichText());

        // Field todoText
        validateTodoText(entry.getTodoText());

/*  */
        validateTodoTitleName(entry.getTodoTitleName());

		if (0 < _errors.size()) {
			throw new TodoValidateException(_errors);
		}
		
	}

    /**
    * todoTitleName field Validation
    *
    * @param todoTitleName
    */
    protected void validateTodoTitleName(String todoTitleName) {
        if (Validator.isNotNull(todoTitleName)) {
            int todoTitleNameMaxLength = ModelHintsUtil.getMaxLength(
                Todo.class.getName(), "todoTitleName");

            if (todoTitleName.length() > todoTitleNameMaxLength) {
                _errors.add("todoTitleName has more than " + todoTitleNameMaxLength +
                " characters");
            }
        }
    }

/*   */
    /**
    * todoId field Validation
    *
    * @param field todoId
    */
    protected void validateTodoId(long field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
    }

    /**
    * title field Validation
    *
    * @param field title
    */
    protected void validateTitle(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (!StringUtils.isNotEmpty(field)) {
            _errors.add("todo-title-required");
        }

    }

    /**
    * todoBooleanStat field Validation
    *
    * @param field todoBooleanStat
    */
    protected void validateTodoBooleanStat(boolean field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * todoDateTime field Validation
    *
    * @param field todoDateTime
    */
    protected void validateTodoDateTime(Date field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * todoDocumentLibrary field Validation
    *
    * @param field todoDocumentLibrary
    */
    protected void validateTodoDocumentLibrary(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * todoDouble field Validation
    *
    * @param field todoDouble
    */
    protected void validateTodoDouble(double field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * todoInteger field Validation
    *
    * @param field todoInteger
    */
    protected void validateTodoInteger(int field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * todoRichText field Validation
    *
    * @param field todoRichText
    */
    protected void validateTodoRichText(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * todoText field Validation
    *
    * @param field todoText
    */
    protected void validateTodoText(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

/*  */ 	
	

	protected List<String> _errors = new ArrayList<>();

}
