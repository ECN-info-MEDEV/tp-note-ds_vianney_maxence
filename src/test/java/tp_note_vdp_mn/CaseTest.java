/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tp_note_vdp_mn;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CaseTest {
    
    public CaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getPosition method, of class Case.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Case case1 = new Case();
        Case case2 = new Case(new Point2D(1,1),new Navire(),false);
        Point2D expResult1 = new Point2D(0,0);
        Point2D result1 = case1.getPosition();
        assertTrue(expResult1.equals(result1));
        Point2D expResult2 = new Point2D(1,1);
        Point2D result2 = case2.getPosition();
        assertTrue(expResult2.equals(result2));
    }

    /**
     * Test of getNavire method, of class Case.
     */
    @Test
    public void testGetNavire() {
        System.out.println("getNavire");
        Case instance = new Case();
        Navire expResult = null;
        Navire result = instance.getNavire();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstTouche method, of class Case.
     */
    @Test
    public void testIsEstTouche() {
        System.out.println("isEstTouche");
        Case case1 = new Case();
        Case case2 = new Case(new Point2D(),new Navire(),true);
        boolean expResult1 = false;
        boolean result1 = case1.isEstTouche();
        assertEquals(expResult1, result1);
        boolean expResult2 = true;
        boolean result2 = case2.isEstTouche();
        assertEquals(expResult2, result2);
    }
    
    

    
    
}
