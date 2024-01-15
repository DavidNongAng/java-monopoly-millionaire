/*
    David Nong-Ang
    2024/01/15
    ActionSquare Class
    This subclass is used for the tiles on the board that has a prompt for the user.
 */

import javax.swing.*;
import java.util.ArrayList; //

public class ActionSquare extends Square{ //subclass inherited from the parent class "Square"

    //Instance Variable
    public final int length;
    public final int width;
    public final int ID;

    //Constructor
    public ActionSquare(int length, int width, String name, int position, int ID){
        super(name, position);
        this.length = length;
        this.width = width;
        this.name = name;
        this.position = position;
        this.ID = ID;
    }

    //Method

    public static ArrayList<ActionSquare> initializeCornerTiles(){
        ArrayList<ActionSquare> cornerPieces = new ArrayList<ActionSquare>(4);
        cornerPieces.add(new ActionSquare(2, 2, "Go", 1, 1));
        cornerPieces.add(new ActionSquare(2, 2, "Jail", 9, 2));
        cornerPieces.add(new ActionSquare(2, 2, "Free Parking", 17, 3));
        cornerPieces.add(new ActionSquare(2, 2, "Go To Jail", 25, 4));
        return cornerPieces;
    }

    public static ArrayList<ActionSquare> initializeSpecialTiles(){
        ArrayList<ActionSquare> specialTiles = new ArrayList<ActionSquare>(6);
        specialTiles.add(new ActionSquare(1, 1, "Millionaire Lifestyle", 3, 5));
        specialTiles.add(new ActionSquare(1, 1, "Chance", 6, 6));
        specialTiles.add(new ActionSquare(1, 1, "Millionaire Lifestyle", 14, 5));
        specialTiles.add(new ActionSquare(1, 1, "Chance", 19, 6));
        specialTiles.add(new ActionSquare(1, 1, "Millionaire Lifestyle", 28, 5));
        specialTiles.add(new ActionSquare(1, 1, "Chance", 30, 6));
        return specialTiles;
    }

}
