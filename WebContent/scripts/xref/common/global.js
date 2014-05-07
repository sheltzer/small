$(document).ready(function() {
	// Initialize custom binding handlers
	ko.bindingHandlers.uiButtonDisable = {
		init : function(element, valueAccessor, allBindingsAccessor, viewModel) {
			var value = ko.utils.unwrapObservable(valueAccessor());
			if (value) {
				$(element).button("option", "disabled", true);
			}
			else {
				$(element).button("option", "disabled", false);
			}
		},
		update : function(element, valueAccessor, allBindingsAccessor, viewModel) {
			var value = ko.utils.unwrapObservable(valueAccessor());
			if (value) {
				$(element).button("option", "disabled", true);
			}
			else {
				$(element).button("option", "disabled", false);
			}
		}
	};
	
	ko.bindingHandlers.uiButtonEnabled = {
			init : function(element, valueAccessor, allBindingsAccessor, viewModel) {
				var value = ko.utils.unwrapObservable(valueAccessor());
				if (value) {
					$(element).attr("disabled", false);
					$(element).removeClass('ui-state-disabled');
				}
				else {
					$(element).attr("disabled", true);
					$(element).addClass('ui-state-disabled');	
				}
			},
			update : function(element, valueAccessor, allBindingsAccessor, viewModel) {
				var value = ko.utils.unwrapObservable(valueAccessor());
				if (value) {
					$(element).attr("disabled", false);
					$(element).removeClass('ui-state-disabled');
				}
				else {
					$(element).attr("disabled", true);
					$(element).addClass('ui-state-disabled');	
				}
			}
		};
	
	//Binds an event that calls a function when the enter key is pressed
	ko.bindingHandlers.executeOnEnter = {
		    init : function (element, valueAccessor, allBindingsAccessor, viewModel) {
		        var allBindings = allBindingsAccessor();
		        $(element).keypress(function (event) {
		            var keyCode = (event.which ? event.which : event.keyCode);
		            if (keyCode == 13) {
		                allBindings.executeOnEnter.call(viewModel);
		            }
		        });
		    }
		};
	// End initialize
	
	var viewModel = new HeaderActionHandlers();
	
	//IE 8 doesn't support String.trim()
	//So we make sure those calls won't break
	if(typeof String.prototype.trim !== 'function') {
		String.prototype.trim = function() {
			return this.replace(/^\s+|\s+$/g, ''); 
		};
	}
	
	$('#nav ul li').mouseover(function() {
		// Determine if there is a sub-menu to overlay
		
		var idValue = $(this).attr('id');
		var secondLevelMenu = $('#' + idValue + 'SecondLevel');
		
		var originalSecondLevelMenu = $('.second-level-menu-group.original-sl-menu-group');
		
		if (secondLevelMenu.size() > 0 && (idValue + 'SecondLevel') != originalSecondLevelMenu.attr('id')) {
			$('.second-level-menu-group').addClass('hidden').removeClass('visible').unbind('mouseout').hide();
			secondLevelMenu.removeClass('hidden').addClass('visible').show();
		}
	});
	
	$('#nav ul li').mouseleave(function(event) {
		
		var menuItem = $(this);
		var currentSecondLevelMenu = $('.second-level-menu-group.visible');
		
		var menuItemPosition = currentSecondLevelMenu.position();
		var menuItemRight = menuItemPosition.left + currentSecondLevelMenu.outerWidth();
		var menuItemBottom = menuItemPosition.top + currentSecondLevelMenu.outerHeight();
		
		
		var isCurrentSecondLevelMenuEmpty = (currentSecondLevelMenu.attr('id') == 'emptySecondLevel');
		
		if (event.clientY >= menuItemBottom && event.clientX >= menuItemPosition.left && event.clientX <= menuItemRight
				&& !isCurrentSecondLevelMenuEmpty) {
			//alert('keeping sub-menu open'); //keeping the sub-menu open for the last hover
			// need to handle the mouse out if the menu isn't the current selected sub-menu
			var originalSecondLevelMenu = $('.second-level-menu-group.original-sl-menu-group');
			
			if (originalSecondLevelMenu.attr('id') != currentSecondLevelMenu.attr('id')) {
				//currentSecondLevelMenu.mouseleave(function(event2) {
				$(this).addClass('hovered');
				$('#menuSecondLevel').mouseleave(function(event2) {
					
					menuItem.removeClass('hovered');
					/*
					currentSecondLevelMenu.removeClass('visible').addClass('hidden').hide();
					originalSecondLevelMenu.removeClass('hidden').addClass('visible').show();
					$(this).unbind('mouseleave');
					*/
					
					currentSecondLevelMenu.removeClass('visible').addClass('hidden').fadeOut('fast', function() {
						originalSecondLevelMenu.removeClass('hidden').addClass('visible').show();
						$(this).unbind('mouseleave');
					});
					
				});
			}
		}
		else {
			// close the current sub-menu from hover and return the original selection
			var originalSecondLevelMenu = $('.second-level-menu-group.original-sl-menu-group');
			
			if (originalSecondLevelMenu.attr('id') != currentSecondLevelMenu.attr('id')) {
				
				currentSecondLevelMenu.removeClass('visible').addClass('hidden').hide();
				originalSecondLevelMenu.removeClass('hidden').addClass('visible').show();
			}
		}
	});
	
	//Obtain the current path
	var pathName = window.location.href;
	
	var logout = $('#logout');
	//Logout settings local versus other environments
	//Check to see if localhost
	if(pathName.toLowerCase().indexOf('localhost') != -1) {
		logout.attr('href', '/supportal/j_spring_security_logout').text('Logout');
	}
	else {
		logout.attr('href', '/supportal/saml/logout').text('Logout');
	}
	
	//Highlight menu
	var currentMenuItem = null;
	
	if (primaryMenuSelected != '') {
		currentMenuItem = $('#' + primaryMenuSelected);
	}
	else if(pathName.indexOf('/supportal/sp/home/display') != -1) {
		currentMenuItem = $('#homeLink');
	}
	else if(pathName.indexOf('/supportal/sp/admin/display') != -1) {
		currentMenuItem = $('#administrationLink');
	}
	else if(pathName.indexOf('/supportal/sp/help/contactus') != -1) {
		currentMenuItem = $('#contactUsLink');
	}
	else if(pathName.indexOf('/supportal/sp/help/helpmenu') != -1) {
		currentMenuItem = $('#helpLink');
	}
	
	if(currentMenuItem != null) {
		//Apply highlight
		currentMenuItem.addClass('highlighted');
		
		if (primaryMenuSelected != '') {
			var secondLevelMenuTarget = $('#' + primaryMenuSelected + 'SecondLevel');
			
			if (secondLevelMenuTarget.size() == 0) {
				secondLevelMenuTarget = $('#emptySecondLevel');
			}
			secondLevelMenuTarget.addClass('original-sl-menu-group').addClass('visible').removeClass('hidden').show();
			
			if (secondaryMenuSelected != '') {
				
				$('#' + secondaryMenuSelected).addClass('selected');
			}
		}
		else {
			$('#emptySecondLevel').addClass('original-sl-menu-group').addClass('visible').removeClass('hidden').show();
		}
	}
	else {
		$('#emptySecondLevel').addClass('original-sl-menu-group').addClass('visible').removeClass('hidden').show();
	}
	
	// Override original ajax function to override default error handler for specific status codes
	// Executes original ajax function with updated parameters
	{
		// Save original ajax function to be called at the end of the overriding function
		var originalAjaxMethod = $.ajax;
		// Used when no function was defined in original call
		var emptyFunction = function(){};
		// Override ajax function
		$.ajax = function(options){
			// If a function was defined, store it.  Otherwise set the value to the empty function
			var originalErrorFunction = (typeof options.error === 'function') ? options.error : emptyFunction;
			// Override error function to use different functions than the original for specific error codes
			options.error = function(jqXHR, textStatus, errorThrown) {
					switch(jqXHR.status){
			  		// Value should match constant in com.ussco.supplierportal.web.security.AjaxTimeoutRedirectFilter
			  		case 475:
			  			ajaxTimeoutRedirect();
			  			break;
			  		default:
			  			// Execute original error function if there are no overrides
			  			originalErrorFunction(jqXHR, textStatus, errorThrown);
			  			break;
				}
			};
			// Execute original ajax function with updated options
			return originalAjaxMethod(options);
		};
	}
});

