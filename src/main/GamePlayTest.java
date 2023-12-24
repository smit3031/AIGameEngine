package main;


import main.boards.TicTacToeBoard;
import main.game.Cell;
import main.game.Move;
import main.game.Player;
import main.api.AIEngine;
import main.api.GameEngine;
import main.api.RuleEngine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.Scanner;

public class GamePlayTest {

    GameEngine gameEngine;
    RuleEngine ruleEngine;
    AIEngine aiEngine;
    Player computer;
    Player human;
    TicTacToeBoard board;

    @Before
    public void setup(){
        gameEngine = new GameEngine();
        aiEngine = new AIEngine();
        ruleEngine = new RuleEngine();

        computer = new Player("O");
        human = new Player("X");

        board = (TicTacToeBoard) gameEngine.start("TicTacToe");
    }


    @Test
    public void checkRowWin() {
        int humanMoves[][] = {{1,0}, {1,1}, {1,2}};
        int computerMoves[][] = {{0,0}, {2,2}, {0,1}};

        playGame(humanMoves, computerMoves);

        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }


    @Test
    public void checkColWin() {
        int humanMoves[][] = {{1,1}, {0,1}, {2,1}};
        int computerMoves[][] = {{0,0}, {2,2}, {1,2}};

        playGame(humanMoves, computerMoves);

        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkDiaWin() {
        int humanMoves[][] = {{0,0}, {1,1}, {2,2}};
        int computerMoves[][] = {{0,1}, {0,2}, {2,0}};

        playGame(humanMoves, computerMoves);

        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkRevDiaWin() {
        int humanMoves[][] = {{2,0}, {1,1}, {0,2}};
        int computerMoves[][] = {{0,0}, {2,2}, {0,1}};

        playGame(humanMoves, computerMoves);

        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkComputerWin() {
        int humanMoves[][] = {{1,0}, {2,1}, {1,2}};
        int computerMoves[][] = {{0,0}, {2,2}, {1,1}};

        playGame(humanMoves, computerMoves);

        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "O");
    }

    @Test
    public void checkTie() {
        int humanMoves[][] = {{1,1}, {2,2}, {0,1}, {1,0}, {2,0}};
        int computerMoves[][] = {{0,0}, {0,2}, {2,1}, {1,2}};

        playGame(humanMoves, computerMoves);

        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "-");
    }

    private void playGame(int[][] humanMoves, int[][] compMoves) {
        int movesCount = Math.max(humanMoves.length, compMoves.length);

        for (int i = 0; i < movesCount; i++) {
            if (i < humanMoves.length) {
                int h_row = humanMoves[i][0];
                int h_col = humanMoves[i][1];
                Move humanMove = new Move(new Cell(h_row, h_col), human);
                board.move(humanMove);
            }

            if (i < compMoves.length) {
                int c_row = compMoves[i][0];
                int c_col = compMoves[i][1];
                Move compMove = new Move(new Cell(c_row, c_col), computer);
                board.move(compMove);
            }
        }
    }


}
