package org;

import java.awt.*;
import java.util.ArrayList;

public class GameController {
    private GameLogic gameLogic;
    private Player[] players;
    private int numPlayers;

    public GameController(int numPlayers, ArrayList<String> names){
        this.numPlayers = numPlayers;
        this.players = new Player[this.numPlayers];

        for(int i = 0; i < this.numPlayers; i++){
            this.players[i] = new Player(names.get(i), new Shelf(new PersonalObjective()), this);
        }

        this.gameLogic = new GameLogic(this.numPlayers, this.players);
    }

    public void printAvailableMoves(){
        System.out.println("Operazioni possibili (per adesso)");
        System.out.println("0: Esci");
        System.out.println("1: Stampa il soggiorno");
        System.out.println("2: Stampa le casselle disponibili");
    }

    public void getRequest(int req){
        switch (req){
            case 0:
                System.exit(0);
                break;
            case 1:
                this.gameLogic.printBoard();
                break;
            case 2:
                this.gameLogic.printAvailable();
                break;
            default:
                break;
        }
    }

    public Player[] getPlayers() {
        return players;
    }
}
