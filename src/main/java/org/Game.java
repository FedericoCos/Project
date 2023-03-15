package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
    private final static int numPlayers = 2;
    private Board board;


    public Game(){
        this.board = new Board(numPlayers);
    }

    public void PrintBoard(){
        Card[][] currentStatus = board.getBoard();
        for(Card[] row : currentStatus){
            for(Card card : row){
                if(card != null){
                    System.out.print(card.getColor());
                }
                else{
                    System.out.print("N");
                }
            }
            System.out.println();
        }
    }

    public void PrintAvailable(){
        Map<Integer[], Card> av = board.getAvailable();
        for(Map.Entry<Integer[], Card> pos : av.entrySet()){
            System.out.println(pos.getKey()[0] + " " + pos.getKey()[1] + " " + pos.getValue().getColor());
        }
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.PrintBoard();
        g.PrintAvailable();
    }
}
