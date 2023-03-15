package org;

public class Card {
    private CardColor color;
    private boolean isAvailable;

    public Card(CardColor color){
        this.color = color;
    }

    public CardColor getColor() {
        return color;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
