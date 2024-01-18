/*
    David Nong-Ang
    2024/01/15
    Monopoly Millionaire Project
    This is the main class for the code.
 */

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.io.*;

public class Main {

    // Scanner Object
    public static Scanner input = new Scanner(System.in);

    //Public Variables
    public static String username = null;
    public static String userInput = null;
    public static int menuChoice = 0;
    public static int gameLoop = 0;
    public static boolean menuError = false;
    public static String currentTile = null;
    public static int currentTileInt = 0;
    public static int doublesCount = 0;
    public static String mortgageProperty = null;
    public static boolean gameOver = false;


    public static void main(String[] args) {

        //Username
        username = Functions.getName();

        //Dice Objects
        Dice diceOne = new Dice(100, 100, 6);
        Dice diceTwo = new Dice(100, 100, 6);
        Dice rng = new Dice(100, 100, 10);
        Dice cardRNG  = new Dice(100, 100, 5);

        //Player Objects
        Player p1 = new HumanPlayer(username, new Piece(0), 372000);
        Player cpu1 = new CPU(new Piece(1), 372000, "AI 1");
        Player cpu2 = new CPU(new Piece(2), 372000, "AI 2");
        Player cpu3 = new CPU(new Piece(3), 372000, "AI 3");

        //Place Objects
        ArrayList<Place> places = Place.initializePlace();

        //Corner Tile Objects
        ArrayList<ActionSquare> cornerTiles = ActionSquare.initializeCornerTiles();

        //Special Tile Objects
        ArrayList<ActionSquare> specialTiles = ActionSquare.initializeSpecialTiles();

        //Create object for all Tiles on the Board
        ArrayList<Square> tiles = Square.initializeAllTiles(places, cornerTiles, specialTiles);

        //Board Object
        Board board = new Board(22, 22, places, cornerTiles, specialTiles);

        //Card Object
        Card chanceCards = new Card(100, 100, 1, "Chance");
        Card lifeStyleCards = new Card(100, 100, 2, "LifeStyle");

        do{
            menuChoice = Functions.printMenuSelect();

            if(menuChoice == 1){
                System.out.println("Welcome to Monopoly Millionaire, you start off with $372K and the goal is to achieve 1 Million $ before the three other opponents: AI 1, AI 2, AI 3.");
                gameLoop = menuChoice;

                while(gameLoop == 1 && !gameOver){


                    if(p1.jail){
                        menuChoice = 0;
                        Functions.printJailMenu();
                        if(menuChoice == 1){
                            System.out.println("You decided to pay for the bail, you lose $50,000");
                            p1.jail = false;
                        }
                        if(menuChoice == 2){
                            System.out.println("You have chosen to roll for doubles. \nPress enter to roll: ");
                            diceOne.roll();
                            diceTwo.roll();

                            Functions.printDice(diceOne);
                            Functions.printDice(diceTwo);

                            if(diceOne.lastRoll() == diceTwo.lastRoll()){
                                System.out.println("Congratulations, you rolled doubles! You are now out of jail.");
                                p1.jail = false;
                            }else{
                                System.out.println("You did not roll doubles. Better luck next time.");
                            }

                        }
                    }

                    if(p1.money >= 1000000)
                        Functions.victoryScreen();
                    if(p1.money <= 0)
                        Functions.lostScreen();


                    if(!p1.jail){
                        System.out.println("It is your turn. Press ENTER to roll: ");
                        input.nextLine();
                        p1.move(diceOne.roll() + diceTwo.roll());
                        //Main.printBoard();
                        if(p1.position > 32){
                            p1.position -= 32;
                            p1.money += 200000;
                            System.out.println("Congratulations! You passed 'GO' and gained $200,000 ");
                            Functions.showMoney(p1);
                        }

                    }


                }

            }else if(menuChoice == 2){
                Functions.printInfoScreen();
            }else if(menuChoice == 3){
                System.out.println("Thanks for playing! Have a good day. ");
                break;
            }else{
                System.out.println("User's input is invalid, try again!");
            }
        }while(menuChoice != 0);





    }
}