/*
* 	MapSearch.java
*
*	Ramblerssearch for map traversal
*  Rebanth Kanner 2021 version
* 
*/

public class RamblersSearch extends Search{    
    private Carta map;
    private Coords goal;

    public Carta getMap() {
        return map;
    }

    public Coords getGoal() {
        return goal;
    }

    public RamblersSearch(Carta m, Coords g) {
        map = m;
        goal = g;
    }

}
