/**
 *
 */
package com.ussco.xref.utils;

/**
 * @author larsonr
 *
 */
public enum RequestTypeEnum {
    REPORT_ALL_XREF("R1"),
    REPORT_ITEMS_WITH_XREFS("R2"),
    REPORT_ITEMS_WITHOUT_XREFS("R3"),
    REPORT_DUPLICATE_XREFS("R4"),
    REPORT_INACTIVE_XREFS("R5"),
    XREFS_NOT_MODIFIED_IN_X_DAYS("R6"),
    XREFS_MODIFIED_BY_DATE("R7"),
    XREFS_BY_VENDOR("R8"),
    MASS_MAINTENANCE("MM"),
    MATCHING("MA");

    private final String code;

    RequestTypeEnum(String code)
    {
        this.code = code;

    }//end method

	/**
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	public static RequestTypeEnum fromValue(String v) {
		for (RequestTypeEnum c : RequestTypeEnum.values()) {
			if (c.code.equals(v)) {
				return c;
			}
		}

		return null;
	}

}//end enum