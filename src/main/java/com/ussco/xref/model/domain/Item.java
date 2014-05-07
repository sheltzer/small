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
public class Item implements Serializable{

	private static final long serialVersionUID = 2139377450032844921L;

	private String itemNumber;
	private String activeIndicator;
	private String description;
	private String uom;
	private String uomQuantity;
	private String productNumber;
	private String cartonGtin;
	private String palletGtin;
	private String boxGtin;
	private String itemGtin;
	private String unbuttedStockNumber;
	private FacilityItem currentGlobalFacilityItem;
	private Integer minimumOrderQuantity;
	private Double conversionFactor;

	/**
	 * @return the itemNumber
	 */
	public String getItemNumber() {
		return this.itemNumber;
	}
	/**
	 * @param itemNumber the itemNumber to set
	 */
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	/**
	 * @return the activeIndicator
	 */
	public String getActiveIndicator() {
		return this.activeIndicator;
	}
	/**
	 * @param activeIndicator the activeIndicator to set
	 */
	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the uom
	 */
	public String getUom() {
		return this.uom;
	}
	/**
	 * @param uom the uom to set
	 */
	public void setUom(String uom) {
		this.uom = uom;
	}
	/**
	 * @return the uomQuantity
	 */
	public String getUomQuantity() {
		return this.uomQuantity;
	}
	/**
	 * @param uomQuantity the uomQuantity to set
	 */
	public void setUomQuantity(String uomQuantity) {
		this.uomQuantity = uomQuantity;
	}
	/**
	 * @return the productNumber
	 */
	public String getProductNumber() {
		return this.productNumber;
	}
	/**
	 * @param productNumber the productNumber to set
	 */
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	/**
	 * @return the cartonGtin
	 */
	public String getCartonGtin() {
		return this.cartonGtin;
	}
	/**
	 * @param cartonGtin the cartonGtin to set
	 */
	public void setCartonGtin(String cartonGtin) {
		this.cartonGtin = cartonGtin;
	}
	/**
	 * @return the palletGtin
	 */
	public String getPalletGtin() {
		return this.palletGtin;
	}
	/**
	 * @param palletGtin the palletGtin to set
	 */
	public void setPalletGtin(String palletGtin) {
		this.palletGtin = palletGtin;
	}
	/**
	 * @return the boxGtin
	 */
	public String getBoxGtin() {
		return this.boxGtin;
	}
	/**
	 * @param boxGtin the boxGtin to set
	 */
	public void setBoxGtin(String boxGtin) {
		this.boxGtin = boxGtin;
	}
	/**
	 * @return the itemGtin
	 */
	public String getItemGtin() {
		return this.itemGtin;
	}
	/**
	 * @param itemGtin the itemGtin to set
	 */
	public void setItemGtin(String itemGtin) {
		this.itemGtin = itemGtin;
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
	 * @return the currentGlobalFacilityItem
	 */
	public FacilityItem getCurrentGlobalFacilityItem() {
		return this.currentGlobalFacilityItem;
	}
	/**
	 * @param currentGlobalFacilityItem the currentGlobalFacilityItem to set
	 */
	public void setCurrentGlobalFacilityItem(FacilityItem currentGlobalFacilityItem) {
		this.currentGlobalFacilityItem = currentGlobalFacilityItem;
	}
	/**
	 * @return the minimumOrderQuantity
	 */
	public Integer getMinimumOrderQuantity() {
		return this.minimumOrderQuantity;
	}
	/**
	 * @param minimumOrderQuantity the minimumOrderQuantity to set
	 */
	public void setMinimumOrderQuantity(Integer minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}
	/**
	 * @return the conversionFactor
	 */
	public Double getConversionFactor() {
		return this.conversionFactor;
	}
	/**
	 * @param conversionFactor the conversionFactor to set
	 */
	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

}
