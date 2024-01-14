import java.util.ArrayList;

public class Player {
    //Instance Variables
    public String name;
    public Piece piece;
    public int money;
    private ArrayList<Place> placesOwned = new ArrayList<Place>();
    public int position = 1;
    public boolean jail = false;

    //Methods
    public void move(int distance){
        this.position += distance;
        this.piece.position += distance;
    }

    public String getPlaced(){
        String str = "";
        for(Place i: this.placesOwned){
            str += i.name + ", ";
        }
        return str;
    }

    public void addProperty(Place place){
        this.placesOwned.add(place);
    }

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
