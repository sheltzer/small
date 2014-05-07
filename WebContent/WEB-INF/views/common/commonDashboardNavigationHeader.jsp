<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Much of this top part can either be an include page, or we could create a tiles template and override the table details --%>
<c:if test="${param.includeGlobalMessage == true}">
<div class="messages grid_12">

	<div id="updateNotifications" class="ui-state-highlight ui-corner-all" data-bind="visible: showGlobalNotificationMessage()" style="display: none;">
        <p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span><strong></strong><span id="notificationMessageContent" data-bind="text: globalNotificationMessage"></span></p>
    </div>
    
	<div id="errors" class="ui-state-error ui-corner-all" style="display: none;" data-bind="visible: showGlobalErrorMessage()">
        <p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span><strong>Alert: </strong><span id="errorMessageContent" data-bind="text: globalErrorMessage"></span></p>
    </div>
</div>
<div class="clear"></div>
</c:if>

<%-- Parameterize --%>
<form id="actionForm" method="GET"></form>
<div class="grid_6 left">
	<div class="dashboard-filter-bar" data-bind="foreach: primaryFilters">
		<span data-bind="click: clickHandler, css: {selected: $root.primaryFilterName() == $data.id}"><span data-bind="text: label"></span>(<span data-bind="text: count"></span>)</span>
		<span data-bind="ifnot: $data == $root.lastPrimaryFilter">|</span>
	</div>
</div>
<div class="grid_6 right">
	<div class="dashboard-filter-bar textRight">
		<span class="record-selected-statement"><span data-bind="text: selectedItems().length"></span> records are currently selected</span>
		<select data-bind="options: resultSetSizeOptions, optionsValue: 'id', optionsText: 'label', value: selectedResultSetSize"></select>
	</div>
</div>


<div class="grid_12">
	<div class="dashboard-action-paging-bar ui-widget-content">
	<!-- Used to having filter-bar -->
		<div class="action-controls">
			<c:if test="${param.includeBulkActions == true}">
				<div class="action-options">
					<input type="button" id="addNew" value="Add New">
					<input type="button" id="deleteSelected" value="Delete Selected">
			        <c:if test="${param.includeCopyAll == true}">
			             <input type="button" id="copyAll" value="Copy All XRefs">
			        </c:if>		
				</div>
			</c:if>
			<c:if test="${param.includeAdvancedFilter == true}" >
				<div class="filter-sort-buttons">
					<div class="filter-sort-option"><input type="checkbox" id="filterOption" /><label for="filterOption" class="filter-sort-option-label">Advanced Filter</label><span class="refine-option">Refine Filters</span></div>
				</div>
			</c:if>
		</div>
		<div class="paging-controls">
			<div class="prev-page" data-bind="css: {'active': paging.currentPage() != 1}, click: getPrevPage">
				<span class="ui-icon ui-icon-carat-1-w" data-bind="visible: paging.currentPage() != 1"></span><span data-bind="visible: paging.currentPage() == 1">&nbsp;</span>
			</div>
			<div class="current-page"><span>Page <span id="resultCurrentPage" data-bind="text: paging.currentPage, click: selectPage"></span> of <span id="resultTotalPages" data-bind="text: paging.totalPages"></span></span></div>
			<div class="next-page active" data-bind="css: {'active': paging.currentPage() != paging.totalPages()}, click: getNextPage">
				<span class="ui-icon ui-icon-carat-1-e" data-bind="visible: paging.currentPage() != paging.totalPages()"></span><span data-bind="visible: paging.currentPage() == paging.totalPages()">&nbsp;</span>
			</div>
		</div>
	</div>
</div>
<div class="clear"></div>

<c:if test="${param.hideSortBar != true}">
	<div class="grid_16">
		<div class="sort-bar">
			<span class="sort-label">Sort Order: </span>
			<!-- Loop through set of currently active sort options -->
			<ul data-bind="foreach: activeSortFieldSet">
				<li><span data-bind="text: label"></span><span data-bind="css: {'ui-icon-arrow-1-s' : currentSortDirection == 'ASC', 'ui-icon-arrow-1-n' : currentSortDirection == 'DSC'}" class="ui-icon"></span></li>
			</ul>
			<%-- This may be added eventually to support multi-column sorts
			<span class="edit-sort-link" data-bind="click: showAdvancedSortOptions">Advanced Sorting</span>
			--%>
		</div>
	</div>
	<div class="clear"></div>
</c:if>