<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
String iconChecked = "checked";
String iconUnchecked = "unchecked";
SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatVal);
SimpleDateFormat dateTimeFormat = new SimpleDateFormat(datetimeFormatVal);


TodoDisplayContext todoDisplayContext = (TodoDisplayContext)request.getAttribute(TodoWebKeys.TODO_DISPLAY_CONTEXT);

String displayStyle = todoDisplayContext.getDisplayStyle();
SearchContainer entriesSearchContainer = todoDisplayContext.getSearchContainer();

PortletURL portletURL = entriesSearchContainer.getIteratorURL();

TodoManagementToolbarDisplayContext todoManagementToolbarDisplayContext = new TodoManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, request, entriesSearchContainer, trashHelper, displayStyle);
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems='<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
				navigationItem -> {
					navigationItem.setActive(true);
					navigationItem.setHref(renderResponse.createRenderURL());
					navigationItem.setLabel(LanguageUtil.get(request, "Todo"));
				});

			}
		}
	%>'
/>

<clay:management-toolbar
	actionDropdownItems="<%= todoManagementToolbarDisplayContext.getActionDropdownItems() %>"
	clearResultsURL="<%= todoManagementToolbarDisplayContext.getSearchActionURL() %>"
	componentId="todoManagementToolbar"
	creationMenu="<%= todoManagementToolbarDisplayContext.getCreationMenu() %>"
	disabled="<%= todoManagementToolbarDisplayContext.isDisabled() %>"
	filterDropdownItems="<%= todoManagementToolbarDisplayContext.getFilterDropdownItems() %>"
	itemsTotal="<%= todoManagementToolbarDisplayContext.getItemsTotal() %>"
	searchActionURL="<%= todoManagementToolbarDisplayContext.getSearchActionURL() %>"
	searchContainerId="todo"
	searchFormName="fm"
	showSearch="true"
	sortingOrder="<%= todoManagementToolbarDisplayContext.getOrderByType() %>"
	sortingURL="<%= todoManagementToolbarDisplayContext.getSortingURL() %>"
/>

<portlet:actionURL name="/todo/crud" var="restoreTrashEntriesURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.RESTORE %>" />
</portlet:actionURL>

<liferay-trash:undo
	portletURL="<%= restoreTrashEntriesURL %>"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form action="<%= portletURL.toString() %>" method="get" name="fm">
		<aui:input name="<%= Constants.CMD %>" type="hidden" />
		<aui:input name="redirect" type="hidden" value="<%= portletURL.toString() %>" />
		<aui:input name="deleteEntryIds" type="hidden" />
		<aui:input name="selectAll" type="hidden" value="<%= false %>" />

		<liferay-ui:search-container
			emptyResultsMessage="no-record-was-found"
			id="todo"
			rowChecker="<%= new EmptyOnClickRowChecker(renderResponse) %>"
			searchContainer="<%= entriesSearchContainer %>"
		>
			<liferay-ui:search-container-row
				className="com.liferay.sb.test.model.Todo"
				escapedModel="<%= true %>"
				keyProperty="todoId"
				modelVar="todo"
			>
			
<%--  --%>

				<liferay-ui:search-container-column-text
					align="left"
					name="TodoId"
					orderable="true"
					orderableProperty="todoId"
					property="todoId"
				/>


				<liferay-ui:search-container-column-text
					align="left"
					name="Title"
					orderable="true"
					orderableProperty="title"
					property="title"
				/>


				<liferay-ui:search-container-column-text
					align="left"
					name="TodoBooleanStat"
					orderable="true"
					orderableProperty="todoBooleanStat"
					property="todoBooleanStat"
				/>

				<liferay-ui:search-container-column-text
					name="TodoDateTime"
					value="<%= dateFormat.format(todo.getTodoDateTime()) %>"
					orderable="true"
					orderableProperty="todoDateTime"
					align="left"
				/>


				<liferay-ui:search-container-column-text
					align="left"
					name="TodoDocumentLibrary"
					orderable="true"
					orderableProperty="todoDocumentLibrary"
					property="todoDocumentLibrary"
				/>


				<liferay-ui:search-container-column-text
					align="left"
					name="TodoDouble"
					orderable="true"
					orderableProperty="todoDouble"
					property="todoDouble"
				/>


				<liferay-ui:search-container-column-text
					align="left"
					name="TodoInteger"
					orderable="true"
					orderableProperty="todoInteger"
					property="todoInteger"
				/>


				<liferay-ui:search-container-column-text name="TodoRichText"
														 align="center">
					<%
					String todoRichTextIcon = iconUnchecked;
					String todoRichText = todo.getTodoRichText();
					if (!todoRichText.equals("")) {
						todoRichTextIcon= iconChecked;
					}
					%>
					<liferay-ui:icon image="<%= todoRichTextIcon %>" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="TodoText"
														 align="center">
					<%
					String todoTextIcon = iconUnchecked;
					String todoText = todo.getTodoText();
					if (!todoText.equals("")) {
						todoTextIcon= iconChecked;
					}
					%>
					<liferay-ui:icon image="<%= todoTextIcon %>" />
				</liferay-ui:search-container-column-text>
<%--  --%>

				<liferay-ui:search-container-column-jsp
					align="right"
					path="/todo/edit_actions.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator displayStyle="list" markupView="lexicon" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />deleteEntries() {
		if (<%=trashHelper.isTrashEnabled(scopeGroupId) %> || confirm('<%=UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-the-selected-entries") %>')) {
			var form = AUI.$(document.<portlet:namespace />fm);

			form.attr('method', 'post');
			form.fm('<%=Constants.CMD%>').val('<%=trashHelper.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE%>');
			form.fm('deleteEntryIds').val(Liferay.Util.listCheckedExcept(form, '<portlet:namespace />allRowIds'));

			submitForm(form, '<portlet:actionURL name="/todo/crud" />');
		}
	}
</aui:script>
