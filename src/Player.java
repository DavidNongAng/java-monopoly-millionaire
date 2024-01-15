/*
    David Nong-Ang
    2024/01/15
    Player Class
    This abstract class is used as a base for the 2 types of player classes.
 */


import java.util.ArrayList; //imports the class for arraylists

public abstract class Player { //abstract class used as a base for other subclasses.
    //Instance Variables
    public String name;
    public Piece piece;
    public int money;
    private ArrayList<Place> placesOwned = new ArrayList<Place>();
    public int position = 1;
    public boolean jail = false;

    //Methods

    //This method takes an integer as a parameter and updates the player's position and its piece by adding.
    public void move(int distance){
        this.position += distance; //Add the distance to the player's position
        this.piece.position += distance; //Add the distance to the piece's position
    }

    //This function returns the list of places owned by the Player.
    public String getPlaces(){
        String str = ""; //Create a String variable.
        for(Place i: this.placesOwned){ //Loops through the arraylist with the places owned by the player.
            str += i.name + ", ";
        }
        return str;
    }

    //This method takes a Place object "place" as a parameter and adds it to the arrayList of places owned.
    public void addProperty(Place place){
        this.placesOwned.add(place);
    }

    //This method returns a String with all the places owned by the player.
    public String placeList(){
        String str = "none";
        for(int i = 0; i < this.placesOwned.size(); i++){
            if(i == 0 && i != this.placesOwned.size() - 1){
                str = this.placesOwned.get(i).name + ", ";
            } else if (i == 0 && i == this.placesOwned.size() - 1) {
                str = this.placesOwned.get(i).name;
            } else if (i == this.placesOwned.size()- 1) {
                str += this.placesOwned.get(i).name;
            } else{
                str += this.placesOwned.get(i).name + ", ";
            }
            if(str.equals("none")){
                return str;
            }
        }
        return str;
    }


}
