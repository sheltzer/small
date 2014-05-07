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
package com.ussco.xref.domain;

import java.io.Serializable;

/**
 * @author Sandy Heltzer
 *
 */
public class MatchingCriteria implements Serializable{

	private static final long serialVersionUID = -8234741568726111575L;

	private Object inputFile;
	private Object businessUnit;
	private Object activeOnly;
	private Object resellers;
	private Object xrefTypes;
	private Object additionalFields;
	private Object outputFileName;
	private Object outputFormat;
	private Object matchTypes;
	private Object selectedAdditionalFields;

	/**
	 * @return the inputFile
	 */
	public Object getInputFile() {
		return this.inputFile;
	}
	/**
	 * @param inputFile the inputFile to set
	 */
	public void setInputFile(Object inputFile) {
		this.inputFile = inputFile;
	}
	/**
	 * @return the businessUnit
	 */
	public Object getBusinessUnit() {
		return this.businessUnit;
	}
	/**
	 * @param businessUnit the businessUnit to set
	 */
	public void setBusinessUnit(Object businessUnit) {
		this.businessUnit = businessUnit;
	}
	/**
	 * @return the activeOnly
	 */
	public Object getActiveOnly() {
		return this.activeOnly;
	}
	/**
	 * @param activeOnly the activeOnly to set
	 */
	public void setActiveOnly(Object activeOnly) {
		this.activeOnly = activeOnly;
	}
	/**
	 * @return the resellers
	 */
	public Object getResellers() {
		return this.resellers;
	}
	/**
	 * @param resellers the resellers to set
	 */
	public void setResellers(Object resellers) {
		this.resellers = resellers;
	}
	/**
	 * @return the xrefTypes
	 */
	public Object getXrefTypes() {
		return this.xrefTypes;
	}
	/**
	 * @param xrefTypes the xrefTypes to set
	 */
	public void setXrefTypes(Object xrefTypes) {
		this.xrefTypes = xrefTypes;
	}
	/**
	 * @return the additionalFields
	 */
	public Object getAdditionalFields() {
		return this.additionalFields;
	}
	/**
	 * @param additionalFields the additionalFields to set
	 */
	public void setAdditionalFields(Object additionalFields) {
		this.additionalFields = additionalFields;
	}
	/**
	 * @return the outputFileName
	 */
	public Object getOutputFileName() {
		return this.outputFileName;
	}
	/**
	 * @param outputFileName the outputFileName to set
	 */
	public void setOutputFileName(Object outputFileName) {
		this.outputFileName = outputFileName;
	}
	/**
	 * @return the outputFormat
	 */
	public Object getOutputFormat() {
		return this.outputFormat;
	}
	/**
	 * @param outputFormat the outputFormat to set
	 */
	public void setOutputFormat(Object outputFormat) {
		this.outputFormat = outputFormat;
	}
	/**
	 * @return the matchTypes
	 */
	public Object getMatchTypes() {
		return this.matchTypes;
	}
	/**
	 * @param matchTypes the matchTypes to set
	 */
	public void setMatchTypes(Object matchTypes) {
		this.matchTypes = matchTypes;
	}
	/**
	 * @return the selectedAdditionalFields
	 */
	public Object getSelectedAdditionalFields() {
		return this.selectedAdditionalFields;
	}
	/**
	 * @param selectedAdditionalFields the selectedAdditionalFields to set
	 */
	public void setSelectedAdditionalFields(Object selectedAdditionalFields) {
		this.selectedAdditionalFields = selectedAdditionalFields;
	}

	}
