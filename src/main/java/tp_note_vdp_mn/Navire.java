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
    private ArrayList<Point2D> composition;
    
    public Navire(String nm,int tll){
        nom=nm;
        taille=tll;
    }

    
    
    public String getNom() {
        return nom;
    }

    public int getTaille() {
        return taille;
    }

    public ArrayList<Point2D> getComposition() {
        return composition;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public void setComposition(ArrayList<Point2D> composition) {
        this.composition = composition;
    }
    
    
}
