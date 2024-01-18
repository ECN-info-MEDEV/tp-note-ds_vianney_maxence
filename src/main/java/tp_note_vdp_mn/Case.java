
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
    
    private Point2D position;
    private Navire navire;
    private boolean estTouche;

    /**
     * 
     * @return
     */
    public Point2D getPosition() {
        return position;
    }

    /**
     *
     * @return
     */
    public Navire getNavire() {
        return navire;
    }

    /**
     *
     * @return
     */
    public boolean isEstTouche() {
        return estTouche;
    }

    /**
     *
     * @param position
     */
    public void setPosition(Point2D position) {
        this.position = position;
    }

    /**
     *
     * @param navire
     */
    public void setNavire(Navire navire) {
        this.navire = navire;
    }

    /**
     *
     * @param estTouche
     */
    public void setEstTouche(boolean estTouche) {
        this.estTouche = estTouche;
    }

    /**
     *
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
     *
     */
    public Case() {
        this.position = new Point2D();
        this.navire = null;
        this.estTouche = false;
    }
    
    /**
     *
     * @param c
     */
    public Case(Case c) {
        this.position = new Point2D(c.getPosition());
        this.navire = c.getNavire();
        this.estTouche = c.isEstTouche();
    }

}
