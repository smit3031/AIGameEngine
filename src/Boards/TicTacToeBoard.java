package Boards;

import Game.Board;
import Game.Cell;
import Game.Move;
import Game.Player;

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

    @Override
    public void move(Board board, Move move){
        if (board instanceof TicTacToeBoard){
            ((TicTacToeBoard) board).setCell(move.getCell(), move.getPlayer());
        }else{
            throw new IllegalArgumentException("Board type not valid!");
        }
    }
}
