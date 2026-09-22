package fr.fms.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO permettant d'effectuer les opérations CRUD
 * sur les articles de la base de données Shop.
 */
public class ArticleDao {

	// =========================
	// PARAMETRES DE CONNEXION
	// =========================

	private String url = "jdbc:mariadb://localhost:3306/shop";
	private String login = "root";
	private String password = "";


	// =========================
	// CONNEXION
	// =========================

	/**
	 * Ouvre une connexion vers la base de données Shop.
	 *
	 * @return connexion à la base de données
	 * @throws SQLException si la connexion échoue
	 */
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, login, password);
	}


	// =========================
	// READ ALL
	// =========================

	/**
	 * Récupère tous les articles présents dans la base de données.
	 *
	 * @return liste contenant tous les articles
	 */
	public ArrayList<Article> readAll() {

		ArrayList<Article> articles = new ArrayList<>();

		String sql = "SELECT * FROM T_Articles";

		try (
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery()
		) {

			while (resultSet.next()) {

				int id = resultSet.getInt("IdArticle");
				String description = resultSet.getString("Description");
				String brand = resultSet.getString("Brand");
				double unitaryPrice = resultSet.getDouble("UnitaryPrice");

				Article article =
						new Article(id, description, brand, unitaryPrice);

				articles.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return articles;
	}


	// =========================
	// READ
	// =========================

	/**
	 * Recherche un article grâce à son identifiant.
	 *
	 * @param id identifiant de l'article recherché
	 * @return article correspondant à l'identifiant,
	 *         ou null si aucun article n'est trouvé
	 */
	public Article read(int id) {

		String sql =
				"SELECT * FROM T_Articles WHERE IdArticle = ?";

		try (
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)
		) {

			ps.setInt(1, id);

			try (ResultSet resultSet = ps.executeQuery()) {

				if (resultSet.next()) {

					return new Article(
						resultSet.getInt("IdArticle"),
						resultSet.getString("Description"),
						resultSet.getString("Brand"),
						resultSet.getDouble("UnitaryPrice")
					);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	// =========================
	// CREATE
	// =========================

	/**
	 * Ajoute un nouvel article dans la base de données.
	 *
	 * @param article article à ajouter
	 */
	public void create(Article article) {

		String sql =
				"INSERT INTO T_Articles "
				+ "(Description, Brand, UnitaryPrice) "
				+ "VALUES (?, ?, ?)";

		try (
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)
		) {

			ps.setString(1, article.getDescription());
			ps.setString(2, article.getBrand());
			ps.setDouble(3, article.getUnitaryPrice());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	// =========================
	// UPDATE
	// =========================

	/**
	 * Met à jour un article existant dans la base de données.
	 *
	 * L'article est recherché grâce à son identifiant.
	 *
	 * @param article article contenant les nouvelles informations
	 */
	public void update(Article article) {

		String sql =
				"UPDATE T_Articles "
				+ "SET Description = ?, Brand = ?, UnitaryPrice = ? "
				+ "WHERE IdArticle = ?";

		try (
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)
		) {

			ps.setString(1, article.getDescription());
			ps.setString(2, article.getBrand());
			ps.setDouble(3, article.getUnitaryPrice());
			ps.setInt(4, article.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	// =========================
	// DELETE
	// =========================

	/**
	 * Supprime un article de la base de données
	 * grâce à son identifiant.
	 *
	 * @param id identifiant de l'article à supprimer
	 */
	public void delete(int id) {

		String sql =
				"DELETE FROM T_Articles WHERE IdArticle = ?";

		try (
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)
		) {

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}