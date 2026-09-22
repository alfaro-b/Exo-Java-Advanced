package fr.fms.exception;

/**
 * Représente une ville avec son nom, son pays et sa population.
 */
public class City {
	// =========================
    // ATTRIBUTS
    // =========================

	private String name;
	private String country;
	private int population;
	
	
	// =========================
    // CONSTRUCTEUR
    // =========================
	
	/**
     * Crée une ville avec son nom, son pays et sa population.
     *
     * @param name       nom de la ville
     * @param country    pays de la ville
     * @param population nombre d'habitants
     */
	public City(String name, String country, int population) {
		this.name = name;
		this.country = country; 
		this.population = population;
	}

	
	// =========================
    // ACCESSEURS
    // =========================
	
	/**
     * Retourne le nom de la ville.
     *
     * @return le nom de la ville
     */
	public String getName() {
		return name;
	}
	/**
     * Modifie le nom de la ville.
     *
     * @param name nouveau nom de la ville
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Retourne le pays de la ville.
     *
     * @return le pays de la ville
     */
	public String getCountry() {
		return country;
	}
	/**
     * Modifie le pays de la ville.
     *
     * @param country nouveau pays de la ville
     */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
     * Retourne la population de la ville.
     *
     * @return le nombre d'habitants
     */
	public int getPopulation() {
		return population;
	}
	/**
     * Modifie la population de la ville.
     *
     * @param population nouveau nombre d'habitants
     */
	public void setPopulation(int population) throws PopulationException {
		if (population < 0) {
			throw new PopulationException("La population ne peut être négative.");
		}
		this.population = population;
	}
	// throws : la méthode annonce qu'elle peut transmettre une exception
	// throw : on déclenche réellement l'exception
	
	
	// =========================
    // MÉTHODES
    // =========================
	
	/**
     * Retourne une représentation textuelle de la ville.
     *
     * @return les informations de la ville sous forme de phrase
     */
    @Override
	public String toString() {
		return  this.name + ", " +
				this.country + ", " +
				this.population + " d'habitants ";
	}

	
}
