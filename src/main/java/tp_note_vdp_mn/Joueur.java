/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_note_vdp_mn;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Classe Joueur qui gère la défense et l'attaque du joueur ainsi que la création de ses grilles
 * @author viann
 */
public class Joueur {
    /**Nom du joueur*/
    private String nom;
    /**Jeu dans lequel le joueur évolue*/
    private Jeu jeu;
    /**Liste des bateaux constituant la flotte du joueur*/
    private ArrayList<Navire> armada;
    /**Map de la défense du joueur*/
    private int[][] mapDef;      //0=case vide, 1=bateau présent, 2= bateau touché
    /**Map d'attaque du joueur*/
    private int[][] mapAtt;     //0=case vide,  1=plouf, 2=touché

    
    /**Constructeur par défaut du joueur avec son placement de bateaux
     */
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
    
    /**Méthode pour placer un navire du Joueur
     * 
     * @param nav Navire à placer
     */
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
    
    /**Méthode d'affichage du tableau de bord du joueur
     * 
     */
    public void affiche(){
        System.out.println("\nTableau de bord de "+nom);
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

    /**Méthode d'attaque du joueur avec le choix de la case à attaquer
     * 
     * @param j Nom du joueur à attaquer
     */
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
    }
    
    /**Méthode pour savoir si le joueur est touché par l'attaque adverse
     * 
     * @param p Case attaquée par l'adversaire
     * @return Booléen indiquant si le joueur est touché ou non
     */
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
    /**Méthode pour savoir si le joueur a perdu, càd si tous ses bateaux ont coulé.
     * 
     * @return Booléen indiquant si le joueur a perdu.
     */    
    public boolean aPerdu(){
        for (Navire nav:armada){
            if (nav.estCoule()==false){
                return false;
            }
        }
        return true;
    }     
    /**Getter pour le nom
     * 
     * @return Nom du joueur
     */   
    public String getNom() {
        return nom;
    }
    
    /**Getter pour le jeu
     * 
     * @return Jeu dont fait partie le joueur
     */
    public Jeu getJeu() {
        return jeu;
    }
    
    /**Getter des bateaux de la flotte du joueur
     * 
     * @return La liste des bateaux
     */
    public ArrayList<Navire> getArmada() {
        return armada;
    }
    /**Getter de la map de défense du joueur
     * 
     * @return La map de défense
     */
    public int[][] getMapDef() {
        return mapDef;
    }
    /**Getter de la map d'attaque du joueur
     * 
     * @return La map d'attaque
     */
    public int[][] getMapAtt() {
        return mapAtt;
    }
    
    
}
