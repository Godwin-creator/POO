# Système de Gestion de Fichiers (Java)
**Projet Semestre 3 - Cours de M. HOETOWOU**

## 📌 Présentation
Ce projet consiste en la création d'un interpréteur de commandes (CLI) permettant de manipuler un système de fichiers virtuel stocké en mémoire vive et sauvegardé de manière persistante sur le disque.

## 🏗️ Architecture du Projet
Le projet est structuré en trois couches principales :

### 1. Couche Métier (`gestion.fichier.metier`)
Utilisation du polymorphisme pour gérer l'arborescence :
* **Fichier (Abstraite)** : Classe mère gérant le nom, le parent et la persistance.
* **Repertoire** : Conteneur pouvant stocker une liste d'objets `Fichier`.
* **FichierSimple** : Représente les fichiers de données (feuilles de l'arborescence).

### 2. Couche Interface (`gestion.fichier.cli`)
Implémentation du **Design Pattern Command** :
* **ParseurCommande** : Analyse la saisie utilisateur et instancie la commande appropriée.
* **Navigateur** : Singleton gérant la position actuelle (répertoire courant) de l'utilisateur.
* **Classes Commande** : `CmLs`, `CmCD`, `CmMkdir`, `CmTouch`, `CmAide`, `CmQuitter`.

### 3. Point d'Entrée (`gestion.fichier`)
* **Main** : Initialise le système, restaure les données sauvegardées et lance la boucle interactive.

## 💾 Persistance des données
Le projet utilise la **Sérialisation Java**. L'intégralité de l'arborescence à partir du dossier `root` est sauvegardée dans un fichier binaire `.ser`.
* **Sauvegarde** : `Fichier.sauvegarder()`
* **Restauration** : `Fichier.restaurer()` (appelée au lancement du programme).

## 🚀 Commandes Disponibles
* `LS` : Lister le contenu du répertoire actuel.
* `CD [nom]` : Changer de répertoire.
* `MKDIR [nom]` : Créer un nouveau dossier.
* `TOUCH [nom]` : Créer un nouveau fichier simple.
* `HELP` : Afficher l'aide.
* `EXIT` : Quitter et fermer l'application.

---
*Dernière mise à jour : 19 Décembre 2025*
