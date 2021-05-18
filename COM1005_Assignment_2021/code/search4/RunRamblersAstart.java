/**
  * RunRamblersAstart.java
  *
  * Rebanth Kanner 2021 version
  * 
  * run A star map traversal 
 */

public class RunRamblersAstart {
    public static void main(String[] arg) {

    Carta map1 = new Carta();
    map1.mapFromFile("diablo.pgm");

    RamblersSearch searcher = new RamblersSearch(map1, new Coords(104, 99));
    SearchState initState = (SearchState) new RamblersState(new Coords(0, 0), 0, 0);

    float res_astar = searcher.runSearchE(initState, "AStar");
    System.out.println(res_astar);
    } 
}
