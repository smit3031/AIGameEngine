package main.game;

public class Player {
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Player(String symbol) {
        this.symbol = symbol;
    }

    public Player flip(){
        return new Player(symbol.equals("X") ? "O":"X");
    }
}
