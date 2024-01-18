import javax.swing.*;
import java.util.ArrayList;

public class Functions {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String WHITE = "\u001B[47m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String BLACK = "\u001B[30m";
    public static final String RESET = "\u001B[0m";

    public static String getName(){
        System.out.println("Please enter your name: ");
        String username = Main.input.nextLine();
        System.out.println("Press ENTER to start the game!");
        Main.input.nextLine();
        System.out.println();
        return username;
    }

    public static void printMainMenu(){
        System.out.println("1. Play\n2. Information\n3. Exit Program\n");
        while(Main.menuChoice < 1 || Main.menuChoice > 3){
            try{
                if(Main.menuError){
                    System.out.println("Sorry, please enter a valid input (enter a number): \n");
                    System.out.println("1. Play\n2. Information\n3. Exit Program\n");
                }
                Main.menuError = true;
                Main.userInput = Main.input.nextLine();
                Main.menuChoice = Integer.parseInt(Main.userInput);
            }catch(NumberFormatException err){
                Main.menuChoice = 0;
            }
        }
        Main.menuError = false;
    }

    public static void printInfoScreen(){
        System.out.println("Game Information");
        System.out.println("All players in the game will start with a balance of $372K and the goal is to reach $1M first. ");
        System.out.println("The player will take turns rolling the dice to determine any actions taken.");
        System.out.println("Users can purchase properties, claim cards, mortgage properties, build houses/hotels, etc. ");
        System.out.println("The first player to reach the goal of 1 Million dollars is the winner!");
    }

    public static void printJailMenu(){
        System.out.println("You are in jail! You may either roll for doubles or pay the bail of $50,000");
        System.out.println("Please choose an option (Enter a number): \n1. Pay Bail\n2. Roll for Doubles.\n");
        while(Main.menuChoice < 1 || Main.menuChoice > 2){
            try{
                if(Main.menuError){
                    System.out.println("Please enter a valid input (Enter a number):  \n1. Pay Bail\n2. Roll for Doubles.\n");
                }
                Main.menuError = true;
                Main.userInput = Main.input.nextLine();
                Main.menuChoice = Integer.parseInt(Main.userInput);
                System.out.println();
            }catch(NumberFormatException err){
                Main.menuChoice = 0;
            }
        }
        Main.menuError = false;
    }

    public static void printEndTurnMenu(){
        System.out.println("\nYour turn is over, please choose an option: (Enter a number): \n1. Mortgage Property\n2. Unmortgage Property\n3. Build Houses/Hotels\n4. List Owned Places\n5. End Turn \n");
        while(Main.menuChoice < 1 || Main.menuChoice > 5){
            try{
                if(Main.menuError){
                    System.out.println("\nYour turn is over, please choose an option: (Enter a number): \n1. Mortgage Property\n2. Unmortgage Property\n3. Build Houses/Hotels\n4. List Owned Places\n5. End Turn \n");
                }
                Main.menuError = true;
                Main.userInput = Main.input.nextLine();
                Main.menuChoice = Integer.parseInt(Main.userInput);
                System.out.println();
            }catch(NumberFormatException err){
                Main.menuChoice = 0;
            }
        }
        Main.menuError = false;
    }

    public static void printBuyMenu(){
        System.out.println("Please choose an option (enter a number): \n1. Buy\n2. Don't Buy\n");
        while(Main.menuChoice < 1 || Main.menuChoice > 2){
            try{
                if(Main.menuError){
                    System.out.println("Sorry please enter a valid input (Enter a number): \n1. Buy\n2. Don't Buy\n");
                }
                Main.menuError = true;
                Main.userInput = Main.input.nextLine();
                Main.menuChoice = Integer.parseInt(Main.userInput);
                System.out.println();
            }catch(NumberFormatException err){
                Main.menuChoice = 0;
            }
        }
        Main.menuError = false;
    }

    public static void printTurnScreen(){
        System.out.println("\nPlease choose an option (Enter an integer): \n1. Roll\n2. Information\n3. Exit\n");
        while(Main.menuChoice < 1 || Main.menuChoice > 3){
            try{
                if(Main.menuError){
                    System.out.println("Sorry, please enter a valid input (Enter an integer): \n1. Roll\n2. Information\n3. Exit\n");
                }
                Main.menuError = true;
                Main.userInput = Main.input.nextLine();
                Main.menuChoice = Integer.parseInt(Main.userInput);
                System.out.println();
            }catch(NumberFormatException err){
                Main.menuChoice = 0;
            }
        }
        Main.menuError = false;
    }

    public static void playerOneTurn(Player p1, Dice d1, Dice d2){
        System.out.println(p1.name + ", press ENTER to roll the dices: ");
        Main.input.nextLine();
        p1.move(d1.roll() + d2.roll());
        System.out.println("You moved "+ (d1.lastRoll() + d2.lastRoll()) + " spaces and are now on ");
    }

    public static void printDice(Dice d1){
        if(d1.lastRoll() == 1){
            printDice1();
        }
        if(d1.lastRoll() == 2){
            printDice2();
        }
        if(d1.lastRoll() == 3){
            printDice3();
        }
        if(d1.lastRoll() == 4){
            printDice4();
        }
        if(d1.lastRoll() == 5){
            printDice5();
        }
        if(d1.lastRoll() == 6){
            printDice6();
        }
    }

    public static void showMoney(Player p1){
        if(p1 instanceof HumanPlayer){
            System.out.println("You have $" + p1.money + ".");
        }else{
            System.out.println(p1.name + " have $" + p1.money + ".");
        }
    }

    public static void printDice1(){
        System.out.println(" ----- ");
        System.out.println("|"+WHITE+"     "+RESET+"|");
        System.out.println("|"+WHITE+"  "+BLACK+"o  "+RESET+"|");
        System.out.println("|"+WHITE+"     "+RESET+"|");
        System.out.println(" ----- ");
    }
    public static void printDice2(){
        System.out.println(" ----- ");
        System.out.println("|"+WHITE+" "+BLACK+"o   "+RESET+"|");
        System.out.println("|"+WHITE+"     "+RESET+"|");
        System.out.println("|"+WHITE+"   "+BLACK+"o "+RESET+"|");
        System.out.println(" ----- ");
    } // End of printDice2
    public static void printDice3(){
        System.out.println(" ----- ");
        System.out.println("|"+WHITE+" "+BLACK+"o   "+RESET+"|");
        System.out.println("|"+WHITE+"  "+BLACK+"o  "+RESET+"|");
        System.out.println("|"+WHITE+"   "+BLACK+"o "+RESET+"|");
        System.out.println(" ----- ");
    } // End of printDice3
    public static void printDice4(){
        System.out.println(" ----- ");
        System.out.println("|"+WHITE+" "+BLACK+"o o "+RESET+"|");
        System.out.println("|"+WHITE+"     "+RESET+"|");
        System.out.println("|"+WHITE+" "+BLACK+"o o "+RESET+"|");
        System.out.println(" ----- ");
    } // End of printDice4
    public static void printDice5(){
        System.out.println(" ----- ");
        System.out.println("|"+WHITE+" "+BLACK+"o o "+RESET+"|");
        System.out.println("|"+WHITE+"  "+BLACK+"o  "+RESET+"|");
        System.out.println("|"+WHITE+" "+BLACK+"o o "+RESET+"|");
        System.out.println(" ----- ");
    } // End of printDice5
    public static void printDice6(){
        System.out.println(" ----- ");
        System.out.println("|"+WHITE+" "+BLACK+"o o "+RESET+"|");
        System.out.println("|"+WHITE+" "+BLACK+"o o "+RESET+"|");
        System.out.println("|"+WHITE+" "+BLACK+"o o "+RESET+"|");
        System.out.println(" ----- ");
    } // End of printDice6

    public static void playerInJail(Player player, Dice d1, Dice d2){
        if(player.jail){
            Main.menuChoice = 0;
            printJailMenu();
            if(Main.menuChoice == 1){
                System.out.println("You chose to pay for bail, you lose $50,000.");
            }
            if(Main.menuChoice == 2){
                System.out.println("You chose to roll for doubles. \nPress ENTER to roll:");
                d1.roll();
                d2.roll();
                printDice(d1);
                printDice(d2);
                if(d1.lastRoll() == d2.lastRoll()){
                    System.out.println("Congratulations, You rolled doubles! You are now out of jail.");
                    player.jail = false;
                }else{
                    System.out.println("You did not roll doubles. Better luck next time.");
                }
            }
        }
    }

    public static void checkMillion(Player player){
        if(player.money>=1000000)
            victoryScreen();
        if(player.money<=0)
            lostScreen();
    }

    public static void playerTurn(Player player, Dice d1, Dice d2, Dice cardRNG, ArrayList<Square> tiles, Card chanceCards, Card lifeStyleCards){
        if(!player.jail){
            System.out.println("It is now your turn. Press enter to roll: ");
            Main.input.nextLine();
            player.move(d1.roll() + d2.roll());
            if(player.position > 32){
                player.position -= 32;
                player.money += 200000;
                System.out.println("Congratulations! You have passed 'Go' and gained $200,000!");
                showMoney(player);
            }
            printDice(d1);
            printDice(d2);
            System.out.println("You rolled: " + (d1.lastRoll() + d2.lastRoll()) + ".");
            for(int i  = 0; i < 32; i++){
                if(player.position == tiles.get(i).position)
                    Main.currentTile = tiles.get(i).name;
            }
            System.out.println("You are now at position: " + player.position + " and landed on " + Main.currentTile + ".");
            for(int i = 0; i < 32; i++){
                if(player.position == tiles.get(i).position){
                    if(tiles.get(i) instanceof Place){
                        if(((Place)tiles.get(i)).owner != null && ((Place)tiles.get(i)).owner != player){
                            System.out.println("You landed on someone else's property, you must pay rent. ");
                            ((Place)tiles.get(i)).payRent(player);
                            showMoney(player);
                            break;
                        }
                        if(((Place)tiles.get(i)).owner == player){
                            System.out.println("You landed on your own property, nothing happens. \nPress ENTER to continue: ");
                            Main.input.nextLine();
                            break;
                        }
                        if(((Place)tiles.get(i)).owner == null){
                            System.out.println(tiles.get(i).name + " is unowned. Would you like to buy it? ");
                            Main.menuChoice = 0;
                            printBuyMenu();
                            if(Main.menuChoice == 1){
                                ((Place)tiles.get(i)).buy(player);
                                System.out.println("You have purchased " + ((Place)tiles.get(i)).name + "!");
                                showMoney(player);
                                System.out.println("Press ENTER to continue: ");
                                Main.input.nextLine();
                                break;
                            }
                            if(Main.menuChoice == 2){
                                System.out.println("You decided not to buy the property.\nPress ENTER to continue: ");
                                Main.input.nextLine();
                                break;
                            }
                        }
                    }
                    if(tiles.get(i) instanceof ActionSquare){
                        if(((ActionSquare)tiles.get(i)).name == "Chance"){
                            cardRNG.roll();
                            switch (cardRNG.lastRoll()){
                                case 1:
                                    chanceCards.chance1(player);
                                    break;
                                case 2:
                                    chanceCards.chance2(player);
                                    break;
                                case 3:
                                    chanceCards.chance3(player);
                                    break;
                                case 4:
                                    chanceCards.chance4(player);
                                    break;
                                case 5:
                                    chanceCards.chance5(player);
                                    break;
                            }
                        }
                        if(((ActionSquare)tiles.get(i)).name == "Millionaire LifeStyle"){
                            cardRNG.roll();
                            switch (cardRNG.lastRoll()){
                                case 1:
                                    lifeStyleCards.lifeStyle1(player);

                                case 2:
                                    lifeStyleCards.lifeStyle2(player);
                                    break;
                                case 3:
                                    lifeStyleCards.lifeStyle3(player);
                                    break;
                                case 4:
                                    lifeStyleCards.lifeStyle4(player);
                                    break;
                                case 5:
                                    lifeStyleCards.lifeStyle5(player);
                                    break;
                            }
                        }
                        if(((ActionSquare)tiles.get(i)).name == "Go"){
                            System.out.println("You are on 'Go', nothing happens. \nPress ENTER to continue:");
                            Main.input.nextLine();
                            break;
                        }
                        if(((ActionSquare)tiles.get(i)).name == "Go To Jail"){
                            player.position = 9;
                            player.jail = true;
                            System.out.println("You are now in jail.\nPress enter to continue: ");
                            Main.input.nextLine();
                            break;
                        }
                        if(((ActionSquare)tiles.get(i)).name == "Free Parking"){
                            System.out.println("You are on 'Free Parking', nothing happens.\nPress enter to continue: ");
                            Main.input.nextLine();
                            break;
                        }
                        if(((ActionSquare)tiles.get(i)).name == "Jail"){
                            System.out.println("You are on 'Just Visiting', nothing happens.\nPress enter to continue: ");
                            Main.input.nextLine();
                            break;
                        }
                    }
                }
            }

        }
    }

    //Function for when player lands on a property
    //Function for when player lands on a action property
    //Function for roll doubles
    //

    public static void printSprite(){
        System.out.println();
        System.out.println("███╗░░░███╗░█████╗░███╗░░██╗░█████╗░██████╗░░█████╗░██╗░░░░░██╗░░░██╗");
        System.out.println("████╗░████║██╔══██╗████╗░██║██╔══██╗██╔══██╗██╔══██╗██║░░░░░╚██╗░██╔╝");
        System.out.println("██╔████╔██║██║░░██║██╔██╗██║██║░░██║██████╔╝██║░░██║██║░░░░░░╚████╔╝░");
        System.out.println("██║╚██╔╝██║██║░░██║██║╚████║██║░░██║██╔═══╝░██║░░██║██║░░░░░░░╚██╔╝░░");
        System.out.println("██║░╚═╝░██║╚█████╔╝██║░╚███║╚█████╔╝██║░░░░░╚█████╔╝███████╗░░░██║░░░");
        System.out.println("╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚══╝░╚════╝░╚═╝░░░░░░╚════╝░╚══════╝░░░╚═╝░░░");
        System.out.println();
        System.out.println("███╗░░░███╗██╗██╗░░░░░██╗░░░░░██╗░█████╗░███╗░░██╗░█████╗░██╗██████╗░███████╗");
        System.out.println("████╗░████║██║██║░░░░░██║░░░░░██║██╔══██╗████╗░██║██╔══██╗██║██╔══██╗██╔════╝");
        System.out.println("██╔████╔██║██║██║░░░░░██║░░░░░██║██║░░██║██╔██╗██║███████║██║██████╔╝█████╗░░");
        System.out.println("██║╚██╔╝██║██║██║░░░░░██║░░░░░██║██║░░██║██║╚████║██╔══██║██║██╔══██╗██╔══╝░░");
        System.out.println("██║░╚═╝░██║██║███████╗███████╗██║╚█████╔╝██║░╚███║██║░░██║██║██║░░██║███████╗");
        System.out.println("╚═╝░░░░░╚═╝╚═╝╚══════╝╚══════╝╚═╝░╚════╝░╚═╝░░╚══╝╚═╝░░╚═╝╚═╝╚═╝░░╚═╝╚══════╝");
    }

    public static void victoryScreen(){
        System.out.println("██╗░░░██╗░█████╗░██╗░░░██╗░██╗░░░░░░░██╗░█████╗░███╗░░██╗██╗");
        System.out.println("╚██╗░██╔╝██╔══██╗██║░░░██║░██║░░██╗░░██║██╔══██╗████╗░██║██║");
        System.out.println("░╚████╔╝░██║░░██║██║░░░██║░╚██╗████╗██╔╝██║░░██║██╔██╗██║██║");
        System.out.println("░░╚██╔╝░░██║░░██║██║░░░██║░░████╔═████║░██║░░██║██║╚████║╚═╝");
        System.out.println("░░░██║░░░╚█████╔╝╚██████╔╝░░╚██╔╝░╚██╔╝░╚█████╔╝██║░╚███║██╗");
        System.out.println("░░░╚═╝░░░░╚════╝░░╚═════╝░░░░╚═╝░░░╚═╝░░░╚════╝░╚═╝░░╚══╝╚═╝");
        System.out.println("Congratulations! Thanks for playing!");
        System.out.println("The program will now end, press 'run' if you wish to play again.");
    }

    public static void lostScreen(){
        System.out.println("███╗░░██╗██╗░█████╗░███████╗  ████████╗██████╗░██╗░░░██╗██╗");
        System.out.println("████╗░██║██║██╔══██╗██╔════╝  ╚══██╔══╝██╔══██╗╚██╗░██╔╝██║");
        System.out.println("██╔██╗██║██║██║░░╚═╝█████╗░░  ░░░██║░░░██████╔╝░╚████╔╝░██║");
        System.out.println("██║╚████║██║██║░░██╗██╔══╝░░  ░░░██║░░░██╔══██╗░░╚██╔╝░░╚═╝");
        System.out.println("██║░╚███║██║╚█████╔╝███████╗  ░░░██║░░░██║░░██║░░░██║░░░██╗");
        System.out.println("╚═╝░░╚══╝╚═╝░╚════╝░╚══════╝  ░░░╚═╝░░░╚═╝░░╚═╝░░░╚═╝░░░╚═╝");
        System.out.println("Nice try! Thanks for playing!");
        System.out.println("The program will now end, press 'run' if you wish to play again.");
    }



}
