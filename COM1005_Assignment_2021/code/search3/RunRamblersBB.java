
/**
  * RunRamblersBB.java
  *
  * 
  * Rebanth Kanner 2021 version
  run a Ramblers Branch and Bound Search
**/

import java.util.*;

public class RunRamblersBB {
    public static void main(String[] arg){
        Carta map1 = new Carta();
        map1.mapFromFile("diablo.pgm");

        RamblersSearch searcher = new RamblersSearch(map1, new Coords(104, 99));
        SearchState initState = (SearchState) new RamblersState(new Coords(0, 0), 0);

        String res_bb = searcher.runSearch(initState, "branchAndBound");
        System.out.println(res_bb);
    }
}
