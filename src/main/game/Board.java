package main.game;

public interface Board {
    public void move(Move move);

    public Board copy(Board board);
}
