<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
	PortletURL portletURL = PortletURLUtil.clone(renderResponse.createRenderURL(), liferayPortletResponse);
	boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
	String CMD = ParamUtil.getString(request, Constants.CMD, Constants.UPDATE);
	Todo todo = (Todo)request.getAttribute("todo");
	String redirect = ParamUtil.getString(request, "redirect");
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(redirect);
%>

<portlet:actionURL name="/todo/crud" var="todoEditURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= CMD %>" />
	<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
</portlet:actionURL>

<div class="container-fluid-1280">
	<aui:form action="<%= todoEditURL %>" method="post" name="todoEdit">
		<aui:model-context bean="<%= todo %>" model="<%= Todo.class %>" />
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= CMD %>" />
		<aui:input name="fromAsset" type="hidden" value="<%= fromAsset %>" />
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="resourcePrimKey" type="hidden" value="<%= todo.getPrimaryKey() %>" />

		<%

		//This tag is only necessary in Asset publisher

		if (fromAsset) {
		%>

		<div class="lfr-form-content">

		<%
		}
		%>

		<c:if test="<%= Constants.ADD.equals(CMD) %>">
			<aui:input name="addGuestPermissions" type="hidden" value="true" />
			<aui:input name="addGroupPermissions" type="hidden" value="true" />
		</c:if>
<%--   --%>
						<liferay-ui:error key="duplicated-url-title"
												  message="duplicated-url-title" />
						<aui:input name="todoTitleName" label="title" />
						<aui:input name="todoSummaryName" label="summary" />
<%--  --%>

		<%
			String requiredLabel = "";
		%>
<%--   --%>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="todo-title-required"
						  message="todo-title-required" />

					<aui:input name="title" disabled="false"
						label='<%=LanguageUtil.get(request, "todo-title")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="todoBooleanStat" disabled="false"
						label='<%=LanguageUtil.get(request, "todo-todobooleanstat")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="todoDateTime" disabled="false"
						label='<%=LanguageUtil.get(request, "todo-tododatetime")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="todoDocumentLibrary" disabled="false"
						 readonly="true" type="text" label='<%=LanguageUtil.get(request,
						"todo-tododocumentlibrary") + requiredLabel%>' />
					<%
					String todoDocumentLibraryClick = renderResponse.getNamespace() + "dlBrowse('todoDocumentLibrary Files select','" +
					renderResponse.getNamespace()+"todoDocumentLibrary')";
					%>

					<aui:button onClick="<%=todoDocumentLibraryClick%>" value="select" />
		<%
			requiredLabel = "";
		%>

					<aui:input name="todoDouble" disabled="false"
						label='<%=LanguageUtil.get(request, "todo-tododouble")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="todoInteger" disabled="false"
						label='<%=LanguageUtil.get(request, "todo-todointeger")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:field-wrapper
						label="<%=LanguageUtil.get(request,\"todo-todorichtext\") + requiredLabel%>">
						<liferay-ui:input-editor name="todoRichTextEditor"
												 initMethod="inittodoRichTextEditor" />
					</aui:field-wrapper>
					<aui:input disabled="false" name="todoRichText" type="hidden" />
		<%
			requiredLabel = "";
		%>

					<aui:input name="todoText" disabled="false"
						label='<%=LanguageUtil.get(request, "todo-todotext")
						+ requiredLabel%>'
					/>
