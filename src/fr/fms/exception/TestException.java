package fr.fms.exception;

import java.util.Date;

public class TestException {
	public static void main(String[] args) {
		Date date = null;
		Date today = new Date();

		try {
			System.out.println(date.getClass().getName());
		} catch (NullPointerException e) {
			System.out.println("Impossible d'utiliser getClass() : date vaut null");
		}

		System.out.println(today.getClass().getName());
	}
}


// Sans try catch 

/*
public class TestException {
	public static void main(String[] args) {
		Date date = null;
		Date today = new Date();

		System.out.println(date.getClass().getName());
		System.out.println(today.getClass().getName());
	}
}*/

// Message erreur : 
// Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "date" is null

//getClass() est une méthode héritée de la classe Object.
//Toutes les classes Java héritent directement ou indirectement de Object.