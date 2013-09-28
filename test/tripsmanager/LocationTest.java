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
public class LocationTest {

    public LocationTest() {
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
     * Test of getNeighbours method, of class Location.
     */
    @Test
    public void testGetNeighbours() {
        System.out.println("getNeighbours");
        Location instance = null;
        Iterator expResult = null;
        Iterator result = instance.getNeighbours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeTraveled method, of class Location.
     */
    @Test
    public void testGetTimeTraveled() {
        System.out.println("getTimeTraveled");
        Location instance = null;
        Integer expResult = null;
        Integer result = instance.getTimeTraveled();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPrevious method, of class Location.
     */
    @Test
    public void testAddPrevious() {
        System.out.println("addPrevious");
        Location loc = null;
        int time = 0;
        Location instance = null;
        instance.addPrevious(loc, time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExpTime method, of class Location.
     */
    @Test
    public void testGetExpTime() {
        System.out.println("getExpTime");
        Location instance = null;
        Integer expResult = null;
        Integer result = instance.getExpTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRating method, of class Location.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        Location instance = null;
        Integer expResult = null;
        Integer result = instance.getRating();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPathRating method, of class Location.
     */
    @Test
    public void testGetPathRating() {
        System.out.println("getPathRating");
        Location instance = null;
        Integer expResult = null;
        Integer result = instance.getPathRating();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class LocationImpl extends Location {

        public LocationImpl() {
            super("");
        }
    }

}