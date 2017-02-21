package bbc.codingtests.gameoflife.gamestate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by laurynas on 18-Feb-17.
 */
public class GameStateImplTest {

    @Test
    public void print() {
        GameStateImpl gameState = new GameStateImpl("--*\n**-\n");
        System.out.print(gameState.toString());
    }

    @Test
    public void evolveState() throws Exception {
        GameStateImpl gameState = new GameStateImpl("--*\n-*-\n");
        char[][] c = gameState.evolveBoard();
        for (char[] line : c) {
            for (char coll : line) {
                assertEquals(coll, '-');
            }

        }

    }


    @Test
    public void getBoard() throws Exception {
        GameStateImpl gameState = new GameStateImpl("*");
        char[][] board = new char[gameState.getRows()][gameState.getCols()];
        board[0][0] = '*';
        char[][] board2 = gameState.getBoard();
        assertEquals(board2, board);


    }


    @Test
    public void isCellAliveAt() throws Exception {
        GameStateImpl gameState = new GameStateImpl("*--\n*--\n*--\n");
        assertEquals(gameState.isCellAliveAt(2, 2), false);
        GameStateImpl gameState2 = new GameStateImpl("***\n***\n***\n");
        assertEquals(gameState2.isCellAliveAt(1, 1), true);
        GameStateImpl gameState3 = new GameStateImpl("-*-\n***\n---\n");
        assertEquals(gameState3.isCellAliveAt(1, 1), true);


    }

    @Test
    public void getRows() throws Exception {
        GameStateImpl gameState = new GameStateImpl("*-*-*-\n*-*-*-");
        assertEquals(2, gameState.getRows());

    }

    @Test
    public void getCols() throws Exception {
        GameStateImpl gameState = new GameStateImpl("*-*-*-\n*-*-*-");
        assertEquals(6, gameState.getCols());

    }

}