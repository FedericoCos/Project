package org;

import java.util.List;
import java.util.Map;

public class GameLogic {
    private Board board;
    private Player[] players;


    public GameLogic(int numPlayers, Player[] players){
        this.board = new Board(numPlayers);
        this.players = players;
    }

    public void printBoard(){
        for(Card[] row : board.getBoard()){
            for(Card card : row){
                if(card != null){
                    System.out.print(card.getColor());
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public void printAvailable(){
        for(Map.Entry<Integer[], Card> pos : board.getAvailable().entrySet()){
            System.out.println(pos.getKey()[0] + " " + pos.getKey()[1] + " " + pos.getValue().getColor());
        }
    }

    public Map<Integer[], Card> getAvailable() {
        return board.getAvailable();
    }
}
