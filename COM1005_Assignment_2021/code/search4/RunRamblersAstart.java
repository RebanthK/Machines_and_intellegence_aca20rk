/**
  * RunRamblersAstart.java
  *
  * Rebanth Kanner 2021 version
  * 
  * run A star map traversal 
 */

import java.util.*;

public class RunRamblersAstart {
    public static void main(String[] arg) {
    Carta map1 = new Carta();
    map1.mapFromFile("diablo.pgm");
    
    // coordinate pairs to be tested
    HashMap<Coords,Coords> pairs = new HashMap<Coords, Coords>();
    pairs.put(new Coords(194, 125), new Coords(212, 100));
    /*
    pairs.put(new Coords(65, 88), new Coords(66, 99));
    pairs.put(new Coords(12, 122), new Coords(45, 230));
    pairs.put(new Coords(104, 208), new Coords(153, 91));
    pairs.put(new Coords(36, 57), new Coords(32, 109));
    pairs.put(new Coords(158, 65), new Coords(154, 220));
    pairs.put(new Coords(182, 241), new Coords(89, 173));
    pairs.put(new Coords(174, 63), new Coords(17, 82));
    pairs.put(new Coords(166, 147), new Coords(164, 180));
    pairs.put(new Coords(207, 181), new Coords(105, 80));
    pairs.put(new Coords(195, 187), new Coords(230, 206));
    pairs.put(new Coords(24, 154), new Coords(20, 156));
    pairs.put(new Coords(137, 200), new Coords(211, 150));
    pairs.put(new Coords(205, 210), new Coords(218, 132));
    pairs.put(new Coords(243, 21), new Coords(203, 13));
    pairs.put(new Coords(137, 139), new Coords(224, 187));
    pairs.put(new Coords(100, 15), new Coords(89, 69));
    pairs.put(new Coords(122, 86), new Coords(110, 32));
    pairs.put(new Coords(115, 79), new Coords(42, 104));
    pairs.put(new Coords(194, 125), new Coords(212, 100));
    pairs.put(new Coords(22, 134), new Coords(40, 100));
    pairs.put(new Coords(67, 120), new Coords(19, 154));
    pairs.put(new Coords(146, 26), new Coords(121, 22));   
    pairs.put(new Coords(147, 147), new Coords(163, 235));
    pairs.put(new Coords(43, 226), new Coords(87, 101));
    pairs.put(new Coords(75, 16), new Coords(35, 5));
    pairs.put(new Coords(8, 4), new Coords(5, 55));
    pairs.put(new Coords(175, 100), new Coords(100, 75));
    pairs.put(new Coords(76, 103), new Coords(46, 148));
    pairs.put(new Coords(140, 193), new Coords(167, 102));
    pairs.put(new Coords(205, 178), new Coords(155, 100));
    pairs.put(new Coords(154, 200), new Coords(110, 193));
    pairs.put(new Coords(123, 210), new Coords(80, 145));
    pairs.put(new Coords(216, 35), new Coords(200, 43));
    pairs.put(new Coords(83, 149), new Coords(42, 120));
    pairs.put(new Coords(145, 51), new Coords(84, 52));
    pairs.put(new Coords(6, 103), new Coords(20, 140));
    pairs.put(new Coords(71, 143), new Coords(130, 101));
    pairs.put(new Coords(8, 0), new Coords(25, 17));
    pairs.put(new Coords(32, 9), new Coords(60, 20));
    pairs.put(new Coords(164, 184), new Coords(121, 200));
    pairs.put(new Coords(26, 29), new Coords(46, 42));
    pairs.put(new Coords(101, 158), new Coords(114, 163));
    pairs.put(new Coords(19, 18), new Coords(19, 38));
    pairs.put(new Coords(146, 142), new Coords(167, 130));
    pairs.put(new Coords(169, 100), new Coords(131, 74));
    pairs.put(new Coords(202, 170), new Coords(180, 190));
    pairs.put(new Coords(150, 172), new Coords(197, 200));
    pairs.put(new Coords(155, 125), new Coords(125, 130));
    pairs.put(new Coords(88, 93), new Coords(70, 73));
    pairs.put(new Coords(0, 0), new Coords(200, 200));
    */

    for (Coords m: pairs.keySet()){
      RamblersSearch searcher = new RamblersSearch(map1, pairs.get(m));
      SearchState initState = (SearchState) new RamblersState(m, 0, 0);
      float res_bb = searcher.runSearchE(initState, "AStar");
      System.out.println("init state = " + initState.toString());
      System.out.println(res_bb);
      System.out.println("\n");
    }
  }
}

