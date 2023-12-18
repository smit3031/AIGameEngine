import Boards.TicTacToeBoard;
import Game.Cell;
import Game.GameResult;
import Game.Move;
import Game.Player;
import api.GameEngine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine();
        TicTacToeBoard board = (TicTacToeBoard) gameEngine.start("TicTacToe");

        int row, col;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game started");

        while(!gameEngine.isComplete(board).isOver()){
            Player computer = new Player("O");
            Player human = new Player("X");

            System.out.println("Make your move!");
            System.out.println(board);

            row = scanner.nextInt();
            col = scanner.nextInt();

            Move humanMove = new Move(new Cell(row, col));
            gameEngine.move(board, human, humanMove);

            if (!gameEngine.isComplete(board).isOver()){
                Move compMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, computer, compMove);
            }


        }

        System.out.println("GameResult : " + gameEngine.isComplete(board).toString() + "\n");
        System.out.println(board);
    }
}
