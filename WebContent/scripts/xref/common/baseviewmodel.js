var BaseViewModel = function() {
	
	var self = this;
	
	this.globalNotificationMessage = ko.observable();
	this.globalErrorMessage = ko.observable();
	this.containsFieldErrors = ko.observable(false);
	this.validationErrors = [];
	
	self.isDirty = ko.observable(false);
	
	self.monitorForChanges = function(object){
		$(window).on('beforeunload', function() {
		    if(self.isDirty()){
		    	return "You have pending changes that will be lost if you continue.";
		    };
		});
		
		for (var child in object) {
	        if (ko.isObservable(object[child])){
	        	object[child].subscribe(function(newValue) {
	        		self.isDirty(true);
	        	});
	        }
	    }
	};
	

	
	this.showGlobalNotificationMessage = ko.computed(function() {
		return (this.globalNotificationMessage() != null && this.globalNotificationMessage() != ''); 
	}, this);
	
	this.showGlobalErrorMessage = ko.computed(function() {
		return (this.globalErrorMessage() != null && this.globalErrorMessage() != '');
	}, this);
	
	this.setGlobalErrorMessageFromStatus = function(xhr, status, error) {
		
		if (xhr.status == 401) {
			self.globalErrorMessage('Access has not been granted to perform this request.');
		} else if (xhr.status == 403) {
			//self.globalErrorMessage('Access has not been granted to perform this request.');
			var href = window.location.href;
			window.location.replace(href);
		} else {
			self.globalErrorMessage('An error has occurred during your request');
		}
	};
	
	this.buildErrors = function() {
		var self = this;
		$('.form-container ul li, .upload-form-container ul li').each(function(index, value) {
			//alert(value + ", " + index);
			var nodeRef = $(this);
			var id = nodeRef.find('.input-container input, .input-container select, .input-container div').attr('id');
			if (id) {
				self.applyErrorMessage(nodeRef, id);
			}
			else {
				id = nodeRef.find('.input-container select').attr('id');
				if (id) {
					self.applyErrorMessage(nodeRef, id);
				}
			}
		});
	};
	
	this.clear = function() {
		this.globalNotificationMessage('');
		this.globalErrorMessage('');
		this.containsFieldErrors(false);
		this.validationErrors = [];
		
		$('.info-box.error span').text('').parent().hide();
		$('.itemNumber-status-bulkSuccess').removeClass('itemNumber-status-bulkSuccess');
		$('.itemNumber-status-bulkNotSuccess').removeClass('itemNumber-status-bulkNotSuccess');
	};
	
	// Deprecated, use setFieldErrors
	this.applyErrorMessage = function(nodeRef, id) {
		
		var fieldErrorMessage = this.validationErrors[id];
		if (fieldErrorMessage ) {
			var fieldInfo = nodeRef.find('.info-box.error');
			//$('<div>').addClass('error-pointer').appendTo(fieldInfo);
			fieldInfo.find('span').text(fieldErrorMessage);
			fieldInfo.show();
			//$('<div>').attr('id', id + 'Error').addClass('ui-state-error').addClass('error-cell').addClass('ui-corner-right').addClass('ui-corner-bl').text(fieldErrorMessage).appendTo(fieldInfo);
		} else if (id == 'notificationEntry') {
			// This else is a one off change for the New Item Add / Stock And Sell Request.  This should be made more generic, but a quick solution
			// was needed when reformatting the UI.
			fieldErrorMessage = this.validationErrors['notificationContacts'];
			
			if (fieldErrorMessage) {
				var fieldInfo = nodeRef.find('.info-box.error');
				//$('<div>').addClass('error-pointer').appendTo(fieldInfo);
				fieldInfo.find('span').text(fieldErrorMessage);
				fieldInfo.show();
			}
		}
		this.containsFieldErrors(true);
	};
	
	this.setFieldErrors = function(fieldErrors){
		if(fieldErrors != null){
			$.each(fieldErrors, function(key, value){
				var errorSpan = $('span[id="' + key + 'Error"]');
				$(errorSpan).text(value);
				$(errorSpan).parents('div.error').show();
			});
		}
	};
	
	this.clearFieldErrors = function(fieldErrors){
		if(fieldErrors != null){
			$.each(fieldErrors, function(key, value){
				var errorSpan = $('span[id="' + key + 'Error"]');
				$(errorSpan).text('');
				$(errorSpan).parents('div.error').hide();
			});
		}
	};
};

