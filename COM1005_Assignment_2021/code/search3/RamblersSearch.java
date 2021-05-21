/*
* 	Ramblerssearch.java
*
*   Ramblerssearch for map traversal
*   Rebanth Kanner 2021 version
* 
*/

public class RamblersSearch extends Search{    
    private Carta map;
    private Coords goal;

    /*
    *Constructor
    *
    *@param map m
    *@param goal g
    */

    public RamblersSearch(Carta m, Coords g) {
        map = m;
        goal = g;
    }

    //accessors

    public Carta getMap() {
        return map;
    }

    public Coords getGoal() {
        return goal;
    }
}
