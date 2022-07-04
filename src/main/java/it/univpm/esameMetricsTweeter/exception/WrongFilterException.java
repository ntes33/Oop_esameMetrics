package it.univpm.esameMetricsTweeter.exception;

public class WrongFilterException extends Exception {
private static final long serialVersionUID = 1L;
  /**
   *  Lancia  un eccezione nel caso in cui venga inserito un filtro sbagliato
   * @author Verdolini Gian Paolo, Paolucci Alessio
   *
   */
	public WrongFilterException(String message) {
		super(message);
	}
}
