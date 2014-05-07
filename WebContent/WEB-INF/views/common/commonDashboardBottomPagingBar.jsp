<div class="grid_12">
	<div class="dashboard-action-paging-bar ui-widget-content">
		<div class="paging-controls">
			<div class="prev-page" data-bind="css: {'active': paging.currentPage() != 1}, click: getPrevPage">
				<span class="ui-icon ui-icon-carat-1-w" data-bind="visible: paging.currentPage() != 1"></span><span data-bind="visible: paging.currentPage() == 1">&nbsp;</span>
			</div>
			<div class="current-page"><span>Page <span id="resultsCurrentPageBottom" data-bind="text: paging.currentPage, click: selectPageBottom"></span> of <span data-bind="text: paging.totalPages"></span></span></div>
			<div class="next-page active" data-bind="css: {'active': paging.currentPage() != paging.totalPages()}, click: getNextPage">
				<span class="ui-icon ui-icon-carat-1-e" data-bind="visible: paging.currentPage() != paging.totalPages()"></span><span data-bind="visible: paging.currentPage() == paging.totalPages()">&nbsp;</span>
			</div>
		</div>
	</div>
</div>
<div class="clear"></div>