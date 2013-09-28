/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tripsmanager;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dell
 */
public class PlaceTest {

    public PlaceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNeighbours method, of class Place.
     */
    @Test
    public void testGetNeighbours() {
        System.out.println("getNeighbours");
        Place instance = null;
        Iterator expResult = null;
        Iterator result = instance.getNeighbours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeTraveled method, of class Place.
     */
    @Test
    public void testGetTimeTraveled() {
        System.out.println("getTimeTraveled");
        Place instance = null;
        Integer expResult = null;
        Integer result = instance.getTimeTraveled();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPathRating method, of class Place.
     */
    @Test
    public void testGetPathRating() {
        System.out.println("getPathRating");
        Place instance = null;
        Integer expResult = null;
        Integer result = instance.getPathRating();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPrevious method, of class Place.
     */
    @Test
    public void testAddPrevious() {
        System.out.println("addPrevious");
        Location pre = null;
        int timeToAdd = 0;
        Place instance = null;
        instance.addPrevious(pre, timeToAdd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}