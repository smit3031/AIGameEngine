package main.api;

import jdk.jshell.SourceCodeAnalysis;
import main.boards.TicTacToeBoard;
import main.game.Board;
import main.game.Cell;
import main.game.Move;
import main.game.Player;

public class AIEngine {

    public Move suggestMove(Player player, Board board) {

        if (board instanceof TicTacToeBoard){
            TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
            int threshold = 3;
            Move suggestion;
            if (numberOfMoves(ticTacToeBoard) < threshold) {
                suggestion = suggestBasicMove(player, ticTacToeBoard);
            }else{
                suggestion = suggestSmartMove(player, ticTacToeBoard);
            }

            return suggestion;
        }else{
            throw new IllegalArgumentException();
        }
    }

    private int numberOfMoves(TicTacToeBoard ticTacToeBoard) {
        int count = 0;
        for(int i=0; i<3; i++){
            for(int j=0;j<3;j++){
                if (ticTacToeBoard.getCell(i,j)!=null) count++;
            }
        }
        return count;
    }

    private Move suggestBasicMove(Player player, TicTacToeBoard board) {
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (board.getCell(i, j) == null){
                    return new Move(new Cell(i, j), player);
                }
            }
        }
        throw new IllegalStateException();
    }

    private Move suggestSmartMove(Player player, TicTacToeBoard ticTacToeBoard) {

        RuleEngine ruleEngine = new RuleEngine();

        // Win
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToeBoard.getCell(i, j) == null) {
                    Move move = new Move(new Cell(i, j), player);
                    TicTacToeBoard boardCopy = ticTacToeBoard.copy(ticTacToeBoard);
                    boardCopy.move(move);
                    if (ruleEngine.getState(boardCopy).isOver()) {
                        return move;
                    }
                }
            }
        }

        // Defend
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToeBoard.getCell(i, j) == null) {
                    Move move = new Move(new Cell(i, j), player.flip());
                    TicTacToeBoard boardCopy = ticTacToeBoard.copy(ticTacToeBoard);
                    boardCopy.move(move);
                    if (ruleEngine.getState(boardCopy).isOver()) {
                        System.out.println("Defending Move: " + move); // Add this line for debugging
                        return new Move(new Cell(i, j), player);
                    }
                }
            }
        }


        // Center

        return suggestBasicMove(player, ticTacToeBoard);
    }


}
