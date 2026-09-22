package fr.fms.thread;

/**
 * Exemple de création et d'exécution de plusieurs threads.
 */
public class TestThread extends Thread {

	/**
	 * Crée un thread avec un nom.
	 *
	 * @param name nom du thread
	 */
	public TestThread(String name) {
		super(name);
	}

	/**
	 * Affiche 5 fois le nom du thread.
	 */
	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.print(this.getName() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		TestThread t1 = new TestThread("1-");
		TestThread t2 = new TestThread("2--");
		TestThread t3 = new TestThread("3---");
		TestThread t4 = new TestThread("4----");
		TestThread t5 = new TestThread("5-----");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

// L'ordre d'affichage peut changer à chaque exécution, car les threads sont exécutés de manière concurrente.
// L'ordonnanceur du système détermine leur ordre d'exécution.