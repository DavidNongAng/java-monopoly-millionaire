public class Functions {

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





}
