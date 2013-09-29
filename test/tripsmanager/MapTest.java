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

    /*
     * test case input)format:
     *      noOfLocs: each entry of the array represents no of locations(incuding source and destination) of each test case
     *
     *       timeExpected: each entry of the array represents time limit defined by user of each test case
     *
     *       placesData: each row represents one test case(eg: two test cases are here)
     *                   in a row, each {x,y} represents data to create places(locations excluding the source and destination)
     *                   x=rating, y=time spent in the location
     *
     *       lowestDistances: each row represents one test case(eg: two test cases are here)
     *                      in a row, each {x,y,z....} SHORTEST TIME DISTANCE from a location to all other locations
     *                      all the locations should know the shortest time distance to all other locations
     *                      first {x,y,z......} represents source location
     *                      others represents data for other locations in the same order used in placesData array
     *                      shortest time distance data for destination location shouldn't be added
     */
    Location src, dest;
    int[] noOfLocs={5,6};
    int[] timesExpected={70,70};
    int[][][] placesData={{{1,1}, {1,1}, {1,1}},
                            {{1,1},{1,1},{1,1},{1,1}}};
    int[][][] lowestDistances={{{10,10,19,0},{0,20,9,10},{20,0,29,10},{9,29,0,19}},
        {{10, 30, 45, 20, 0}, {0,20,35,10,10}, {20,0,15,15,30}, {35,15,0,30,45}, {10,15,30,0,20}}};


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