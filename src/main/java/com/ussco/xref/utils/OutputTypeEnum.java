package com.ussco.xref.utils;

public enum OutputTypeEnum {
	EXCEL("xls"),
	EXCEL_2007("xlsx"),
	CSV("csv");

    private final String code;

    OutputTypeEnum(String code)
    {
        this.code = code;

    }//end method

	/**
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	public static OutputTypeEnum fromValue(String v) {
		for (OutputTypeEnum c : OutputTypeEnum.values()) {
			if (c.code.equals(v)) {
				return c;
			}
		}

		return null;
	}
}
