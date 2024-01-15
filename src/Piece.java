/*
    David Nong-Ang
    2024/01/15
    Piece Class
    This class is used to represent the Player on the board of the game.
 */

public class Piece {

    //Instance Variable
    public final int id;
    public int position;

    //Constructors
    public Piece(int id){
        this.id = id;
    }

    //Method

    //This method is used to return a String with all the information of the piece.
    public String toString(){
        return ("ID: " + this.id + ", Position: " + this.position + ".");
    }
}
