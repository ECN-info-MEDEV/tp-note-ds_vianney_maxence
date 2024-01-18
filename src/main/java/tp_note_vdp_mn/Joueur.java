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
        armada=new ArrayList<>();
        armada.add(new Navire("Porte-avions",5));
        armada.add(new Navire("Cuirassé",4));
        armada.add(new Navire("Destroyer",3));
        Scanner sc=new Scanner(System.in);
        System.out.println("Création Joueur : rentrez vos choix :\nVotre nom ?");
        try {
            nom=sc.nextLine();
        }catch (InputMismatchException ex){
            System.out.println("Mauvaise rentrée...");
        }
        affiche();
        System.out.println("Maintenant, nous allons placer vos bateaux !\nVous en possédez "+armada.size());
        for (int i=0;i<armada.size();i++){
            System.out.println("Bateau "+(i+1)+" : "+armada.get(i).getNom());
            placerNavire(armada.get(i));
            
        }
    }
    
    public void placerNavire(Navire nav){
        System.out.println("Choisissez la première case ! \nnuméro de la ligne...");
        Scanner sc=new Scanner(System.in);
        int x=0;
        while (x==0){
            try{
                x=sc.nextInt();
                if (x<=0 && x>jeu.SIZE){
                    x=0;
                }
            }catch (InputMismatchException ex){
            } finally {
                System.out.println("Erreur... réessayez");
            }
        }
        System.out.println("numéro de la colonne...");
        int y=0;
        while (y==0){
            try{
                y=sc.nextInt();
                if (y<=0 && y>jeu.SIZE){
                    y=0;
                }
            }catch (InputMismatchException ex){
            } finally {
                System.out.println("Erreur... réessayez");
            }
        }
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
        System.out.println("MAP DE LA DEFENSE");
        for(int i=0;i<jeu.SIZE;i++){
            //Conception d'une ligne
            String ligne="|";
            for (int j=0;j<jeu.SIZE;j++){
                String val="   ";
                //Détermination de l'élément présent sur la case
                switch(mapDef[i][j]){                 
                    case 0:
                        val=" ";
                        break;
                    case 1:
                        val="/";
                        break;
                    case 2:
                        val="X";
                        break;
                }
                ligne=ligne+" "+val+" |";
            }
            System.out.println(ligne);
            System.out.println(bordure);
        }
        //Affichage de la légende
        System.out.println("Légende : / = segment de bateau intact");
        System.out.println("          X = segemnt de bateau touché");
        System.out.println("MAP DE L'ATTAQUE");
        for(int i=0;i<jeu.SIZE;i++){
            //Conception d'une ligne
            String ligne="|";
            for (int j=0;j<jeu.SIZE;j++){
                String val="   ";
                //Détermination de l'élément présent sur la case
                switch(mapAtt[i][j]){                 
                    case 0:
                        val=" ";
                        break;
                    case 1:
                        val="o";
                        break;
                    case 2:
                        val="X";
                        break;
                }
                ligne=ligne+" "+val+" |";
            }
            System.out.println(ligne);
            System.out.println(bordure);
        }
        //Affichage de la légende
        System.out.println("Légende : o = plouf    X = touché");
    }
}
