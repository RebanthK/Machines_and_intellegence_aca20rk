/*
*	State in a Rambler's search
*	Rebanth Kanner 2021 version
* 
*/

import java.util.*;

public class RamblersState extends SearchState{
    
    //Coordinates for this state
    private Coords coords;

    //Constructor
    public RamblersState(Coords co, int lc){
        coords = co;
        localCost = lc;
    }

    // accessor
    public Coords getCoords(){
        return coords;
    }

    public boolean goalPredicate(Search searcher){
        RamblersSearch rsearcher = (RamblersSearch) searcher;
        Coords tar = rsearcher.getGoal();
        if (tar == coords){
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<SearchState> getSuccessors(Search searcher){
        RamblersSearch rsearcher = (RamblersSearch) searcher;
        Carta map = rsearcher.getMap();
        ArrayList<CoordsLink> links = map.getLinks(coords);
        // System.out.println(links.size());
        ArrayList<SearchState> succs = new ArrayList<SearchState>();

        for (CoordsLink l : links) {
            if (coords.equals(l.getCoords1())){
                succs.add((SearchState) new RamblersState(l.getCoords2(), l.getCost()));
            }
        }

        return succs;
    }

    public boolean sameState(SearchState s2){
        RamblersState rs2 = (RamblersState) s2;
        if (coords == rs2.getCoords() && localCost == rs2.getLocalCost()){
            return true;
        }
        else{
            return false;
        }

    }

    public String toString(){
        return ("Map State: " + coords.getx() + ", " + coords.gety());
    }
}