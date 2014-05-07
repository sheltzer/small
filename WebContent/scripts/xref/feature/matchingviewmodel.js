$(document).ready(function() {
	
	var waitDialog = new PleaseWaitDialog();
	waitDialog.show();
	
	var requiredFieldLabels = $('label.required');
	$.each(requiredFieldLabels, function(index, labelElement) {
		var label = $(labelElement);
		var text = label.text();
		var requiredSpan = $('<span>').addClass('required-display');
		requiredSpan.text("*");
		label.html(text + '&nbsp;');
		label.append(requiredSpan);
	});
	
	var viewModel = new MatchingRequestViewModel();
	viewModel.loadDropDowns();
	
	ko.applyBindings(viewModel);
	waitDialog.hide();
});

/*
 * View model class containing the master set of drop down options, the data object 
 * being bound to the form inputs, and the functions to react the events in the form.
 */
function MatchingRequestViewModel() {
	var self = this;
	// This will inherit base functionality of the BaseViewModel object
	this.baseViewModel = new BaseViewModel();
	
	// Instantiate variables to include option lists
	self.businessUnitOptions = ko.observableArray([]);
	self.resellerOptions = ko.observableArray([]);
	self.additionalFieldOptions = ko.observableArray([]);
	self.xrefTypeOptions = ko.observableArray([]);
	self.matchTypeOptions = ko.observableArray([]);
	
	self.data = new MatchingRequest();
	
	self.isEditAllowed = function() {
		return true;
	};
	
	self.loadDropDowns = function() {
		 var waitDialog = new PleaseWaitDialog();

		var outputFormatValues = this.populateOutputFormatOptions();
		self.outputFormatOptions = ko.observableArray(outputFormatValues);
		self.data.outputFormat = ko.observable(outputFormatValues[0].id);
		
		self.resellerOptions = ko.observableArray(outputFormatValues);
		
		$.ajax({
			url : '/xref/xr/matching/loadDropDowns',
			type : 'POST',
			contentType : 'application/json',
			beforeSend : function (status) {
				waitDialog.show();
				self.baseViewModel.clear();
			},
			success : function(data) {
				self.populateDropDownValues(data);
			},
			error : function(xhr, status, error) {
				self.baseViewModel.globalErrorMessage('An unexpected error has occurred.');
			},
			complete : function(xhr, status) {
				waitDialog.hide();
			},
			async : false
		});
	};
	
	self.populateDropDownValues = function(data) {
		self.resellerOptions = ko.observableArray(data.resellerOptions);
		self.additionalFieldOptions = ko.observableArray(data.additionalFieldOptions);
		self.businessUnitOptions = ko.observableArray(data.businessUnitOptions);
		self.xrefTypeOptions = ko.observableArray(data.xrefTypeOptions);
		self.matchTypeOptions = ko.observableArray(data.matchTypeOptions);
	};
	
	self.populateOutputFormatOptions = function() {
		var outputFormatValues = [];
		
		outputFormatValues[0] = new CodeSetOption('xlsx', 'Excel 2007 (xlsx)');
		outputFormatValues[1] = new CodeSetOption('xls', 'Excel 97 (xls)');
		outputFormatValues[2] = new CodeSetOption('csv', 'CSV');
		
		return outputFormatValues;
	};
	
	self.reset = function() {
		self.loadDropDowns();
		self.data.selectedAdditionalFields([]);
		self.data.additionalFields([]);
		self.data.reseller([]);
		self.data.xrefType([]);
		self.data.matchType([]);
		
		$('#businessUnit').val("");
		$('#inputFile').val("");	
		$('#outputFormat').val("");	
		$('#outputFilename').val("");	
		$('#activeOnly').removeAttr('checked');
	};
	
	self.addAdditionalField = function() {
		ko.utils.arrayForEach(self.data.additionalFields(), function(field) {
			self.data.selectedAdditionalFields.push({'label' : field, 'id' : field});
			
			// remove from selectable list
			ko.utils.arrayForEach(self.additionalFieldOptions(), function(fieldOption) {
				if (fieldOption && fieldOption.label.trim() == field.trim()) {
					self.additionalFieldOptions.remove(fieldOption);
				}
			});
	    });
		
		self.data.additionalFields([]);
	};
	
	this.removeAdditionalField = function(field) {
		self.data.selectedAdditionalFields.remove(field);
		self.additionalFieldOptions.push(field);
	};
	
	self.save = function() {
				
		var waitDialog = new PleaseWaitDialog();

		$('#matchingForm').ajaxSubmit({
			url : '/xref/xr/matching/generateReport',
			type : 'POST',
			contentType: false,
			processData: false,
			beforeSend : function (status) {
				waitDialog.show();
				self.baseViewModel.clear();
			},
			success : function(data) {
				
				self.handleSuccessfulSaveSubmit(data, false);
			},
			error : function(xhr, status, error) {
				self.baseViewModel.globalErrorMessage('An unexpected error has occurred.');
			},
			complete : function(xhr, status) {
				waitDialog.hide();
			},
			async : false
		});
	};
	
	self.handleSuccessfulSaveSubmit = function(data, submitData) {
		
		var self = this;
		if (data.processingSuccessMessage) {
			
			this.baseViewModel.globalNotificationMessage(data.processingSuccessMessage);
		}
		else if (data.errorMessage) {
			this.baseViewModel.globalErrorMessage(data.errorMessage);
		}
		
		if (data.fieldErrors) {
			$.each(data.fieldErrors, function(index, value) {
				self.baseViewModel.validationErrors[index] = value;
			});
			this.baseViewModel.buildErrors();
		}
	};
	
	self.showGlobalNotificationMessage = ko.computed(function() {
		return (this.baseViewModel.globalNotificationMessage() != null && this.baseViewModel.globalNotificationMessage() != '');
	}, this);
	
	self.showGlobalErrorMessage = ko.computed(function() {
		return (this.baseViewModel.globalErrorMessage() != null && this.baseViewModel.globalErrorMessage() != '');
	}, this);
};
//MatchTypeViewModel.prototype = BaseViewModel.prototype;

/*
 * Observable object bound to the fields of the form.
 */
function MatchingRequest() {
	this.inputFile = ko.observable();
	this.businessUnit = ko.observable();
	this.activeOnlyChecked = ko.observable();
	this.reseller = ko.observable([]);
	this.xrefType = ko.observableArray([]);
	this.matchType = ko.observableArray([]);
	this.additionalFields = ko.observableArray([]);
	this.outputFormat = ko.observable();
	this.outputFileName = ko.observable();
	this.selectedAdditionalFields = ko.observableArray();
}

/**
 * Represents the data to be sent back to the server so the report can be generated.
 */
function MatchingCriteria() {
	this.inputFile;
	this.businessUnit;
	this.activeOnly;
	this.resellers;
	this.xrefTypes;
	this.matchTypes;
	this.additionalFields;
	this.outputFilename;
	this.outputFormat;
}