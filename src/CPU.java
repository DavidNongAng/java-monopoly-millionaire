/*
    David Nong-Ang
    2024/01/15
    CPU Class
    This subclass is used to create the CPU players if there is no other players to play against the user.
 */

import java.util.ArrayList;

public class CPU extends Player{ //subclass inherited from the parent class "Player"

    //Constructor
    public CPU(Piece piece, int money, String name){
        this.piece = piece;
        this.money = money;
        this.name = name;
    }
}
