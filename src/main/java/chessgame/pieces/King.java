package chessgame.pieces;

import chessgame.Board;
import chessgame.Color;

public class King extends Piece{
    public King(Color color, int row, int col) {
        super(color, col, row);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        int diffRow = Math.abs(destRow - getRow());
        int diffCol = Math.abs(destCol - getCol());
        return diffRow == getRow() && diffCol == getCol();
    }
}
