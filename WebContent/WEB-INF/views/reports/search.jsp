<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="main" class="container_12">
    <div class="grid_12">
        <h1>Single Item Search</h1>
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
                    <input type="button" value="Find XRefs" data-bind="click: save, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default " >
                    <input type="button" value="Reset" data-bind="click: save, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default " >
                </div>
	        </div>
            <div id="reportForm" class="form-container">
               <div>
                   <h3 class="group-heading">Lookup Criteria</h3>
                   <hr class="group-line-break" />
                   <ul>
                        <li>
                            <div>
                                <div class="label-container"><label for="businessUnit" class="required">Business Unit</label></div>
                                <div class="input-container"><select id="businessUnit" data-bind="options: businessUnitOptions, optionsText: 'label', optionsValue: 'id', value: data.businessUnit, optionsCaption: '-- Select --', enable: isEditAllowed()"></select></div>
                            </div>
                        </li>
                        
                        <li>
                            <div>
                                <div class="label-container"><label for="searchBy" class="required">By</label></div>
                                <div class="input-container"><select id="searchBy" data-bind="options: searchByOptions, optionsText: 'display', optionsValue: 'code', value: data.searchBy, enable: isEditAllowed()"></select></div>
                            </div>
                        </li> 
	                    <li>
	                        <div>
	                          <div class="label-container"><label for="searchValue">Value</label></div>
	                          <div class="input-container"><input id="searchValue" type="text" data-bind="value: data.searchValue" value=""></div>
	                        </div>
	                    </li>
	                    <li>
                            <div class="label-container"><label for="partialSearch">Search for Partials?</label></div>
                            <div id="partialSearch" class="input-container input-container-checkbox"><input type="checkbox" value="y" data-bind="checked: data.partialSearch" /></div>
                       </li>
                    </ul>
                </div>
                <div>
                   <h3 class="group-heading">Matching Criteria</h3>
                   <hr class="group-line-break" />
                   <ul> 
                        
                       <li>
                            <div>
                                <div class="label-container"><label for="reseller" class="required">Reseller</label></div>
                                <div class="input-container input-container-multiple"><select id="reseller" multiple="multiple" data-bind="options: resellerOptions,  optionsText: 'resellerName', optionsValue: 'code', selectedOptions: data.reseller, enable: isEditAllowed()"></select></div>
                            </div>
                        </li>
                        <sec:authorize access="hasAnyRole('ROLE_XREF_MAINTENANCE','ROLE_XREF_MAINTENANCE_TEST') and fullyAuthenticated">
                        <li>
                            <div>
                                <div class="label-container"><label for="customerReseller">Customer</label></div>
                                <div class="input-container input-container-multiple"><select id="customerReseller" multiple="multiple" data-bind="options: customerResellerOptions,  optionsText: 'resellerName', optionsValue: 'code', selectedOptions: data.customerReseller, enable: isEditAllowed()"></select></div>
                            </div>
                        </li>
                        </sec:authorize>
                       <li>
                            <div>
                                <div class="label-container"><label for="xrefTypes" class="required">XRef Types</label></div>
                                <div class="input-container input-container-multiple"><select id="xrefTypes" multiple="multiple" data-bind="options: xrefTypeOptions,  optionsText: 'description', optionsValue: 'code', selectedOptions: data.xrefTypes, enable: isEditAllowed()"></select></div>
                            </div>
                        </li>
                       <li>
                            <div>
                                <div class="label-container"><label for="matchTypes" class="required">Match Types</label></div>
                                <div class="input-container input-container-multiple"><select id="matchTypes" multiple="multiple" data-bind="options: matchTypeOptions,  optionsText: 'description', optionsValue: 'code', selectedOptions: data.matchTypes, enable: isEditAllowed()"></select></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="ssr-item-info-bar">
                <div class="form-button-set" >
                    <input type="button" value="Find XRefs" data-bind="click: save, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default " >
                    <input type="button" value="Reset" data-bind="click: save, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default " >
                </div>
            </div>
        </div>
    </div>
</div>