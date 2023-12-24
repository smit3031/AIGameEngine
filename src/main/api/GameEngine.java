package main.api;

import main.boards.TicTacToeBoard;
import main.game.*;

public class GameEngine {

    public Board start(String type) {
        if (type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException("Board type not valid!");
        }
    }


}