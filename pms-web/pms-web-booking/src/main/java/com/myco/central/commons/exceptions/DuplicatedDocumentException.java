/**
 * Representa una excepcion ocurrida al tratar de registrar un valor duplicado
 * para un campo que puede contener solo valores unicos. 
 */
package com.myco.central.commons.exceptions;

import java.sql.SQLException;

/**
 * @author Johnny Olivas
 *
 */
public class DuplicatedDocumentException extends SQLException {

	private static final long serialVersionUID = 1L;

}
