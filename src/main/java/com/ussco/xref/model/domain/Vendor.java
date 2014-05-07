package com.ussco.xref.model.domain;

import com.ussco.xref.to.maintenance.BaseMaintenanceTO;

public class Vendor extends BaseMaintenanceTO 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -60424149378334762L;

	private String shortName;
	private String abbreviation;

	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}

