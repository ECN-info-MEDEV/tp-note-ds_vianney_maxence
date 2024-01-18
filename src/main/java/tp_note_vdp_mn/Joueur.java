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
public class Joueur {
    private String nom;
    private Jeu jeu;
    private ArrayList<Navire> armada;
    private int[][] mapDef;
    private int[][] mapAtt;

    public Joueur(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Joueur 1 rentre ses choix :\nVotre nom ?");
        try {
            nom=sc.nextLine();
        }catch (InputMismatchException ex){
            System.out.println("Mauvaise rentrée... Vous serez joueur 1");
        }
        System.out.println("Maintenant, nous allons placer vos bateaux !\nVous en possédez 3.");
        System.out.println("Le premier est le porte-avions. Il a une longueur de 5.");
    }
    
    
    public void affiche(){
        System.out.println("Tableau de bord de "+nom);
        //Conception de la bordure interligne
        String bordure="-";
        System.out.println("N= "+jeu.SIZE);
        for (int k=0;k<jeu.SIZE;k++){
            bordure=bordure+"----";
        }
        System.out.println(bordure);
        for(int i=0;i<20;i++){
            //Conception d'une ligne
            String ligne="|";
            for (int j=0;j<20;j++){
                String val="   ";
                //Détermination de l'élément présent sur la case
                switch(mapDef[i][j]){                 
                    case (1):
                        val=" P ";
                        break;
                    case (2):
                        val="ps ";
                        break;
                    case (3):
                        val="ep ";
                        break;
                    case (4):
                        val=" M ";
                        break;
                    case (5):
                        val="nou";
                        break;
                    case (6):
                        val="nt ";
                        break;
                    case (100):
                        val="MOI";
                }
                ligne=ligne+" "+val+" |";
            }
            System.out.println(ligne);
            System.out.println(bordure);
        }
        //Affichage de la légende
        System.out.println("Légende : P = Personnage    M = Monstre             ps = Potion de Soin");
        System.out.println("          ep = Epée         nt = Nuage Toxique      nou = Nourriture  ");
    }
}
