/*
    David Nong-Ang
    2024/01/15
    Card Class
    This class is used for the random cards that the player's can land on in the game.
 */

public class Card {

    //Instance Variables
    public final int length;
    public final int width;
    public final int cardID;
    public final String cardType;

    //Constructor
    public Card(int length, int width, int cardID, String cardType){
        this.length = length;
        this.width = width;
        this.cardID = cardID;
        this.cardType = cardType;
    }

    //Methods

    //This method takes a Player object as a parameter and moves their position to 9.
    public void chance1(Player player){
        System.out.println("Take a Visit!\nTake a quick visit to the jail.");
        player.position = 9;
    }

    //This method takes a Player object as a parameter and subtracts 50000 from them.
    public void chance2(Player player){
        System.out.println("Donation!\nDonate $50,000 to the local animal shelter. ");
        player.money -= 50000;
        Functions.showMoney(player);
    }

    //This method takes a Player object as a parameter and puts them in jail.
    public void chance3(Player player){
        System.out.println("You are Arrested!\nGo directly to jail.");
        player.position = 9;
        player.jail = true;
    }

    //This method takes a Player object as a parameter and moves their position to 1.
    public void chance4(Player player){
        System.out.println("Back to Basics!\nPlayer is moved back to first position.");
        player.position = 1;
    }

    //This method takes a Player object as a parameter and moves their position up 3.
    public void chance5(Player player){
        System.out.println("Uber!\nPlayer moves up 3 position.");
        player.position += 3;
    }

    //This method takes a Player object as a parameter and increases their money by 1.25.
    public void lifeStyle1(Player player){
        System.out.println("Crypto Genius!\nPlayer Gains 25% of their current money.");
        player.money *= 1.25;
        Functions.showMoney(player);
    }

    //This method takes a Player object as a parameter and decreases their money by 0.75.
    public void lifeStyle2(Player player){
        System.out.println("Stocks Crash!\nPlayer Loses 25% of their current money.");
        player.money *= 0.75;
        Functions.showMoney(player);
    }

    //This method takes a Player object as a parameter and decreases their money by 100000.
    public void lifeStyle3(Player player){
        System.out.println("Party Gone Wrong!\nPlayer hosts a celebrity party and loses $100,000 from property damage");
        player.money -= 100000;
        Functions.showMoney(player);
    }

    //This method takes a Player object as a parameter and increases their money by 200000.
    public void lifeStyle4(Player player){
        System.out.println("Buy low Sell High?\nPlayer makes a profit of $200,000 from stocks");
        player.money += 200000;
        Functions.showMoney(player);
    }

    //This method takes a Player object as a parameter and increases their money by 250000.
    public void lifeStyle5(Player player){
        System.out.println("Business is Blooming!\nPlayer opens a small business and earns $250,000.");
        player.money += 250000;
        Functions.showMoney(player);
    }
}
