package chessgame.pieces;

import chessgame.Board;
import chessgame.Color;

public class Knight extends Piece {
    public Knight(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        int diffRow = Math.abs(destRow - getRow());
        int diffCol = Math.abs(destCol - getCol());
        return (diffCol == 1 && diffRow ==2) || (diffCol == 2 && diffRow ==1);
    }
}
