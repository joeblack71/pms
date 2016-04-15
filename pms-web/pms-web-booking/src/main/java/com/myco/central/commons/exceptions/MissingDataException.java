package com.myco.central.commons.exceptions;

/**
 * Esta excepcion se lanza cuando un objeto no cuenta
 * en sus atributos con datos mandatorios para su procesamiento 
 *
 */
public class MissingDataException extends Exception {

	private static final long serialVersionUID = 1L;

	public MissingDataException() {
		super();
	}

	public MissingDataException(String message) {
		System.out.println(message);
	}

	/*public MissingDataException(Throwable cause) {
		super(cause);
	}*/

}
