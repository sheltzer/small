package com.ussco.xref.exception;

public class SystemException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 2926562046833058635L;
	private String userDisplayMessage;

	public SystemException(String arg0,String userDisplayMessage ) {
		super(arg0);
		this.userDisplayMessage=userDisplayMessage;
	}
	public SystemException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}



	public String getUserDisplayMessage() {
		return this.userDisplayMessage;
	}

}
