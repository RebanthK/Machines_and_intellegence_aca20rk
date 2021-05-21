/**
 * CoordsLink.java
 *
 * Rebanth Kanner 2021 version
 * 
 * a coordinate pair (y,x) for use in Ramblers problems to plot solution paths
 * on TerrainMaps
 */

public class CoordsLink {
    private Coords coords1;
    private Coords coords2;
    private int height1;
    private int height2;
    private int cost;

    /*
    * Constructor 
    * @param coords1 co1
    * @param coords2 co2
    * @param height1 h1
    * @param height2 h2
    */

    public CoordsLink(Coords co1, Coords co2, int h1, int h2){
        coords1 = co1;
        coords2 = co2;
        height1 = h1;
        height2 = h2;
        if (h2 > h1){
            cost = 1 + (h2 - h1);
        }
        else{
            cost = 1;
        }
    }

    //accessors

    public Coords getCoords1() {
        return coords1;
    }

    public Coords getCoords2() {
        return coords2;
    }

    public int getCost() {
        return cost;
    }

    public String toString(){
        return coords1.getx() + ", " + coords1.gety() + " to " + coords2.getx() + ", " + coords2.gety() + " " + cost;
    }
}
