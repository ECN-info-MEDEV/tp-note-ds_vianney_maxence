/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_note_vdp_mn;

/**
 * Classe Case pour permettre la gestion du statut des cases d'un navire
 * @author User
 */
public class Case {
    /** position de la case*/
    private Point2D position;
    /** navire auquel appartient la case*/
    private Navire navire;
    /** statut de la case (touché ou non)*/
    private boolean estTouche;

    /**
     * Getter de la position
     * @return
     */
    public Point2D getPosition() {
        return position;
    }

    /**
     * Getter du Navire
     * @return
     */
    public Navire getNavire() {
        return navire;
    }

    /**
     * Getter du statut touché ou non
     * @return
     */
    public boolean isEstTouche() {
        return estTouche;
    }

    /**
     * Setter de la postion
     * @param position
     */
    public void setPosition(Point2D position) {
        this.position = position;
    }

    /**
     * Setter pour le navire
     * @param navire
     */
    public void setNavire(Navire navire) {
        this.navire = navire;
    }

    /**
     * Setter du statut touché ou non
     * @param estTouche
     */
    public void setEstTouche(boolean estTouche) {
        this.estTouche = estTouche;
    }

    /**
     * Constructeur avec attributs de la classe
     * @param position
     * @param navire
     * @param estTouche
     */
    public Case(Point2D position, Navire navire, boolean estTouche) {
        this.position = new Point2D(position);
        this.navire = navire;
        this.estTouche = estTouche;
    }

    /**
     * Constructeur sans attribut de la classe
     */
    public Case() {
        this.position = new Point2D();
        this.navire = null;
        this.estTouche = false;
    }
    
    /**
     * Constructeur de recopie de la classe
     * @param c
     */
    public Case(Case c) {
        this.position = new Point2D(c.getPosition());
        this.navire = c.getNavire();
        this.estTouche = c.isEstTouche();
    }

    
    
    
    
}
