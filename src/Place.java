import java.util.ArrayList;

public class Place extends Square{

    //Instance Variables
    public final int price;
    public final int initRent;
    public int rent;
    public double rentMultiplier;
    public final int mortgage;
    private boolean mortgaged = false;
    public final int length = 0;
    public final int width = 0;
    public Player owner = null;
    public ArrayList<House> houses = new ArrayList<House>();
    public Hotel hotel = null;
    public ArrayList<Place> set = new ArrayList<Place>(3);

    //Constructors
    public Place(String name, int price, int rent, int mortgage, int position){
        super(name, position);
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.mortgage = mortgage;
        this.position = position;
    }

    //Methods
    public void buy(Player buyer){
        if(this.owner == null){
            if(buyer.money >= this.price){
                if(buyer.position == this.position){
                    this.owner = buyer;
                    this.owner.money -= this.price;
                    this.owner.addProperty(this);
                }else{
                    System.out.println("Sorry you must be on the property to purchase it.");
                }
            }else{
                System.out.println("Sorry you cannot afford this property, the price is $" + this.price + ".");
            }
        }else{
            System.out.println("This property is already owned by " + this.owner + ", you cannot purchase it. Please initiate a trade instead.");
        }
    }

    public void mortgage(){
        if(this.mortgaged == false){
            this.owner.money += this.mortgage;
            this.mortgaged = true;
        }else{
            System.out.println("Sorry this property has already been mortgaged");
        }
    }

    public boolean mortgage(Player owner){
        if(this.owner == owner){
            if(this.mortgaged == false){
                this.owner.money += this.mortgage;
                this.mortgaged = true;
                return true;
            }else{
                System.out.println("Sorry this property has already been mortgaged.");
                return false;
            }
        }else{
            System.out.println("Sorry you don't own this property.");
            return false;
        }
    }



}
