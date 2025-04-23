package me.findthepeach.myood.chessgame;

import me.findthepeach.myood.chessgame.pieces.Piece;

public class Player {
    private final Color color;
    public Player(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }

    public void movePiece(Board board, Move move) {
        Piece piece = move.getPiece();
        int destRow = move.getDestRow();
        int destCol = move.getDestCol();

        if(board.isValidMove(piece, destRow, destCol)) {
            int currRow = piece.getRow();
            int currCol = piece.getCol();
            board.setPiece(currRow, currCol, null);
            board.setPiece(destRow, destCol, piece);
            piece.setRow(destRow);
            piece.setCol(destCol);
        }else{
            System.out.println("Invalid move");
        }
    }
}
