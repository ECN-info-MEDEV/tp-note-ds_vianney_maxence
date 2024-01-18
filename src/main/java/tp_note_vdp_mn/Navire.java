/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_note_vdp_mn;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Classe Navire pour gérer les navires des joueurs lors du jeu
 * @author viann
 */
public class Navire {
    /**Nom du navire*/
    private String nom;
    /**Taille du navire*/
    private int taille;
    /**Liste des cases composant le navire*/
    private ArrayList<Case> composition;
    
    /**Méthode pour savoir si le navire est entièrement coulé ou non
     * 
     * @return Booléen indiquant si le navire est coulé
     */
    public boolean estCoule(){
        int cpt=0;
        for (Case c:composition){
            if (c.isEstTouche()){
                cpt+=1;
            }
        }if (cpt==taille){
            return true;
        }else{
            return false;
        }
    }
    
    /**Getter du nom du navire
     * 
     * @return Le nom du navire
     */
    public String getNom() {
        return nom;
    }

    /**Getter de la taille du navire
     * @return La taille du navire
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Getter pour la liste de position
     * @return La liste des cases occupées par le navire
     */
    public ArrayList<Case> getComposition() {
        return composition;
    }

    /**
     *Setter du nom du navire
     * @param nom Nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    /**
     * Setter de la taille du navire
     * @param taille 
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }   
    

    /**
     *Setter de la composition du navire
     * @param composition Cases composant le navire
     */
    public void setComposition(ArrayList<Case> composition) {
        this.composition = composition;
    }

    /**Constructeur à paramètres du navire
     * @param nom   Nom du navire
     * @param taille Taille de navire
     * @param composition Composition du navire
     */
    public Navire(String nom, int taille, ArrayList<Case> composition) {
        this.nom = nom;
        this.taille = taille;
        this.composition = composition;
    }

    /**
     *Constructeur par défaut du navire
     */
    public Navire() {
        this.nom = "nomVide";
        this.taille = 0;
        this.composition = new ArrayList();
    }
    
    
    /**
     * Constructeur à paramètres du navire
     * @param nm Nom du navire
     * @param tll Taille du navire
     */
    public Navire(String nm,int tll){
        nom=nm;
        taille=tll;
        composition=new ArrayList<>();
    }

}