import java.util.ArrayList;
import java.lang.Math;

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

    public Dice(int length, int width, int numOfSides){
        this.length = length;
        this.width = width;
        this.numOfSides = numOfSides;
    }

    //Methods
    public int roll(){
        int num = (int)((Math.random() * numOfSides) + 1);
        this.lastThreeRolls.add(0, num);
        if(this.lastThreeRolls.size() > 3){
            this.lastThreeRolls.remove(this.lastThreeRolls.size() - 1);
        }
        return num;
    }

    public int lastRoll(){
        int num = this.lastThreeRolls.get(0);
        return num;
    }

    public int[] getLastThreeRolls(){
        int num[] = new int[3];
        for(int i = 0; i < 3; i++){
            num[i] = this.lastThreeRolls.get(i);
        }
        return num;
    }

}
