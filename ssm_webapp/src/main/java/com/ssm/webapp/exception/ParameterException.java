

package com.ssm.webapp.exception;

/**
 * 参数异常 throw new ParameterException("XXXX")
 */

public class ParameterException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 6417641452178955756L;
	
	private String code;

	public ParameterException() {
		super();
	}

	public ParameterException(String message) {
		super(message);
	}
	
	public ParameterException(String code, String message) {
		super(message);
		this.code = code;
	}

	public ParameterException(Throwable cause) {
		super(cause);
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ParameterException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
