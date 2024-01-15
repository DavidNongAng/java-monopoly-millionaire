/*
    David Nong-Ang
    2024/01/15
    HumanPlayer Class
    This subclass from the Player class is used to create the player's that are alive.
 */

import java.util.ArrayList;

public class HumanPlayer extends Player{

    //Constructors
    public HumanPlayer(){
        this.name = "Player One";
        this.piece = new Piece(1);
    }

    //Overloading Constructor
    public HumanPlayer(String name, Piece piece, int money){
        this.name = name;
        this.piece = piece;
        this.money = money;
    }

}
