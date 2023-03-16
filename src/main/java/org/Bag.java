package org;

import java.util.Random;

public class Bag {
    private Random randomizer;
    private static final int DIMENSION = 132;
    private static final int NUMTYPES = 22;

    private Card[] cards;

    private int currentIndex;

    public Bag(){
        this.randomizer = new Random();

        this.createAndShuffle();
    }

    public Card draw(){
        if(this.currentIndex < DIMENSION){
            return this.cards[this.currentIndex++];
        }
        return null;
    }

    public void reset(){
        this.currentIndex = 0;
        this.shuffle();
    }

    private void createAndShuffle(){
        int i = 0;
        this.cards = new Card[DIMENSION];
        this.currentIndex = 0;
        for (CardColor color : CardColor.values()) {
            for(int j = 0; j < NUMTYPES; j++){
                this.cards[i++] = new Card(color);
            }
        }

        this.shuffle();
    }

    private void shuffle(){
        for(int i = 0; i < DIMENSION; i++){
            int n = randomizer.nextInt(DIMENSION);
            Card temp = this.cards[i];
            this.cards[i] = this.cards[n];
            this.cards[n] = temp;
        }
    }
}
