package api;

import Boards.TicTacToeBoard;
import GameState.*;

public class GameEngine {

    public Board start(String type) {
        if (type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException("Board type not valid!");
        }
    }


}