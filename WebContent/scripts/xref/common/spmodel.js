/*
 * This module contains the common set of Java Script model objects used throughout the 
 * site.  Any domain object that is applicable across multiple pages/features should be
 * placed in ths file.
 */
function CodeSetOption(id, label) {
	this.id = id;
	this.label = label;
}

function SortableColumn(id, label) {
	
	this.id = id;
	this.label = label;
	this.currentSortDirection = '';
	
	this.isActive = function() {
		return (this.currentSortDirection == 'ASC' || this.currentSortDirection == 'DSC');
	};
	
	this.isAscending = function() {
		return (this.currentSortDirection == 'ASC');
	};
	
	this.isDescending = function() {
		return (this.currentSortDirection == 'DSC');
	};
}

function BulkAction(id, label, action) {
	
	this.id = id;
	this.label = label;
	this.action = action;
}

function DashboardPrimaryFilter(id, label, clickHandler) {
	
	this.id = id;
	this.label = label;
	this.clickHandler = clickHandler;
	this.count = ko.observable(0);
}