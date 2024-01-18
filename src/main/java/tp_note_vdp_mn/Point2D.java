package tp_note_vdp_mn;
import java.util.*;
/**
 *
 * @author viann
 */
public class Point2D {
    /**Abscisse x*/
    private int x;
    /**Ordonnée y*/
    private int y;
    
    
    /**Constructeur par défaut. */
    public Point2D(){
        x=-10;
        y=-10;
    }
    /**Constructeur à paramètres
     * 
     * @param x Abscisse du Point2D
     * @param y Ordonnée du Point2D
     */
    public Point2D(int x, int y){
        this.x=x;
        this.y=y;
    }
    /**Constructeur de recopie
     * 
     * @param p Point2D à recopier
     */
    public Point2D(Point2D p){
        x=p.getX();
        y=p.getY();
    }
    
    /**Getter x
     * 
     * @return Abscisse x
     */
    public int getX() {
        return x;
    }
    /**Getter y
     * 
     * @return Ordonnée y
     */
    public int getY() {
        return y;
    }
    /**Setter x
     * 
     * @param x Nouvelle abscisse x
     */
    public void setX(int x) {
        this.x = x;
    }
    /**Setter y
     * 
     * @param y Nouvelle ordonnée y
     */
    public void setY(int y) {
        this.y = y;
    }
    /**Setter position
     * 
     * @param x Nouvelle abscisse du point
     * @param y Nouvelle ordonnée du point
     */
    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }
    /**Méthode de translation de Point2D
     * 
     * @param dx Déplacement horizontal/abscisses
     * @param dy Déplacement vertical/ordonnées
     */
    public void translate(int dx, int dy){
        this.x+=dx;
        this.y+=dy;
    }
    /**Méthode d'affichage du Point2D*/
    public void affiche(){
        ArrayList liste = new ArrayList();
        liste.add(this.getX());
        liste.add(this.getY());
        System.out.println(liste);
    }
    
    /**Méthode qui dit si deux Point2D sont égaux
     * @param p Point2D avec qui on compare
     * @return True s'ils sont égaux, False sinon
     */
    public boolean equals(Point2D p){
        return(this.x==p.x && this.y==p.y);
    }
    
}