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
import java.util.Date;

/**
 * @author Sandy Heltzer
 *
 */
public class ReferItem implements Serializable{
	private static final long serialVersionUID = 2669224466388545637L;

	private String prefixNumber;
	private String stockNumber;
	private String unbuttedStockNumber;
	private String referPrefixNumber;
	private String referStockNumber;
	private String referUnbuttedStockNumber;
	private String usableCode;
	private Date itemEffectiveDate;
	/**
	 * @return the prefixNumber
	 */
	public String getPrefixNumber() {
		return this.prefixNumber;
	}
	/**
	 * @param prefixNumber the prefixNumber to set
	 */
	public void setPrefixNumber(String prefixNumber) {
		this.prefixNumber = prefixNumber;
	}
	/**
	 * @return the stockNumber
	 */
	public String getStockNumber() {
		return this.stockNumber;
	}
	/**
	 * @param stockNumber the stockNumber to set
	 */
	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}
	/**
	 * @return the unbuttedStockNumber
	 */
	public String getUnbuttedStockNumber() {
		return this.unbuttedStockNumber;
	}
	/**
	 * @param unbuttedStockNumber the unbuttedStockNumber to set
	 */
	public void setUnbuttedStockNumber(String unbuttedStockNumber) {
		this.unbuttedStockNumber = unbuttedStockNumber;
	}
	/**
	 * @return the referPrefixNumber
	 */
	public String getReferPrefixNumber() {
		return this.referPrefixNumber;
	}
	/**
	 * @param referPrefixNumber the referPrefixNumber to set
	 */
	public void setReferPrefixNumber(String referPrefixNumber) {
		this.referPrefixNumber = referPrefixNumber;
	}
	/**
	 * @return the referStockNumber
	 */
	public String getReferStockNumber() {
		return this.referStockNumber;
	}
	/**
	 * @param referStockNumber the referStockNumber to set
	 */
	public void setReferStockNumber(String referStockNumber) {
		this.referStockNumber = referStockNumber;
	}
	/**
	 * @return the referUnbuttedStockNumber
	 */
	public String getReferUnbuttedStockNumber() {
		return this.referUnbuttedStockNumber;
	}
	/**
	 * @param referUnbuttedStockNumber the referUnbuttedStockNumber to set
	 */
	public void setReferUnbuttedStockNumber(String referUnbuttedStockNumber) {
		this.referUnbuttedStockNumber = referUnbuttedStockNumber;
	}
	/**
	 * @return the usableCode
	 */
	public String getUsableCode() {
		return this.usableCode;
	}
	/**
	 * @param usableCode the usableCode to set
	 */
	public void setUsableCode(String usableCode) {
		this.usableCode = usableCode;
	}
	/**
	 * @return the itemEffectiveDate
	 */
	public Date getItemEffectiveDate() {
		return this.itemEffectiveDate;
	}
	/**
	 * @param itemEffectiveDate the itemEffectiveDate to set
	 */
	public void setItemEffectiveDate(Date itemEffectiveDate) {
		this.itemEffectiveDate = itemEffectiveDate;
	}

}
