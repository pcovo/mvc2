package br.com.ccee;

public class CCEERuntimeException extends RuntimeException {

	private static final long serialVersionUID = 5200272127491873210L;

	public CCEERuntimeException() {
		
	}

	public CCEERuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CCEERuntimeException(String message) {
		super(message);
	}

	public CCEERuntimeException(Throwable cause) {
		super(cause);
	}
}