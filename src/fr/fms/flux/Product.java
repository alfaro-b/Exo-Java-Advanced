package fr.fms.flux;


/**
 * Représente un produit du restaurant.
 * 
 * Un produit possède un nom et un prix.
 */
public class Product {

    // =========================
    // ATTRIBUTS
    // =========================
	private String name;
	private double price;
	
    // =========================
    // CONSTRUCTEUR
    // =========================
	/** Crée un produit avec son nom et son prix
	 * 
	 * @param name nom du produit
	 * @param price prix du produit
	 */
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
    // =========================
    // ACCESSEURS
    // =========================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	// =========================
    // MÉTHODE
    // =========================
	/** Retourne les informations du produit sous forme de chaine.
	 *
	 *@return représentation textuelle du produit
	 */
	@Override
	public String toString() {
		return name + " - " + price + " €";
	}

}
