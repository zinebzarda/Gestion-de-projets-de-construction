###ConstructionXpert Services - Application de Gestion de Projets de Construction
##Description de l'application
L'application "ConstructionXpert Services" est conçue pour fournir aux équipes de construction un outil efficace pour planifier, organiser et gérer les projets de construction. Elle offre une interface conviviale permettant de visualiser, mettre à jour et supprimer des projets, des tâches et des ressources, tout en garantissant la sécurité des données et l'intégrité du système.

##Fonctionnalités
#Gestion des Projets
Créer un nouveau projet : Spécifier le nom, la description, la date de début, la date de fin et le budget du projet.
Afficher les projets existants : Voir la liste des projets avec leurs détails.
Mettre à jour un projet : Modifier les détails d'un projet existant.
Supprimer un projet : Retirer un projet existant de la liste.
#Gestion des Tâches
Créer une nouvelle tâche : Ajouter une tâche à un projet avec description, date de début, date de fin, statut (à faire, en cours, terminé) et les ressources nécessaires.
Afficher les tâches d'un projet : Voir la liste des tâches associées à un projet avec leurs détails.
Mettre à jour une tâche : Modifier les détails d'une tâche existante.
Supprimer une tâche : Retirer une tâche existante de la liste.
#Gestion des Ressources
Ajouter de nouvelles ressources : Ajouter des ressources avec nom, type, quantité et informations du fournisseur.
Afficher les ressources disponibles : Voir la liste des ressources avec leurs détails.
Mettre à jour une ressource : Modifier les détails d'une ressource existante.
Supprimer une ressource : Retirer une ressource existante de la liste.

##Technologies Utilisées
#Frontend
HTML : Structure de la page.
CSS / Bootstrap / Tailwind : Design et mise en page.
JavaScript : Fonctionnalités interactives et validation des données côté client.
#Backend
Langage de Programmation : Java.
Framework Web : Java EE (Servlets, JSP).
Base de Données : MySQL / PostgreSQL.
JDBC API : Communication entre l'application Java et la base de données.
Serveur d'Application : Apache Tomcat.
Outils de Développement : Eclipse, IntelliJ IDEA, Maven.
Système de Gestion de Versions : Git.
#Diagrammes UML
Diagramme de Classes
Diagramme de Cas d'Utilisation
Diagramme de Séquence
Les diagrammes sont disponibles dans le dossier uml_diagrams sous forme d'images.

##Installation
Prérequis
JDK 8 ou supérieur
Apache Tomcat 9
MySQL / PostgreSQL
Maven
Git
#Étapes d'installation
Cloner le repository GitHub :
bash git clone https://github.com/yourusername/constructionxpert-services.git
Importer le projet dans votre IDE (Eclipse, IntelliJ IDEA).
Configurer la base de données en modifiant le fichier src/main/resources/db.properties.
Construire le projet avec Maven :
bash
Copier le code
mvn clean install
Déployer le fichier WAR généré sur le serveur Apache Tomcat.
Démarrer le serveur Tomcat et accéder à l'application via http://localhost:8080/constructionxpert-services.
Utilisation
Authentification
Se connecter avec vos identifiants.
Accéder aux différentes fonctionnalités de gestion des projets, tâches et ressources.
Gestion des Projets
Naviguer vers la section "Projets".
Créer, mettre à jour ou supprimer des projets.
Gestion des Tâches
Naviguer vers la section "Tâches" associée à un projet spécifique.
Créer, mettre à jour ou supprimer des tâches.
Gestion des Ressources
Naviguer vers la section "Ressources".
Ajouter, mettre à jour ou supprimer des ressources.


Auteur
zinebzarda1@gmail.com
