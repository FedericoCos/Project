package org;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {
    private final static int ROWS = 9;
    private final static int COLS = 9;

    private Card[][] board;

    private Short[][] chart;
    private Bag bag;

    public Board(int type){
        this.board = new Card[ROWS][COLS];
        this.bag = new Bag();
        this.chart = new Short[ROWS][COLS];

        this.CreateChart();
        this.Fill(type);
    }

    private void CreateChart(){
        File file = new File("C:\\Users\\fedec\\OneDrive\\Desktop\\Universita'\\Ingegneria del Software" +
                                        "\\Test1\\src\\main\\java\\org\\BoardText.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < ROWS; i++){
            String temp = sc.nextLine();
            for(int j = 0; j < COLS; j++){
                if (temp.charAt(j) == '*') {
                    this.chart[i][j] = 5;
                }
                else{
                    this.chart[i][j] = (short) Character.getNumericValue(temp.charAt(j));
                }
            }
        }
    }

    private boolean checkNeighbours(int r, int c){
        if (r != 0 && r != ROWS - 1 && c != 0 && c != COLS - 1) {
            for (int i = -1; i < 2; i++) {
                if (this.board[r + i][c] == null || this.board[r][c + i] == null) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    private boolean hasNeighbours(int r, int c){
        if(this.board[r == 0 ? r : r -1][c] != null){
            return true;
        }
        if(this.board[r == ROWS - 1 ? r : r + 1][c] != null){
            return true;
        }
        if(this.board[r][c == 0 ? c : c - 1] != null){
            return true;
        }
        if(this.board[r][c == ROWS - 1 ? c : c + 1] != null){
            return true;
        }
        return false;
    }
    public void Fill(int type){
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(this.chart[i][j] <= type && this.board[i][j] == null){
                    this.board[i][j] = this.bag.draw();
                }
            }
        }
    }

    public boolean shouldRefill(){
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(this.board[i][j] != null && this.hasNeighbours(i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    public Map<Integer[], Card> getAvailable() {
        Map<Integer[], Card> available = new HashMap<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (this.board[i][j] != null && this.checkNeighbours(i, j)) {
                    available.put(new Integer[]{i, j}, this.board[i][j]);
                }
            }
        }
        return available;
    }

    public void removeCards(List<List<Integer>> positions){
        for(List<Integer> pos : positions){
            this.board[pos.get(0)][pos.get(1)] = null;
        }
    }

    public Card[][] getBoard() {
        return board.clone();
    }
}
