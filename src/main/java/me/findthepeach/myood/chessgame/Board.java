package me.findthepeach.myood.chessgame;

import me.findthepeach.myood.chessgame.pieces.*;

public class Board {
    private final Piece[][] board;

    public Board() {
        this.board = new Piece[8][8];
        init();
    }

    public void init(){
        // init white
        board[0][0] = new Rook(Color.WHITE, 0,0);
        board[0][1] = new Knight(Color.WHITE, 0,1);
        board[0][2] = new Bishop(Color.WHITE, 0,2);
        board[0][3] = new Queen(Color.WHITE, 0,3);
        board[0][4] = new King(Color.WHITE, 0,4);
        board[0][5] = new Bishop(Color.WHITE, 0,5);
        board[0][6] = new Knight(Color.WHITE, 0,6);
        board[0][7] = new Rook(Color.WHITE, 0,7);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE, 0,i);
        }

        // init black
        board[7][0] = new Rook(Color.BLACK, 0,0);
        board[7][1] = new Knight(Color.BLACK, 0,1);
        board[7][2] = new Bishop(Color.BLACK, 0,2);
        board[7][3] = new Queen(Color.BLACK, 0,3);
        board[7][4] = new King(Color.BLACK, 0,4);
        board[7][5] = new Bishop(Color.BLACK, 0,5);
        board[7][6] = new Knight(Color.BLACK, 0,6);
        board[7][7] = new Rook(Color.BLACK, 0,7);
        for(int i = 0; i < 8; i++){
            board[6][i] = new Pawn(Color.BLACK, 0,i);
        }
    }

    public boolean isValidMove(Piece piece, int destRow, int destCol){
        if(piece == null || destRow < 0 || destRow > 7 || destCol < 0 || destCol > 7){
            return false;
        }
        Piece destPiece = board[destRow][destCol];
        return (destPiece == null || destPiece.getColor() != piece.getColor()) && piece.canMove(this, destRow,destCol);
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }
}
