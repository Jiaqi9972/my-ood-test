package chessgame.pieces;

import chessgame.Board;
import chessgame.Color;

public class Queen extends Piece{
    public Queen(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        int diffRow = Math.abs(destRow - getRow());
        int diffCol = Math.abs(destCol - getCol());
        return (diffRow == diffCol) || (getCol() == destCol || getRow() == destRow);
    }
}
