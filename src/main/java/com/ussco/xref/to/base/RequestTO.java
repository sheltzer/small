package com.ussco.xref.to.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ussco.xref.utils.RequestStatusEnum;
import com.ussco.xref.utils.RequestTypeEnum;

public class RequestTO implements java.io.Serializable, Cloneable {

	private static final long serialVersionUID = -684507666052547166L;
	private static Logger log = Logger.getLogger(RequestTO.class);

	private String userId;
	private String emailAddress;
	private String inputFileName;
	private String outputFileName;
	private String fileName;
	private String outputFileExtension;
	private String requestTypeString;
	private String statusCodeString;
	private RequestTypeEnum requestType;
	private RequestStatusEnum statusCode;
	private Integer requestId;
	private Date requestDateTime;
	private String formattedReqDate;
	private String inputFileType;
	private String inputFilePath;
	private String outputFilePath;
	private String errorTextDescription;
	protected String tagText = "";
	private String companyId;
	private String companyName;

	@Override
	public Object clone() {
		try {
			RequestTO to = (RequestTO) super.clone();
			to.setUserId(this.userId);
			to.setEmailAddress(this.emailAddress);
			to.setInputFileName(this.inputFileName);
			to.setOutputFileName(this.outputFileName);
			to.setFileName(this.fileName);
			to.setOutputFileExtension(this.outputFileExtension);
			to.setCompanyId(this.companyId);
			to.setCompanyName(this.companyName);
			to.setRequestTypeString(this.requestTypeString);
			to.setStatusCodeString(this.statusCodeString);
			to.setRequestType(this.getRequestType());
			to.setStatusCode(this.getStatusCode());
			to.setRequestId(this.requestId);
			to.setRequestDateTime(this.requestDateTime);
			to.setInputFileType(this.inputFileType);
			to.setInputFilePath(this.inputFilePath);
			to.setOutputFilePath(this.outputFilePath);
			to.setErrorTextDescription(this.errorTextDescription);
			return to;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	public String getTagText() {
		return this.tagText;
	}

	public void setTagText(String tagText) {
		this.tagText = tagText;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAdd) {
		this.emailAddress = emailAdd;
	}

	public Date getRequestDateTime() {
		return this.requestDateTime;
	}

	public void setRequestDateTime(Date requestDateTime) {
		this.requestDateTime = requestDateTime;

		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
		this.formattedReqDate = dt.format(requestDateTime);
	}

	public String getInputFileName() {
		return this.inputFileName;
	}

	public void setInputFileName(String inFileLoc) {
		this.inputFileName = inFileLoc;
	}

	public String getOutputFileName() {
		return this.outputFileName;
	}

	public void setOutputFileName(String opFileLoc) {
		this.outputFileName = opFileLoc;
	}

	public RequestTypeEnum getRequestType() {
		return this.requestType;
	}

	public void setRequestType(RequestTypeEnum requestType) {
		this.requestType = requestType;
	}

	public RequestStatusEnum getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(RequestStatusEnum statusCode) {
		this.statusCode = statusCode;
	}

	public Integer getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public String getRequestTypeString() {
		return this.requestTypeString;
	}

	public void setRequestTypeString(String requestTypeString) {
		this.requestTypeString = requestTypeString;
	}

	public String getStatusCodeString() {
		return this.statusCodeString;
	}

	public void setStatusCodeString(String statusCodeString) {
		this.statusCodeString = statusCodeString;
	}

	public void setRequestTypeEnum(String requestTypeString) {
		this.requestType = RequestTypeEnum.valueOf(requestTypeString);
	}

	public void setStatusCodeEnum(String statusCodeString) {
		if (log.isDebugEnabled()) {
			log.debug("Code: " + RequestStatusEnum.valueOf(statusCodeString));
		}
		this.statusCode = RequestStatusEnum.valueOf(statusCodeString);
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("  userId; " + this.userId);

		str.append("  emailAdd; " + this.emailAddress);
		str.append("  inputFileName; " + this.inputFileName);
		str.append("  outputFileName; " + this.outputFileName);
		str.append("  companyId; " + this.companyId);
		str.append("  companyName; " + this.companyName);
		str.append("  requestTypeString; " + this.requestTypeString);
		str.append("  statusCodeString; " + this.statusCodeString);
		str.append("  requestType; " + this.requestType);
		str.append("  requestId; " + this.requestId);
		str.append("  statusCode; " + this.statusCode);
		str.append("  requestDateTime; " + this.requestDateTime);
		str.append("  outputFilePath; " + this.outputFilePath);
		str.append("  errorTextDescription; " + this.errorTextDescription);

		return str.toString();
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setOutputFileExtension(String outputFileExtension) {
		this.outputFileExtension = outputFileExtension;
	}

	public String getOutputFileExtension() {
		return this.outputFileExtension;
	}

	public String getInputFileType() {
		return this.inputFileType;
	}

	public void setInputFileType(String inputFileType) {
		this.inputFileType = inputFileType;
	}

	/**
	 * @return the inputFilePath
	 */
	public String getInputFilePath() {
		return this.inputFilePath;
	}

	/**
	 * @param inputFilePath
	 *            the inputFilePath to set
	 */
	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}

	/**
	 * @return the outputFilePath
	 */
	public String getOutputFilePath() {
		return this.outputFilePath;
	}

	/**
	 * @param outputFilePath
	 *            the outputFilePath to set
	 */
	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	public String getErrorTextDescription() {
		return this.errorTextDescription;
	}

	public void setErrorTextDescription(String errorText) {
		this.errorTextDescription = errorText;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the formattedReqDate
	 */
	public String getFormattedReqDate() {
		return this.formattedReqDate;
	}

	/**
	 * @param formattedReqDate the formattedReqDate to set
	 */
	public void setFormattedReqDate(String formattedReqDate) {
		this.formattedReqDate = formattedReqDate;
	}



}// end class
