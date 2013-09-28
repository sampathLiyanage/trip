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
public class MapTest {

    Location src, dest;
    public MapTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        src= new Source();
        dest=new Destination(120);
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPath method, of class Map.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        Location A,B,C;
        A=new Place(1,1);
        B=new Place(1,1);
        C=new Place(1,1);
        src.addNeighbour(new Neighbour(A,55));
        src.addNeighbour(new Neighbour(B,20));
        src.addNeighbour(new Neighbour(C,45));
        src.addNeighbour(new Neighbour(dest,0));
        A.addNeighbour(new Neighbour(src,55));
        A.addNeighbour(new Neighbour(B,15));
        A.addNeighbour(new Neighbour(C,10));
        A.addNeighbour(new Neighbour(dest,55));
        B.addNeighbour(new Neighbour(src,20));
        B.addNeighbour(new Neighbour(A,15));
        B.addNeighbour(new Neighbour(C,25));
        B.addNeighbour(new Neighbour(dest,20));
        C.addNeighbour(new Neighbour(src,45));
        C.addNeighbour(new Neighbour(A,10));
        C.addNeighbour(new Neighbour(B,25));
        C.addNeighbour(new Neighbour(dest,45));
        Map instance = new Map(src, (Destination)dest);
        Destination result = instance.getPath();
        assertEquals(result.previous, A);
        assertEquals(result.previous.previous, src);
        // TODO review the generated test code and remove the default call to fail.
    }

}