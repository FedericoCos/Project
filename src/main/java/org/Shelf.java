package org;

import java.util.List;
import java.util.Map;

public class Shelf {
     private static final int ROWS = 6;
     private static final int COLS = 5;

     PersonalObjective personalObjective;

     Card[][] shelf;

     public Shelf(PersonalObjective personalObjective){
          this.shelf = new Card[ROWS][COLS];
          this.personalObjective = personalObjective;
     }

     public void reset(){
          for(int i = 0; i < ROWS; i++){
               for(int j = 0; j < COLS; j++){
                    this.shelf[i][j] = null;
               }
          }
     }

     public void insert(List<Card> cards, int col){
          // Check conditions for insertion
          if(col < 0 || col >= COLS){
               return;
          }

          int free = 0;
          int i;

          for(i = 0; i < ROWS; i++){
               if(this.shelf[i][col] == null){
                    free++;
               }
          }

          if(free < cards.size()){
               return;
          }

          // Searching first available cell in column and inserting
          for(i = ROWS - 1; i >= 0; i--){
               if(this.shelf[i][col] != null){
                    break;
               }
          }
          i++;
          for(Card c : cards){
               this.shelf[i][col] = c;
               i++;
          }
     }

     public boolean isFull(){
          for(int i = 0; i < ROWS; i++){
               for(int j = 0; j < COLS; j++){
                    if(this.shelf[i][j] == null){
                         return false;
                    }
               }
          }
          return true;
     }

     public int checkPersonalObj(){
          int score = 0;
          for(Map.Entry<Integer[], CardColor> entry : this.personalObjective.getObjective().entrySet()){
               if(this.shelf[entry.getKey()[0]][entry.getKey()[1]].getColor() == entry.getValue()){
                    score++;
               }
          }

          return score;
     }
}
