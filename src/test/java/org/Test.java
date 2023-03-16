package org;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        GameController controller = new GameController(2, new ArrayList<>(Arrays.asList("Mario", "Carlo")));

        Player p1 = controller.getPlayers()[0];
        System.out.println(p1);
        while(true){
            p1.askMove();
        }

    }
}
