package com.blz.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    private char playerLetter;
    private char computerLetter;
    private char startingPlayer;
    private char[] board = new char[10];

    public void doToss(){
        Random rand = new Random();
        int toss = rand.nextInt(2);
        if (toss == 0){
            startingPlayer = 'C';
            System.out.println("Computer Plays First");
        }
        else {
            startingPlayer = 'U';
            System.out.println("User Play First");
        }
    }

    public char getStartingPlayer() {
        return startingPlayer;
    }

    public TicTacToeGame() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }
    public void showBoard(){
        for (int i = 1; i <= 9; i+= 3){
            System.out.println(i + " | " +(i+1)+ " | " + (i+2));
            if (i < 7){
                System.out.println("_________");
            }
        }
    }
    public void chooseLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter your letter X or O ");
        char letter = scanner.next().charAt(0);
        while (letter != 'X' && letter != 'O'){
            System.out.println("Invalid input");
            letter = scanner.next().charAt(0);
        }
        playerLetter = letter;
        computerLetter = (letter == 'X') ? 'O' : 'X';
    }
    public boolean move (int position, char player) {
       if (position >= 1 && position <= 9){
           if (board[position] == ' '){
               board[position] = player;
               return true;
       }
           else {
               System.out.println("This cell is already engaged, please choose another cell.");
           }
           return false;
        }
       else {
           System.out.println("Invalid move, please choose valid cell 1 - 9. ");
       }
       return false;

    }
    public boolean draw() {
        for (int i = 1; i < board.length; i++){
            if (board[i] == ' '){
                return false;
            }
        }
        return true;
    }
    public boolean win( char player){
        for (int i = 1; i <= 3; i++){
            if (board[i] == player && board[i + 3] == player && board[i + 6] == player){
                return true;
            }
        }
        for (int i = 1; i <= 3; i++) {
            if (board[i] == player && board[i + 1] == player && board[i + 2] == player){
                return true;
            }
        }
        if (board[1] == player && board[5] == player && board[9] == player){
            return true;
        }
        if (board[1] == player && board[5] == player && board[9] == player){
        }
        return false;
    }
    public void printBoard(){
        for (int i = 1; i <= 9; i+= 3){
            System.out.println(board[i] + " | " + board[i + 1] + " | " + board[i + 2]);
            if (i < 7){
                System.out.println("_________");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToeGame  game = new TicTacToeGame();
        game.doToss();
        game.move(1, 'X');
        game.move(5, '0');
        game.move(9, 'X');
        game.showBoard();
        while (true) {
            System.out.println("Make your Move (1 - 9):");
            Scanner scanner = new Scanner(System.in);
            int move = scanner.nextInt();
            if (game.move(move, game.playerLetter)) ;
            break;
        }
        game.showBoard();
        if (game.win(game.playerLetter)){
            System.out.println("You win");
        } else if (game.win(game.computerLetter)) {
            System.out.println("Computer loss");
        }
        else if (game.draw()){
            System.out.println("Draw The Game");
        }
    }
    
}
