public class ActionSquare extends Square{

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

}
