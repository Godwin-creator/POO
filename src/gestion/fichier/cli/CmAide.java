/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

/**
 *
 * @author herit
 */
public class CmAide extends Commande{
    
    /*Affiche la liste des instructions disponibles et leur utilisation.*/

    @Override
    public void executer() {
        System.out.println("MKDIR : Créer un fichier");
        System.out.println("LS : Afficher les fichiers");
        System.out.println("TOUCH : Crée un nouvel fichier simple vide dans le dossier courant. ");
        System.out.println("CD : Changer ");
        System.out.println("Exit : Quitter le programme");
        System.out.println("Help : Commande d'aide");
    }

    @Override
    public void setParametres(String[] paramatre) {
        
    }
    
}
