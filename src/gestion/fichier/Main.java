/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion.fichier;

import gestion.fichier.cli.Commande;
import gestion.fichier.cli.Navigateur;
import gestion.fichier.cli.ParseurCommande;
import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author herit
 */
public class Main {
    private static Scanner clavier = new Scanner(System.in); //Permettant de lire ce que l'user saisie au clacier.
    private static ParseurCommande parseur = new ParseurCommande();/*son rôle est de saisir ce que l'user à tapé et de le transfomer en objet de commande comprehensible
    par Java*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("...INVITE DE COMMANDE Gestion-Fichier...");   
        try{
            Fichier.restaurer();
        }catch (Exception e){
            e.printStackTrace();
        }
        /*Le bloc précédent cherche le fichier gestion_fichiers.ser sur ton disque pour 
        reconstruire l'arborescence (tes dossiers et fichiers créés précédemment)*/
            
        Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
        /*ici on a définit le repertoire "root" comme
        la racine, où l'on se trouve au démarrage.*/
        
        while (true){
            String chemin = "C:\\Users\\EDOHB" + 
                    Navigateur.getInstance().getRepertoireCourrant().getNomComplet() +
                    ">";
            
            System.out.print(chemin);
            String strCmde = clavier.nextLine(); /*cette ligne attend que l'user tape qq chose et entre.*/
            Commande commande = parseur.parser(strCmde); /*Celle-ci récupère et convertit ce que l'user à taper grâce à strCmde qui l'avait stocké.*/
            commande.executer(); /*Appel à la méthode "executer pour repondre a la commande entré par l'user.*/
        }
        
        // TODO code application logic here
    }
}
