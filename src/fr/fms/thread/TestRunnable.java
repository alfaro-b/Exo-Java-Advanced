package fr.fms.thread;

/**
 * Exemple d'utilisation de Runnable avec plusieurs threads.
 * Chaque thread génère une ligne composée d'un caractère ASCII et d'un nombre croissant d'étoiles.
 */
public class TestRunnable implements Runnable{
	
	private int number;
	
	/**
	 * Crée une tâche avec le numéro indiqué.
	 *
	 * @param number numéro utilisé pour générer le caractère et le nombre d'étoiles
	 */
	public TestRunnable(int number) {
		this.number = number;
	}
	
	/**
	 * Construit puis affiche la ligne correspondant au numéro du thread.
	 */
	@Override
	public void run() {
		
		// Les caractères ASCII utilisés vont de ! (33) à * (42).
		// ! " # $ % & ' ( ) *
		char character = (char) (32 + number);
		
		String line = "" + character;
		
		// Ajoute autant d'étoiles que la valeur de number.
		for(int i = 0; i < number; i++) {
			line += "*";
		}
		
		line += character;
		
		System.out.println(line);
	}

	public static void main(String[] args) {

		// Création et lancement de 10 threads avec une seule variable.
		for(int i = 1; i <= 10; i++) {
			Thread thread = new Thread(new TestRunnable(i));
			thread.start();
	        try {
	        	// Attend la fin du thread avant de lancer le suivant afin de conserver l'ordre d'affichage.
	            thread.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			}
	}
}