public class Hotel extends House{
    //Construtors
    public Hotel(Place place, int price, double multiplier, House house1, House house2, House house3, House house4){
        super(place, price, multiplier);
    }

    public Hotel(Place place, int price, double multiplier, double length, double width, House house1, House house2, House house3, House house4){
        super(place, price, multiplier, length, width);
    }
}
