package main.api;

import main.boards.TicTacToeBoard;
import main.game.Board;
import main.game.GameState;

public class RuleEngine {

    public GameState getState(Board board) {

        if (board instanceof TicTacToeBoard){

            TicTacToeBoard toeBoard = (TicTacToeBoard) board;
            String firstSymbol = "-";

            boolean rowComplete = true;

            for (int i = 0; i<3; i++){
                firstSymbol = toeBoard.getCell(i, 0);
                rowComplete = firstSymbol!=null;
                for (int j = 1; j<3; j++){
                    if (firstSymbol!=null && !firstSymbol.equals(toeBoard.getCell(i, j))){
                        rowComplete = false;
                        break;
                    }
                }

                if (rowComplete) break;
            }

            if (rowComplete) return new GameState(true, firstSymbol);


            boolean colComplete = true;

            for (int i = 0; i<3; i++){
                firstSymbol = toeBoard.getCell(0, i);
                colComplete = firstSymbol!=null;
                for (int j = 1; j<3; j++){
                    if (firstSymbol!=null && !firstSymbol.equals(toeBoard.getCell(j, i))){
                        colComplete = false;
                        break;
                    }
                }

                if (colComplete) break;
            }

            if (colComplete) return new GameState(true, firstSymbol);


            firstSymbol = toeBoard.getCell(0, 0);
            boolean diaComplete = firstSymbol!=null;
            for (int j = 1; j<3; j++){
                if (firstSymbol!=null && !firstSymbol.equals(toeBoard.getCell(j, j))){
                    diaComplete = false;
                    break;
                }
            }

            if (diaComplete) return new GameState(true, firstSymbol);

            firstSymbol = toeBoard.getCell(0, 2);
            boolean revDiaComplete = firstSymbol!=null;
            for (int j = 1; j<3; j++){
                if (firstSymbol!=null && !firstSymbol.equals(toeBoard.getCell(j, 2-j))){
                    revDiaComplete = false;
                    break;
                }
            }

            if (revDiaComplete) return new GameState(true, firstSymbol);

            int filledCells = 0;

            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    if ((toeBoard.getCell(i, j)!=null)){
                        filledCells++;
                    }
                }
            }

            if (filledCells == 9){
                return new GameState(true, "-");
            }else{
                return new GameState(false, "-");
            }

        }
        return null;
    }
}
