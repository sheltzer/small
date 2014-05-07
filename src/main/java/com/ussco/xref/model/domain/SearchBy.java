/**
 * SearchByCriteria.java
 */
package com.ussco.xref.model.domain;

import java.io.Serializable;

/**
 * @author larsonb
 *
 */
public class SearchBy implements Serializable 
{
	private static final long serialVersionUID = -7683687380235777901L;

	private String label;
	private String id;
	
	
	public SearchBy(final String  display, final String code)
	{
		this.label = display;
		this.id = code;
		
	}
	
	/**
	 * @return the display
	 */
	public String getDisplay() {
		return label;
	}
	/**
	 * @param display the display to set
	 */
	public void setDisplay(String display) {
		this.label = display;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return id;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.id = code;
	}
	
	
}