/**
 * Base view model class for use by dashboards.  Dashboards all have the similar features:
 * 1. Primary Filters
 * 2. Count of selected records in the page
 * 3. Results per page
 * 4. Bulk Actions (optional)
 * 5. Advanced Filters (optional)
 * 6. Paging
 * 7. Display of table data
 * 
 * Many of these functions are generalized, with specific features for loading options and data
 * delegated down to a delegate layer.  Data is initialized from a factory which is passed into 
 * the constructor.
 */
var BaseDashboardViewModel = function(dashboardDetailsFactory, tableId) {
	
	var self = this;
	
	self.tableId = tableId;
	
	self.headerData;
	
	self.dashboardDetailsEventDelegate = dashboardDetailsFactory.getEventDelegate();
	self.dashboardDetailsEventDelegate.viewModel = self;
	
	// To Be Implemented fully later on! / Not Currently used
	self.advancedFilterEnabled =ko.observable(false);
	
	self.actions = ko.observableArray(dashboardDetailsFactory.getBulkActions());
	self.selectedBulkAction = ko.observable();
	
	var resultSetSizeValues = dashboardDetailsFactory.getResultSetSizeOptionValues();
	self.resultSetSizeOptions = ko.observableArray(resultSetSizeValues);
	self.selectedResultSetSize = ko.observable(resultSetSizeValues[0].id);
	self.selectedResultSetSize.subscribe(function() {
		self.loadDashboardPageData(1, self.primaryFilterName(), true);
	});
	
	self.tableData = ko.observableArray();
	self.selectedItems = ko.observableArray();
	
	self.paging = {
		'currentPage' : ko.observable(1),
		'totalPages' : ko.observable(1)	
	};
	
	// TODO Need to figure out how this will exactly work !!!!! MH: Done
	self.advancedFilterSelections = dashboardDetailsFactory.getAdvancedFilterSelections();
	
	self.primaryFilters = dashboardDetailsFactory.getPrimaryFilters();
	self.primaryFilterName = ko.observable(self.primaryFilters[0].id);
	self.lastPrimaryFilter = self.primaryFilters[self.primaryFilters.length - 1];
	self.sortableColumns = dashboardDetailsFactory.getMasterSortOptions();
	
	self.activeSortFieldSet = dashboardDetailsFactory.getDefaultSort();
	
	// TODO - Need to tie this into a set of advanced filters, and hide if there are none MH: Done
	
	// Assign the delegates functions for these initial events to these functions
	self.loadFilters = self.dashboardDetailsEventDelegate.loadFilters;
	self.loadDashboardPageData = self.dashboardDetailsEventDelegate.loadDashboardData;
	
	self.initialize = function() {
		$('#filterOption').button();
		var lastRequest = self.loadFilters();
		//MH:
		self.initializeAdvancedFilterDialog(lastRequest);
		//Default Primary Filter to all
		var primaryFilterValue = 'all'; 
		if(lastRequest != null) {
			//If there is a filter already attached to the session, use it
			primaryFilterValue = lastRequest.primaryFilterName;
		}
		// TODO - We need to load the second parameter from the currently set primary filter name - MH: Done
		self.loadDashboardPageData(1, primaryFilterValue, true, false);
	};
	
	self.applyBulkAction = function() {
		self.selectedBulkAction().action();
	};
	
	self.getPrevPage = function() {
		
		var currentPage = self.paging.currentPage();
		
		if (currentPage > 1) {
	
			--currentPage;
			//this.paging.currentPage(currentPage);
			self.loadDashboardPageData(currentPage, self.primaryFilterName(), true, true);
		}
	};
	
	self.getNextPage = function() {
		
		var currentPage = self.paging.currentPage();
		
		if (currentPage < self.paging.totalPages()) {
			
			++currentPage;
			//this.paging.currentPage(currentPage);
			self.loadDashboardPageData(currentPage, self.primaryFilterName(), true, true);
		}
	};
	
	self.selectPage = function() {

		var currentPage = $('#resultCurrentPage');
		self.selectPageCommon(currentPage, false);
	};
	
	self.selectPageBottom = function() {
		var currentPage = $('#resultsCurrentPageBottom');
		self.selectPageCommon(currentPage, true);
	};
	
	self.selectPageCommon = function(currentPage, bottomBox) {
		
		var pageNumberInput = $('<input>').attr('id', 'pageNumberInput').css('width', '30px');
		pageNumberInput.attr('type', 'text');
		var currentPageValue = currentPage;
		currentPageValue.after(pageNumberInput);
		currentPageValue.hide();
		
		
		pageNumberInput.keypress(function(e) {
			
			var keyIsOkay = (e.which == 0 || e.which == 13 || e.which == 8);
			var keyIsNumeric = (e.which >= 48 && e.which <= 57);
			
			if (keyIsOkay == false && keyIsNumeric == false) {
				// In this case, ignore the character typed in
				return false;
			}

			if (e.which == 13) {
				var pageInputValue = $('#pageNumberInput').val();
				// TODO Add NaN check
				self.loadDashboardPageData(pageInputValue, self.primaryFilterName(), true, true);
				self.paging.currentPage(pageInputValue);
				currentPageValue.show();
				pageNumberInput.remove();
				if (bottomBox) {
					// We should scroll, but need to figure out how to do this
				}
				
			}
		});
		
		pageNumberInput.focus().val(currentPageValue.text());
	};
	
	// TODO - Do we need this as a function, or should we simply inline the code?
	self.initializeColumnSortHeaders = function() {
		
		$('.dashboard-header div.sortable').click(function() {
			var columnText = $(this).text();
			self.applySingleColumnSort(columnText);
		});
	};
	self.initializeColumnSortHeaders();
	
	self.applySingleColumnSort = function(columnLabel) {
		
		var columnsSelectedBeforeQuery = [];
		var selectedSortColumn = self.sortableColumns[columnLabel];
		
		for (var i=0; i < self.activeSortFieldSet().length; ++i) {
			var sortedColumn = self.activeSortFieldSet()[i];
			columnsSelectedBeforeQuery.push(sortedColumn);
			if (sortedColumn != selectedSortColumn) {
				// Set the direction of any sorted column to '' so we can remove
				// it from the active sort field list
				sortedColumn.currentSortDirection = '';
			}
		}
		
		//alert('Sorting ' + selectedSortColumn.label);
		var originalDirectionOfSelectedColumn = selectedSortColumn.currentSortDirection;
		if (originalDirectionOfSelectedColumn == null || originalDirectionOfSelectedColumn == '' || originalDirectionOfSelectedColumn == 'DSC') {
			selectedSortColumn.currentSortDirection = 'ASC';
		}
		else {
			selectedSortColumn.currentSortDirection = 'DSC';
		}
		
		self.activeSortFieldSet.removeAll();
		self.activeSortFieldSet.push(selectedSortColumn);
		
		// Make ajax call, if error then rollback to original sort state
		// TODO use the function built into this class, not the delegate directly
		self.dashboardDetailsEventDelegate.loadDashboardData(1, self.primaryFilterName(), true, false);
	};
	
	self.initializeRowCheckboxes = function() {
		var self = this;
		
		var rowSelectBoxes = $('.select-col.row-select :checkbox');
		var selectAllBox = $('.select-col.select-all :checkbox');
		
		selectAllBox.prop('checked', false);
		
		// TODO - Change the unbind/bind to the newer JQuery approach
		rowSelectBoxes.unbind('click').click(function(event) {
			var checkbox = $(event.target);
			var checked = checkbox.prop('checked');
			var row = checkbox.parents('.dashboard-data-row');
			self.dashboardDetailsEventDelegate.selectRow(checked, row);
		});
		
		selectAllBox.unbind('click').click(function(event) {
			var checkbox = $(event.target);
			var checked = checkbox.prop('checked');
			
			if (checked) {
				// Find all unchecked row boxes
				$.each(rowSelectBoxes, function(index, rowSelectBox) {
					var wrappedRowSelectBox = $(rowSelectBox);
					if (wrappedRowSelectBox.prop('checked') == false) {
						wrappedRowSelectBox.prop('checked', true);
						var row = wrappedRowSelectBox.parents('.dashboard-data-row');
						self.dashboardDetailsEventDelegate.selectRow(true, row);
					}
				});
			}
			else {
				// Find all checked row boxes
				$.each(rowSelectBoxes, function(index, rowSelectBox) {
					var wrappedRowSelectBox = $(rowSelectBox);
					if (wrappedRowSelectBox.prop('checked') == true) {
						wrappedRowSelectBox.prop('checked', false);
						var row = wrappedRowSelectBox.parents('.dashboard-data-row');
						self.dashboardDetailsEventDelegate.selectRow(false, row);
					}
				});
			}
		});
	};
	
	self.deselectAllSelectedCheckboxes = function() {
		
		var rowSelectBoxes = $('.select-col.row-select :checkbox');
		var selectAllBox = $('.select-col.select-all :checkbox');
		
		if (selectAllBox.prop('checked')) {
			selectAllBox.prop('checked', false);
		}
		
		$.each(rowSelectBoxes, function(index, rowSelectBox) {
			var wrappedRowSelectBox = $(rowSelectBox);
			if (wrappedRowSelectBox.prop('checked') == true) {
				wrappedRowSelectBox.prop('checked', false);
				var row = wrappedRowSelectBox.parents('.dashboard-data-row');
				self.dashboardDetailsEventDelegate.selectRow(false, row);
			}
		});
	};
	
	self.updatePrimaryFilterCounts = function(primaryFilterCountMap) {
		
		$.each(self.primaryFilters, function(index, filter) {
			if (typeof primaryFilterCountMap[filter.id] != 'undefined') {
				filter.count(primaryFilterCountMap[filter.id]);
			}
		});
	};
	
//MH:
	self.initializeAdvancedFilterDialog = function(lastRequest) {
		
		$('.advanced-filter-form').dialog({
			'autoOpen' : false,
			'show' : 'fold',
			'hide' : 'fold',
			'closeOnEscape' : false,
			'buttons' : [
			    {
			    	'id' : 'applyFilterChangesButton',
			    	'text' : 'Apply Filter Changes',
					'click' : function() {
						self.applyFilterUpdates();
						$(this).dialog('close');
					}
			    },
			    {
			    	'text' : 'Cancel',
			    	'click' : function() {
			    		self.revertAppliedFilterUpdates();
			    		$(this).dialog('close');
			    	}
			    }
			]
		});
		
		var filterOptionButton = $('#filterOption').button();
		
		filterOptionButton.click(function() {
			//$('.advanced-filter-form').toggle('fold');
			//viewModel.initializeAdvancedFilterOptions(true);
			var advancedFilterDialog = $('.advanced-filter-form');
			
			if (self.advancedFilterEnabled()) {
				
				if (advancedFilterDialog.dialog('isOpen')) {
					self.revertAppliedFilterUpdates();
					advancedFilterDialog.dialog('close');
				}
				
				// The advancedFilterEnabled must be set to false before calling 
				// the load function to ensure the advanced filters are turned off.
				self.advancedFilterEnabled(false);
				self.loadDashboardPageData(1, self.primaryFilterName(), true, true);
			}
			else {
				
				var filterArea = $('.advanced-filter-form .filter-area');
				var checkboxes = filterArea.find(':checkbox');
				
				checkboxes.attr('checked', 'true');
				checkboxes.addClass('filter-value-active').removeClass('filter-value-inactive');
				checkboxes.parent().next().addClass('filter-value-active').removeClass('filter-value-inactive');
				checkboxes.data('currentFilterActive', true);
				$('#applyFilterChangesButton').button("option", "disabled", true);
				
				advancedFilterDialog.dialog('open');
				
				self.advancedFilterEnabled(true);
			}
			
			$('.filter-sort-option span.refine-option').toggle();
			
		});
		
		$('.filter-sort-option span.refine-option').click(function() {
			
			var advancedFilterDialog = $('.advanced-filter-form');
			if (!advancedFilterDialog.dialog('isOpen')) {
				advancedFilterDialog.dialog('open');
			}
		});
		
		// This step must be done after the filter options are loaded, but before we determine any
		// previous selections
		self.initializeApplyFilterStateMonitoring();
		
		if (lastRequest) {
			self.primaryFilterName(lastRequest.primaryFilterName);
			
			if (lastRequest.advancedFiltersEnabled) {
				
				var advancedFilterButton = $('#filterOption');
				advancedFilterButton.prop('checked', true);
				advancedFilterButton.button('refresh');
				
				self.advancedFilterEnabled(true);
				$('.filter-sort-option span.refine-option').toggle();
				
				//
				if (self.dashboardDetailsEventDelegate.reloadFilterOptionSelections) {
					self.dashboardDetailsEventDelegate.reloadFilterOptionSelections(lastRequest);
				}
			}
			
			var itemsPerPage = lastRequest.numberOfResultsToFetch;
			
			$.each(self.resultSetSizeOptions(), function(index, value) {
				if ((itemsPerPage == 0 && value.id == 'All') || (value.id == new String(itemsPerPage))) {
					self.selectedResultSetSize(value.id);
				}
			});
		}		
	};
	
	//MH: Added this base functionality 
	self.baseReloadFilterOptionSelections = function(optionValues, filterId) {
		if (optionValues.length > 0) {
			var filter = $(filterId);
			var checkboxes = filter.find(':checkbox');
			checkboxes.prop('checked', false);
			checkboxes.data('currentFilterActive', false);
			checkboxes.addClass('filter-value-inactive').removeClass('filter-value-active');
			checkboxes.parent().next().addClass('filter-value-inactive').removeClass('filter-value-active');
			
			$.each(optionValues, function(index, optionValue) {
				var filteredCheckbox = checkboxes.filter('[value="' + optionValue + '"]');
				filteredCheckbox.prop('checked', true);
				filteredCheckbox.data('currentFilterActive', true);
				filteredCheckbox.toggleClass('filter-value-inactive').toggleClass('filter-value-active');
				filteredCheckbox.parent().next().toggleClass('filter-value-inactive').toggleClass('filter-value-active');
			});
			
			self.advancedFilterSelections.updated = true;
		}
	};	
	
	/**
	 * Apply the filter changes and then manage the state of the checkboxes, the apply changes button, and the filter labels.
	 */
	self.applyFilterUpdates = function() {
		
		var applyFilterHanlder = function() {
			var filterArea = $('.advanced-filter-form .filter-area');
			var deactivationPendingElements = filterArea.find(':checkbox.filter-value-deactivation-pending');
			var activationPendingelements = filterArea.find(':checkbox.filter-value-activation-pending');
			
			// First change the classes associated with the checkbox
			deactivationPendingElements.toggleClass('filter-value-deactivation-pending').toggleClass('filter-value-inactive').data('currentFilterActive', false);
			// Then change the classes of the sibling span element, in relation to the span containing the checkbox
			deactivationPendingElements.parent().next().toggleClass('filter-value-deactivation-pending').toggleClass('filter-value-inactive');
			
			// First change the classes associated with the checkbox
			activationPendingelements.toggleClass('filter-value-activation-pending').toggleClass('filter-value-active').data('currentFilterActive', true);
			// Then change the classes of the sibling span element, in relation to the span containing the checkbox
			activationPendingelements.parent().next().toggleClass('filter-value-activation-pending').toggleClass('filter-value-active');
			$('#applyFilterChangesButton').button("option", "disabled", true);
		};
		
		self.advancedFilterSelections.updated = true;
		self.loadDashboardPageData(1, self.primaryFilterName(), true, true, applyFilterHanlder, null);
	};
	
	self.revertAppliedFilterUpdates = function() {
		
		var filterArea = $('.advanced-filter-form .filter-area');
		var deactivationPendingElements = filterArea.find(':checkbox.filter-value-deactivation-pending');
		var activationPendingelements = filterArea.find(':checkbox.filter-value-activation-pending');
		
		deactivationPendingElements.toggleClass('filter-value-deactivation-pending').toggleClass('filter-value-active').data('currentFilterActive', true).attr('checked', true);
		// Then change the classes of the sibling span element, in relation to the span containing the checkbox
		deactivationPendingElements.parent().next().toggleClass('filter-value-deactivation-pending').toggleClass('filter-value-active');
		
		// First change the classes associated with the checkbox
		activationPendingelements.toggleClass('filter-value-activation-pending').toggleClass('filter-value-inactive').data('currentFilterActive', false).attr('checked', false);
		// Then change the classes of the sibling span element, in relation to the span containing the checkbox
		activationPendingelements.parent().next().toggleClass('filter-value-activation-pending').toggleClass('filter-value-inactive');
		
		$('#applyFilterChangesButton').button("option", "disabled", true);
	};
	
	self.handleFilterClicked = function(element) {
		
		var checkbox = $(element);
		var currentFilterActive = checkbox.data('currentFilterActive');
		
		if (currentFilterActive) {
			// First change the classes associated with the checkbox
			checkbox.toggleClass('filter-value-active').toggleClass('filter-value-deactivation-pending');
			// Then change the classes of the sibling span element, in relation to the span containing the checkbox
			checkbox.parent().next().toggleClass('filter-value-active').toggleClass('filter-value-deactivation-pending');
		}
		else {
			// First change the classes associated with the checkbox
			checkbox.toggleClass('filter-value-inactive').toggleClass('filter-value-activation-pending');
			// Then change the classes of the sibling span element, in relation to the span containing the checkbox
			checkbox.parent().next().toggleClass('filter-value-inactive').toggleClass('filter-value-activation-pending');
		}

		this.manageApplyFilterChangesButtonState();
	};
	
	self.handleSelectAllClicked = function(element) {
		
		// Find the unselected checkboxes for this filter; we need to get the parent div to the
		var inactiveCheckboxes = $(element).parents('.filter').find(':checkbox.filter-value-inactive');
		inactiveCheckboxes.toggleClass('filter-value-inactive').toggleClass('filter-value-activation-pending').attr('checked', true);
		inactiveCheckboxes.parent().next().toggleClass('filter-value-inactive').toggleClass('filter-value-activation-pending');
		
		// Then find any pending deactivations, and reselect them
		var pendingDeactivations = $(element).parents('.filter').find(':checkbox.filter-value-deactivation-pending');
		pendingDeactivations.toggleClass('filter-value-deactivation-pending').toggleClass('filter-value-active').attr('checked', true);
		pendingDeactivations.parent().next().toggleClass('filter-value-deactivation-pending').toggleClass('filter-value-active');
		
		this.manageApplyFilterChangesButtonState();
	};
	
	self.handleClearAllClicked = function(element) {
		
		var activeCheckboxes = $(element).parents('.filter').find(':checkbox.filter-value-active');
		activeCheckboxes.toggleClass('filter-value-active').toggleClass('filter-value-deactivation-pending').attr('checked', false);
		activeCheckboxes.parent().next().toggleClass('filter-value-active').toggleClass('filter-value-deactivation-pending');
		
		// Then find any pending deactivations, and reselect them
		var pendingActivations = $(element).parents('.filter').find(':checkbox.filter-value-activation-pending');
		pendingActivations.toggleClass('filter-value-activation-pending').toggleClass('filter-value-inactive').attr('checked', false);
		pendingActivations.parent().next().toggleClass('filter-value-activation-pending').toggleClass('filter-value-inactive');
		
		this.manageApplyFilterChangesButtonState();
	};
	
	self.manageApplyFilterChangesButtonState = function() {
		
		var filterArea = $('.advanced-filter-form .filter-area');
		var pendingFilters = filterArea.find(':checkbox.filter-value-deactivation-pending,:checkbox.filter-value-activation-pending');
		if (pendingFilters.size() > 0) {
			$('#applyFilterChangesButton').button("option", "disabled", false);
		}
		else {
			$('#applyFilterChangesButton').button("option", "disabled", true);
		}
	};
	
	/**
	 * This function initializes the state management of the filter checkboxes in relation to the apply button.  The button should only
	 * be active if there are pending filter changes.  Pending filter changes display in italics.  The screen needs to be smart enough 
	 * to disable the button again if any pending selections have been changed to the point there are no longer any pending changes.
	 */
	self.initializeAdvancedFilterOptions = function(initializeEventHandlersOnly) {
		var self = this;
		
		var filterArea = $('.advanced-filter-form .filter-area');
		var checkboxes = filterArea.find(':checkbox');
		
		if (!initializeEventHandlersOnly) {
	
			checkboxes.attr('checked', 'true');
			checkboxes.addClass('filter-value-active');
			checkboxes.parent().next().addClass('filter-value-active');
			checkboxes.data('currentFilterActive', true);
			$('#applyFilterChangesButton').button("option", "disabled", true);
		}
		
		checkboxes.unbind('click');
		checkboxes.click(function() {
			self.handleFilterClicked(this);
		});
		
		var selectAllLinks = filterArea.find('.filter-select-all');
		selectAllLinks.unbind('click');
		selectAllLinks.click(function() {
			self.handleSelectAllClicked(this);
		});
		
		var clearAllLinks = filterArea.find('.filter-clear-all');
		clearAllLinks.unbind('click');
		clearAllLinks.click(function() {
			self.handleClearAllClicked(this);
		});
	};
	
	self.initializeApplyFilterStateMonitoring = function() {
		self.initializeAdvancedFilterOptions(false);
	};
	
	//MH: added this.
	self.buildFilterValues = function(filterId) {
		var filterArray = [];
		var filter = $(filterId);
		var totalOptionCount = filter.find(':checkbox').size();
		var selectedOptions = filter.find(':checkbox').filter('[checked=checked]');
		var selectedOptionCount = selectedOptions.size();
		
		// As long as at least one option is selected and all are not selected, we have to apply the filter
		if (selectedOptionCount > 0 && selectedOptionCount < totalOptionCount) {

			$.each(selectedOptions, function(index, option) {
				filterArray.push($(option).val());
			});
		}
		return filterArray;
	};	
//End MH
	self.handleTableScroll = function(scrollEvent) {
		handleDashboardTableScroll(scrollEvent);
	};
	
	
};

