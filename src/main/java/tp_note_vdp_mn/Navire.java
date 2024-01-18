/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_note_vdp_mn;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author viann
 */
public class Navire {
    private String nom;
    private int taille;
    private ArrayList<Case> composition;

    public String getNom() {
        return nom;
    }

    /**
     * Getter pour la taille
     * @return
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Getter pour la liste de position
     * @return
     */
    public ArrayList<Case> getComposition() {
        return composition;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param taille
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }

    /**
     *
     * @param composition
     */
    public void setComposition(ArrayList<Case> composition) {
        this.composition = composition;
    }

    /**
     *
     * @param nom
     * @param taille
     * @param composition
     */
    public Navire(String nom, int taille, ArrayList<Case> composition) {
        this.nom = nom;
        this.taille = taille;
        this.composition = new ArrayList<>();
    }

    /**
     *
     */
    public Navire() {
        this.nom = "nomVide";
        this.taille = 0;
        this.composition = new ArrayList();
    }
    
    
    
    public Navire(String nm,int tll){
        nom=nm;
        taille=tll;
        composition=new ArrayList<>();
    }

   }
