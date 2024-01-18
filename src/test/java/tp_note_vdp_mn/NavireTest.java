/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tp_note_vdp_mn;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class NavireTest {
    
    public NavireTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    /**
     * Test of getNom method, of class Navire.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Navire instance = new Navire();
        String expResult = "nomVide";
        String result = instance.getNom();
        assertEquals(expResult, result);
        Navire instanceBis = new Navire ("testNom",2, new ArrayList<>());
        assertEquals("testNom",instanceBis.getNom());
    }

    /**
     * Test of getTaille method, of class Navire.
     */
    @Test
    public void testGetTaille() {
        System.out.println("getTaille");
        Navire instance = new Navire();
        int expResult = 0;
        int result = instance.getTaille();
        assertEquals(expResult, result);
        Navire instanceBis = new Navire ("testNom",2, new ArrayList<>());
        assertEquals(2,instanceBis.getTaille());
    }

    /**
     * Test of getComposition method, of class Navire.
     */
    @Test
    public void testGetComposition() {
        System.out.println("getComposition");
        Navire instance = new Navire();
        ArrayList<Case> expResult = new ArrayList<>();
        ArrayList<Case> result = instance.getComposition();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNom method, of class Navire.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "nouveauNom";
        Navire instance = new Navire();
        instance.setNom(nom);
        assertEquals(nom,instance.getNom());
    }

    /**
     * Test of setTaille method, of class Navire.
     */
    @Test
    public void testSetTaille() {
        System.out.println("setTaille");
        int taille = 2;
        Navire instance = new Navire();
        instance.setTaille(taille);
        assertEquals(2,instance.getTaille());
    }
    
    /**
     * Test of setComposition method, of class Navire
     */
    @Test
    public void testSetComposition(){
        System.out.println("setComposition");
        ArrayList<Case> compo = new ArrayList<>();
        Case case1 = new Case();
        Case case2 = new Case();
        case1.setEstTouche(true);
        case2.setEstTouche(true);
        compo.add(case1);
        compo.add(case2);
        Navire navire = new Navire ("testCoule",7,compo);
        assertEquals(compo, navire.getComposition());
    }
    
    /**
     * Test of estCoule method, of class Navire.
     */
    @Test
    public void testEstCoule() {
        System.out.println("estCoule");
        ArrayList<Case> compo = new ArrayList<>();
        Case case1 = new Case();
        Case case2 = new Case();
        Case case3 = new Case();
        case1.setEstTouche(true);
        case2.setEstTouche(true);
        case3.setEstTouche(true);
        compo.add(case1);
        compo.add(case2);
        compo.add(case3);
        Navire navire = new Navire ("testCoule",3,compo);
        assertTrue(navire.estCoule());
    }
    
}
