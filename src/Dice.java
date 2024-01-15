/*
    David Nong-Ang
    2024/01/15
    Dice Class
    This class is used for rolling and determine the player's location.
 */

import java.util.ArrayList; //imports the class for arraylists
import java.lang.Math; //imports the library for math methods.

public class Dice {

    //Instance Variable
    public int numOfSides = 2;
    public final int length;
    public final int width;
    private ArrayList<Integer> lastThreeRolls = new ArrayList<Integer>();

    //Constructor
    public Dice(int length, int width){
        this.length = length;
        this.width = width;
        this.lastThreeRolls.add(0,0);
        this.lastThreeRolls.add(1, 0);
        this.lastThreeRolls.add (2, 0);
    }

    //Overloading Constructor
    public Dice(int length, int width, int numOfSides){
        this.length = length;
        this.width = width;
        this.numOfSides = numOfSides;
    }

    //Methods

    //This method returns an integer from rolling the dice Object.
    public int roll(){
        int num = (int)((Math.random() * numOfSides) + 1); //returns a random number between 1 and 3.
        this.lastThreeRolls.add(0, num); //Adds the roll to the arraylist to keep track of the last 3 rolls to make sure its not all the same.
        if(this.lastThreeRolls.size() > 3){ //Check if the arraylist exceeds 3.
            this.lastThreeRolls.remove(this.lastThreeRolls.size() - 1); //Remove the 3rd value from the arraylist.
        }
        return num;
    }

    //This method returns the previous value of the dice roll.
    public int lastRoll(){
        int num = this.lastThreeRolls.get(0);
        return num;
    }

    //This method returns an integer array with the values of the last 3 rolls to determine if they are all the same or not.
    public int[] getLastThreeRolls(){
        int num[] = new int[3];
        for(int i = 0; i < 3; i++){ //loop through the array and set the elements as the arraylist's values.
            num[i] = this.lastThreeRolls.get(i);
        }
        return num;
    }

}
