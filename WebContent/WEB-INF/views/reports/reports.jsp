<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div id="main" class="container_12">
	<div class="grid_12">
		<h1>Reports</h1>
	</div>
	<div class="clear"></div>
	<div class="page-copy grid_12">
		<br /> <br /> <span class="required-display">*</span> - Required
		Field<br />
	</div>
	<div class="clear"></div>
	<div class="messages grid_12">
		<div id="updateNotifications" class="ui-state-highlight ui-corner-all"
			data-bind="visible: showGlobalNotificationMessage()"
			style="display: none;">
			<p>
				<span class="ui-icon ui-icon-check"
					style="float: left; margin-right: .3em;"
					data-bind="visible: !baseViewModel.containsFieldErrors()"></span> <span
					class="ui-icon ui-icon-alert"
					style="float: left; margin-right: .3em;"
					data-bind="visible: baseViewModel.containsFieldErrors()"></span> <strong></strong><span
					id="notificationMessageContent"
					data-bind="text: baseViewModel.globalNotificationMessage"></span>
			</p>
		</div>

		<!-- <div id="errors" class="ui-state-error ui-corner-all" style="display: none;"> -->
		<div id="errors" class="ui-state-error ui-corner-all"
			style="display: none;" data-bind="visible: showGlobalErrorMessage()">
			<p>
				<span class="ui-icon ui-icon-alert"
					style="float: left; margin-right: .3em;"></span><strong>Alert:
				</strong><span id="errorMessageContent"
					data-bind="text: baseViewModel.globalErrorMessage"></span>
			</p>
		</div>
	</div>
	<div class="clear"></div>

	<div class="grid_12 item-content-container"
		style="margin-top: 10px; margin-bottom: 30px;">
		<div class="category-fields-container">
			<div class="ssr-item-info-bar">
				<div class="form-button-set">
				    <input type="button" value="Reset" data-bind="click: reset, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default ">
					<input type="button" value="Generate" data-bind="click: save, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default ">
				</div>
			</div>
			<div id="reportForm" class="form-container">
				<div>
					<ul>
						<li>
							<h3 class="group-heading">Report Type</h3>
							<hr class="group-line-break" />
						</li>
						<li>
							<div>
								<div class="label-container">
									<label for="reportType" class="required"></label>
								</div>
								<div class="input-container">
									<select id="reportType"
										data-bind="options: reportTypeOptions, optionsText: 'label', optionsValue: 'id', value: data.reportType, optionsCaption: '-- Select --', enable: isEditAllowed(), event: { change: onReportTypeChange() }"></select>
								</div>
							</div>
						</li>
						<li>
							<h3 class="group-heading">Report Criteria</h3>
							<hr class="group-line-break" />
						</li>
						<li data-bind="visible: showBusinessUnit">
							<div>
								<div class="label-container">
									<label for="businessUnit" class="required">Business Unit</label>
								</div>
								<div class="input-container">
									<select id="businessUnit"
										data-bind="options: businessUnitOptions, optionsText: 'label', optionsValue: 'id', optionsCaption: '-- Select --', value: data.businessUnit, enable: isEditAllowed()"></select>
								</div>
							</div>
						</li>
						<li data-bind="visible: showResellerPrefix">
							<div>
								<div class="label-container">
									<label for="resellerPrefix">Reseller Prefix</label>
								</div>
								<div id="ResellerPrefix"
									class="input-container input-container-checkbox">
									<input type="checkbox" value="y" id="resellerPrefix"
										data-bind="checked: data.resellerPrefixChecked, enable:isEditAllowed()" />
								</div>
							</div>
						</li>
						<li data-bind="visible: showReseller">
							<div>
								<div class="label-container">
									<label for="reseller" class="required">Reseller</label>
								</div>
								<div class="input-container input-container-multiple">
									<select id="reseller" multiple="multiple"
										data-bind="options: resellerOptions,  optionsText: 'resellerName', optionsValue: 'code', selectedOptions: data.reseller, enable: isEditAllowed()"></select>
								</div>
							</div>
						</li>

						<li data-bind="visible: showXrefTypes">
							<div>
								<div class="label-container">
									<label for="xrefTypes" class="required">Xref Types</label>
								</div>
								<div class="input-container input-container-multiple">
									<select id="xreftypes" multiple="multiple"
										data-bind="options: xrefTypeOptions,  optionsText: 'description', optionsValue: 'code', selectedOptions: data.xrefTypes, enable: isEditAllowed()"></select>
								</div>
							</div>
						</li>

						<li data-bind="visible: showActiveOnly">
							<div>
								<div class="label-container">
									<label for="businessUnit">Active Only</label>
								</div>
								<div id="ActiveOnly"
									class="input-container input-container-checkbox">
									<input type="checkbox" value="y"
										data-bind="checked: data.activeOnlyChecked, enable:isEditAllowed()" />
								</div>
							</div>
						</li>

						<li data-bind="visible: showItemNumberPrefix">
							<div>
								<div class="label-container">
									<label for="itemNumberPrefix">Item Number <br>
										(Begins With)
									</label>
								</div>
								<div class="input-container">
									<input id="itemNumber" type="text"
										data-bind="value: data.itemNumberPrefix, enable: isEditAllowed()"
										value="">
								</div>
							</div>
						</li>
						<li data-bind="visible: showResellerItemNumberPrefix">
							<div>
								<div class="label-container">
									<label for="resellerItemNumberPrefix">Reseller Item
										Number <br> (Begins With)
									</label>
								</div>
								<div class="input-container">
									<input id="itemNumber" type="text"
										data-bind="value: data.resellerItemNumberPrefix, enable: isEditAllowed()"
										value="">
								</div>
							</div>
						</li>
						<li data-bind="visible: showAddtionalFields">
							<div>
								<div class="label-container">
									<label for="additionalFields">Additional Fields</label>
								</div>
								<div class="input-container input-container-multiple">
									<select id="additionalFields" multiple="multiple"
										data-bind="options: additionalFieldOptions,  optionsText: 'label', optionsValue: 'id', selectedOptions: data.additionalFields, enable: isEditAllowed()"></select>
								</div>
							</div>
						</li>

						<li data-bind="visible: showLastModified">
							<div>
								<div class="label-container">
									<label for="lastModified" class="required">Days Since
										Last Modified</label>
								</div>
								<div class="input-container">
									<input id="lastModified" type="text"
										data-bind="value: data.lastModified, enable: isEditAllowed()"
										value="">
								</div>
							</div>
						</li>

						<li data-bind="visible: showDateRanges">
							<div>
								<div class="label-container">
									<label for="fromDate" class="required">Date From:</label>
								</div>
								<div class="input-container">
									<input id="fromDate" type="text"
										data-bind="datepickerfrom: data.fromDate, datepickerOptions: {}" />
								</div>
							</div>
							<div>
								<div class="label-container">
									<label for="toDate" class="required">Date To:</label>
								</div>
								<div class="input-container">
									<input id="toDate" type="text"
										data-bind="datepickerto: data.toDate, datepickerOptions: {}" />
								</div>
							</div>
						</li>

						<li data-bind="visible: showVendors">
							<div>
								<div class="label-container">
									<label for="vendors" class="required">Vendors:</label>
								</div>
								<div class="input-container">
									<select id="vendors"
										data-bind="options: vendorOptions, optionsText: 'shortName', optionsValue: 'shortName', value: data.vendor, optionsCaption: '-- Select --', enable: isEditAllowed()"></select>
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
							<div class="label-container">
								<label for="outputFilename">Output File Name</label>
							</div>
							<div class="input-container">
								<input id="outputFilename" type="text"
									data-bind="value: data.outputFileName, enable: isEditAllowed()"
									value="">
							</div>
						</div>
					</li>
					<li>
						<div>
							<div class="label-container">
								<label for="outputFormat" class="required">Output File
									Format</label>
							</div>
							<div class="input-container">
								<select id="outputFormat"
									data-bind="options: outputFormatOptions, optionsText: 'label', optionsValue: 'id', value: data.outputFormat, optionsCaption: '-- Select --', enable: isEditAllowed()"></select>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="ssr-item-info-bar">
				<div class="form-button-set">
				    <input type="button" value="Reset" data-bind="click: reset, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default ">
					<input type="button" value="Generate" data-bind="click: save, uiButtonDisable: !isEditAllowed()" class="ui-state-default ui-widget-content ui-state-default ">
				</div>
			</div>
		</div>
	</div>
</div>