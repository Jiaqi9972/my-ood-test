package chessgame.pieces;

import chessgame.Board;
import chessgame.Color;

public abstract class Piece {
    private final Color color;
    private int col;
    private int row;

    public Piece(Color color, int row, int col) {
        this.color = color;
        this.col = col;
        this.row = row;
    }

    public abstract boolean canMove(Board board, int destRow, int destCol);

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
