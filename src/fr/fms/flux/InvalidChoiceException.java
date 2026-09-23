package fr.fms.flux;

/**
 * Crée une exception avec un message explicatif.
 *
 * @param message message décrivant l'erreur
 */
public class InvalidChoiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidChoiceException (String message) {
		super (message);
	}
}
