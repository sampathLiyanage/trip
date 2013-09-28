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
public class SourceTest {

    public SourceTest() {
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
     * Test of getNeighbours method, of class Source.
     */
    @Test
    public void testGetNeighbours() {
        System.out.println("getNeighbours");
        Source instance = new Source();
        Iterator expResult = null;
        Iterator result = instance.getNeighbours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}