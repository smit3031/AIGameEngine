package Boards;

import Game.Board;
import Game.Cell;
import Game.Player;

import java.util.Arrays;

public class TicTacToeBoard extends Board {
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
}
