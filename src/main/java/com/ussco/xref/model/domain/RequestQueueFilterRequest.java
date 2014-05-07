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

/**
 * @author Sandy Heltzer
 *
 */
public class RequestQueueFilterRequest extends PagingRequest {
	private static final long serialVersionUID = -648793450902373227L;

	private String primaryFilterName;
	private String[] sortFilterName;
	private boolean advancedFiltersEnabled;
	private String[] userFilterNames;
	private String[] typeFilterNames;
	private String[] busUnitFilterNames;

	/**
	 * @return the primaryFilterName
	 */
	public String getPrimaryFilterName() {
		return this.primaryFilterName;
	}
	/**
	 * @param primaryFilterName the primaryFilterName to set
	 */
	public void setPrimaryFilterName(String primaryFilterName) {
		this.primaryFilterName = primaryFilterName;
	}
	/**
	 * @return the sortFilterName
	 */
	public String[] getSortFilterName() {
		return this.sortFilterName;
	}
	/**
	 * @param sortFilterName the sortFilterName to set
	 */
	public void setSortFilterName(String[] sortFilterName) {
		this.sortFilterName = sortFilterName;
	}
	/**
	 * @return the advancedFiltersEnabled
	 */
	public boolean isAdvancedFiltersEnabled() {
		return this.advancedFiltersEnabled;
	}
	/**
	 * @param advancedFiltersEnabled the advancedFiltersEnabled to set
	 */
	public void setAdvancedFiltersEnabled(boolean advancedFiltersEnabled) {
		this.advancedFiltersEnabled = advancedFiltersEnabled;
	}
	/**
	 * @return the userFilterNames
	 */
	public String[] getUserFilterNames() {
		return this.userFilterNames;
	}
	/**
	 * @param userFilterNames the userFilterNames to set
	 */
	public void setUserFilterNames(String[] userFilterNames) {
		this.userFilterNames = userFilterNames;
	}
	/**
	 * @return the typeFilterNames
	 */
	public String[] getTypeFilterNames() {
		return this.typeFilterNames;
	}
	/**
	 * @param typeFilterNames the typeFilterNames to set
	 */
	public void setTypeFilterNames(String[] typeFilterNames) {
		this.typeFilterNames = typeFilterNames;
	}
	/**
	 * @return the busUnitFilterNames
	 */
	public String[] getBusUnitFilterNames() {
		return this.busUnitFilterNames;
	}
	/**
	 * @param busUnitFilterNames the busUnitFilterNames to set
	 */
	public void setBusUnitFilterNames(String[] busUnitFilterNames) {
		this.busUnitFilterNames = busUnitFilterNames;
	}
}
