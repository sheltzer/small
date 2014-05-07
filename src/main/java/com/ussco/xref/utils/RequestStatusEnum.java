/**
 * 
 */
package com.ussco.xref.utils;

/**
 * @author larsonr
 *
 */
public enum RequestStatusEnum {
    INITIAL("IN"), ENQUEUED("NQ"), PROCESSING("IP"), COMPLETED("FN"), FAILED("FB");

    private final String code;
    
    RequestStatusEnum(String code) 
    {
        this.code = code;
        
    }//end method

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
    
}//end enum