/**
 * 
 */
package com.ussco.xref.utils;

/**
 * @author larsonb
 *
 */
public enum ResellerTypeEnum 
{
	RESELLER("N"), 
	CUSTOMER("Y");
	
	private String resellerTypeCode;
	
	private ResellerTypeEnum(String code)
	{
		this.resellerTypeCode =  code;
	}

	/**
	 * @return the resellerTypeCode
	 */
	public String getResellerTypeCode() {
		return resellerTypeCode;
	}
	
}