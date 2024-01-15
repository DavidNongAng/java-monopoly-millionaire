/*
    David Nong-Ang
    2024/01/15
    ActionSquare Class
    This subclass is used for the tiles on the board that has a prompt for the user.
 */

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

}
