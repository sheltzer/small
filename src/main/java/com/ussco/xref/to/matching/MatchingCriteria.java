package com.ussco.xref.to.matching;

import java.util.List;

public class MatchingCriteria {

	private String searchOnId;
	private String searchOnValue;
	
	private List<String> matchCodes;
	private List<String> xrefCodes;
	private List<String> resellerCodes;
	private List<String> extraFields;
	private List<String> itemFields;
	private List<String> facItemFields;
	private List<String> catlDetlFields;
	private String companyId;
	private boolean activeOnly;
	
	public String getSearchOnId() {
		return searchOnId;
	}
	public void setSearchOnId(String searchOnId) {
		this.searchOnId = searchOnId;
	}
	public String getSearchOnValue() {
		return searchOnValue;
	}
	public void setSearchOnValue(String searchOnValue) {
		this.searchOnValue = searchOnValue;
	}
	public List<String> getMatchCodes() {
		return matchCodes;
	}
	public void setMatchCodes(List<String> matchCodes) {
		this.matchCodes = matchCodes;
	}
	public List<String> getXrefCodes() {
		return xrefCodes;
	}
	public void setXrefCodes(List<String> xrefCodes) {
		this.xrefCodes = xrefCodes;
	}
	public List<String> getResellerCodes() {
		return resellerCodes;
	}
	public void setResellerCodes(List<String> resellerCodes) {
		this.resellerCodes = resellerCodes;
	}
	public void setExtraFields(List<String> extraFields) {
		this.extraFields = extraFields;
	}
	public List<String> getExtraFields() {
		return extraFields;
	}
	public void setActiveOnly(boolean activeOnly) {
		this.activeOnly = activeOnly;
	}
	public boolean isActiveOnly() {
		return activeOnly;
	}
	
	public String getActiveOnlyAsString() {
		if (activeOnly) {
			return "Y";
		} else {
			return "N";
		}		
	}
	public List<String> getItemFields() {
		return itemFields;
	}
	public void setItemFields(List<String> itemFields) {
		this.itemFields = itemFields;
	}
	public List<String> getFacItemFields() {
		return facItemFields;
	}
	public void setFacItemFields(List<String> facItemFields) {
		this.facItemFields = facItemFields;
	}
	public List<String> getCatlDetlFields() {
		return catlDetlFields;
	}
	public void setCatlDetlFields(List<String> catlDetlFields) {
		this.catlDetlFields = catlDetlFields;
	}		
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(super.toString());
		strBuilder.append("  searchOnId :" + searchOnId);
		strBuilder.append("  searchOnValue :" + searchOnValue);
		strBuilder.append("  matchCodes :" + matchCodes);
		strBuilder.append("  xrefCodes :" + xrefCodes);
		strBuilder.append("  resellerCodes :" + resellerCodes);
		strBuilder.append("  extraFields :" + extraFields);
		strBuilder.append("  itemFields :" + itemFields);
		strBuilder.append("  facItemFields :" + facItemFields);
		strBuilder.append("  catlDetlFields :" + catlDetlFields);
		strBuilder.append("  companyId :" + companyId);
		return strBuilder.toString();
	}
	
	
}
