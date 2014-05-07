package com.ussco.xref.model.domain;

import com.ussco.xref.to.maintenance.BaseMaintenanceTO;

public class  XRefType extends BaseMaintenanceTO {

	private static final long serialVersionUID = -6712313247983186644L;
	private String description;
	private Boolean existingXrefType;
	private Boolean originalXrefType;

	@Override
	public Object clone() {
		XRefType to = (XRefType)super.clone();

		to.setDescription(this.description);

		return to;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the existingXrefType
	 */
	public Boolean getExistingXrefType() {
		return this.existingXrefType;
	}

	/**
	 * @param existingXrefType the existingXrefType to set
	 */
	public void setExistingXrefType(Boolean existingXrefType) {
		this.existingXrefType = existingXrefType;
	}

	/**
	 * @return the originalXrefType
	 */
	public Boolean getOriginalXrefType() {
		return this.originalXrefType;
	}

	/**
	 * @param originalXrefType the originalXrefType to set
	 */
	public void setOriginalXrefType(Boolean originalXrefType) {
		this.originalXrefType = originalXrefType;
	}

}
