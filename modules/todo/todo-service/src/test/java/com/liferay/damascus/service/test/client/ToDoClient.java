package com.liferay.damascus.service.test.client;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;

import com.liferay.damascus.service.test.model.ConstantsApi;
import com.liferay.damascus.service.test.model.ToDo;
import com.liferay.damascus.service.test.utils.BaseApi;

import io.restassured.response.ValidatableResponse;

public class ToDoClient extends BaseApi {

	public ToDoClient() {
		BaseApi.preCondition();
	}
	
	public ValidatableResponse getToDoContent(Integer primaryKey) {
		
		return
	        
		given().

			auth().
		    preemptive().
		    basic(ConstantsApi.EMAIL, ConstantsApi.PASSWORD).
		    pathParam("primaryKey", primaryKey).
		    
	    when()
	        .get("todo.todo/get-todo/primary-key/{primaryKey}").
	        
	    then()
	        .statusCode(HttpStatus.SC_OK);
	}

	public ToDo deleteToDo_byPrimaryKey_sucess_BuilderPattern(Integer primaryKey) {
		
		return
				
		given().
				
			auth().
			preemptive().
		    basic(ConstantsApi.EMAIL, ConstantsApi.PASSWORD).

			
			pathParam("primaryKey", primaryKey).
			pathParam("apiPath", ConstantsApi.API_PATH).
			pathParam("deleteApiPath", ConstantsApi.DELETE).
			
		when().
			post("{apiPath}/{deleteApiPath}/primary-key/{primaryKey}").
			
		then().
			statusCode(HttpStatus.SC_OK).
			extract().
				body().
				as(ToDo.class);
	}

	public ValidatableResponse deleteToDo_primaryKeyDoesNotExist_404NotFound(Integer primaryKey) {
		
		return
				
		given().
			auth().
			preemptive().
		    basic(ConstantsApi.EMAIL, ConstantsApi.PASSWORD).
			
			pathParam("primaryKey", primaryKey).
			pathParam("apiPath", ConstantsApi.API_PATH).
			pathParam("deleteApiPath", ConstantsApi.DELETE).
				
		when().
			post("{apiPath}/{deleteApiPath}/primary-key/{primaryKey}").
				
		then().
			statusCode(HttpStatus.SC_NOT_FOUND);
	}
	
		
	public void addNewToDoList_success(String toDo) {
        
		given()
			.auth()
			.preemptive()
		    .basic(ConstantsApi.EMAIL, ConstantsApi.PASSWORD)

            .body(toDo)
        .when()
            .post(ConstantsApi.ADD_NEW_TODO_LIST).
        then().
	        statusCode(HttpStatus.SC_OK);
	}
	
	public void updateToDoList_success() {
		
	}
	public void moveToTrashToDoList_success() {
		
	}
}
