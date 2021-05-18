/**
 * Coords.java
 *
 * Rebanth Kanner 2021 version
 * 
 * a map for searching
 * called Carta to avoid confusion with Interface map
 */

import java.util.*;

import java.io.*;

public class Carta {
    private ArrayList<CoordsLink> links;
    private HashSet coordinates;

      // accessors
    public ArrayList<CoordsLink> getAllLinks() {
        return links;
    }

    public HashSet getCoordinates() {
        return coordinates;
    }

    public Carta() {
        links = new ArrayList<CoordsLink>();
    }

    /*
   * addLink adds a link to a map
   * 
   * @param co1 coords1
   * @param co2 coords2
   * @param h1 height1
   * @param h2 height2
   */

  public void addLink(Coords co1, Coords co2, int h1, int h2) {
    CoordsLink cl = new CoordsLink(co1, co2, h1, h2);
    links.add(cl);
  }

  public String toString() {
    StringBuffer buf = new StringBuffer("MAP WITH LINKS\n");
    for (CoordsLink lnk : links) {
      String lstr = lnk.toString();
      buf.append(lstr + "\n");
    }
    return buf.toString();
  }

    /*
   * getLinks returns all links to/from the given coordinates
   * 
   * @param coords - the coordinates
   * @return ArrayList of links
   */
    
    public ArrayList<CoordsLink> getLinks(Coords coords) {
        ArrayList<CoordsLink> clinks = new ArrayList<CoordsLink>();
        for (CoordsLink l : links) {
            // System.out.println(coords == l.getCoords1());
            if (coords.equals(l.getCoords1())){
                // System.out.println("at least pass 1");
                clinks.add(l);
            }
        }
        return clinks;
    }

    /*
    * costbetween returns cost between 2 coordinates
    * 
    * @param co1 coords1
    * @param co2 coords2
    */

    public int costbetween(Coords co1, Coords co2) {
        ArrayList<CoordsLink> c1links = getLinks(co1);
        int ans = -1;
        Iterator i = c1links.iterator();
        while (i.hasNext() && (ans < 0)) {
            CoordsLink l = (CoordsLink) i.next();
            if (co2 == l.getCoords2()) {
                ans = l.getCost();
            }
        }
        return ans;
    }

    public void mapFromFile(String filename) {
        TerrainMap tm = new TerrainMap(filename);
        // System.out.println(tm.getTmap()[7][2]);
        for (int i = 0; i < tm.getDepth(); i++) {
            for (int j = 0; j < tm.getWidth(); j++) {
                // System.out.println(i < tm.getDepth());
                Coords co1 = new Coords(j, i);
                // System.out.println(i + ", " + j + ", " +tm.getDepth() + ", " +tm.getWidth() );
                int h1 = tm.getTmap()[i][j];
                if ((i+1) < tm.getDepth()){
                    
                    Coords co2 = new Coords(j, i+1);
                    int h2 = tm.getTmap()[i+1][j];
                    links.add(new CoordsLink(co1, co2, h1, h2));
                }

                if ((j+1) < tm.getWidth()){
                    Coords co2 = new Coords(j+1, i);
                    int h2 = tm.getTmap()[i][j+1];
                    links.add(new CoordsLink(co1, co2, h1, h2));
                }

                if ((j-1) >= 0){
                    Coords co2 = new Coords(j-1, i);
                    int h2 = tm.getTmap()[i][j-1];
                    links.add(new CoordsLink(co1, co2, h1, h2));
                }

                if ((i-1) >= 0){
                    Coords co2 = new Coords(j, i-1);
                    int h2 = tm.getTmap()[i-1][j];
                    links.add(new CoordsLink(co1, co2, h1, h2));
                }        
            }
        }
    //System.out.println(links.size());
    findCoordinates();
    }


    private void findCoordinates(){
        coordinates = new HashSet();
        for (CoordsLink l: links){
            coordinates.add(l.getCoords1());
        }
    }

}
