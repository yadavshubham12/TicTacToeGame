package com.blz.tictactoe;

public class TicTacToeGame {

    private char[] board = new char[10];

    public TicTacToeGame() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }
    public  void move (int position, char player) {
        board[position] = player;
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
                System.out.println("    ");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToeGame  game = new TicTacToeGame();
        game.move(1, 'X');
        game.move(5, '0');
        game.move(9, 'X');
        if (game.win('X')){
            System.out.println("X wins");
        } else if (game.win('O')) {
            System.out.println("O loss");
        }
        else if (game.draw()){
            System.out.println("Draw The Game");
        }
    }
    
}
