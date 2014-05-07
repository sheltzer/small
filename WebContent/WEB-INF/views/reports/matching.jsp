<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="main" class="container_12">
    <div class="grid_12">
        <h1>Matching</h1>
    </div>
    <div class="clear"></div>
    <div class="page-copy grid_12">
        <br/><br/>
        <span class="required-display">*</span> - Required Field<br/>
    </div>
    <div class="clear"></div>
    <div class="messages grid_12">
        <div id="updateNotifications" class="ui-state-highlight ui-corner-all" data-bind="visible: showGlobalNotificationMessage()" style="display: none;">
            <p>
                <span class="ui-icon ui-icon-check" style="float: left; margin-right: .3em;" data-bind="visible: !baseViewModel.containsFieldErrors()"></span>
                <span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;" data-bind="visible: baseViewModel.containsFieldErrors()"></span>
                <strong></strong><span id="notificationMessageContent" data-bind="text: baseViewModel.globalNotificationMessage"></span>
            </p>
        </div>
        
        <!-- <div id="errors" class="ui-state-error ui-corner-all" style="display: none;"> -->
        <div id="errors" class="ui-state-error ui-corner-all" style="display: none;" data-bind="visible: showGlobalErrorMessage()">
            <p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span><strong>Alert: </strong><span id="errorMessageContent" data-bind="text: baseViewModel.globalErrorMessage"></span></p>
        </div>
    </div>
    <div class="clear"></div>

    <div class="grid_12 item-content-container" style="margin-top:10px;margin-bottom:30px;">
        <div class="category-fields-container">
            <div class="ssr-item-info-bar">
	            <div class="form-button-set" >
	                <input type="button" value="Reset" data-bind="click: reset, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default " >
	                <input type="button" value="Generate" data-bind="click: save, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default " >
	            </div>
	        </div>
            <div id="reportFormContainer" class="form-container">
                <form id="matchingForm" modelAttribute="matchingRequest" 
                                enctype="multipart/form-data">
	               <div>
	                   <h3 class="group-heading">Input</h3>
	                   <hr class="group-line-break" />
	                   <ul>
	                        <li>
	                            <div>
	                                <div class="label-container"><label for="inputFile" class="required">Input File Location</label></div>
	                                <div class="input-container"><input id="inputFile" type="file" data-bind="file: data.inputFile" value=""></div>
	                            </div>
	                        </li> 
	                    </ul>
	                </div>
	                <div>
	                   <h3 class="group-heading">Report Criteria</h3>
	                   <hr class="group-line-break" />
	                   <ul>             
	                        <li>
	                            <div>
	                                <div class="label-container"><label for="businessUnit" class="required">Business Unit</label></div>
	                                <div class="input-container"><select id="businessUnit" data-bind="options: businessUnitOptions, optionsText: 'name', optionsValue: 'code', value: data.businessUnit, optionsCaption: '-- Select --', enable: isEditAllowed()"></select></div>
	                            </div>
	                        </li>
	                        <li>
	                            <div class="label-container"><label for="activeOnly">Active Only</label></div>
	                            <div class="input-container input-container-checkbox"><input id="activeOnly" type="checkbox" value="y" data-bind="checked: data.activeOnlyChecked, enable:isEditAllowed()" /></div>
	                       </li>
	                       <li>
	                            <div>
	                                <div class="label-container"><label for="reseller" class="required">Reseller</label></div>
	                                <div class="input-container input-container-multiple"><select id="resellers" multiple="multiple" data-bind="options: resellerOptions,  optionsText: 'resellerName', optionsValue: 'code', selectedOptions: data.reseller, enable: isEditAllowed()"></select></div>
	                            </div>
	                        </li>
	                       <li>
	                            <div>
	                                <div class="label-container"><label for="xrefTypes" class="required">XRef Types</label></div>
	                                <div class="input-container input-container-multiple"><select id="xrefTypes" multiple="multiple" data-bind="options: xrefTypeOptions,  optionsText: 'description', optionsValue: 'code', selectedOptions: data.xrefType, enable: isEditAllowed()"></select></div>
	                            </div>
	                        </li>
	                       <li>
	                            <div>
	                                <div class="label-container"><label for="matchTypes" class="required">Match Types</label></div>
	                                <div class="input-container input-container-multiple"><select id="matchTypes" multiple="multiple" data-bind="options: matchTypeOptions,  optionsText: 'description', optionsValue: 'code', selectedOptions: data.matchType, enable: isEditAllowed()"></select></div>
	                            </div>
	                        </li>
	                    </ul>
	                </div>
	               <div>
	                   <ul>
	                   <li>
		               <h3 class="group-heading">Additional Fields</h3>
		               <hr class="group-line-break" />
		               </li>
	                       <li>
	                            <div>
	                                <div class="label-container"><label for="additionalFields">Additional Fields</label></div>
	                                <div class="input-container input-container-multiple">
	                                    <select id="additionalFields" multiple="multiple" data-bind="options: additionalFieldOptions,  optionsText: 'label', optionsValue: 'id', selectedOptions: data.additionalFields, enable: isEditAllowed()"></select>
	                                    <div class="repeatable-addButton" data-bind="click: addAdditionalField">Add</div>
	                                </div>
	                                
	                        
	                                <div style="clear: both;"></div>
			                        <div>
			                            <div data-bind="ifnot: data.selectedAdditionalFields().length == 0">
			                                <div class="label-container">&nbsp;</div>
			                            </div>
			                            <div data-bind="foreach: data.selectedAdditionalFields()" class="input-container" style="margin-bottom: 5px;">
			                                <div class="repeatable-valueContainer">
			                                    <a class="repeatable-value" data-bind="text: label"></a>
			                                    <div>
			                                        <a href="#" class="repeatable-removeButton info-box-close" style="position: static;" data-bind="click: $parent.removeAdditionalField">x</a>
			                                    </div>
			                                    <div style="clear: both;"></div>
			                                </div>
			                            </div>
			                            <div style="clear: both;"></div>
			                        </div>
	                            </div>
	                        </li>
		                </ul>
	                </div>
	                <ul>
	                    <li>
		                    <h3 class="group-heading">Output</h3>
		                    <hr class="group-line-break" />
		                </li>
		                <li>
	                        <div>
	                          <div class="label-container"><label for="outputFilename">Output File Name</label></div>
	                          <div class="input-container"><input id="outputFilename" type="text" data-bind="value: data.outputFilename, enable: isEditAllowed()" value=""></div>
	                        </div>
	                    </li>
	                    <li>
	                        <div>
	                            <div class="label-container"><label for="outputFormat" class="required">Output File Format</label></div>
	                            <div class="input-container"><select id="outputFormat" data-bind="options: outputFormatOptions, optionsText: 'label', optionsValue: 'id', value: data.outputFormat, optionsCaption: '-- Select --', enable: isEditAllowed()"></select></div>
	                        </div>
	                    </li>
	                </ul>
	                <input type="hidden" id="selectedAdditionalFields" data-bind="value: data.selectedAdditionalFields">
                    </form>
	            </div>
	            <div class="ssr-item-info-bar">
	                <div class="form-button-set" >
	                    <input type="button" value="Reset" data-bind="click: reset, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default " >
	                    <input type="button" value="Generate" data-bind="click: save, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default " >
	                </div>
	            </div>
            </div>
    </div>
</div>