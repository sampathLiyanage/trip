/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tripsmanager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/**
 *
 * @author dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Location src, dest;
          src= new Source();
        dest=new Destination(60);
        System.out.println("getPath");
        Location A,B;
        A=new Place(1,1);
        B=new Place(1,1);
        src.addNeighbour(new Neighbour(A,55));
        src.addNeighbour(new Neighbour(B,20));
        src.addNeighbour(new Neighbour(dest,45));
        A.addNeighbour(new Neighbour(src,55));
        A.addNeighbour(new Neighbour(B,15));
        A.addNeighbour(new Neighbour(dest,10));
        B.addNeighbour(new Neighbour(src,20));
        B.addNeighbour(new Neighbour(A,15));
        B.addNeighbour(new Neighbour(dest,25));
        Map instance = new Map(src, (Destination)dest);
        Destination result = instance.getPath();
    }

}





abstract class Location {
	public float x,y;
	public String type; //Eg: source, destination, place
	public Location previous; //to be used when finding the path


	public Location(String aType){
		type=aType;
	}

	public Iterator<Neighbour> getNeighbours(){
		return null;
	}

	public Integer getTimeTraveled(){
		return null;
	}

	public void addPrevious(Location loc, int time){
		previous=loc;
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



//for source
class Source extends Location{
	public Set<Neighbour> neighbours;
	public int timeToVisit;

	public Source(){
		super("source");
		neighbours=new HashSet<Neighbour>();
		timeToVisit=0;
	}

	public Iterator<Neighbour> getNeighbours(){
		return neighbours.iterator();
	}

        public void addNeighbour(Neighbour n){
            neighbours.add(n);
        }

        public Integer getTimeTraveled(){
		return 0;
	}

	public Integer getPathRating(){
		return 0;
	}

        public Integer getTimeToVisit(){
            return 0;
        }

	public Integer getRating(){
		return 0;
	}
}

//for destination
class Destination extends Location{
	public int expectedTime;
	public int ratingOfPath;
	public int timeTraveled;
	public int latestTimeAdded;

	public Destination(int time){
		super("destination");
		expectedTime=time;
		ratingOfPath=0;
		timeTraveled=0;
		latestTimeAdded=0;
	}

	public Integer getExpTime(){
		return expectedTime;
	}

	public Integer getTimeTraveled(){
		return timeTraveled;
	}

	public Integer getPathRating(){
		return ratingOfPath;
	}

	public void addPrevious(Location pre, int timeToAdd ){
		if (this.previous!=null){
			ratingOfPath-=(previous.getPathRating());
			timeTraveled-=(previous.getTimeTraveled()+latestTimeAdded);
		}

		latestTimeAdded=timeToAdd;
		ratingOfPath+=(pre.getPathRating());
		timeTraveled+=(pre.getTimeTraveled()+latestTimeAdded);
		previous=pre;
	}

        public Integer getTimeToVisit(){
            return 0;
        }

	public Integer getRating(){
		return 0;
	}
}

//for places on the way
class Place extends Location{
	public int rating;
	public int ratingOfPath;
	public int timeToVisit;
	public int timeTraveled;
	public int latestTimeAdded;
	public Set<Neighbour> neighbours;



	public Place(int aRating, int aTimetoVisit){
		super("place"); //type is "place"
		rating=aRating;
		timeToVisit=aTimetoVisit;
		neighbours=new HashSet<Neighbour>();
		ratingOfPath=0;
		timeTraveled=0;
		latestTimeAdded=0;
	}

        public void addNeighbour(Neighbour n){
            neighbours.add(n);
        }
	public Iterator<Neighbour> getNeighbours(){
		return neighbours.iterator();
	}

	public Integer getTimeTraveled(){
		return timeTraveled;
	}

	public Integer getPathRating(){
		return ratingOfPath;
	}

        public Integer getTimeToVisit(){
            return timeToVisit;
        }

	public Integer getRating(){
		return rating;
	}
        

	public void addPrevious(Location pre, int timeToAdd ){
		if (this.previous!=null){
			ratingOfPath-=(previous.getPathRating()+rating);
			timeTraveled-=(previous.getTimeTraveled()+timeToVisit+latestTimeAdded);
		}

		latestTimeAdded=timeToAdd;
		ratingOfPath+=(pre.getPathRating()+rating);
		timeTraveled+=(pre.getTimeTraveled()+timeToVisit+latestTimeAdded);
		previous=pre;
	}

}

//for neighbour places
class Neighbour{
	public int timeToTravel;
	public Location loc;

	public Neighbour(Location aLoc, int time){
		loc=aLoc;
		timeToTravel=time;
	}
}

class Map{
	public Location source;
	public Destination destination;

	public Map(Location src, Destination dest){
		source=src;
                destination=dest;
	}

	//breadth first search
	public Destination getPath(){
		Queue<Location> q = new LinkedList<Location>();
		q.add(source);

		while(!q.isEmpty()){
			Location location=q.remove();
			Iterator<Neighbour> ittr=location.getNeighbours();
			while (ittr.hasNext()){
				Neighbour neighbour=ittr.next();

				if (location.type.equals("source")){
					neighbour.loc.addPrevious(location, neighbour.timeToTravel);
                                        if (!neighbour.loc.type.equals("destination"))
                                            q.add(neighbour.loc);
				} else if (neighbour.loc.type.equals("destination")){
					if((neighbour.loc.getExpTime()>(location.getTimeTraveled()+neighbour.timeToTravel)) && ((neighbour.loc.getPathRating()-neighbour.loc.getRating())<location.getPathRating())){
						neighbour.loc.addPrevious(location, neighbour.timeToTravel);
					}

				} else if (location.type.equals("place") && neighbour.loc.type.equals("place")){
					Location temp= location;
					boolean loop=false;
					while(temp.previous.type!="source"){
						temp=temp.previous;
						if (temp==neighbour.loc){
							loop=true;
						}
					}

					if (loop==false){
						if((destination.getExpTime()>(location.getTimeTraveled()+neighbour.timeToTravel+neighbour.loc.getTimeToVisit())) && ((neighbour.loc.getPathRating()-neighbour.loc.getRating())<location.getPathRating())){
							neighbour.loc.addPrevious(location, neighbour.timeToTravel);
							q.add(neighbour.loc);
						}
					}
				}
			}
		}
		return destination;
	}


}