function handleDashboardTableScroll(scrollEvent){
	var tableHeader = $('.dashboard-header');
	var firstRow = $('.dashboard-row:first');
	var topActualVal = tableHeader[0].getBoundingClientRect().top;
	var firstRowTopActualVal = firstRow[0].getBoundingClientRect().top;
	
	// !!IMPORTANT - to avoid a jittery screen, we need to add/remove both classes
	if (topActualVal < 0 && !tableHeader.hasClass('sticky-header')) {
		firstRow.addClass('sticky-header-adjusted');
		tableHeader.addClass('sticky-header');
	}
	else if (tableHeader.hasClass('sticky-header') && firstRowTopActualVal > topActualVal) {
		tableHeader.removeClass('sticky-header');
		firstRow.removeClass('sticky-header-adjusted');
	}


	// Scroll sticky header to match the horizontal scrolling of the table
	 $(".sticky-header").offset({
        left: (0 - $('.dashboard-header').scrollLeft()) + $('.dashboard-table').offset().left
     });
}

BaseDashboardViewModel.setupDashboardRowActionButtons = function(){
	$('.single-action-button').each(function(){
		$(this).button();
	});
	
	$('.multi-action-button-menu').each(function(){
		$(this).menu();
	});

	$('.multi-action-button').each(function(){
		$(this).button()
	        .click(function() {
	        	// Hide any open menus
	        	$('.multi-action-button-menu').hide();
	        	var menu = $(this).next();
	        	$(menu).show().position({
		            my: "left top",
		            at: "left bottom",
		            of: this
		          });
	        	return false;
	        	});	
	});
};

BaseDashboardViewModel.prototype = new BaseViewModel();