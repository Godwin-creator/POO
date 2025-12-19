/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author herit
 */
public abstract class Fichier implements Serializable{
    private static Repertoire root = new Repertoire("\\root", null);
    public static final String path = "C:\\Users\\EDOHB\\OneDrive\\Documents\\EPL\\Cours S3\\Programmation orientée objet\\FichierSortie_Serialisation\\fichier.ser";//"C:\\Users\\Public\\Documents\\fichier.ser";
    private LocalDate dateCreation ; 
    private String nom;
    private Repertoire repertoireParent;
    
    public Fichier(){
        this.dateCreation = LocalDate.now();
    }
    
    public Fichier(String nom){
        this();
        this.nom = nom;
    }
    
    public Fichier(String nom, Repertoire repertoireParent){
        this(nom);
        this.repertoireParent = repertoireParent;
        if(this.repertoireParent != null){
            this.repertoireParent.getFichiers().add(this);
        }
    }
    
    //Ici c'est le bloc de la serialisation objet root --> fichier .ser
        public static void sauvegarder() throws Exception{
        //1: Tout d'abord on ouvre un chemin vers le fichier .ser
        FileOutputStream fichier = new FileOutputStream(Fichier.path);
        
        //2: cette ligne transforme les objets en flux d'octects (données)
        ObjectOutputStream objectOtputStream = new ObjectOutputStream(fichier);
        
        //3: on envoie l'objet "root" dans le fichier et Java sauvergarde automatiquement tout l'arborescence.
        objectOtputStream.writeObject(root);
        
        //On force le passage des données restant !!? (demander à heritier avnt la présentatoion)
        objectOtputStream.flush();
        
        //pour sauvegarder o a utiliser OutputStream
    }
    
        
        //Ici c'est le bloc qui designe la déserialisation fichier .ser --> objet root 
    public static void restaurer(){
        try{
            FileInputStream fichier = new FileInputStream(Fichier.path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fichier);
            root = (Repertoire) objectInputStream.readObject();
        }catch (FileNotFoundException e){
            
        }catch (IOException e){
            
        }catch (ClassNotFoundException e){
            
        }
        
        /*FileInputStream / ObjectInputStream : ouvrent le fichier et lisent les données binaires.*/
    }
    
    public static Repertoire getRoot(){
        return root;
    }
    
    public abstract int getTaille();
    public abstract boolean estRepertoire();
    
    public String getNom(){
        return this.nom;
    }
    
    
    public String getNomComplet(){
        if(repertoireParent == null){
            return this.nom;
        }
        return repertoireParent.getNomComplet() + "\\" + this.nom;
    }
    
    public Repertoire getRepertoireParent(){
        return repertoireParent;
    }
}
