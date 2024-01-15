/*
    David Nong-Ang
    2024/01/15
    Place Class
    This subclass is used for all the places around the board.
 */


import java.util.ArrayList; //

public class Place extends Square{ //subclass inherited from the parent class "Square"

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

    //This method takes a Player object "buyer" as a parameter and checks if the "buyer" is eligible to purchase the property.
    public void buy(Player buyer){
        if(this.owner == null){ //Check if the property is not owned by someone.
            if(buyer.money >= this.price){ //check if the buyer has enough money to purchase the property.
                if(buyer.position == this.position){ //Check if the buyer is currently on the property.
                    this.owner = buyer; //set the owner as the buyer.
                    this.owner.money -= this.price; //subtract the cost of the property from the buyer.
                    this.owner.addProperty(this); //add the property to their list of properties.
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

    //This method checks if a property is eligible to be mortgaged.
    public void mortgage(){
        if(!this.mortgaged){ //Check if the property has been mortgaged or not.
            this.owner.money += this.mortgage; //add the amount from the mortgage to the property's owner.
            this.mortgaged = true; //change the status of the property to mortgaged.
        }else{
            System.out.println("Sorry this property has already been mortgaged");
        }
    }

    //This overloading method takes a Player object "owner" as parameters and checks if the "owner" is eligible for a mortgage on the property.
    public boolean mortgage(Player owner){
        if(this.owner == owner){ //Check if the player is the owner of the property.
            if(this.mortgaged == false){ //Check if the property has been mortgaged or not.
                this.owner.money += this.mortgage; //add the amount from the mortgage to the property's owner.
                this.mortgaged = true; //change the status of the property to mortgaged.
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

    //This method takes a Player object "owner" and returns a boolean depending on if they were able to mortgage the property or not.
    public boolean unMortgage(Player owner){
        if(this.owner == owner){ //Check if they own the property.
            if(this.mortgaged){ //Check if the property is mortgaged.
                this.owner.money -= this.mortgage; //subtract the amount from the owner.
                this.mortgaged = false; //change the status to unmortgaged.
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

    //This method takes a Player object "newOwner" as a parameter and changes the property's owner.
    public void changeOwnership(Player newOwner){
        if(this.owner != null){ //Check if the property has an owner.
            this.owner = newOwner; //change the owners.
        }else{
            System.out.println("Please buy this property first.");
        }
    }

    //This method takes a Player object "owner" as a parameter and returns a boolean depending on if they were able to build a house on the property or not.
    public boolean buildHouse(Player owner){
        if(owner == this.owner){ //Check if they own the property or not.
            if(this.owner.money >= (this.price / 2)){ //Check if the owner has enough money to purchase a house.
                this.rent = this.initRent; //set the price of the rent.
                House house = new House(this, (this.price/2), 1.5, .5 ,.5); //create a new House object.
                this.houses.add(house);  //Add this house to the arraylist.
                this.rentMultiplier += this.houses.get(0).rentMultiplier; //gets the rent multiplier from the first house.
                this.owner.money -= this.houses.get(0).price; //gets the price of the house from the first house.
                this.rent *= rentMultiplier; //increase the rent by multiplying by the rent multiplier.
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

    //This function takes a Player object "player" as a parameter and returns a boolean depending on if the player was able to build a house on their property or not.
    public boolean buildHotel(Player player){
        if(player == this.owner){ //check if the player is the owner of the property
            if(this.houses.get(3) != null && this.owner.money >= this.houses.get(0).price){ //check if the player has 4 houses on the property and enough money to buy a hotel.
                this.hotel = new Hotel(this, this.houses.get(0).price, 10.00, .5, .5, this.houses.get(0), this.houses.get(1), this.houses.get(2), this.houses.get(3)); //Create a new Hotel object.
                this.rentMultiplier = this.hotel.rentMultiplier; //change the rent multiplier into the hotel's one.
                this.rent = this.initRent; //change the rent into its initial one.
                this.rent *= rentMultiplier; //multiply the initial rent by the hotel rent multiplier.
                this.owner.money -= this.hotel.price; //subtract the money from the owner.
                this.houses.clear(); //clear the arraylist of houses.
                return true;
            }else{
                System.out.println("Sorry you don't meet the criteria to build a hotel on this property.");
                return false;
            }
        }else{
            System.out.println("Sorry you don't own this property.");
            return false;
        }
    }

    //This function takes a Player object "renter" as a parameter and subtracts their money to pay the rent for the property.
    public void payRent(Player renter){
        renter.money -= this.rent; //subtract the money from the person that landed on the property
        this.owner.money += this.rent; //add the money to the owner of the property.
    }

    //This function returns a String with the place's information.
    public String toString(){
        return ("Name: " + this.name + ", Price: $" + this.price + ", Rent: $" + this.rent + ", Owner: " + this.owner.name + ".");
    }

}
