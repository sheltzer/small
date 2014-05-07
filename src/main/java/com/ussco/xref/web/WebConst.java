/**
 * Copyright United Stationers Supply Company
 *
 * This material is confidential, proprietary product of
 * United Stationers Supply Co. for the sole and exclusive use
 * by United Stationers Supply Co. or an authorized dealer.
 *
 * United Stationers retains the exclusive right to compile and
 * publish this material. By accepting this material, you agree
 * to respect the confidential nature of this material and not
 * make copies of the whole or any part thereof, or distribute
 * the same, or divulge the contents of the materials to any
 * person not an authorized dealer or customer of United
 * Stationers Supply Co. without permission.
*/
package com.ussco.xref.web;

/**
 * @author Sandy Heltzer
 *
 */
public class WebConst {
	/**
	 * Constant set of content types for use in the types of content a controller
	 * operation accepts or produces.
	 *
	 * @author mike.nolan
	 */
	public static final class ContentType {

		private ContentType() {};

		public static final String APP_JSON = "application/json";
		public static final String IMG_JPEG = "image/jpeg";
	}

	/**
	 * Constants used for setting name/value pairs in the ModelAndView object instance,
	 * or the ModelMap contained in the ModelAndView.
	 *
	 * @author mike.nolan
	 */
	public static final class ModelKey {
		private ModelKey() {};

		public static final String REQUEST_LIST = "requestList";
		public static final String REQ_TYPE_OPTIONS = "typeOptions";
		public static final String USER_OPTIONS = "userOptions";
		public static final String MATCH_TYPE = "matchType";
		public static final String MATCH_TYPE_CODE = "matchTypeCode";
		public static final String XREF_TYPE = "xrefType";
		public static final String XREF_TYPE_CODE = "xrefTypeCode";
		public static final String RESELLER = "reseller";
		public static final String RESELLER_ID = "resellerId";
		public static final String ERROR_MESSAGE = "errorMessage";
		public static final String PROCESSING_SUCCESS_MESSAGE = "processingSuccessMessage";
		public static final String RESELLER_OPTIONS = "resellerOptions";
		public static final String CUSTOMER_RESELLER_OPTIONS = "customerResellerOptions";
		public static final String ADDITIONAL_FIELD_OPTIONS = "additionalFieldOptions";
		public static final String XREF_TYPE_OPTIONS = "xrefTypeOptions";
		public static final String VENDOR_OPTIONS = "vendorOptions";
		public static final String ITEM_NUMBER = "itemNumber";
		public static final String ITEM_INFO = "item";
		public static final String ITEM_XREF_ID = "itemXrefId";
		public static final String MATCH_TYPE_OPTIONS = "matchTypeOptions";
		public static final String COMPANY_NAME = "company";
		public static final String NEW_ITEM_NUMBER = "newItemNumber";
		public static final String ACTION = "action";
		public static final String ITEM_XREF_INFO = "itemXref";
		public static final String SEARCH_BY_OPTIONS = "searchByOptions";
		public static final String PRIMARY_FILTER_COUNTS = "primaryFilterCounts";
		public static final String BUSINESS_UNIT_OPTIONS = "businessUnitOptions";
	}

	/**
	 * Constant values for the UI Views specified in controllers for UI display.
	 *
	 * @author mike.nolan
	 */
	public static final class View {

		private View() {};

		public static final String REQUESTS = "requests";
		public static final String MATCH_TYPE = "matchtype";
		public static final String MATCH_TYPE_REQUEST_FORM = "matchtypeform";
		public static final String XREF_TYPE = "xreftype";
		public static final String XREF_TYPE_REQUEST_FORM = "xreftypeform";
		public static final String RESELLER = "reseller";
		public static final String RESELLER_REQUEST_FORM = "resellerform";
		public static final String REPORTS = "reportrequest";
		public static final String SUPPLY_XREF_MAINTENANCE = "supplyitemxref";
		public static final String SUPPLY_XREF_MAINT_FORM = "supplyitemxrefform";
		public static final String LAGASSE_XREF_MAINTENANCE = "lagasseitemxref";
		public static final String LAGASSE_XREF_MAINT_FORM = "lagasseitemxrefform";
		public static final String MATCHING = "matchingrequest";
		public static final String SINGLE_ITEM_SEARCH = "singleitemsearch";
	}

	public static final class ErrorMsg {

		private ErrorMsg() {};

		public static final String SUPPLY_ITEM_NOT_FOUND = "The specified USSCO item does not exist.";
		public static final String LAGASSE_ITEM_NOT_FOUND = "The specified Lagasse item does not exist.";
		public static final String STOCK_NUM_CHANGED = "Item number %s has been changed to new number %s.";
	}
}
