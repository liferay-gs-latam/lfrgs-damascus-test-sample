<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
Todo todo = (Todo)request.getAttribute("todo");
String redirect = ParamUtil.getString(request, "redirect");
boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

%>

<div class="container-fluid-1280">
	<aui:fieldset>
<%--  --%>
	    <div class="form-group">
	        <h3><liferay-ui:message key="asset-title" /></h3>
	        <p class="form-control"><%=todo.getTodoTitleName()%></p>
	    </div>
	    <div class="form-group">
	        <h3><liferay-ui:message key="asset-title" /></h3>
	        <p class="form-control"><%=todo.getTodoSummaryName()%></p>
	    </div>

		<div class="form-group">
	        <h3><liferay-ui:message key="todo-todoId" /></h3>
			<p class="form-control"><%=todo.getTodoId()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="todo-title" /></h3>
			<p class="form-control"><%=todo.getTitle()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="todo-todoBooleanStat" /></h3>
			<p class="form-control"><%=todo.getTodoBooleanStat()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="todo-todoDateTime" /></h3>
			<p class="form-control"><%=todo.getTodoDateTime()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="todo-todoDocumentLibrary" /></h3>
			<p class="form-control"><%=todo.getTodoDocumentLibrary()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="todo-todoDouble" /></h3>
			<p class="form-control"><%=todo.getTodoDouble()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="todo-todoInteger" /></h3>
			<p class="form-control"><%=todo.getTodoInteger()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="todo-todoRichText" /></h3>
			<p class="form-control"><%=todo.getTodoRichText()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="todo-todoText" /></h3>
			<p class="form-control"><%=todo.getTodoText()%></p>
		</div>
<%--  --%>		
	</aui:fieldset>
</div>