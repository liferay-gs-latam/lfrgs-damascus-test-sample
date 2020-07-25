<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
PortletURL navigationPortletURL = renderResponse.createRenderURL();
PortletURL portletURL = PortletURLUtil.clone(navigationPortletURL, liferayPortletResponse);

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Todo todo = (Todo)row.getObject();

long groupId = todo.getGroupId();
String name = Todo.class.getName();
String primKey = String.valueOf(todo.getPrimaryKey());
%>

<liferay-ui:icon-menu
	cssClass='<%= row == null ? "entry-options inline" : StringPool.BLANK %>'
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= TodoEntryPermission.contains(permissionChecker, todo, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="com.liferay.sb.test.model.Todo"
			modelResourceDescription="Todo"
			resourcePrimKey="<%= String.valueOf(primKey) %>"
			var="permissionsEntryURL"
		/>

		<liferay-ui:icon iconCssClass="icon-lock" label="<%= true %>" markupView="lexicon" message="permissions" url="<%= permissionsEntryURL %>" />
	</c:if>

	<c:if test="<%= TodoEntryPermission.contains(permissionChecker, todo, ActionKeys.VIEW) %>">
		<portlet:renderURL var="viewTodoURL">
			<portlet:param name="mvcRenderCommandName" value="/todo/crud" />

			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.VIEW %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:renderURL>

		<liferay-ui:icon iconCssClass="icon-eye-open" label="<%= true %>" markupView="lexicon" message="view" url="<%= viewTodoURL.toString() %>" />
	</c:if>

	<c:if test="<%= TodoEntryPermission.contains(permissionChecker, todo, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editTodoURL">
			<portlet:param name="mvcRenderCommandName" value="/todo/crud" />

			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.UPDATE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:renderURL>

		<liferay-ui:icon iconCssClass="icon-edit" label="<%= true %>" markupView="lexicon" message="edit" url="<%= editTodoURL.toString() %>" />
	</c:if>

	<c:if test="<%= TodoEntryPermission.contains(permissionChecker, todo, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/todo/crud" var="deleteTodoURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.DELETE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-remove" label="<%= true %>" markupView="lexicon" message="remove" url="<%= deleteTodoURL.toString() %>" />
	</c:if>

	<c:if test="<%= TodoEntryPermission.contains(permissionChecker, todo, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/todo/crud" var="moveToTrashTodoURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.MOVE_TO_TRASH %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-trash" label="<%= true %>" markupView="lexicon" message="trash" url="<%= moveToTrashTodoURL.toString() %>" />
	</c:if>
</liferay-ui:icon-menu>