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
package com.ussco.xref.model.domain;

import java.io.Serializable;

/**
 * @author Sandy Heltzer
 *
 */
public class AdditionalField implements Serializable {
	private static final long serialVersionUID = -9200542857053580504L;
	private String label;
	private String id;

	/**
	 * @return the label
	 */
	public String getLabel() {
		return this.label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
