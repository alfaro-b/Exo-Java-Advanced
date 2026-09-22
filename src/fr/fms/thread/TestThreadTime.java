package fr.fms.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Affiche l'heure en temps réel à l'aide d'un thread.
 */
public class TestThreadTime {

	public static void main(String[] args) {

		// Création d'un thread avec un délai d'une seconde
		Thread thread = new Thread(new MonRunnable(1000));

		thread.start();
	}

	/**
	 * Tâche chargée d'afficher l'heure à intervalles réguliers.
	 */
	private static class MonRunnable implements Runnable {

		private long delai;

		/**
		 * Crée la tâche avec le délai indiqué.
		 *
		 * @param delai délai entre deux affichages en millisecondes
		 */
		public MonRunnable(long delai) {
			this.delai = delai;
		}

		@Override
		public void run() {
			DateFormat df = new SimpleDateFormat("HH:mm:ss");

			while (true) {
				
				// Affiche l'heure courante
				System.out.println(df.format(new Date()));

				try {
					// Attend une seconde avant le prochain affichage
					Thread.sleep(delai);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}