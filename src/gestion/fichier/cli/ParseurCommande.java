/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import java.util.Arrays;

/**
 *
 * @author herit
 */
public class ParseurCommande {
    public Commande parser(String strCmd){
        
        String[] tbCmd = strCmd.trim().split(" ");
        /*trim() : Cette méthode enlève les espaces inutiles au début et
        à la fin de ta saisie (au cas où tu aurais tapé " ls ").*/
        
        /*split(" ") : coupe la phrase saisie en morceaux à chaque espace 
        et place les mots dans un tableau nommé tbCmd. Par exemple, si je tape mkdir monDossier, le tableau contiendra ["mkdir", "monDossier"].*/

        String premierMot = tbCmd[0].toUpperCase();
        /*toUpperCase() : On convertit le premier mot du tableau tbCmd en majuscules pour que
        la commande fonctionne même si on écrit "ls", "Ls" ou "LS".*/
        
        
        /*Préparation du texte taper par l'user stocker dans strCmd pour l'analyse afin d'executer le prog*/
        Commande commande;
        commande = switch (premierMot) {

            case "EXIT" -> new CmQuitter();

            case "HELP" -> new CmAide();

            case "MKDIR" -> new CmMkdir();

            case "LS" -> new CmLs();

            case "TOUCH" -> new CmTouch();

            case "CD" -> new CmCD();

            default -> new CmInconnue();

        };
        
        /* Pour ecrire claire et détaillé :
        switch(premierMot){
                case "EXIT":
                    commande = new CmQuitter();
                    break;
                case "HELP":
                    commande = new CmAide();
                    break;
                case "MKDIR":
                    commande = new CmMkdir();
                    break;
                case "LS":
                    commande = new CmLs();
                    break;
                case "TOUCH":
                    commande = new CmTouch();
                    break;
                case "CD":
                    commande = new CmCD();
                    break;
                default:
                    commande = new CmInconnue();
        };*/
        
        if (tbCmd.length > 1){
            /*tbCmd.length > 1 : On vérifie s'il y a d'autres mots après le premier.*/
            
            String[] parametres = Arrays.copyOfRange(tbCmd, 1, tbCmd.length);
            /*Arrays.copyOfRange : On crée un nouveau tableau qui contient 
            tous les mots sauf le premier (le premier étant la commande elle-même).*/
            
            commande.setParametres(parametres);
            /*On "donne" ces paramètres à l'objet commande pour qu'il sache sur quoi agir.*/
        }
        return commande;
    }
}
