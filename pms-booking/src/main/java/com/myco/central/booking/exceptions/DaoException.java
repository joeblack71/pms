package com.myco.central.booking.exceptions;

/**
 * Representa una excepci�n de una DAO.
 *
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
