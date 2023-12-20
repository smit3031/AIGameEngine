package api;

import Boards.TicTacToeBoard;
import Game.*;

public class GameEngine{

    public Board start(String type) {
        if (type.equals("TicTacToe")){
            return new TicTacToeBoard();
        }else{
            throw new IllegalArgumentException("Board type not valid!");
        }
    }



    public GameResult isComplete(Board board) {

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
            
            if (rowComplete) return new GameResult(true, firstSymbol);


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

            if (colComplete) return new GameResult(true, firstSymbol);


            firstSymbol = toeBoard.getCell(0, 0);
            boolean diaComplete = firstSymbol!=null;
            for (int j = 1; j<3; j++){
                if (firstSymbol!=null && !firstSymbol.equals(toeBoard.getCell(j, j))){
                    diaComplete = false;
                    break;
                }
            }

            if (diaComplete) return new GameResult(true, firstSymbol);

            firstSymbol = toeBoard.getCell(2, 0);
            boolean revDiaComplete = firstSymbol!=null;
            for (int j = 1; j<3; j++){
                if (firstSymbol!=null && !firstSymbol.equals(toeBoard.getCell(j, 2-j))){
                    revDiaComplete = false;
                    break;
                }
            }

            if (revDiaComplete) return new GameResult(true, firstSymbol);

            int filledCells = 0;

            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    if ((toeBoard.getCell(i, j)!=null)){
                        filledCells++;
                    }
                }
            }

            if (filledCells == 9){
                return new GameResult(true, "-");
            }else{
                return new GameResult(false, "-");
            }

        }


        return null;
    }
}
