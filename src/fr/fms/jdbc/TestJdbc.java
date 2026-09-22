package fr.fms.jdbc;

/**
 * Classe permettant de tester les différentes opérations
 * réalisées sur les articles avec ArticleDao.
 */
public class TestJdbc {

	/**
	 * Point d'entrée du programme.
	 *
	 * @param args arguments de la ligne de commande
	 */
	public static void main(String[] args) {

		// Chargement du driver MariaDB
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Création du DAO
		ArticleDao articleDao = new ArticleDao();


		// =========================
		// READ ALL
		// =========================

		System.out.println("----- ARTICLES DE DEPART -----");

		for (Article article : articleDao.readAll()) {
			System.out.println(article);
		}


		// =========================
		// CREATE
		// =========================

		System.out.println("\n----- INSERT -----");

		Article newArticle =
				new Article("Monitor", "Samsung", 249.99);

		articleDao.create(newArticle);


		// =========================
		// READ
		// =========================

		System.out.println("\n----- READ -----");

		Article article = articleDao.read(1);

		System.out.println(article);


		// =========================
		// UPDATE
		// =========================

		System.out.println("\n----- UPDATE -----");

		Article articleToUpdate =
				new Article(
					1,
					"Wireless Mouse",
					"Logitech",
					79.99
				);

		articleDao.update(articleToUpdate);

		System.out.println(articleDao.read(1));


		// =========================
		// DELETE
		// =========================

		System.out.println("\n----- DELETE -----");

		articleDao.delete(13);


		// =========================
		// AFFICHAGE FINAL
		// =========================

		System.out.println("\n----- ARTICLES A LA FIN -----");

		for (Article currentArticle : articleDao.readAll()) {
			System.out.println(currentArticle);
		}
	}
}