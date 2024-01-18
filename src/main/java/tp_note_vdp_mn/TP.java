/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tp_note_vdp_mn;


/**
 *
 * @author viann
 */
public class TP {

    public static void main(String[] args) {
        Jeu j=new Jeu();
        int i=1;
        while (j.fini()==false){
            j.tourDeJeu(i);
            i+=1;
        }
        System.out.println("\n\nFIN DU JEU ! BYYYYYE");
    }
}
