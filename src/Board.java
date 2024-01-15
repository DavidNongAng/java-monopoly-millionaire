/*
    David Nong-Ang
    2024/01/15
    Board Class
    This class is used for the board that the players will be playing on.
 */

import java.util.ArrayList; //imports the library for arraylist.

public class Board {

    //Instance Variable
    public final int length;
    public final int width;
    private ArrayList<Place> places;
    private ArrayList<ActionSquare> cornerPieces = new ArrayList<ActionSquare>();
    private ArrayList<ActionSquare> specialTiles = new ArrayList<ActionSquare>();

    //Constructor
    public Board(int length, int width){
        this.length = length;
        this.width = width;
    }

    //Overloaded Constructor
    Board(int length, int width, ArrayList<Place> places, ArrayList<ActionSquare> cornerPieces, ArrayList<ActionSquare> specialTiles){
        this.length = length;
        this.width = width;
        this.places = places;
        this.cornerPieces = cornerPieces;
        this.specialTiles = specialTiles;
    }
}