function ajaxTimeoutRedirect(){
	var counter = 5;
	$('#pageRefreshCountdownSeconds').text(counter);
	var dialog = $('#ajaxSessionTimeoutDialog');
	var timer=null;
	$(dialog).dialog({
		title: 'Session Expired',
		buttons:{
			Cancel: function(){
				clearInterval(timer);
				$(this).dialog('close');
			}
		}
		
	});
	$(dialog).dialog('open');

	timer = setInterval(function(){
		counter--;
		if(counter == 0){
			clearInterval(timer);
			location.reload();
		}
		$('#pageRefreshCountdownSeconds').text(counter);
	}, 1000);
	
}

/*
 * View model class containing the master set of drop down options, the data object 
 * being bound to the form inputs, and the functions to react the events in the form.
 */
function HeaderActionHandlers() {
	
	this.getAvailableSuppliers = function () {
		$.ajax({
			url : '/supportal/sp/supplier/availableSuppliers',
			success : function(data) {
				if(data.availableSuppliersOptions && !data.errorMessage) {
					var multipleAvaibleSuppliers = false;
					if(data.availableSuppliersOptions.length > 1) {
						multipleAvaibleSuppliers = true;
					}
					
					//Obtain the active supplier id
					var activeSupplierId = data.activeSupplierId;
					// find #brandSelector
					var brandSelector = $('#brandSelector');
					//find #company
					var company = $('#company');
					
					if(data.allSuppliersOption) {
						//Logic for All suppliers (canProxySupplier only)
						//allSuppliersObject will be a supplier with all null properties
						var allSuppliersObject = data.allSuppliersOption;
						var allSuppliersOption = $('<option>').attr('value', allSuppliersObject.vendorNumber).text('All Suppliers');
						//Add supplier data to the option
						allSuppliersOption.data('supplierObject', allSuppliersObject);
						brandSelector.find('select').append(allSuppliersOption);						
					}
					
					$.each(data.availableSuppliersOptions, function(index, value) {
						var supplierDisplayValue = value.vendorNumber + " - " + value.vendorShortName;
						//If the active supplier id matches the supplier id in the list, populate the company with it
						if(activeSupplierId == value.vendorNumber) {
							//Multiple available suppliers, add carrot
							if(multipleAvaibleSuppliers) {
								company.html(supplierDisplayValue + '<span class="ui-icon ui-icon-carat-1-s"></span>');
							}
							else {
								company.html(supplierDisplayValue);
							}
							//Add the supplier data to company
							company.data('supplierObject', value);
						}
						var newSupplierOption = $('<option>').attr('value', value.vendorNumber).text(supplierDisplayValue);
						//Add supplier data to the option
						newSupplierOption.data('supplierObject', value);
						brandSelector.find('select').append(newSupplierOption);
					});					
					if(multipleAvaibleSuppliers && !activeSupplierId) {
						company.html('All Suppliers' + '<span class="ui-icon ui-icon-carat-1-s"></span>');
						company.data('supplierObject', allSuppliersObject);
					}
				}
			},
			error : function(xhr, textStatus, errorThrown) {
				alert('An unexpected error has occurred.');
			},			
			async : false
		});
	};
	
	this.changeBrand = function(supplierObject) {
		var currentVendorValue = $('#company').text();
		var supplierDisplayValue;
		//If there are no values within the supplier object, this means it represents all suppliers
		if(supplierObject.vendorNumber == null && supplierObject.vendorShortName == null) {
			supplierDisplayValue = "All Suppliers";
		}
		else {
			supplierDisplayValue = supplierObject.vendorNumber + " - " + supplierObject.vendorShortName;	
		}
		
		var supplierChanged = false;
		//Make sure the active supplier wasn't selected
		if(supplierDisplayValue != currentVendorValue) {
			supplierChanged = true;
		}
		
		if(supplierChanged) {
			//alert('Attempting to change active supplier to: ' + supplierObject.vendorShortName + ' - ' + supplierObject.vendorNumber);
			
			// make ajax call passing the vendor number		
			$.ajax({
				url : '/supportal/sp/supplier/changeActiveSupplier/' + supplierObject.vendorNumber + '/' + supplierObject.vendorShortName,
				type : 'POST',
				success : function(data) {
					if(!data.errorMessage) {
						$('#company').html(supplierDisplayValue + '<span class="ui-icon ui-icon-carat-1-s"></span>');	
						//Update the data attached with the newly selected supplier
						$('#company').data('supplierObject', supplierObject);
					}
				},
				error : function(xhr, textStatus, errorThrown) {
					supplierChanged = false;
					alert('An unexpected error has occurred.');
				},
				async : false
			});
		}
		//return supplier changed flag
		return supplierChanged;
	};
};

