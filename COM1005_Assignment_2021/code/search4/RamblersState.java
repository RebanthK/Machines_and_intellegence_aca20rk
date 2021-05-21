/*
*	RamblersState.java
*   State in a Rambler's search
*	Rebanth Kanner 2021 version
* 
*/

import java.util.*;

public class RamblersState extends SearchState{
    
    //Coordinates for this state
    private Coords coords;

    //Constructor for manhattan
    public RamblersState(Coords co, int lc, int rc){
        coords = co;
        localCost = lc;
        estRemCost = rc;
    }

    // accessor
    public Coords getCoords(){
        return coords;
    }

    public boolean goalPredicate(Search searcher){
        RamblersSearch rsearcher = (RamblersSearch) searcher;
        Coords tar = rsearcher.getGoal();
        if (tar.equals(coords)){
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
        ArrayList<SearchState> succs = new ArrayList<SearchState>();

        for (CoordsLink l : links) {
            if (coords.equals(l.getCoords1())){
                succs.add((SearchState) new RamblersState(l.getCoords2(), l.getCost(),  map.estbetween(l.getCoords2(), rsearcher.getGoal())));
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