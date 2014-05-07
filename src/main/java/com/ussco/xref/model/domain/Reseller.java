package com.ussco.xref.model.domain;

import com.ussco.xref.to.maintenance.BaseMaintenanceTO;
import com.ussco.xref.utils.ResellerTypeEnum;


public class Reseller extends BaseMaintenanceTO {

	private static final long serialVersionUID = 8067424163898530816L;
	private String resellerName;
	private String matchData;
	private String originalReseller;
	private Boolean existingReseller;
	private ResellerTypeEnum resellerType;

	
	@Override
	public Object clone() {
		Reseller to = (Reseller)super.clone();

		to.setResellerName(this.resellerName);
		to.setMatchData(this.matchData);

		return to;
	}

	public String getResellerName() {
		return this.resellerName;
	}
	public void setResellerName(String resellerName) {
		this.resellerName = resellerName;
	}
	public String getMatchData() {
		return this.matchData;
	}
	public void setMatchData(String matchData) {
		this.matchData = matchData;
	}

	/**
	 * @return the originalReseller
	 */
	public String getOriginalReseller() {
		return this.originalReseller;
	}

	/**
	 * @param originalReseller the originalReseller to set
	 */
	public void setOriginalReseller(String originalReseller) {
		this.originalReseller = originalReseller;
	}

	/**
	 * @return the existingReseller
	 */
	public Boolean getExistingReseller() {
		return this.existingReseller;
	}

	/**
	 * @param existingReseller the existingReseller to set
	 */
	public void setExistingReseller(Boolean existingReseller) {
		this.existingReseller = existingReseller;
	}

	/**
	 * @return the resellerType
	 */
	public ResellerTypeEnum getResellerType() {
		return resellerType;
	}

	/**
	 * @param resellerType the resellerType to set
	 */
	public void setResellerType(ResellerTypeEnum resellerType) {
		this.resellerType = resellerType;
	}

}
