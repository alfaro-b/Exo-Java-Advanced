package fr.fms.flux;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simule la prise de commandes dans un restaurant et génère un fichier texte contenant le résumé des commandes.
 */

public class Resto2 {

	// =========================
	// PRODUITS DU MENU
	// =========================

	// Produits disponibles pour chaque catégorie avec leur prix.
	public static final Product[] STARTER = { new Product("salade", 5.50), new Product("soupe", 6.00),
			new Product("quiche", 7.00) };
	public static final Product[] DISHES = { new Product("poulet", 12.50), new Product("boeuf", 15.00),
			new Product("poisson", 14.00), new Product("végétarien", 11.00), new Product("vegan", 11.00) };
	public static final Product[] SIDE_DISH = { new Product("riz", 3.50), new Product("pates", 3.50),
			new Product("frites", 4.00), new Product("légumes", 4.50) };
	public static final Product[] DRINKS = { new Product("eau plate", 2.00), new Product("eau gazeuse", 2.50),
			new Product("soda", 3.00), new Product("vin", 5.00) };
	public static final Product[] DESSERTS = { new Product("tarte maison", 6.00),
			new Product("mousse au chocolat", 6.50), new Product("tiramisu", 7.00) };

	/**
	 * Point d'entrée du programme.
	 *
	 * @param args arguments de la ligne de commande
	 */
	public static void main(String[] args) {

		System.out.println("bonjour, combien de menus souhaitez vous ?");

		// Le try-with-resources ferme automatiquement le Scanner
		// et le BufferedWriter à la fin du bloc.
		try (Scanner scan = new Scanner(System.in);
			BufferedWriter writer = new BufferedWriter(new FileWriter("order2.txt"))
		) {
			int nbMenu;

			// Vérifie que l'utilisateur saisit bien un entier.
			while (scan.hasNextInt() == false)
				scan.next();

			nbMenu = scan.nextInt();

			// Contient les produits sélectionnés pour le menu en cours.
			ArrayList<Product> order = new ArrayList<Product>();

			// Répète la saisie pour chaque menu de la commande.
			for (int i = 0; i < nbMenu; i++) {

				System.out.println("-".repeat(30));
				System.out.println("Menu numéro " + (i + 1));
				System.out.println();

				int result = getInfos(scan, "entrée", STARTER);
				if (result != 0)
					order.add(STARTER[result-1]);
				
				result = getInfos(scan, "plats", DISHES);
				if (result != 0)
					order.add(DISHES[result-1]);
				
				result = getInfos(scan, "accompagnements", SIDE_DISH);
				if (result != 0)
					order.add(SIDE_DISH[result-1]);
				
				result = getInfos(scan, "boisson", DRINKS);
				if (result != 0)
					order.add(DRINKS[result-1]);
				
				result = getInfos(scan, "desserts", DESSERTS);
				if (result != 0)
					order.add(DESSERTS[result-1]);

				// =========================
				// AFFICHAGE CONSOLE
				// =========================
				System.out.println("-".repeat(30));
				System.out.println("Résumé du menu " + (i + 1));
				System.out.println();
				
				// Calcule le total d'un menu avec un Stream
				// La lambda product -> product.getPrice() récupère le prix de chaque produit
				// puis sum() additionne les prix
				double total = order.stream()
						.mapToDouble(product -> product.getPrice())
						.sum();
				// Même écriture avec une référence de méthode Product::getPrice
				// double total = order.stream().mapToDouble(Product::getPrice).sum();
				
				for (Product product : order) {
					System.out.println(product);
				}

				System.out.println("Total : " + total + " €");

				// =========================
				// ECRITURE DANS LE FICHIER
				// =========================
				writer.write("******************** Résumé du menu N°" + (i + 1) + " ********************");
				writer.newLine();

				for (Product product : order) {

					writer.write(
						product.getName()
						+ " - "
						+ product.getPrice()
						+ " €"
					);

					writer.newLine();
				}

				writer.write("------------------------------");
				writer.newLine();

				writer.write("TOTAL : " + total + " €");
				writer.newLine();
				writer.newLine();

				// Réinitialise la liste avant la commande suivante.
				order.clear();
			}

			System.out.println("\n Le fichier order2.txt a été généré.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Affiche les produits disponibles d'une catégorie et retourne le choix de l'utilisateur.
	 *
	 * @param scan scanner utilisé pour la saisie
	 * @param category catégorie de produit demandée
	 * @param products produits disponibles dans cette catégorie
	 * @return numéro du choix effectué
	 */
	public static int getInfos(Scanner scan,String category, Product[] products) {

		System.out.println("choix " + category + " : ");

		System.out.println("0 - AUCUN");
		displayTable(products);
		
		System.out.println("que souhaitez vous comme " + category + " ? [saisir le chiffre correspondant]");

		return scan.nextInt();
	}

	/**
	 * Affiche les produits disponibles avec leur prix.
	 *
	 * @param products tableau de produits à afficher
	 */
	public static void displayTable(Product[] products) {

		for (int i = 0; i < products.length; i++) {

			System.out.println(
					(i + 1) 
					+ " - " + products[i].getName().toUpperCase() 
					+ " - " + products[i].getPrice()
					+ " €"
			);
		}
		System.out.println();
	}
}
