public class Piece {
    //Instance Variable
    public final int id;
    public int position;

    //Constructors
    public Piece(int id){
        this.id = id;
    }

    public String toString(){
        return ("ID: " + this.id + ", Position: " + this.position + ".");
    }
}
