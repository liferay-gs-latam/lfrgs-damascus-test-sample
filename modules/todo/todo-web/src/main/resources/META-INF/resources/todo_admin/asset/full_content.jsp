<%--  --%>
<%--  --%>
<%--  --%>

<%@ include file="../init.jsp" %>

<jsp:useBean id="todo" scope="request" type="com.liferay.sb.test.model.Todo" />

<portlet:defineObjects />

<%--  --%>
<%= todo.getTodoTitleName()
<%--  --%>