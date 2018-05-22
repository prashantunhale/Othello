package com.prashu.othello;

import com.prashu.othello.utils.UserInput;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        System.out.println("Let's Play Othello (Reversi)");
        Board board = new Board();
        System.out.println(board.display());
        Scanner scanner = new Scanner(System.in);
        String result = play(scanner, board);
        System.out.println(result);
        scanner.close();
    }

    public static String play(Scanner scanner, Board board) {
        Disc playerTurn = Disc.X;

        boolean playerXStuck = false;
        boolean playerOStuck = false;

        while(! board.isGameFinished()){
            int possibleSpots = board.getPossibleSpotsCount(playerTurn);
            System.out.println("\nPossible spots for Player" + playerTurn + ": " + possibleSpots);
            if(possibleSpots == 0){
                System.out.println("No possible moves for Player" + playerTurn);
                playerTurn = switchUser(playerTurn);
                if(playerTurn == Disc.O){playerOStuck = true;}
                if(playerTurn == Disc.X){playerXStuck = true;}
                if(playerOStuck && playerXStuck){
                    System.out.println("No possible moves for either of the Player. Game is finished.");
                    break;
                }
            }else{
                if(playerOStuck && playerTurn == Disc.O){playerOStuck = false;}
                if(playerXStuck && playerTurn == Disc.X){playerXStuck = false;}
                Position playerInput = getPlayerInput(scanner, playerTurn);
                Outcome outcome = makeMove(board, playerTurn, playerInput);
                if(outcome == Outcome.LEGAL_MOVE){
                    playerTurn = switchUser(playerTurn);
                }
            }
        }

        return board.displayWinner();
     }

    public static Position getPlayerInput(Scanner scanner, Disc playerTurn){
        System.out.println("\nPlayer" + playerTurn + ":");
        String input = scanner.nextLine();
        boolean isValidInput = UserInput.validateInput(input);
        if(!isValidInput){
            System.out.println(input + " is an invalid input. Examples of valid input: [1-8][a-hA-H] or [a-hA-H][1-8] i.e. 3A, 5D, 7e, 8b, 6c, 3D...");
            System.out.println("Try again!");
            return getPlayerInput(scanner, playerTurn);
        }

        return UserInput.convertInputToPosition(input);
    }

    public static Outcome makeMove(Board board, Disc turn, Position playerInput){
        Outcome outcome = board.placeDisc(playerInput, turn);
        if(outcome == Outcome.LEGAL_MOVE){
            System.out.println(board.display());
        }else{
            System.out.println(outcome.getResult());
            System.out.println("Try again!");
        }
        return outcome;
    }

    public static Disc switchUser(Disc turn){
        return turn == Disc.O ? Disc.X : Disc.O;
    }

}