package com.ussco.xref.utils;

public enum ReportTypeEnum {
	
	ITEMS_WITH_XREFS("Items With XRefs"),
	ITEMS_WITHOUT_XREFS("Items Without XRefs"),
	DUPLICATE_XREFS("Duplicate XRefs"),
	INACTIVE_XREFS("Inactive XRefs"),
	ALL_XREFS("All XRefs"),
	XREFS_NOT_MODIFIED("XRefs Not Modified In X Days"),
	XREFS_MODIFIED_BY_DATE("XRefs Modified By Date"),
	XREFS_BY_VENDOR("XRefs By Vendor");
	
	private String typeAsString;
	
	private ReportTypeEnum(String typeAsString) {
		this.typeAsString = typeAsString;
	}
	
	public String getTypeAsString() {
		return this.typeAsString;
	}

}
