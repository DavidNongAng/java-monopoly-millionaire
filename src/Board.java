import javax.swing.*;
import java.util.ArrayList;

public class Board {
    //Instance Variable
    public final int length;
    public final int width;
    private ArrayList<Place> places;
    private ArrayList<ActionSquare> cornerPieces = new ArrayList<ActionSquare>();
    private ArrayList<ActionSquare> specialTiles = new ArrayList<ActionSquare>();

    //Constructors
    public Board(int length, int width){
        this.length = length;
        this.width = width;
    }

    Board(int length, int width, ArrayList<Place> places, ArrayList<ActionSquare> cornerPieces, ArrayList<ActionSquare> specialTiles){
        this.length = length;
        this.width = width;
        this.places = places;
        this.cornerPieces = cornerPieces;
        this.specialTiles = specialTiles;
    }
}
