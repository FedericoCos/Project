package org;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PersonalObjective {
    private static final int ROWS = 6;
    private static final int COLS = 5;
    Map<Integer[], CardColor> objective;

    public PersonalObjective(){
        this.objective = new HashMap<>();
        int i, j;
        Integer[] key;
        Random random = new Random();

        for(CardColor value : CardColor.values()){
            do{
                i = random.nextInt(ROWS);
                j = random.nextInt(COLS);
                key = new Integer[]{i, j};
            }while(this.objective.containsKey(key));

            this.objective.put(key, value);
        }
    }

    public Map<Integer[], CardColor> getObjective() {
        return objective;
    }
}
