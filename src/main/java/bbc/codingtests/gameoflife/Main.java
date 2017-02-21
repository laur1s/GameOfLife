package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;

/**
 * Created by laurynas on 21-Feb-17.
 */
public class Main {


    public static void main(String args[]) throws InterruptedException {
      /*  GameStateImpl state = new GameStateImpl("-----\n--*--\n" +
                "-***-\n--*--\n-----\n");*/
        GameStateImpl state = new GameStateImpl("-----\n-----\n" +
                "-***-\n-----\n-----\n"); //Glider
        char[][] initial = state.getBoard();

        for (char[] line : initial) {
            for (char coll : line) {
                System.out.print(coll);
            }
            System.out.println();
        }


        while (true) {
            System.out.println("NEW GENERATION");
            char[][] newState = state.evolveState();
            for (char[] line : newState) {
                for (char coll : line) {
                    System.out.print(coll);
                }
                System.out.println();
            }

            Thread.sleep(1000);

        }
    }
}
