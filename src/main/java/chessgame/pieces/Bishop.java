package chessgame.pieces;

import chessgame.Board;
import chessgame.Color;

public class Bishop extends Piece{
    public Bishop(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int row, int col) {
        int diffRow = Math.abs(row - getRow());
        int diffCol = Math.abs(col - getCol());
        return diffCol == diffRow;
    }
}
