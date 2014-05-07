package com.ussco.xref.to.matching;

import java.util.ArrayList;
import java.util.List;

import com.ussco.xref.to.base.RequestTO;
import com.ussco.xref.utils.OutputTypeEnum;

public class MatchingTO extends RequestTO implements Cloneable{

	private static final long serialVersionUID = -2412064456428057288L;
	private String fileLocation;
	private String matchBy;
	
	private List<String> resellerCodes;
	private List<String> xrefCodes;
	private List<String> matchCodes;
	private List<String> extraFields;
	
	private boolean activeOnly;
	
	private OutputTypeEnum outputType;
	
	public Object clone() {
		MatchingTO matchTO = (MatchingTO) super.clone();
		
		List<String> list = new ArrayList<String>();
		list.addAll(resellerCodes);
		matchTO.setResellerCodes(list);

		list = new ArrayList<String>();
		list.addAll(xrefCodes);
		matchTO.setXrefCodes(list);
		
		list = new ArrayList<String>();
		list.addAll(matchCodes);
		matchTO.setMatchCodes(list);
		
		list = new ArrayList<String>();
		list.addAll(extraFields);
		matchTO.setExtraFields(list);
		
		matchTO.setFileLocation(fileLocation);
		matchTO.setMatchBy(matchBy);
		matchTO.setActiveOnly(activeOnly);
		matchTO.setOutputType(outputType);
		
		
		return matchTO;
    }
	
	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getMatchBy() {
		return matchBy;
	}

	public void setMatchBy(String matchBy) {
		this.matchBy = matchBy;
	}

	public List<String> getResellerCodes() {
		return resellerCodes;
	}

	public void setResellerCodes(List<String> resellerCodes) {
		this.resellerCodes = resellerCodes;
	}

	public List<String> getXrefCodes() {
		return xrefCodes;
	}

	public void setXrefCodes(List<String> xrefCodes) {
		this.xrefCodes = xrefCodes;
	}

	public List<String> getMatchCodes() {
		return matchCodes;
	}

	public void setMatchCodes(List<String> matchCodes) {
		this.matchCodes = matchCodes;
	}

	public List<String> getExtraFields() {
		return extraFields;
	}

	public void setExtraFields(List<String> extraFields) {
		this.extraFields = extraFields;
	}

	public OutputTypeEnum getOutputType() {
		return outputType;
	}

	public void setOutputType(OutputTypeEnum outputType) {
		this.outputType = outputType;
	}

	public boolean isActiveOnly() {
		return activeOnly;
	}

	public void setActiveOnly(boolean activeOnly) {
		this.activeOnly = activeOnly;
	}
			
	
	public String toString() {
		
		StringBuffer str = new StringBuffer();
	
		str.append("  fileLocation; " + fileLocation);
		str.append("  matchBy " + matchBy);
		str.append("  resellerCodes; " + resellerCodes);
		str.append("  xrefCodes; " + xrefCodes);
		str.append("  matchCodes; " + matchCodes);
		str.append("  extraFields; " + extraFields);
		str.append("  activeOnly; " + activeOnly);
		str.append("  outputType; " + outputType);
		str.append(  super.toString());
	return str.toString();
	}
	
	
}
