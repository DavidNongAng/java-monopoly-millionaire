public class House {

    //Instance Variables
    public double length = 0;
    public double width = 0;
    public final String color = "green";
    private final Place place;
    public final int price;
    public final double rentMultiplier;

    //Constructors
    public House(Place place, int price, double multiplier) {
        this.place = place;
        this.price = price;
        this.rentMultiplier = multiplier;
    }

    public House(Place place, int price, double multiplier, double length, double width) {
        this.place = place;
        this.price = price;
        this.rentMultiplier = multiplier;
        this.length = length;
        this.width = width;
    }

    //Methods
    public String getPlace() {
        return this.place.name;
    }

    public String toString() {
        return ("Property: " + this.place.name + ", Price: $" + this.price + ", Rent Multiplier: " + this.rentMultiplier + ".");
    }

}
