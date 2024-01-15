/*
    David Nong-Ang
    2024/01/15
    Square Class
    This class is for each tile around the board of the game.
 */

import java.util.ArrayList;


public class Square {

    //Instance Variables
    public String name;
    public int position;

    //Constructor
    public Square(String name, int position){
        this.name = name;
        this.position = position;
    }

    //Methods

    //This method demonstrates the use of polymorphism because it works with objects of different types but with shared base type.
    public static ArrayList<Square> initializeAllTiles(ArrayList<Place> places, ArrayList<ActionSquare> cornerPieces, ArrayList<ActionSquare> specialTiles){
        ArrayList<Square> tiles = new ArrayList<Square>(32);
        for(int i = 0; i < 22; i++)
            tiles.add(places.get(i));
        for(int i = 0; i < 4; i++)
            tiles.add(cornerPieces.get(i));
        for(int i = 0; i < 6; i++)
            tiles.add(specialTiles.get(i));
        return tiles;
    }



}
