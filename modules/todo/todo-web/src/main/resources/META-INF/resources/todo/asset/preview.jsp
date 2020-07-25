<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="/todo/init.jsp" %>

<jsp:useBean id="todo" scope="request" type="com.liferay.sb.test.model.Todo" />

<%= todo.getTodoTitleName() %>