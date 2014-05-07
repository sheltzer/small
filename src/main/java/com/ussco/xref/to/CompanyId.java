/**
 * 
 */
package com.ussco.xref.to;

import java.util.ArrayList;
import java.util.List;


/**
 * @author chavdas
 *
 */
public enum CompanyId {
	ALL("00", "---ALL---"),
	UNITED_STATIONERS_SUPPLY("01", "Supply"),
	UNITED_STATNRS_FURN_DIV("02", "United Furniture"),
	AZERTY_DIV_OF_USSCO("03", "Azerty"),
	UNITED_STATNRS_CANADA("04", "Lagasse"),
	THE_ORDER_PEOPLE("05", "Order"),
	UNITED_STATIONERS_INC("99", "United");
	
	public static final String ALL_COMPANIES = "All";
	private final String value;
	private final String name;
	
	private CompanyId(final String value, final String name) {
		this.value = value;
		this.name = name;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static CompanyId getName(final String companyId) {
		final CompanyId[] companyIds = CompanyId.values();
		for (CompanyId companyIdTemp : companyIds) {
			if (companyIdTemp.getValue().equals(companyId)) {
				return companyIdTemp;
			}
		}
		throw new IllegalArgumentException(String.format("An invalid CompanyId %s has been passed", companyId));
	}
	
	public static List<String> getXRefCompanyIds() {
		List<String> xrefCompanyIds = new ArrayList<String>();
		xrefCompanyIds.add(UNITED_STATIONERS_SUPPLY.getValue());
		xrefCompanyIds.add(UNITED_STATNRS_CANADA.getValue());
		return xrefCompanyIds;
	}
}
