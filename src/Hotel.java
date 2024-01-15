/*
    David Nong-Ang
    2024/01/15
    Hotel Class
    This is a subclass used to make Hotels on the properties owned by players.
 */

public class Hotel extends House{ //subclass inherited from the parent class "House"

    //Construtor
    public Hotel(Place place, int price, double multiplier, House house1, House house2, House house3, House house4){
        super(place, price, multiplier);
    }

    //Overloading Constructor
    public Hotel(Place place, int price, double multiplier, double length, double width, House house1, House house2, House house3, House house4){
        super(place, price, multiplier, length, width);
    }
}
