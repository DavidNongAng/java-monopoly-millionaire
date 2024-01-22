import javax.swing.*;
import java.util.ArrayList;

public class Functions {

    public static final String WHITE = "\u001B[47m";
    public static final String BLACK = "\u001B[30m";
    public static final String RESET = "\u001B[0m";

    //This function asks the user for their main and returns it as a String.
    public static String getName(){
        System.out.println("Please enter your name: ");
        String username = Main.input.nextLine();
        System.out.println("Press ENTER to start the game!");
        Main.input.nextLine();
        System.out.println();
        return username;
    }

    //This function displays the main menu at the beginning of the program.
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

    //This function displays the information option of the menu.
    public static void printInfoScreen(){
        System.out.println("Game Information");
        System.out.println("All players in the game will start with a balance of $372K and the goal is to reach $1M first. ");
        System.out.println("The player will take turns rolling the dice to determine any actions taken.");
        System.out.println("Users can purchase properties, claim cards, mortgage properties, build houses/hotels, etc. ");
        System.out.println("The first player to reach the goal of 1 Million dollars is the winner!");
    }

    //This function displays the jail menu when the player is in the jail.
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

    //This function displays the menu for the player after they complete their turn.
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

    //This function displays the buy menu when the player lands on a property.
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

    //This function takes a Player object as a parameter and displays their money.
    public static void showMoney(Player p1){
        if(p1 instanceof HumanPlayer){
            System.out.println("You have $" + p1.money + ".");
        }else{
            System.out.println(p1.name + " have $" + p1.money + ".");
        }
    }

    //This function takes a Player object as a parameter and check's if they passed the "Go" tile on the board and gives them money.
    public static void checkGo(Player p1){
        if (p1.position > 32) { // Check if they pass the Start Position.
            p1.position -= 32;
            p1.money += 200000;
            System.out.println("Congratulations!" + p1.name + " have passed 'Go' and gained $200,000!");
            showMoney(p1);
        }
    }

    //This function takes a Player object as a parameter and check's if they have achieved $1 Million or have no money and displays a screen depending on it.
    public static void checkMillion(Player player){
        if(player.money>=1000000)
            victoryScreen();
        if(player.money<=0)
            lostScreen();
    }

    //This function takes a Player object and 2 Dice objects as parameters and is used for when the user is in jail.
    public static void playerJail(Player player, Dice d1, Dice d2){
        //Checks if the player is in jail.
        if(player.jail){
            Main.menuChoice = 0;
            printJailMenu(); //Display the jail menu.

            //If the user chooses to pay to get out of jail.
            if(Main.menuChoice == 1){
                System.out.println("You chose to pay for bail, you lose $50,000.");
                player.jail = false;
            }
            //If the user chooses to roll their dices for doubles to get out of jail.
            if(Main.menuChoice == 2){
                System.out.println("You chose to roll for doubles. \nPress ENTER to roll:");
                d1.roll();
                d2.roll();
                printDice(d1);
                printDice(d2);
                if(d1.lastRoll() == d2.lastRoll()){ //Checks if they got a double.
                    System.out.println("Congratulations, You rolled doubles! You are now out of jail.");
                    player.jail = false;
                }else{
                    System.out.println("You did not roll doubles. Better luck next time.");
                }
            }
        }
    }

    //This function takes a lot of different class objects as its parameter and runs the player's turn in the game.
    public static void playerTurns(Player p1, Dice rng, Dice d1, Dice d2, ArrayList<Square> tiles, Dice cardRNG, Card chanceCards, Card lifeStyleCards, ArrayList<Place> places){
        //Check if the player is in jail.
        playerJail(p1, d1, d2);

        //Check if they achieved 1 Million or bankrupted.
        checkMillion(p1);

        //When player is not in jail.
        if(!p1.jail){
            System.out.println("It is now your turn. Press ENTER to roll: ");
            Main.input.nextLine();
            p1.move(d1.roll() + d2.roll());
            mainGame(p1, rng, d1, d2, tiles, cardRNG, chanceCards, lifeStyleCards); //Runs the function for the main game.
            rollDoubles(p1, rng, d1, d2, tiles, cardRNG, chanceCards, lifeStyleCards); //Runs the function for when the user rolls a double.
        }
        Main.menuChoice = 0;
        endTurn(p1, places); //Runs the function for after their turn ends, if they want to do anything after.
    }//end function

