/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tripsmanager;

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
public class DestinationTest {

    public DestinationTest() {
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
     * Test of getExpTime method, of class Destination.
     */
    @Test
    public void testGetExpTime() {
        System.out.println("getExpTime");
        Destination instance = null;
        Integer expResult = null;
        Integer result = instance.getExpTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeTraveled method, of class Destination.
     */
    @Test
    public void testGetTimeTraveled() {
        System.out.println("getTimeTraveled");
        Destination instance = null;
        Integer expResult = null;
        Integer result = instance.getTimeTraveled();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPathRating method, of class Destination.
     */
    @Test
    public void testGetPathRating() {
        System.out.println("getPathRating");
        Destination instance = null;
        Integer expResult = null;
        Integer result = instance.getPathRating();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPrevious method, of class Destination.
     */
    @Test
    public void testAddPrevious() {
        System.out.println("addPrevious");
        Location pre = null;
        int timeToAdd = 0;
        Destination instance = null;
        instance.addPrevious(pre, timeToAdd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}