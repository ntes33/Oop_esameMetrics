package it.univpm.esameMetricsTweeter.exception;

public class EmptyListException extends Exception {

	
	private static final long serialVersionUID = 1L;

	/**
	 * Stampa un messaggio d'errore passato come parametro
	 * @param message Messaggio di errore personalizzato
	 */

	public EmptyListException(String message) {
	super(message);
	
	}
	
	
}
