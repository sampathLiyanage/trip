/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tripsmanager;

import java.util.Iterator;
import java.util.LinkedList;
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

    /*
     * test cases
     */
    Location src, dest;
    int[] noOfLocs={5};
    int[] timesExpected={70};
    int[][][] placesData={{{1,1}, {1,1}, {1,1}}};
    int[][][] lowestDistances={{{10,10,19,0},{0,20,9,10},{20,0,29,10},{9,29,0,19}}};


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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPath method, of class Map.
     */
    @Test
    public void testGetPath() {
        for (int i=0; i<noOfLocs.length; i++){
            src= new Source();
            dest=new Destination(timesExpected[i]);
            System.out.println("getPath");
            Location[] places= new Location[noOfLocs[i]-2];
            int j;
            for (j=0; j<noOfLocs[i]-2; j++){
                places[j]=new Place(placesData[i][j][0],placesData[i][j][1]);
            }

            
            for (j=0; j<noOfLocs[i]-2; j++){
                src.addNeighbour(new Neighbour(places[j],lowestDistances[i][0][j]));
            }
            src.addNeighbour(new Neighbour(dest,lowestDistances[i][0][j]));

            for (j=0; j<noOfLocs[i]-2; j++){
                int k;
                for (k=0; k<noOfLocs[i]-2; k++){
                    if (k==j)
                        continue;
                    places[j].addNeighbour(new Neighbour(places[k],lowestDistances[i][j+1][k]));
                }
                places[j].addNeighbour(new Neighbour(dest,lowestDistances[i][j+1][k]));
            }
            Map instance = new Map(src, (Destination)dest);
            LinkedList<Location> result = instance.getPath();
            Iterator<Location> ittr=result.iterator();
            System.out.print('x');
        }
    }

}