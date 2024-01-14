import java.util.ArrayList;

public class HumanPlayer extends Player{
    //Constructors
    public HumanPlayer(){
        this.name = "Player One";
        this.piece = new Piece(1);
    }

    public HumanPlayer(String name, Piece piece, int money){
        this.name = name;
        this.piece = piece;
        this.money = money;
    }
}
