public class Functions {

    public static String getName(){
        System.out.println("Please enter your name: ");
        String username = Main.input.nextLine();
        System.out.println("Press ENTER to start the game!");
        Main.input.nextLine();
        System.out.println();
        return username;
    }

}