    //This function 
    public static void endTurn(Player p1, ArrayList<Place> places){
        printEndTurnMenu(); //Display choices after their turn ends.
        while(Main.menuChoice != 5){
            if(Main.menuChoice != 4){
                printEndTurnMenu();
            }
            while(Main.menuChoice == 1){
                System.out.println("Please choose a property you own to mortgage. You can also type 'exit' to back out.");
                Main.mortgageProperty = Main.input.nextLine().toLowerCase();
                if(Main.mortgageProperty.equals("exit")){
                    Main.menuChoice = 0;
                    break;
                }
                for(int i = 0; i < 22; i++){
                    if(i == 22){
                        System.out.println("Sorry that property could not be found.");
                    }
                    if(Main.mortgageProperty.equals(places.get(i).name.toLowerCase())){
                        if(!places.get(i).mortgage(p1)){
                            Main.menuChoice = 0;
                            break;
                        }else{
                            System.out.println(places.get(i).name + " has been mortgaged.\nYou gained $" + places.get(i).mortgage + " and you now have $" + p1.money + ".");
                            Main.menuChoice = 0;
                            break;
                        }
                    }
                }
            }
            while(Main.menuChoice == 2){
                System.out.println("Please choose a property you own to unmortgage. You can also type 'exit' to back out.");
                Main.mortgageProperty = Main.input.nextLine().toLowerCase();
                if(Main.mortgageProperty.equals("exit")){
                    Main.menuChoice = 0;
                    break;
                }
                for(int i = 0; i < 22; i++){
                    if(i == 22){
                        System.out.println("Sorry that property could not be found.");
                    }
                    if(Main.mortgageProperty.equals(places.get(i).name.toLowerCase())){
                        if(!places.get(i).unMortgage(p1)){
                            Main.menuChoice = 0;
                            break;
                        }else{
                            System.out.println(places.get(i).name + " has been unmortgaged.\nYou paid $" + places.get(i).unMortgage(p1) + " and you now have $" + p1.money + ".");
                            Main.menuChoice = 0;
                            break;
                        }
                    }
                }
            }
            while(Main.menuChoice == 3){
                System.out.println("Please enter a property to build a house/hotel on (enter property name). You can also type 'exit' to back.");
                Main.mortgageProperty = Main.input.nextLine().toLowerCase();
                if(Main.mortgageProperty.equals("exit")){// allows player to exit menu
                    Main.menuChoice = 0;
                    break;
                }
                for(int i = 0; i < 22; i++){
                    if(i == 22){
                        System.out.println("Sorry that property could not be found.");
                        break;
                    }
                    if(Main.mortgageProperty.equals(places.get(i).name.toLowerCase())){
                        if(places.get(i).hotel != null){
                            System.out.println("You already have a hotel here, you cannot build anything else.");
                            Main.menuChoice = 0;
                            break;
                        }
                        if(places.get(i).houses.size() != 4){
                            if(!places.get(i).buildHouse(p1)){
                                Main.menuChoice = 0;
                                break;
                            }
                            System.out.println("You built a house on " + places.get(i).name + " for $" + places.get(i).houses.get(i).price + ".\nYou have " + places.get(i).houses.size() + " house(s). \nThe new rent is $" + places.get(i).rent + ".");
                            showMoney(p1);
                            Main.menuChoice = 0;
                            break;
                        }
                        if(places.get(i).houses.size() == 4){
                            if(!places.get(i).buildHotel(p1)){
                                Main.menuChoice = 0;
                                break;
                            }
                            System.out.println("You build a hotel on " + places.get(i).name + " for $" + places.get(i).hotel.price + ".\nThe new rent is $" + places.get(i).rent + ".");
                            showMoney(p1);
                            Main.menuChoice = 0;
                            break;
                        }
                    }
                }
            }
            if(Main.menuChoice == 4){
                System.out.println("You own " + p1.placeList() + ".\nPress ENTER to continue: ");
                Main.input.nextLine();
                break;
            }
            if(Main.menuChoice == 5){
                Main.menuChoice = 0;
                break;
            }
        } //end while loop
    }

