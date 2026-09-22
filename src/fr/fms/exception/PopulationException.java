package fr.fms.exception;

/**
 * Crée une exception avec un message explicatif.
 *
 * @param message message décrivant l'erreur
 */
public class PopulationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PopulationException(String message) {
		super(message);
	}
}
