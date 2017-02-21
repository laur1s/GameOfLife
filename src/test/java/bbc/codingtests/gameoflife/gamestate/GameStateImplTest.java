package bbc.codingtests.gameoflife.gamestate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by laurynas on 18-Feb-17.
 */
public class GameStateImplTest {


    @Test
    public void isCellAliveAt() throws Exception {
        GameStateImpl gameState = new GameStateImpl("*\n*\n");
        //System.out.print(gameState.toString());


    }

    @Test
    public void getRows() throws Exception {
        GameStateImpl gameState = new GameStateImpl("*-*-*-\n*-*-*-");
        assertEquals(2, gameState.getRows());

    }

    @Test
    public void getCols() throws Exception {
        GameStateImpl gameState = new GameStateImpl("*-*-*-\n*-*-*-");
        assertEquals(6,gameState.getCols());

    }

}