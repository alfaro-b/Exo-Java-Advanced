package fr.fms.flux;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simule la prise de commandes dans un restaurant
 * et génère un fichier texte contenant le résumé des commandes.
 */

public class Resto {
		public static final String [] STARTER = 	{"entrée", "salade","soupe","quiche","aucune"};
		public static final String [] DISHES = 		{"plats" , "poulet" , "boeuf" , "poisson" , "végétarien" , "vegan","aucun"};
		public static final String [] SIDE_DISH = 	{"accompagnements" , "riz" , "pates" , "frites" , "légumes","aucun"};
		public static final String [] DRINKS = 		{"boissons" , "eau plate" , "eau gazeuze" , "soda" , "vin","aucune"};
		public static final String [] DESSERTS = 	{"desserts" , "tarte maison" , "mousse au chocolat" , "tiramisu","aucun"};
		
	public static void main(String[] args) {	
		
		System.out.println("bonjour, combien de menus souhaitez vous ?");
		
		try(
			Scanner scan = new Scanner(System.in);
			BufferedWriter writer = new BufferedWriter(new FileWriter("order.txt"))
			) {
			int nbMenu;
			
			while(scan.hasNextInt() == false)	scan.next();
			
			nbMenu = scan.nextInt();
			
			ArrayList<String>  order = new ArrayList<String>();
			
			for(int i = 0 ; i < nbMenu ; i ++) {
				
				System.out.println("Commande numéro " + (i+1));
				
				int result = getInfos(scan,STARTER[0]);
				if(STARTER.length-1 > result)	order.add(STARTER[result]);	
			
				result = getInfos(scan,DISHES[0]);
				if(DISHES.length-1 > result)	order.add(DISHES[result]);	
				
				result = getInfos(scan,SIDE_DISH[0]);
				if(SIDE_DISH.length-1 > result)	order.add(SIDE_DISH[result]);	
				
				result = getInfos(scan,DRINKS[0]);
				if(DRINKS.length-1 > result)	order.add(DRINKS[result]);
				
				result = getInfos(scan,DESSERTS[0]);
				if(DESSERTS.length-1 > result)	order.add(DESSERTS[result]);	
				
				// Affichage dans la console
				System.out.println("Résumé de la commande "+(i+1));
				System.out.println(order);		
				System.out.println();
				
				// Écriture de la commande dans le fichier
				writer.write("******************** Résumé de la commande N°" + (i + 1)+ " ********************");
				writer.newLine();
				
				for(String item : order) {
					writer.write(item);
					writer.newLine();
				}
				
				// Ligne vide entre deux commandes
				writer.newLine();
				
				// Vide la commande avant de passer au menu suivant
				order.clear();
			}
			
			System.out.println("\n Le fichier order.txt a été généré.");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Affiche les choix disponibles et retourne le choix de l'utilisateur.
	 *
	 * @param scan scanner utilisé pour la saisie
	 * @param info type de produit demandé
	 * @return numéro du choix effectué
	 */
	public static int getInfos(Scanner scan, String info) {
		
		System.out.println("choix " + info + " : ");
		
		if(info.equalsIgnoreCase(STARTER[0]))	displayTable(STARTER);
		else if(info.equalsIgnoreCase(DISHES[0]))	displayTable(DISHES);
		else if(info.equalsIgnoreCase(SIDE_DISH[0]))	displayTable(SIDE_DISH);
		else if(info.equalsIgnoreCase(DRINKS[0]))	displayTable(DRINKS);
		else if(info.equalsIgnoreCase(DESSERTS[0]))	displayTable(DESSERTS);
		
		System.out.println("que souhaitez vous comme "+ info + " ? [saisir le chiffre correspondant]");
		
		return scan.nextInt();
	}	

	/**
	 * Affiche les différentes possibilités d'un menu.
	 *
	 * @param table tableau à afficher
	 */
	public static void displayTable(String [] table) {
		
		for(int i=1;i<table.length;i++) {			
			
			System.out.print("[" + i + " - " + table[i].toUpperCase() + "]");
		}
		System.out.println();
	}
}
