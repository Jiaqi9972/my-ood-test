package chessgame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private int currentPlayer;

    public Game() {
        board = new Board();
        players = new ArrayList<>();
        currentPlayer = 0;
    }

    public void start(){
        while (!isGameOver()){
            Player player = players.get(currentPlayer);

            try{
                player.movePiece(board, getPlayerMove());
            }catch(Exception e){
                continue;
            }

            currentPlayer = (currentPlayer + 1) % 2;
        }
    }

    public Move getPlayerMove(){
        // use scanner
        int sourceRow = 0;
        int sourceCol = 0;
        int destRow = 0;
        int destCol = 0;
        return new Move(board.getPiece(sourceRow,sourceCol),destRow,destCol);
    }

    public boolean isGameOver(){
        // todo
        return true;
    }

}
