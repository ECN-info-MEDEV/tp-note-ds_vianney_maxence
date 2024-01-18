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
        mapDef=new int[jeu.SIZE][jeu.SIZE];
        mapAtt=new int[jeu.SIZE][jeu.SIZE];
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
            System.out.println("Bateau "+(i+1)+" : "+armada.get(i).getNom()+" de longueur "+armada.get(i).getTaille());
            placerNavire(armada.get(i));
            affiche();
            
        }
    }
    
    public void placerNavire(Navire nav){
        System.out.println("Bateau à l'horizontale ou à la verticale ? Horizontale=1, Verticale=0");
        Scanner sc=new Scanner(System.in);
        int hv=100;
        while (hv==100){
            try{
                hv=sc.nextInt();
                if (hv!=1 && hv!=0){
                    hv=100;
                    System.out.println("Erreur... réessayez");
                }
            }catch(InputMismatchException ex){
                System.out.println("Erreur... réessayez");
                sc.next();
            }
        }
        System.out.println("Choisissez la première case du bateau la plus proche du coin supérieur gauche. \nnuméro de la ligne...");
        int x=0;
        while (x==0){
            try{
                x=sc.nextInt();
                if (x<=0 || x>jeu.SIZE){
                    x=0;
                    System.out.println("Erreur... réessayez");
                }if (hv==0){
                    if ((x+nav.getTaille()-1)>jeu.SIZE){
                        x=0;
                        System.out.println("Le bateau ne rentrera pas !");
                    }
                }
                
            }catch (InputMismatchException ex){
                System.out.println("Erreur... réessayez");
                sc.next();
            }
        }
        System.out.println("numéro de la colonne...");
        int y=0;
        while (y==0){
            try{
                y=sc.nextInt();
                if (y<=0 || y>jeu.SIZE){
                    y=0;
                    System.out.println("Erreur... réessayez");
                }if (hv==1 && ((y+nav.getTaille()-1)>jeu.SIZE)){
                    y=0;
                    System.out.println("Le bateau ne rentrera pas !");
                }
            }catch (InputMismatchException ex){
                System.out.println("Erreur... réessayez");
                sc.next();
            }
        }
        for (int i=0;i<nav.getTaille();i++){
            nav.getComposition().add(new Case(new Point2D(x-1,y-1),nav,false));
            mapDef[x-1][y-1]=1;
            y+=hv;
            x+=-(hv-1);
            
        }
    }
    
    
    public void affiche(){
        System.out.println("Tableau de bord de "+nom);
        //Conception de la bordure interligne
        String bordure="-";
        System.out.println("\nMAP DE LA DEFENSE\n");
        System.out.println("N= "+jeu.SIZE);
        for (int k=0;k<jeu.SIZE;k++){
            bordure=bordure+"----";
        }
        System.out.println(bordure);
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
        System.out.println("          X = segment de bateau touché");
        System.out.println("\nMAP DE L'ATTAQUE\n");
        System.out.println(bordure);
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

    public void attaque(Joueur j){
        System.out.println(nom+", c'est votre tour !");
        affiche();
        System.out.println("Choisissez la case que vous voulez attaquer !\nnuméro de la ligne...");
        Scanner sc=new Scanner (System.in);
        int x=0;
        while (x==0){
            try{
                x=sc.nextInt();
                if (x<0 || x>jeu.SIZE){
                    x=0;
                    System.out.println("Erreur... réessayez");
                }
            }catch(InputMismatchException ex){
                System.out.println("Erreur... réessayez");
                sc.next();
            }
        }
        System.out.println("numéro de la colonne...");
        int y=0;
        while (y==0){
            try{
                y=sc.nextInt();
                if (y<0 || y>jeu.SIZE){
                    y=0;
                    System.out.println("Erreur... réessayez");
                }
            }catch(InputMismatchException ex){
                System.out.println("Erreur... réessayez");
                sc.next();
            }
        }
        Point2D p=new Point2D(x-1,y-1);
        if (j.touche(p)){
            mapAtt[x-1][y-1]=2;
        }else{
            mapAtt[x-1][y-1]=1;
        }
        System.out.println("Fin de l'attaque "+nom);
        affiche();
    }
    
    
    public boolean touche(Point2D p){
        boolean flag=false;
        Navire cible=null;
        for(Navire nav:armada){
            for(Case c:nav.getComposition()){
                if (c.getPosition().equals(p)){
                    flag = true;
                    c.setEstTouche(true);
                    mapDef[p.getX()][p.getY()]=2;
                    cible=nav;
                }
            }
        }
        if (cible!=null){
            if (cible.estCoule()){
                System.out.println("Touché coulé ! Vous avez coulé "+cible.getNom());
            }else{
                System.out.println("Touché");
            }
        }
        return flag;
    }
            
    public boolean aPerdu(){
        for (Navire nav:armada){
            if (nav.estCoule()==false){
                return false;
            }
        }
        return true;
    }     
            
    public String getNom() {
        return nom;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public ArrayList<Navire> getArmada() {
        return armada;
    }

    public int[][] getMapDef() {
        return mapDef;
    }

    public int[][] getMapAtt() {
        return mapAtt;
    }
    
    
}
