package fr.fms.exception;

public class TestCityException {
	public static void main(String[] args) {

		// Création d'une ville avec une population valide
		City city = new City("Bayonne", "France", 52000);

		System.out.println(city);

		// Tentative de modification avec une population invalide
		try {

			city.setPopulation(-500);

		} catch (PopulationException e) {

			// Gestion de l'exception personnalisée
			System.out.println("Erreur : " + e.getMessage());
		}

		// Vérifie que la population n'a pas été modifiée
		System.out.println(city);
	}
}
