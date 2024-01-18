/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_note_vdp_mn;

/**
 *
 * @author viann
 */
public class Jeu {

    public static final int SIZE=5;
    public Joueur joueur1;
    public Joueur joueur2;
    
    public Jeu(){
        System.out.println("Création Joueur 1");
        joueur1=new Joueur();
        System.out.println("######################################################");
        System.out.println("Changement Joueur : Création Joueur 2");
        joueur2 = new Joueur();
    }
}
