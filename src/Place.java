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
        this.initRent = rent;
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

    public boolean unMortgage(Player owner){
        if(this.owner == owner){
            if(this.mortgaged == true){
                this.owner.money -= this.mortgage;
                this.mortgaged = false;
                return false;
            }else{
                System.out.println("Sorry this property hasn't been mortgaged.");
                return false;
            }
        }else{
            System.out.println("Sorry you don't own this property.");
            return false;
        }
    }

    public void changeOwnership(Player newOwner){
        if(this.owner != null){
            this.owner = newOwner;
        }else{
            System.out.println("Please buy this property first.");
        }
    }

    public boolean buildHouse(Player owner){
        if(owner == this.owner){
            if(this.owner.money >= (this.price / 2)){
                this.rent = this.initRent;
                House house = new House(this, (this.price/2), 1.5, .5 ,.5);
                this.houses.add(house);
                this.rentMultiplier += this.houses.get(0).rentMultiplier;
                this.owner.money -= this.houses.get(0).price;
                this.rent *= rentMultiplier;
                return true;
            }else{
                System.out.println("Sorry you don't have enough money to buy a house here, it costs $" + this.houses.get(0).price + " and you have $" + this.owner.money + " .");
                return false;
            }
        }else{
            System.out.println("Sorry you don't own this property.");
            return false;
        }
    }

    public boolean buildHotel(Player player){
        if(player == this.owner){
            if(this.houses. get(3) != null && this.owner.money >= this.houses.get(0).price){
                this.hotel = new Hotel(this, this.houses.get(0).price, 10.00, .5, .5, this.houses.get(0), this.houses.get(1), this.houses.get(2), this.houses.get(3));
                this.rentMultiplier = this.hotel.rentMultiplier;
                this.rent = this.initRent;
                this.rent *= rentMultiplier;
                this.owner.money -= this.hotel.price;
                this.houses.clear();
                return true;
            }else{
                System.out.println("Sorry you don't meet the critera to build a hotel on this property.");
                return false;
            }
        }else{
            System.out.println("Sorry you don't own this property.");
            return false;
        }
    }

    public void payRent(Player renter){
        renter.money -= this.rent;
        this.owner.money += this.rent;
    }

    public String toString(){
        return ("Name: " + this.name + ", Price: $" + this.price + ", Rent: $" + this.rent + ", Owner: " + this.owner.name + ".");
    }

}
