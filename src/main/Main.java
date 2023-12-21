import Boards.TicTacToeBoard;
import GameState.Cell;
import GameState.Move;
import GameState.Player;
import api.AIEngine;
import api.GameEngine;
import api.RuleEngine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine();
        AIEngine aiEngine = new AIEngine();
        RuleEngine ruleEngine = new RuleEngine();
        TicTacToeBoard board = (TicTacToeBoard) gameEngine.start("TicTacToe");

        int row, col;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game started");

        while(!ruleEngine.getState(board).isOver()){
            Player computer = new Player("O");
            Player human = new Player("X");

            System.out.println("Make your move!");
            System.out.println(board);

            row = scanner.nextInt();
            col = scanner.nextInt();

            Move humanMove = new Move(new Cell(row, col), human);
            board.move(board, humanMove);

            if (!ruleEngine.getState(board).isOver()){
                Move compMove = aiEngine.suggestMove(computer, board);
                board.move(board, compMove);
            }


        }

        System.out.println("GameResult : " + ruleEngine.getState(board).toString() + "\n");
        System.out.println(board);
    }
}