    public static void cpuJail(Player cpu, Dice rng, Dice d1, Dice d2){
        if(cpu.jail && !(cpu.money <= 0)){
            Main.menuChoice = 0;
            if(rng.roll() > 7){
                Main.menuChoice = 2;
            }else{
                Main.menuChoice = 1;
            }
            if(Main.menuChoice == 1){
                System.out.println(cpu.name + " decided to pay for bail, " + cpu.name + " loses $50,000.");
                cpu.jail = false;
            }
            if(Main.menuChoice == 2){
                System.out.println(cpu.name + " have chosen to roll for doubles. \nPress enter to roll:");
                d1.roll();
                d2.roll();
                printDice(d1);
                printDice(d2);
                if(d1.lastRoll() == d2.lastRoll()){
                    System.out.println("Congratulations, " + cpu.name + " rolled doubles! " + cpu.name + " is now out of jail.");
                    cpu.jail = false;
                }else{
                    System.out.println(cpu.name + " did not roll doubles. Better luck next time. ");
                }
            }
        } //when in jail
    }


    public static void cpuTurns(Player cpu, Dice rng, Dice d1, Dice d2, ArrayList<Square> tiles, Dice cardRNG, Card chanceCards, Card lifeStyleCards){
        //Check if the cpu ran out of money
        if(cpu.money <= 0){
            System.out.println(cpu.name + " has been eliminated. \nPress ENTER to continue: ");
            Main.input.nextLine();
        }

        //When cpu is in jail
        cpuJail(cpu, rng, d1, d2);

        //Check if cpu has 1 million
        if(cpu.money >= 1000000){
            Main.gameOver = true;
            System.out.println( cpu.name + " has achieved one million dollars!");
            if(Main.gameOver){
                lostScreen();
            }
        }

        //When cpu is NOT in jail
        if(!cpu.jail && !(cpu.money <= 0)){
            System.out.println("It is now " + cpu.name + "'s turn. Press ENTER to roll for them: ");
            Main.input.nextLine();
            cpu.move(d1.roll() + d2.roll());
            mainGame(cpu, rng, d1, d2, tiles, cardRNG, chanceCards, lifeStyleCards);
            rollDoubles(cpu, rng, d1, d2, tiles, cardRNG, chanceCards, lifeStyleCards);
        }//end if
    }//end function


