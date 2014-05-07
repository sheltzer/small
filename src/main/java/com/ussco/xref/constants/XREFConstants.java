package com.ussco.xref.constants;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MUKHERS
 *
 */
public class XREFConstants {
	public static List<String> massMaintainRequiredHeaderList = new ArrayList<String>();


	// ..Output Generator.................
	public final static String LIST_OF_OUTPUT_BEANS = "LIST_OF_OUTPUT_BEANS";
	public final static String SUMMARY_LIST = "SUMMARY_LIST";
	public final static String ERROR_LIST = "ERROR_LIST";
	public final static String SUMMARY = "SUMMARY";
	public final static String FILE_OUTPUT_LOCATION = "FILE_OUTPUT_LOCATION";
	public final static String FILE_OUTPUT_LOCATION_CSV_ERROR = "FILE_OUTPUT_LOCATION_CSV_ERROR";
	public final static String FILE_OUTPUT_LOCATION_CSV_SUMMARY = "FILE_OUTPUT_LOCATION_CSV_SUMMARY";
	public final static String FILE_INPUT_LOCATION = "FILE_INPUT_LOCATION";

	public final static int FIXED_HEADER_LENGTH_FOR_MATCHING_OUTPUT_FILE = 18;
	public final static int FIXED_HEADER_LENGTH_FOR_REPORTS_OUTPUT_FILE = 19;
	public final static int FIXED_HEADER_LENGTH_FOR_REPORTS_OUTPUT_FILE_DTTM = 21;
	public final static int FIXED_HEADER_LENGTH_FOR_ITEMS_WITHOUT_XREFS = 6;
	public final static int FIXED_HEADER_LENGTH_FOR_REPORTS_OUTPUT_FILE_VENDOR = 20;
	public final static String REPORT_TYPE="REPORT_TYPE";
	public final static String REPORT_RESELLER_PFX_STK="RESELLER_PFX_STK";

	// ...Parsing......................
	public final static String ERROR_MESSAGE = " was null or EMPTY.";
	public final static String ERROR_MESSAGE_FOR_MATCHING = "All required fields were NULL or EMPTY.";
	public final static String COMMA_SEPERATOR = ",";
	public final static String ONE_SPACE_STRING = " ";
	public final static String NEW_LINE = "\n";
	public final static String FILE_TYPE_EXCEL = ".xls";
	public final static String FILE_TYPE_EXCEL_2007 = ".xlsx";
	public final static String FILE_TYPE_CSV = ".csv";
	public final static String QUOTE = "\"";
	public final static String ADD=ADD_MODIFY_DELETE.A.toString();
	public final static String DELETE=ADD_MODIFY_DELETE.D.toString();
	public final static String MODIFY=ADD_MODIFY_DELETE.M.toString();
	public static enum ADD_MODIFY_DELETE{A,M,D};
	public final static int REPORT_MAX_OUTPUT_LIMIT_XL = 64000;

	//...DAO and BO's....
	public final static String KEY_ADD_LIST="KEY_ADD_LIST";
	public final static String KEY_MODIFY_LIST="KEY_MODIFY_LIST";
	public final static String KEY_DELETE_LIST="KEY_DELETE_LIST";
	public final static String KEY_ERROR_LIST="KEY_ERROR_LIST";
	public final static String ACTIVE_TRUE="Y";
	public final static String ACTIVE_FALSE="N";
	//..Update *-dao.xml when changing this value.
	public final static int BATCH_SIZE=20;


	//Errors
	public final static String ERROR_MESSAGE_FOR_BAD_INPUT_ROW = "Could not parse the";
	public final static String ADDED_TO_DB = " was successfully added.";
	public final static String DELETED_FROM_DB = " was successfully deleted.";
	public final static String UPDATED_DB = " was successfully updated.";
	public final static String COULD_NOT_ADD_TO_DB = " did not get ADDED(please make sure the row does not exist already OR a foreign KEY violation).";
	public final static String COULD_NOT_DELETE_FROM_DB =  " did not get DELETED(please make sure that row is actually present in DB).";
	public final static String COULD_NOT_UPDATE_DB =  " did not get UPDATED(please make sure that row is actually present in DB).";
	public final static String ERROR_MESSAGE_MATCHING_NO_RECORD_FOUND = "No Matching Record Found.";
	public final static String ERROR_MESSAGE_RQD_FIELD_NOT_PROVIDED =" was not provided ";
	public final static String ERROR_MESSAGE_REPORT_NO_RECORD_FOUND = "No Records were found for the applied Report Criteria";


	//Match coes for reference
	public final static String MATCH_TYPE_CODE_EXACT = "EXT";
	public final static String MATCH_TYPE_CODE_ALL = "ALL";
	//public final static String XREF_DEFAULT_USER_ID = "palbali";


	//MatchLogicHelper - IEField.properties Prefixs
	public final static String ITEM_TABLE_PREFIX = "it";
	public final static String FACITEM_TABLE_PREFIX = "fcit";
	public final static String CATLDETL_TABLE_PREFIX = "ctdt";
	//public final static String OUTPUT_FILE_LOCATION_NETWORK_DRIVE = "C:";

	public final static String MAINTAIN_MESSAGE_DELETE = "Maintain_Delete_Constraint";
	public final static String MAINTAIN_MESSAGE_ADD = "Maintain_Add_Constraint";
	public final static String MATCHING_GOOD_LIST = "GoodList";
	public final static String MATCHING_BAD_LIST = "BadList";
	public final static String UNITED_RESELLER_ID = "USSC";
	public final static String REMOVE_CHAR = "|";

	public final static String ALL = "ALL";
	public static String SUCCESS = "1";

	public final static String LAGASSE_ITEM_STATUS_ACTIVE = "A";
	public final static String LAGASSE_ITEM_STATUS_INACTIVE = "I";
}
