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

    public static int printMenuSelect(){
        System.out.println("\nWelcome to Monopoly Millionaire\n");
        System.out.println("1. Play");
        System.out.println("2. Information");
        System.out.println("3. Exit Program\n");
        while(Main.menuChoice < 1 || Main.menuChoice > 3){
            try{
                if(Main.menuError){
                    System.out.println("Sorry, please enter a valid input (enter a number): \n");
                    System.out.println("1. Play");
                    System.out.println("2. Information");
                    System.out.println("3. Exit Program\n");
                }
                Main.menuError = true;
                Main.userInput = Main.input.nextLine();
                Main.menuChoice = Integer.parseInt(Main.userInput);

            }catch(NumberFormatException err){
                Main.menuChoice = 0;
            }
        }
        Main.menuError = false;
        return Main.menuChoice;
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
        System.out.println("Please choose an option (Enter a number): \n");
        System.out.println("1. Pay Bail");
        System.out.println("2. Roll for Doubles.\n");
        while(Main.menuChoice < 1 || Main.menuChoice > 2){
            try{
                if(Main.menuError == true){
                    System.out.println("Please enter a valid input (Enter a number): ");
                    System.out.println("1. Pay Bail");
                    System.out.println("2. Roll for Doubles\n");
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
        System.out.println("\nYour turn is over, please choose an option: (Enter a number): \n");
        System.out.println("1. Mortgage Property");
        System.out.println("2. Unmortgage Property");
        System.out.println("3. Build Houses/Hotels");
        System.out.println("4. List Owned Places");
        System.out.println("5. End Turn \n");
        while(Main.menuChoice < 1 || Main.menuChoice > 5){
            try{
                if(Main.menuError){
                    System.out.println("\nYour turn is over, please choose an option: (Enter a number): \n");
                    System.out.println("1. Mortgage Property");
                    System.out.println("2. Unmortgage Property");
                    System.out.println("3. Build Houses/Hotels");
                    System.out.println("4. List Owned Places");
                    System.out.println("5. End Turn \n");
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
        System.out.println("Please choose an option (enter a number): \n");
        System.out.println("1. Buy");
        System.out.println("2. Don't Buy\n");
        while(Main.menuChoice < 1 || Main.menuChoice > 2){
            try{
                if(Main.menuError){
                    System.out.println("Sorry please enter a valid input (Enter a number): \n");
                    System.out.println("1. Buy");
                    System.out.println("2. Don't Buy\n");
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
        System.out.println("\nPlease choose an option (Enter an integer): \n");
        System.out.println("1. Roll");
        System.out.println("2. Information");
        System.out.println("3. Exit\n");
        while(Main.menuChoice < 1 || Main.menuChoice > 3){
            try{
                if(Main.menuError){
                    System.out.println("Sorry, please enter a valid input (Enter an integer): \n");
                    System.out.println("1. Play");
                    System.out.println("2. Information");
                    System.out.println("3. Exit\n");
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

    public static void victoryScreen(){
        System.out.println("██╗░░░██╗░█████╗░██╗░░░██╗░██╗░░░░░░░██╗░█████╗░███╗░░██╗██╗");
        System.out.println("╚██╗░██╔╝██╔══██╗██║░░░██║░██║░░██╗░░██║██╔══██╗████╗░██║██║");
        System.out.println("░╚████╔╝░██║░░██║██║░░░██║░╚██╗████╗██╔╝██║░░██║██╔██╗██║██║");
        System.out.println("░░╚██╔╝░░██║░░██║██║░░░██║░░████╔═████║░██║░░██║██║╚████║╚═╝");
        System.out.println("░░░██║░░░╚█████╔╝╚██████╔╝░░╚██╔╝░╚██╔╝░╚█████╔╝██║░╚███║██╗");
        System.out.println("░░░╚═╝░░░░╚════╝░░╚═════╝░░░░╚═╝░░░╚═╝░░░╚════╝░╚═╝░░╚══╝╚═╝");
        System.out.println("Congratulations on your victory! Thanks for playing!");
        System.out.println("The program will now end, press 'run' if you wish to play again.");
        System.out.println("Thanks for playing!");
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
        System.out.println("Thanks for playing!");
    }



}
