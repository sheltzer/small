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
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sandy Heltzer
 *
 */
public class ItemCrossReference implements Serializable{
	private static final long serialVersionUID = 2822582064534368210L;

	private BigInteger id;
	private String prefixNumber;
	private String extendedStockNumber;
	private String extendedItemNumber;
	private Reseller reseller;
	private String resellerPrefixNumber;
	private String resellerStockNumber;
	private String resellerItemNumber;
	private String resellerNationalStockNumber;
	private String resellerDescription;
	private String resellerUpcCode;
	private String resellerUomCode;
	private String xrefResellerUomCode;
	private String xrefUomCode;
	private MatchType matchType;
	private XRefType xrefType;
	private String comments;
	private String userId;
	private Date lastUpdateDate;
	private String companyId;
	private String resellerUnbuttedExtendedStockNumber;
	private Date creationDate;
	private String adminAccessCode;
	private Double inventoryUnitConversionQuantity;
	private Integer resellerUomQuantity;
	private Integer xrefResellerUomQuantity;
	private String formattedLastModifiedDate;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return this.id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
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
	 * @return the extendedStockNumber
	 */
	public String getExtendedStockNumber() {
		return this.extendedStockNumber;
	}
	/**
	 * @param extendedStockNumber the extendedStockNumber to set
	 */
	public void setExtendedStockNumber(String extendedStockNumber) {
		this.extendedStockNumber = extendedStockNumber;
	}
	/**
	 * @return the extendedItemNumber
	 */
	public String getExtendedItemNumber() {
		return this.extendedItemNumber;
	}
	/**
	 * @param extendedItemNumber the extendedItemNumber to set
	 */
	public void setExtendedItemNumber(String extendedItemNumber) {
		this.extendedItemNumber = extendedItemNumber;
	}
	/**
	 * @return the reseller
	 */
	public Reseller getReseller() {
		return this.reseller;
	}
	/**
	 * @param reseller the reseller to set
	 */
	public void setReseller(Reseller reseller) {
		this.reseller = reseller;
	}
	/**
	 * @return the resellerPrefixNumber
	 */
	public String getResellerPrefixNumber() {
		return this.resellerPrefixNumber;
	}
	/**
	 * @param resellerPrefixNumber the resellerPrefixNumber to set
	 */
	public void setResellerPrefixNumber(String resellerPrefixNumber) {
		this.resellerPrefixNumber = resellerPrefixNumber;
	}
	/**
	 * @return the resellerStockNumber
	 */
	public String getResellerStockNumber() {
		return this.resellerStockNumber;
	}
	/**
	 * @param resellerStockNumber the resellerStockNumber to set
	 */
	public void setResellerStockNumber(String resellerStockNumber) {
		this.resellerStockNumber = resellerStockNumber;
	}
	/**
	 * @return the resellerItemNumber
	 */
	public String getResellerItemNumber() {
		return this.resellerItemNumber;
	}
	/**
	 * @param resellerItemNumber the resellerItemNumber to set
	 */
	public void setResellerItemNumber(String resellerItemNumber) {
		this.resellerItemNumber = resellerItemNumber;
	}
	/**
	 * @return the resellerNationalStockNumber
	 */
	public String getResellerNationalStockNumber() {
		return this.resellerNationalStockNumber;
	}
	/**
	 * @param resellerNationalStockNumber the resellerNationalStockNumber to set
	 */
	public void setResellerNationalStockNumber(String resellerNationalStockNumber) {
		this.resellerNationalStockNumber = resellerNationalStockNumber;
	}
	/**
	 * @return the resellerDescription
	 */
	public String getResellerDescription() {
		return this.resellerDescription;
	}
	/**
	 * @param resellerDescription the resellerDescription to set
	 */
	public void setResellerDescription(String resellerDescription) {
		this.resellerDescription = resellerDescription;
	}
	/**
	 * @return the resellerUpcCode
	 */
	public String getResellerUpcCode() {
		return this.resellerUpcCode;
	}
	/**
	 * @param resellerUpcCode the resellerUpcCode to set
	 */
	public void setResellerUpcCode(String resellerUpcCode) {
		this.resellerUpcCode = resellerUpcCode;
	}
	/**
	 * @return the resellerUomCode
	 */
	public String getResellerUomCode() {
		return this.resellerUomCode;
	}
	/**
	 * @param resellerUomCode the resellerUomCode to set
	 */
	public void setResellerUomCode(String resellerUomCode) {
		this.resellerUomCode = resellerUomCode;
	}
	/**
	 * @return the xrefResellerUomCode
	 */
	public String getXrefResellerUomCode() {
		return this.xrefResellerUomCode;
	}
	/**
	 * @param xrefResellerUomCode the xrefResellerUomCode to set
	 */
	public void setXrefResellerUomCode(String xrefResellerUomCode) {
		this.xrefResellerUomCode = xrefResellerUomCode;
	}
	/**
	 * @return the xrefUomCode
	 */
	public String getXrefUomCode() {
		return this.xrefUomCode;
	}
	/**
	 * @param xrefUomCode the xrefUomCode to set
	 */
	public void setXrefUomCode(String xrefUomCode) {
		this.xrefUomCode = xrefUomCode;
	}
	/**
	 * @return the matchType
	 */
	public MatchType getMatchType() {
		return this.matchType;
	}
	/**
	 * @param matchType the matchType to set
	 */
	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}
	/**
	 * @return the xrefType
	 */
	public XRefType getXrefType() {
		return this.xrefType;
	}
	/**
	 * @param xrefType the xrefType to set
	 */
	public void setXrefType(XRefType xrefType) {
		this.xrefType = xrefType;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return this.comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return this.userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}
	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;

		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
		this.formattedLastModifiedDate = dt.format(lastUpdateDate);
	}
	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return this.companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the resellerUnbuttedExtendedStockNumber
	 */
	public String getResellerUnbuttedExtendedStockNumber() {
		return this.resellerUnbuttedExtendedStockNumber;
	}
	/**
	 * @param resellerUnbuttedExtendedStockNumber the resellerUnbuttedExtendedStockNumber to set
	 */
	public void setResellerUnbuttedExtendedStockNumber(
			String resellerUnbuttedExtendedStockNumber) {
		this.resellerUnbuttedExtendedStockNumber = resellerUnbuttedExtendedStockNumber;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the adminAccessCode
	 */
	public String getAdminAccessCode() {
		return this.adminAccessCode;
	}
	/**
	 * @param adminAccessCode the adminAccessCode to set
	 */
	public void setAdminAccessCode(String adminAccessCode) {
		this.adminAccessCode = adminAccessCode;
	}
	/**
	 * @return the inventoryUnitConversionQuantity
	 */
	public Double getInventoryUnitConversionQuantity() {
		return this.inventoryUnitConversionQuantity;
	}
	/**
	 * @param inventoryUnitConversionQuantity the inventoryUnitConversionQuantity to set
	 */
	public void setInventoryUnitConversionQuantity(
			Double inventoryUnitConversionQuantity) {
		this.inventoryUnitConversionQuantity = inventoryUnitConversionQuantity;
	}
	/**
	 * @return the resellerUomQuantity
	 */
	public Integer getResellerUomQuantity() {
		return this.resellerUomQuantity;
	}
	/**
	 * @param resellerUomQuantity the resellerUomQuantity to set
	 */
	public void setResellerUomQuantity(Integer resellerUomQuantity) {
		this.resellerUomQuantity = resellerUomQuantity;
	}
	/**
	 * @return the xrefResellerUomQuantity
	 */
	public Integer getXrefResellerUomQuantity() {
		return this.xrefResellerUomQuantity;
	}
	/**
	 * @param xrefResellerUomQuantity the xrefResellerUomQuantity to set
	 */
	public void setXrefResellerUomQuantity(Integer xrefResellerUomQuantity) {
		this.xrefResellerUomQuantity = xrefResellerUomQuantity;
	}
	/**
	 * @return the formattedLastModifiedDate
	 */
	public String getFormattedLastModifiedDate() {
		return this.formattedLastModifiedDate;
	}
	/**
	 * @param formattedLastModifiedDate the formattedLastModifiedDate to set
	 */
	public void setFormattedLastModifiedDate(String formattedLastModifiedDate) {
		this.formattedLastModifiedDate = formattedLastModifiedDate;
	}
}
