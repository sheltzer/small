package com.ussco.xref.to;

import java.util.List;

import com.ussco.xref.model.domain.MatchType;
import com.ussco.xref.model.domain.Reseller;
import com.ussco.xref.model.domain.XRefType;

public class BaseReportMatchingTO {
	
	private List<Reseller> resellerList;
	private List<MatchType> matchTypeList;
	private List<XRefType> xrefTypeList;
	
	private List<String> resellerCodes;
	private List<String> xrefCodes;
	private List<String> matchCodes;
	
	private List<String> resellerDescriptions;
	private List<String> xrefDescriptions;
	private List<String> matchDescriptions;
	
	private List<String> leftList;
	private List<String> rightList;
	
	private String leftSelected;
	private String rightSelected;
	
	public List<Reseller> getResellerList() {
		return resellerList;
	}
	public void setResellerList(List<Reseller> resellerList) {
		this.resellerList = resellerList;
	}
	public List<MatchType> getMatchTypeList() {
		return matchTypeList;
	}
	public void setMatchTypeList(List<MatchType> matchTypeList) {
		this.matchTypeList = matchTypeList;
	}
	public List<XRefType> getXrefTypeList() {
		return xrefTypeList;
	}
	public void setXrefTypeList(List<XRefType> xrefTypeList) {
		this.xrefTypeList = xrefTypeList;
	}
	public List<String> getLeftList() {
		return leftList;
	}
	public void setLeftList(List<String> leftList) {
		this.leftList = leftList;
	}
	public List<String> getRightList() {
		return rightList;
	}
	public void setRightList(List<String> rightList) {
		this.rightList = rightList;
	}
	public String getLeftSelected() {
		return leftSelected;
	}
	public void setLeftSelected(String leftSelected) {
		this.leftSelected = leftSelected;
	}
	public String getRightSelected() {
		return rightSelected;
	}
	public void setRightSelected(String rightSelected) {
		this.rightSelected = rightSelected;
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
	public List<String> getResellerDescriptions() {
		return resellerDescriptions;
	}
	public void setResellerDescriptions(List<String> resellerDescriptions) {
		this.resellerDescriptions = resellerDescriptions;
	}
	public List<String> getXrefDescriptions() {
		return xrefDescriptions;
	}
	public void setXrefDescriptions(List<String> xrefDescriptions) {
		this.xrefDescriptions = xrefDescriptions;
	}
	public List<String> getMatchDescriptions() {
		return matchDescriptions;
	}
	public void setMatchDescriptions(List<String> matchDescriptions) {
		this.matchDescriptions = matchDescriptions;
	}
	
}