function downloadBlankBulkTemplate(viewModel) {
	var self = this;
		
	var selectedCategory = null;
	var pleaseWaitDialog = new PleaseWaitDialog();
	
	//create UI dialog
	$('#taxonomyTemplateCategory').remove();
	this.dialog = $('<div>').attr('id', 'taxonomyTemplateCategory');
	this.dialog.attr('title', 'Please choose a Taxonomy');
	
	// create a form
	var form = $('<form>').attr('id', 'downloadBulkForm').attr('method', 'POST');
	var input = $('<input></input>').attr({ 'type' : 'hidden', 'id' : 'downloadBulkFormInput', 'name' : 'taxonomy'}).appendTo(form);
	this.dialog.append(form);

	var prompt = $('<p>').text('Please select one of the following Taxonomies.').attr('id', 'prompt').addClass("newParagraph");
	var allCategoryList = $('<select>').attr('id', 'allCategoryList').change(function(){
		changeCategoryListValue("#allCategoryList");});
	var templateFormatPrompt = $('<p>').text('Please select which template format to download.').attr('id', 'format').addClass("newParagraph");
	var xlsFormatChoice = $('<input>').attr({id: 'format', 'class': 'download-format', name: 'format', type: 'radio', value: 'xls'});
	var xlsFormatChoiceLabel = $('<span>').text('.xls Format');
	var xlsxFormatChoice = $('<input>').attr({id: 'format', 'class': 'download-format', name: 'format', type: 'radio', value: 'xlsx', checked: 'checked'});
	var xlsxFormatChoiceLabel = $('<span>').text('.xlsx Format');

	//append objects to dialog
	form.append(prompt);
	form.append(allCategoryList);
	form.append(templateFormatPrompt);
	form.append(xlsxFormatChoice);
	form.append(xlsxFormatChoiceLabel);
	form.append(xlsFormatChoice);
	form.append(xlsFormatChoiceLabel);
	
	$.ajax({
		'url' : '/supportal/sp/contentdashboard/categories/allcategories/',
		'beforeSend' : function(xhr, settings) {
			$('#allCategoryList').empty();
			$('#allCategoryList').fadeIn("slow");
	
			var categoryBlank = $('<option>');
			categoryBlank.attr('id', 'categoryLoading');
			categoryBlank.attr('value', '');
			categoryBlank.text('-- Loading --');
			allCategoryList.append(categoryBlank);
		},
		'success' : function(jSonData) {
			$('#Download').button('disable');
			$('#allCategoryList').empty();
			
			$('#allCategoryList').fadeIn("slow");
	
			var categoryBlank = $('<option>');
			categoryBlank.attr('id', 'categoryBlank');
			categoryBlank.attr('value', '');
			categoryBlank.text('-- select --');
			allCategoryList.append(categoryBlank);
			//populate categories in dropdown list, using JSON object that has been returned. 
			$.each(jSonData.taxonomyCategory, function(index, value) {
				//append category to categoryList
				var category = $('<option>');
				category.attr('code', value.code);
				category.attr('name', value.name);
				category.text(value.description);
				allCategoryList.append(category);
			});
		},
		'complete' : function(xhr, status) {
			
		}
	});//end of ajax
	
	//set dialog to main area
	var mainContentArea = $('#main');
	mainContentArea.append(this.dialog);

	//details of creation of the dialog
	this.dialog.dialog({
		'autoOpen' : false,
		'closeOnEscape' : false,
		'height' : 375,
		'modal' : true,
		'resizable' : true,
		'width' : 600,
		buttons: [{
	        text: "Download",
	        "id": "Download",
	        "disabled": true,
	        click: function () {
	        	var dialogRef = $(this);
//	        	selectedCategory = selectedCategory.replace(/\//g, ' ');
				document.forms['downloadBulkForm'].action = '/supportal/sp/contentdashboard/download/template/' + $('.download-format:checked').val()+'/blank';
				$('#downloadBulkFormInput').val(selectedCategory);
				document.forms['downloadBulkForm'].submit();
				$( this ).dialog( "close" );
				$('#taxonomyTemplateCategory').remove();
	        }
	    },{
	        text: "Close",
	        "id": "Close",
	        click: function () {
	        	$( this ).dialog( "close" );
	        	$('#taxonomyTemplateCategory').remove();
	        }
	    }]
	});
	//opens dialog
	this.dialog.dialog('open');
	
	function changeCategoryListValue(listId) {
		
		selectedCategory = $(listId + " option:selected").text();
		if(selectedCategory != "-- select --"){
			 // selectedCategory = $(listId + " option:selected").text();
			$('#Download').button('enable');
		}else{
			selectedCategory = null;
			$('#Download').button('disable');
		}
	}
	
};//end of downloadBlankBulkTemplate function
function downloadBlankNewItemAddBulkTemplate(){{
	var self = this;

	// create UI dialog
	$('#fileExtensionWizard').remove();
	this.dialog = $('<div>').attr('id', 'fileExtensionWizard');
	this.dialog.attr('title',
			'Please choose a file extension for Download Template...');

	var radioXlsFormat = $("<input/>", {
		type : 'radio',
		name : 'fileExtension',
		id : 'xls'

	});

	var radioXlsText = ".xls Format";
	var paraGraph = $('<p>');
	
	var radioXlsxFormat = $("<input/>", {
		type : 'radio',
		name : 'fileExtension',
		checked: 'true',
		id : 'xlsx'
	});

	var radioXlsxText = ".xlsx Format";
	this.dialog.append(radioXlsxFormat);
	this.dialog.append(radioXlsxText);
	this.dialog.append(paraGraph);
	this.dialog.append(radioXlsFormat);
	this.dialog.append(radioXlsText);	
	var mainContentArea = $('#main');
	mainContentArea.append(this.dialog);

	// details of creation of the dialog
	this.dialog
			.dialog({
				'autoOpen' : false,
				'closeOnEscape' : false,
				'height' : 200,
				'modal' : true,
				'resizable' : true,
				'width' : 500,
				buttons : [
						{	text : "Submit",
							"id" : "Submit",
							click : function() {
								var id = $("input[@name=fileExtension]:checked").attr('id');
								if (id == 'xls') {
									window.open("/supportal/static/documents/DownloadTemplate.xls", "window2", "");
									$(this).dialog("close");
								}
								else {
									window.open("/supportal/static/documents/DownloadTemplate.xlsx", "window2", "");
									$(this).dialog("close");
								}
							}
						}, {
							text : "Close",
							"id" : "Close",
							click : function() {
								$(this).dialog("close");
							}
						} ]
			});

	this.dialog.dialog('open');

};
}

var holidays = [];

function loadHolidays(){
	$.ajax({
		url : '/supportal/sp/holidays',
		success : function(data) {
			/*$.each(data, function(index, value){
				holidays.push(new Date(value));
			});*/
			holidays = data;
		}
	});
}

function disableHolidaysAndWeekends(date){
	var noWeekend = $.datepicker.noWeekends(date);
	if(noWeekend[0]){
		return $.inArray(date.getTime(), holidays) < 0 ? [true, ''] : [false, ''];
	}else{
		return noWeekend;
	}
};