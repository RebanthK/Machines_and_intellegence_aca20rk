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
    map1.mapFromFile("tmc.pgm");

    RamblersSearch searcher = new RamblersSearch(map1, new Coords(5, 8));
    SearchState initState = (SearchState) new RamblersState(new Coords(7, 0), 0, 0);

    String res_astar = searcher.runSearch(initState, "AStar");
    System.out.println(res_astar);
    } 
}
