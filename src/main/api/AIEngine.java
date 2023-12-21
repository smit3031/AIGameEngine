package api;

import Boards.TicTacToeBoard;
import GameState.Cell;
import GameState.Move;
import GameState.Player;

public class AIEngine {

    public Move suggestMove(Player player, TicTacToeBoard board) {
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (board.getCell(i, j) == null){
                    return new Move(new Cell(i, j), player);
                }
            }
        }
        return null;
    }
}
