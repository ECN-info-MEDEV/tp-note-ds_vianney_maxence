/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_note_vdp_mn;

/**
 *Classe Jeu qui gère le déroulé du jeu et des tours de jeu
 * @author viann
 */
public class Jeu {
    /**Taille de la grille de bataille navale*/
    public static final int SIZE=5;
    /**Joueur 1*/
    public Joueur joueur1;
    /**Joueur 2*/
    public Joueur joueur2;
    
    /**Constructeur par défaut du jeu 
     */
    public Jeu(){
        System.out.println("Création Joueur 1");
        joueur1=new Joueur();
        System.out.println("######################################################");
        System.out.println("Changement Joueur : Création Joueur 2");
        joueur2 = new Joueur();
    }
    
    /**Méthode pour dérouler un tour de jeu complet (les deux joueurs ont joué une fois chacun)
     * 
     * @param tour Numéro du tour de jeu en question
     */
    public void tourDeJeu(int tour){
        System.out.println("\n#####################################################");
        System.out.println("Tour de Jeu n°"+tour);
        joueur1.attaque(joueur2);
        System.out.println("\n\n---------------------------------------------");
        joueur2.attaque(joueur1);
    }
    
    /**Méthode pour savoir si le jeu est fini (est-ce qu'un joueur est mort)
     * 
     * @return Booléen indiquant si le jeu est fini ou pas
     */
    public boolean fini(){
        if (joueur1.aPerdu() || joueur2.aPerdu()){
            return true;
        }
        return false;
    }
}
