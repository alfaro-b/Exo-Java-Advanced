# Java Advanced

Exercices réalisés dans le cadre de ma formation afin de pratiquer différentes notions de Java avancé.

## Contenu

Le projet regroupe plusieurs exercices :

- **Exercice 1 - JDBC** : connexion à une base de données MariaDB et opérations CRUD sur des articles.
- **Exercice 2 - Exceptions** : gestion des exceptions et création d'une exception personnalisée.
- **Exercice 3 - Threads** : utilisation de `Thread` et `Runnable`.
- **Exercice 4 - Flux et fichiers** : gestion de commandes de restaurant et génération de fichiers texte.
    - gestion des produits et des tarifs ;
    - calcul du prix des menus et de la commande ;
    - contrôle des saisies utilisateur.

## Installation

### Prérequis

- Java JDK 21
- Eclipse ou un autre IDE Java
- MariaDB pour l'exercice JDBC

### Installation du projet

Cloner le dépôt :

```bash
git clone https://github.com/alfaro-b/Exo-Java-Advanced.git
```

Puis importer le projet dans Eclipse :

1. `File` → `Import`
2. `General` → `Existing Projects into Workspace`
3. Sélectionner le dossier du projet
4. Vérifier que le projet utilise un JDK compatible

### Configuration JDBC

Pour l'exercice JDBC :

1. Installer et démarrer MariaDB.
2. Créer la base de données à partir du script SQL de l'exercice.
3. Télécharger le driver JDBC MariaDB.
4. Ajouter le fichier `.jar` dans le dossier `lib` du projet.
5. Ajouter le driver au `Build Path` dans Eclipse.
6. Vérifier les paramètres de connexion à la base de données dans le code.

> Le driver MariaDB `.jar` n'est pas versionné dans le dépôt.

## Exécution

Les différents exercices peuvent être lancés depuis Eclipse en exécutant les classes contenant une méthode `main()` :

`Run As` → `Java Application`

Les exercices sur les flux génèrent les fichiers `order.txt` et `order2.txt` à la racine du projet.