<%--  --%>

		<%
			if (todo.getPrimaryKey() != 0) {
		%>

		<liferay-ui:ratings
			className="<%= Todo.class.getName() %>"
			classPK="<%= todo.getPrimaryKey() %>"
			type="stars"
		/>

		<%
			}
		%>

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="categorization">
				<aui:input name="categories" type="assetCategories" />

				<aui:input name="tags" type="assetTags" />
			</aui:fieldset>
		</aui:fieldset-group>

		<%
		if (todo.getPrimaryKey() != 0 && false == fromAsset) {
		%>

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="related-assets">
				<liferay-asset:input-asset-links
					className="<%= Todo.class.getName() %>"
					classPK="<%= todo.getPrimaryKey() %>"
				/>
			</aui:fieldset>
		</aui:fieldset-group>

		<%
		}
		%>

		<%

		//This tag is only necessary in Asset publisher

		if (fromAsset) {
		%>

		</div>

		<%
		}
		%>

		<aui:button-row>

			<%
				String publishButtonLabel = "submit";
			%>

			<%
				if (WorkflowDefinitionLinkLocalServiceUtil
					.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, Todo.class.getName())) {

						publishButtonLabel = "submit-for-publication";
				}
			%>

			<aui:button
				cssClass="btn-lg"
				onClick='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveEditors();" %>'
				primary="<%= false %>"
				type="submit"
				value="<%= publishButtonLabel %>"
			/>

			<%
				if (!fromAsset) {
			%>

			&nbsp;&nbsp;&minus; <liferay-ui:message key="or" /> &minus;
			<aui:button onClick="<%= redirect %>" type="cancel" />

			<%
				}
			%>

		</aui:button-row>
	</aui:form>

	<%
	if (todo.getPrimaryKey() != 0 && false == fromAsset) {
	%>

	<liferay-ui:panel-container
		extended="<%= false %>"
		id="todoCommentsPanelContainer"
		persistState="<%= true %>"
	>
		<liferay-ui:panel
			collapsible="<%= true %>"
			extended="<%= true %>"
			id="todoCommentsPanel"
			persistState="<%= true %>"
			title='<%= LanguageUtil.get(request, "comments") %>'
		>
			<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />

			<liferay-comment:discussion
				className="<%= Todo.class.getName() %>"
				classPK="<%= todo.getPrimaryKey() %>"
				formName="fm2"
				ratingsEnabled="<%= true %>"
				redirect="<%= currentURL %>"
				userId="<%= todo.getUserId() %>"
			/>
		</liferay-ui:panel>
	</liferay-ui:panel-container>

	<%
	}
	%>

</div>

<%--   --%>
<aui:script>
	function <portlet:namespace />inittodoRichTextEditor() {
		return '<%=UnicodeFormatter.toString(todo.getTodoRichText())%>';
	}
</aui:script>
<%--  --%>

<aui:script>
	function <portlet:namespace />saveEditors() {
<%--   --%>
		document.<portlet:namespace />todoEdit.<portlet:namespace />todoRichText.value =
		window.<portlet:namespace />todoRichTextEditor.getHTML();
<%--  --%>
		submitForm(document.<portlet:namespace />todoEdit);
	}
</aui:script>

<%--   --%>
<%
TodoItemSelectorHelper todoItemSelectorHelper = (TodoItemSelectorHelper)request
	.getAttribute(TodoWebKeys.TODO_ITEM_SELECTOR_HELPER);
RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil
	.create(liferayPortletRequest);
String selectItemName = liferayPortletResponse.getNamespace()
		+ "selectItem";
%>

<aui:script>
	function <portlet:namespace />dlBrowse (title, inputField) {
		var itemSrc = $('#'+inputField);
		AUI().use(
			'liferay-item-selector-dialog',
			function(A) {
				var itemSelectorDialog = new A.LiferayItemSelectorDialog(
					{
						eventName: '<%= selectItemName %>',
						on: {
							selectedItemChange: function(event) {
								var selectedItem = event.newVal;

								if (selectedItem) {
									var itemValue = JSON.parse(
										selectedItem.value
									);
									itemSrc.val(itemValue.url);
								}
							}
						},
						title: title,
						url: '<%= todoItemSelectorHelper.getItemSelectorURL(
						requestBackedPortletURLFactory, themeDisplay, selectItemName) %>'
					}
				);
				itemSelectorDialog.open();
			}
		);
	}
</aui:script>
<%--  --%>
