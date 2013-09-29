/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tripsmanager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;




//represents a location
/**
 *
 * @author dell
 */
public class Main {

    static void main(String[] args) {
        
    }

    /**
     * @param args the command line arguments
     */
}
abstract class Location {
	public float x,y;  //x,y coordinates
	public String type; //Eg: source, destination, place
        public int rating;
	public int ratingOfPath;    //needed when path is calculated
	public int timeToVisit;     //amount of time a visitor spends in the location
	public int timeOfPath;      //needed when path is calculated
        public int timeToDestination;   //minimum time from this location to destination
        public Boolean alreadyInPath;   //needed when path is calculated
	public Location(String aType){
		type=aType;
                rating=0;
                ratingOfPath=0;
                timeToVisit=0;
                timeOfPath=0;
                alreadyInPath=false;
	}

        //functions to implement polimorphism
	public Iterator<Neighbour> getNeighbours(){
		return null;
	}

	public Integer getTimeTraveled(){
		return null;
	}

	public Integer getExpTime(){
		return null;
	}

        public Integer getTimeToVisit(){
            return null;
        }

	public Integer getRating(){
		return null;
	}

	public Integer getPathRating(){
		return null;
	}

        public void addNeighbour(Neighbour n){
        }
}



//represents source location (where the trip starts)
class Source extends Location{
	public Set<Neighbour> neighbours;   //all other locations with time to travel (not the physical neighbours according to the google map)

	public Source(){
		super("source");
		neighbours=new HashSet<Neighbour>();
	}

        //returns all the neighbours
	public Iterator<Neighbour> getNeighbours(){
		return neighbours.iterator();
	}


        public void addNeighbour(Neighbour n){
            neighbours.add(n);
             if (n.loc.type.equals("destination")){
                timeToDestination=n.timeToTravel;
            }
        }

        
}

//represents the destination (where the trip ends)
class Destination extends Location{
	public int expectedTime;    //the time allocated for the trip by user

	public Destination(int time){
		super("destination");
		expectedTime=time;
                timeToDestination=0;
	}

	public Integer getExpTime(){
		return expectedTime;
	}
}

//represents places on the way
class Place extends Location{
	
	public Set<Neighbour> neighbours;

	public Place(int aRating, int aTimetoVisit){
		super("place"); //type is "place"
		rating=aRating;
		timeToVisit=aTimetoVisit;
		neighbours=new HashSet<Neighbour>();
	}

        public void addNeighbour(Neighbour n){
            neighbours.add(n);
            if (n.loc.type.equals("destination")){
                timeToDestination=n.timeToTravel;
            }
        }
	public Iterator<Neighbour> getNeighbours(){
		return neighbours.iterator();
	}
}

//represents a neighbour of a place (ie: another location + traveling time are attributes)
class Neighbour{
	public int timeToTravel;    //traveling time from a location
	public Location loc;    //neighbour location

	public Neighbour(Location aLoc, int time){
		loc=aLoc;
		timeToTravel=time;
	}
}

//includes algorithms and huristic functions
class Map{
	public Location source;
	public Destination destination;

	public Map(Location src, Destination dest){
		source=src;
                destination=dest;
	}

        //this should be called to get the best path
        public LinkedList<Location> getPath(){

            LinkedList<Location> path=new LinkedList<Location>(); //path
            Location temp=source;
            while (temp!=null){
                //making sure path traveling time doesn't exceed the expected time
                if(temp.timeOfPath+temp.timeToDestination<destination.expectedTime){
                    path.add(temp);
                    temp.alreadyInPath=true;
                } else{
                    break;
                }
                
                temp=getNextBestLoc(temp);
            }
            destination.timeOfPath=path.getLast().timeOfPath+path.getLast().timeToDestination;
            destination.ratingOfPath=path.getLast().ratingOfPath;
            path.add(destination); //ading last node to the path
            return path;
	}

        //get next best location to travel from a location
        //out put may be null if a best location doesn't exsist
        public Location getNextBestLoc(Location loc){
            Location bestLoc=null;
            int bestHeuristic=destination.expectedTime;
            Iterator<Neighbour> ittr=loc.getNeighbours();
            while (ittr.hasNext()){
            	Neighbour neighbour=ittr.next();

                //destination type is neglected
                if (neighbour.loc.type.equals("destination")){
                    continue;
                }

                //if the neighbour location is already in the path
                if (neighbour.loc.alreadyInPath){
                    continue;
                }

                int timeTraveled=loc.timeOfPath+neighbour.timeToTravel+neighbour.loc.timeToVisit;  //time traveled if the neighbour loc is added
                int timeToDest=timeTraveled+neighbour.loc.timeToDestination;    //time from source to destination if the neighbour loc is added
                
                //if time to destination exceeds expected time
                if (timeToDest>destination.expectedTime){
                    continue;
                }

                //heuristic value
                //lowest huristic value is the best one here
                //assumption: 1. rating can be taken only integers 0,1,2,3,4,5
                int heuristicValue=(timeToDest-timeTraveled)+(timeToDest-timeTraveled)*((neighbour.loc.rating*6)/100);
                
                //if a better heuristic value is found
                if (heuristicValue<bestHeuristic || (heuristicValue==bestHeuristic && timeTraveled<bestLoc.timeOfPath)){
                    bestHeuristic=heuristicValue;
                    bestLoc=neighbour.loc;
                    bestLoc.timeOfPath=timeTraveled;
                    bestLoc.ratingOfPath=loc.ratingOfPath+bestLoc.rating;
                } 
            }

            return bestLoc;
        }
}