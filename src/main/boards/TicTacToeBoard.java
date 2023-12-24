package main.boards;

import main.game.Board;
import main.game.Cell;
import main.game.Move;
import main.game.Player;

public class TicTacToeBoard implements Board {
    String[][] cells = new String[3][3];

    public String getCell(int row, int col) {
        return cells[row][col];
    }

    @Override
    public String toString() {
        String result= "";
        for (int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                if (cells[i][j] == null) result+= "_";
                else result += cells[i][j];
            }

            result += "\n";
        }

        return result;
    }

    public void setCell(Cell cell, Player player) {
        cells[cell.getRow()][cell.getCol()] = player.getSymbol();
    }

    @Override
    public void move(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // Check if the cell is null before updating
        if (cells[row][col] == null) {
            cells[row][col] = move.getPlayer().getSymbol();
        }
    }


    @Override
    public TicTacToeBoard copy(Board board) {
        if (!(board instanceof TicTacToeBoard)) {
            throw new IllegalArgumentException("Board type not valid!");
        }

        TicTacToeBoard originalBoard = (TicTacToeBoard) board;
        TicTacToeBoard copiedBoard = new TicTacToeBoard();

        for (int i = 0; i < 3; i++) {
            System.arraycopy(originalBoard.cells[i], 0, copiedBoard.cells[i], 0, 3);
        }

        return copiedBoard;
    }

}
