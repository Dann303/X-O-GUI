package com.daniel;

import java.util.InputMismatchException;
import java.util.Scanner;

//things to do:
//1- add the phrase after someone won "player 1/2 won!" or whatever to declare who won that last round and also add the score each time...
//2- pause for a second before leaving the screen when someone wins the game...
//3- at the intro: "press any button" should be replaced with smth else cuz you're pressing the "start" button to start.. not anywhere else.
//4- after you're all done, you want to remove all the console unnecessary stuff and just try to "clean the code" if you may..
//5- lastly you want to add another validation check to when entering player names cuz it would result in a horrible error... you wanna make sure both names aren't the same..

//but of course you're not gonna do all these things and fix the game for a while... cuz you're looking forward to work on smth else... enough for this one project i guess.


public class Main {

    static Scanner sc = new Scanner(System.in);

    static char[][] myGrid;
    static String player1;
    static String player2;
    static String playerTurn;
    static boolean gameEnded;
    static String playerWon;
    static int matchNumber = 0;
    static int score1;
    static int score2;
    static int cellChosen;
    static boolean chose = false;
    static MyFrame frame;
    static char playAgain;

    public static void main(String[] args) {

        frame = new MyFrame();
        while(playerTurn==null){
            playerTurn=player1;
        }
        play();
    }

    private static void initializeGame(){
        initializeGrid();
        gameEnded = false;
        playerWon = null;
    }

    private static void initializeGrid(){
        myGrid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                myGrid[i][j] = '-';
                MyLabel.items[3*i+j].setIcon(MyLabel.dashIcon);
            }
        }
    }

    public static void display(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(myGrid[i][j]);
            }
            System.out.println();
        }
    }

    public static void gameStart(){
        frame.play();
    }

    public static void play(){
        initializeGame();
        matchNumber++;
//        display();
        game();
        playAgain();
    }

    public static void game(){
        int i = 0;
        while (!gameEnded && i<9){
            if ((i+matchNumber-1)%2==0) { //even, player 1's turn
                playerTurn = player1;
            }else{ //otherwise, player 2's turn
                playerTurn = player2;
            }
            System.out.println(playerTurn + "'s turn!");
            makeMove();
            gameEnded = checkEnded();
            i++;
        }
        if (playerWon == null)
            System.out.println("It is a draw!");
        else{
            System.out.println(playerWon + " won the game!");
            if (playerWon.equals(player1))
                score1++;
            else
                score2++;
        }
    }

    public static void makeMove(){
        System.out.println("Choose a cell:");
        frame.play();
        frame.repaint();

        while(!chose){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chose=false;

        while (MyLabel.items[cellChosen].getIcon()!=MyLabel.dashIcon){
            System.out.println("Choose another cell!");
            while(!chose){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            chose=false;
        }

        int x = cellChosen/3;
        int y = cellChosen%3;

        if (playerTurn.equals(player1)) {
            MyLabel.items[cellChosen].setIcon(MyLabel.XIcon);
            myGrid[x][y] = 'X';
        }else{
            MyLabel.items[cellChosen].setIcon(MyLabel.OIcon);
            myGrid[x][y] = 'O';
        }
    }

    public static boolean checkEnded(){
        for (int k=0; k<2; k++){// two iterations first time check if X won, then second loop check if Y won
            char key = ((k+matchNumber-1)%2==0)?('X'):('O');

            //check horizontally and vertically
            for (int i = 0; i < 3; i++){
                if (myGrid[i][0] == key && myGrid[i][1] == key && myGrid[i][2] == key){
                    return checkEndedHelper(key);
                }
                if (myGrid[0][i] == key && myGrid[1][i] == key && myGrid[2][i] == key){
                    return checkEndedHelper(key);
                }
            }

            //check both diagonals
            if (myGrid[0][0] == key && myGrid[1][1] == key && myGrid[2][2] == key){
                return checkEndedHelper(key);
            }
            if (myGrid[0][2] == key && myGrid[1][1] == key && myGrid[2][0] == key){
                return checkEndedHelper(key);
            }
        }
        return false;
    }

    public static boolean checkEndedHelper(int key){
        playerWon = (key=='X')?(player1):(player2);
        return true;
    }

    public static void playAgain() {
        System.out.println("Would you like to play again? (Y/N for now)");
        frame.playAgain();
        frame.revalidate();
        playAgain = '-';

//        try {
//            playAgain = sc.nextLine().toUpperCase().charAt(0);
//        }catch(StringIndexOutOfBoundsException e){
//            System.out.println("caught el error el khabees");
//            playAgain = sc.nextLine().toUpperCase().charAt(0);
//        }
//
//        while (playAgain!='Y' && playAgain!='N'){
//            System.out.println("please enter (yes) or (no)");
//            playAgain = sc.nextLine().toUpperCase().charAt(0);
//        }

        while (playAgain == '-') {
            frame.revalidate();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (playAgain == 'Y'){
            System.out.println("Oh you wanna play again?");
            play();
        }else {
            System.out.println("Okay now.. I guess this is it.");
            frame.viewScorePanel();
            frame.revalidate();
            showScore();
        }
    }

    public static void showScore(){
        System.out.println("The score:");
        System.out.println(player1 + ": " + score1);
        System.out.println(player2 + ": " + score2);
        System.out.println("Thanks for playing my game! If you know me please lmk how you think of my first game :)");
    }

    private static int validateInt(){
        try{
            int count = sc.nextInt();
            return count;
        }catch(InputMismatchException ime){
            sc.nextLine();
            System.out.println("Please enter a *number* !!");
            return validateInt();
        }
    }
}
