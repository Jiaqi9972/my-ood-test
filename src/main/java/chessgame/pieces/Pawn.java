package chessgame.pieces;

import chessgame.Board;
import chessgame.Color;

public class Pawn extends Piece {
    public Pawn(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        int diffRow = destRow - getRow();
        int diffCol = Math.abs(destCol - getCol());
        if(getColor() == Color.WHITE) {
            return (diffRow ==1 && diffCol ==0) || (getRow() == 1 && diffRow ==2 && diffCol ==0)
                    || (diffRow == 1 && diffCol == 1 && board.getPiece(destRow,destCol)!=null);
        }else{
            return (diffRow == -1 && diffCol == 0) || (getRow() == 6 && diffRow ==-2 && diffCol ==0)
                    || (diffRow == -1 && diffCol == 1 && board.getPiece(destRow,destCol)!=null);
        }
    }
}
