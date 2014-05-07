package com.ussco.xref.model.domain;

import com.ussco.xref.to.maintenance.BaseMaintenanceTO;

public class MatchType extends BaseMaintenanceTO {
	private static final long serialVersionUID = 8411842176962586241L;
	private String description;
	private String code;

	private String originalMatchType;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the matchType
	 */
	@Override
	public String getCode() {
		return this.code;
	}

	/**
	 * @param matchType the matchType to set
	 */
	@Override
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the originalMatchType
	 */
	public String getOriginalMatchType() {
		return this.originalMatchType;
	}

	/**
	 * @param originalMatchType the originalMatchType to set
	 */
	public void setOriginalMatchType(String originalMatchType) {
		this.originalMatchType = originalMatchType;
	}

}
