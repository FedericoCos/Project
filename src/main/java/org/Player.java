package org;

import java.util.Scanner;

public class Player {
    private Shelf shelf;
    private int points;
    private String name;
    private Scanner scanner;

    GameController controller;

    public Player(String name, Shelf shelf, GameController controller){
        this.points = 0;
        this.shelf = shelf;
        this.name = name;
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void askMove(){
        this.controller.printAvailableMoves();
        int move = this.scanner.nextInt();
        this.controller.getRequest(move);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