    public static void mainGame(Player player, Dice rng, Dice d1, Dice d2, ArrayList<Square> tiles, Dice cardRNG, Card chanceCards, Card lifeStyleCards){
        //Check if they passed "Go".
        checkGo(player);

        printDice(d1);
        printDice(d2);
        System.out.println(player.name + " rolled: " + (d1.lastRoll() + d2.lastRoll()) + ".");

        //Move to that position
        for(int i = 0; i < 32; i++){
            if(player.position == tiles.get(i).position){
                Main.currentTile = tiles.get(i).name;
            }
        }

        System.out.println(player.name + " are now at position " + player.position + " and landed on " + Main.currentTile + ".");

        //Check what property they landed on.
        for(int i = 0; i < 32; i++){
            //Check if the position matches the property.
            if(player.position == tiles.get(i).position){
                //If the cpu landed on a property.
                if(tiles.get(i) instanceof Place){
                    if(((Place)tiles.get(i)).owner != null && ((Place)tiles.get(i)).owner != player){ //If they land on someone else's property.
                        System.out.println(player.name + " landed on a property that someone else owns, " + player.name + " must pay rent.");
                        ((Place)tiles.get(i)).payRent(player);
                        showMoney(player);
                        break;
                    }
                    if(((Place)tiles.get(i)).owner == player){ //If they land on their own property.
                        System.out.println(player.name + " landed on their own property, nothing happens.\nPress ENTER to continue.");
                        Main.input.nextLine();
                        break;
                    }
                    if(((Place)tiles.get(i)).owner == null){ //If they land on a vacant property.
                        System.out.println(tiles.get(i).name + " is unowned. Would you like to buy it?");
                        Main.menuChoice = 0;

                        //If it's a CPU use RNG, if it's a player, let them decide.
                        if(player instanceof CPU){
                            if(rng.roll() > 7){
                                Main.menuChoice = 2;
                            }else{
                                Main.menuChoice = 1;
                            }
                        }
                        if(player instanceof HumanPlayer){
                            printBuyMenu();
                        }

                        if(Main.menuChoice == 1){
                            ((Place)tiles.get(i)).buy(player);
                            System.out.println(player.name + " has purchased " + ((Place)tiles.get(i)).name + "!");
                            showMoney(player);
                            System.out.println("Press ENTER to continue:");
                            Main.input.nextLine();
                            break;
                        }
                        if(Main.menuChoice == 2){
                            System.out.println(player.name + " decided to not buy the property.\nPress ENTER to continue: ");
                            Main.input.nextLine();
                            break;
                        }
                    }
                }
                //If the cpu landed on an action square like chance of millionaire lifestyle.
                if(tiles.get(i) instanceof ActionSquare){
                    if(((ActionSquare)tiles.get(i)).name == "Chance"){
                        switch(cardRNG.roll()){
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
                        break;
                    }
                    if(((ActionSquare)tiles.get(i)).name == "Millionaire Lifestyle"){
                        switch(cardRNG.roll()){
                            case 1:
                                lifeStyleCards.lifeStyle1(player);
                                break;
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
                        break;
                    }

                    //If the cpu lands on a corner tile of the board.
                    if(((ActionSquare)tiles.get(i)).name == "Go"){
                        System.out.println(player.name + " is on 'Go', nothing happens. \nPress ENTER to continue: ");
                        Main.input.nextLine();
                        break;
                    }
                    if(((ActionSquare)tiles.get(i)).name == "Go To Jail"){
                        player.position = 9;
                        player.jail = true;
                        System.out.println(player.name + " is now in jail.\nPress ENTER to continue: ");
                        Main.input.nextLine();
                        break;
                    }
                    if(((ActionSquare)tiles.get(i)).name == "Free Parking"){
                        System.out.println(player.name + " is on 'Free Parking', nothing happens.\nPress ENTER to continue: ");
                        Main.input.nextLine();
                        break;
                    }
                    if(((ActionSquare)tiles.get(i)).name == "Jail"){
                        System.out.println(player.name + " is on 'Just Visiting', nothing happens.\nPress enter to continue: ");
                        Main.input.nextLine();
                        break;
                    }
                }
            }
        }//end for loop
    }

    public static void rollDoubles(Player player, Dice rng, Dice d1, Dice d2, ArrayList<Square> tiles, Dice cardRNG, Card chanceCards, Card lifeStyleCards){
        while(d1.lastRoll() == d2.lastRoll()){
            Main.doublesCount++;
            if(Main.doublesCount == 3){
                System.out.println("Sorry" + player.name + "rolled doubles three times in a row. " + player.name + " will proceed directly to jail.");
                player.position = 9;
                player.jail = true;
                break;
            }
            System.out.println("Congratulations! " + player.name + " rolled doubles, " + player.name + " gets to roll again. Press enter to roll: ");
            Main.input.nextLine();
            player.move(d1.roll() + d2.roll());
            mainGame(player, rng, d1, d2, tiles, cardRNG, chanceCards, lifeStyleCards);
        }
        Main.doublesCount = 0;
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
