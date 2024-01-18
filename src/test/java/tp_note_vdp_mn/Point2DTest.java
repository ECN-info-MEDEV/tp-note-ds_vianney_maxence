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
public class Point2DTest {
    
    public Point2DTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getX method, of class Point2D.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Point2D instance = new Point2D();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        expResult = 2;
        Point2D instanceBis = new Point2D(2,0);
        result = instanceBis.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Point2D.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Point2D instance = new Point2D();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        expResult = 2;
        Point2D instanceBis = new Point2D(0,2);
        result = instanceBis.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setX method, of class Point2D.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 5;
        Point2D instance = new Point2D();
        instance.setX(x);
        assertEquals(5, instance.getX());
    }

    /**
     * Test of setY method, of class Point2D.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 8;
        Point2D instance = new Point2D();
        instance.setY(y);
        assertEquals(8, instance.getY());
    }
    
    /**
     * Test of equals method, of classe Point2D
     */
    @Test
    public void testEquals(){
        System.out.println("equals");
        Point2D point1 = new Point2D(2,-5);
        Point2D point2 = new Point2D();
        point2.setX(2);
        assertFalse(point1.equals(point2));
        point2.setY(-5);
        assertTrue(point1.equals(point2));
        
        
    }

}
