package me.findthepeach.myood.chessgame.pieces;

import me.findthepeach.myood.chessgame.Board;
import me.findthepeach.myood.chessgame.Color;

public class Rook extends Piece {
    public Rook(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol){
        int diffRow = Math.abs(destRow - getRow());
        int diffCol = Math.abs(destCol - getCol());
        return diffRow == 0 && diffCol == 0;
    }
}
