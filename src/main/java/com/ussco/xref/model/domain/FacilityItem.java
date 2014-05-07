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
public class FacilityItem implements Serializable{
	private static final long serialVersionUID = -1259238864266917500L;
	private String prefix;
	private String stockNumber;
	private Date facItemStartDate;
	private String facilityNumber;
	private Date facItemEndDate;
	private String productNumber;
	private String boxUnitCode;
	private Double boxPackQuantity;
	private Double cartonPackQuantity;
	private String cartonPackUnitCode;
	private Double cartonWeightQuantity;
	private Double cartonHeightQuantity;
	private Double cartonDepthQuantity;
	private Double cartonWidthQuantity;
	private String shipClassCode;
	private String vendorNumber;
	private String vendorShortName;
	private Double boxDepthQuantity;
	private Double boxHeightQuantity;
	private Double boxWidthQuantity;
	private Double expandedCartonWeight;
	private Double expandedBoxWeight;
	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return this.prefix;
	}
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
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
	 * @return the facItemStartDate
	 */
	public Date getFacItemStartDate() {
		return this.facItemStartDate;
	}
	/**
	 * @param facItemStartDate the facItemStartDate to set
	 */
	public void setFacItemStartDate(Date facItemStartDate) {
		this.facItemStartDate = facItemStartDate;
	}
	/**
	 * @return the facilityNumber
	 */
	public String getFacilityNumber() {
		return this.facilityNumber;
	}
	/**
	 * @param facilityNumber the facilityNumber to set
	 */
	public void setFacilityNumber(String facilityNumber) {
		this.facilityNumber = facilityNumber;
	}
	/**
	 * @return the facItemEndDate
	 */
	public Date getFacItemEndDate() {
		return this.facItemEndDate;
	}
	/**
	 * @param facItemEndDate the facItemEndDate to set
	 */
	public void setFacItemEndDate(Date facItemEndDate) {
		this.facItemEndDate = facItemEndDate;
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
	 * @return the boxUnitCode
	 */
	public String getBoxUnitCode() {
		return this.boxUnitCode;
	}
	/**
	 * @param boxUnitCode the boxUnitCode to set
	 */
	public void setBoxUnitCode(String boxUnitCode) {
		this.boxUnitCode = boxUnitCode;
	}
	/**
	 * @return the boxPackQuantity
	 */
	public Double getBoxPackQuantity() {
		return this.boxPackQuantity;
	}
	/**
	 * @param boxPackQuantity the boxPackQuantity to set
	 */
	public void setBoxPackQuantity(Double boxPackQuantity) {
		this.boxPackQuantity = boxPackQuantity;
	}
	/**
	 * @return the cartonPackQuantity
	 */
	public Double getCartonPackQuantity() {
		return this.cartonPackQuantity;
	}
	/**
	 * @param cartonPackQuantity the cartonPackQuantity to set
	 */
	public void setCartonPackQuantity(Double cartonPackQuantity) {
		this.cartonPackQuantity = cartonPackQuantity;
	}
	/**
	 * @return the cartonPackUnitCode
	 */
	public String getCartonPackUnitCode() {
		return this.cartonPackUnitCode;
	}
	/**
	 * @param cartonPackUnitCode the cartonPackUnitCode to set
	 */
	public void setCartonPackUnitCode(String cartonPackUnitCode) {
		this.cartonPackUnitCode = cartonPackUnitCode;
	}
	/**
	 * @return the cartonWeightQuantity
	 */
	public Double getCartonWeightQuantity() {
		return this.cartonWeightQuantity;
	}
	/**
	 * @param cartonWeightQuantity the cartonWeightQuantity to set
	 */
	public void setCartonWeightQuantity(Double cartonWeightQuantity) {
		this.cartonWeightQuantity = cartonWeightQuantity;
	}
	/**
	 * @return the cartonHeightQuantity
	 */
	public Double getCartonHeightQuantity() {
		return this.cartonHeightQuantity;
	}
	/**
	 * @param cartonHeightQuantity the cartonHeightQuantity to set
	 */
	public void setCartonHeightQuantity(Double cartonHeightQuantity) {
		this.cartonHeightQuantity = cartonHeightQuantity;
	}
	/**
	 * @return the cartonDepthQuantity
	 */
	public Double getCartonDepthQuantity() {
		return this.cartonDepthQuantity;
	}
	/**
	 * @param cartonDepthQuantity the cartonDepthQuantity to set
	 */
	public void setCartonDepthQuantity(Double cartonDepthQuantity) {
		this.cartonDepthQuantity = cartonDepthQuantity;
	}
	/**
	 * @return the cartonWidthQuantity
	 */
	public Double getCartonWidthQuantity() {
		return this.cartonWidthQuantity;
	}
	/**
	 * @param cartonWidthQuantity the cartonWidthQuantity to set
	 */
	public void setCartonWidthQuantity(Double cartonWidthQuantity) {
		this.cartonWidthQuantity = cartonWidthQuantity;
	}
	/**
	 * @return the shipClassCode
	 */
	public String getShipClassCode() {
		return this.shipClassCode;
	}
	/**
	 * @param shipClassCode the shipClassCode to set
	 */
	public void setShipClassCode(String shipClassCode) {
		this.shipClassCode = shipClassCode;
	}
	/**
	 * @return the vendorNumber
	 */
	public String getVendorNumber() {
		return this.vendorNumber;
	}
	/**
	 * @param vendorNumber the vendorNumber to set
	 */
	public void setVendorNumber(String vendorNumber) {
		this.vendorNumber = vendorNumber;
	}
	/**
	 * @return the vendorShortName
	 */
	public String getVendorShortName() {
		return this.vendorShortName;
	}
	/**
	 * @param vendorShortName the vendorShortName to set
	 */
	public void setVendorShortName(String vendorShortName) {
		this.vendorShortName = vendorShortName;
	}
	/**
	 * @return the boxDepthQuantity
	 */
	public Double getBoxDepthQuantity() {
		return this.boxDepthQuantity;
	}
	/**
	 * @param boxDepthQuantity the boxDepthQuantity to set
	 */
	public void setBoxDepthQuantity(Double boxDepthQuantity) {
		this.boxDepthQuantity = boxDepthQuantity;
	}
	/**
	 * @return the boxHeightQuantity
	 */
	public Double getBoxHeightQuantity() {
		return this.boxHeightQuantity;
	}
	/**
	 * @param boxHeightQuantity the boxHeightQuantity to set
	 */
	public void setBoxHeightQuantity(Double boxHeightQuantity) {
		this.boxHeightQuantity = boxHeightQuantity;
	}
	/**
	 * @return the boxWidthQuantity
	 */
	public Double getBoxWidthQuantity() {
		return this.boxWidthQuantity;
	}
	/**
	 * @param boxWidthQuantity the boxWidthQuantity to set
	 */
	public void setBoxWidthQuantity(Double boxWidthQuantity) {
		this.boxWidthQuantity = boxWidthQuantity;
	}
	/**
	 * @return the expandedCartonWeight
	 */
	public Double getExpandedCartonWeight() {
		return this.expandedCartonWeight;
	}
	/**
	 * @param expandedCartonWeight the expandedCartonWeight to set
	 */
	public void setExpandedCartonWeight(Double expandedCartonWeight) {
		this.expandedCartonWeight = expandedCartonWeight;
	}
	/**
	 * @return the expandedBoxWeight
	 */
	public Double getExpandedBoxWeight() {
		return this.expandedBoxWeight;
	}
	/**
	 * @param expandedBoxWeight the expandedBoxWeight to set
	 */
	public void setExpandedBoxWeight(Double expandedBoxWeight) {
		this.expandedBoxWeight = expandedBoxWeight;
	}
}
