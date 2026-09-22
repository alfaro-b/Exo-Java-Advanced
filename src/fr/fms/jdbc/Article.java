package fr.fms.jdbc;

/**
 * Représente un article disponible dans la base de données Shop.
 * 
 * Un article possède un identifiant, une description, une marque et un prix unitaire.
 */
public class Article {
	
    // =========================
    // ATTRIBUTS
    // =========================
	
	private int id;
	private String description;
	private String brand;
	private double unitaryPrice;

    // =========================
    // CONSTRUCTEURS
    // =========================
	
    /**
     * Crée un article avec son identifiant
     *
     * @param id identifiant de l'article
     * @param description description de l'article
     * @param brand marque de l'article
     * @param unitaryPrice prix unitaire de l'article
     */
	public Article(int id, String description, String brand, double unitaryPrice) {
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}
    /**
     * Crée un article sans identifiant
     *
     * @param description description de l'article
     * @param brand marque de l'article
     * @param unitaryPrice prix unitaire de l'article
     */
	public Article(String description, String brand, double unitaryPrice) {
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}

    // =========================
    // ACCESSEURS
    // =========================
	
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getBrand() {
		return brand;
	}

	public double getUnitaryPrice() {
		return unitaryPrice;
	}
	
	
	// =========================
    // MÉTHODES
    // =========================
	
	/**
	 * Retourne les informations de l'article sous forme de chaîne.
	 *
	 * @return représentation textuelle de l'article
	 */
	@Override
	public String toString() {
		return id + " - "
				+ description + " - "
				+ brand + " - "
				+ unitaryPrice;
	}
}