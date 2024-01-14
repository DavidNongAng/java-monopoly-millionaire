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

    public void chance1(Player player){
        System.out.println("Take a Visit!\nTake a quick visit to the jail.");
        player.position = 9;
    }

    public void chance2(Player player){
        System.out.println("Donation!\nDonate $50,000 to the local animal shelter. ");
        player.money -= 50000;
        Main.showMoney(player);
    }

    public void chance3(Player player){
        System.out.println("You are Arrested!\nGo directly to jail.");
        player.position = 9;
        player.jail = true;
    }

    public void chance4(Player player){
        System.out.println("Back to Basics!\nPlayer is moved back to first position.");
        player.position = 1;
    }

    public void chance5(Player player){
        System.out.println("Uber!\nPlayer moves up 3 position.");
        player.position += 3;
    }

    public void lifeStyle1(Player player){
        System.out.println("Crypto Genius!\nPlayer Gains 25% of their current money.");
        player.money *= 1.25;
        Main.showMoney(player);
    }

    public void lifeStyle2(Player player){
        System.out.println("Stocks Crash!\nPlayer Loses 25% of their current money.");
        player.money *= 0.75;
        Main.showMoney(player);
    }

    public void lifeStyle3(Player player){
        System.out.println("Party Gone Wrong!\nPlayer hosts a celebrity party and loses $100,000 from property damage");
        player.money -= 100000;
        Main.showMoney(player);
    }

    public void lifeStyle4(Player player){
        System.out.println("Buy low Sell High?\nPlayer makes a profit of $20,0000 from stocks");
        player.money += 200000;
        Main.showMoney(player);
    }

    public void lifeStyle5(Player player){
        System.out.println("Business is Blooming!\nPlayer opens a small business and earns $250,000.");
        player.money += 250000;
        Main.showMoney(player);
    }
}
