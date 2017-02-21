package bbc.codingtests.gameoflife.gamestate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GameStateImpl implements GameState {
    int numRows = 0;
    int numCols = 0;
    char board[][];
    String rows[];


    //TODO implement this method such    that live cells are represented as a '*' and dead cells are represented by a '.'
    //TODO use newline ('\n') to separate rows
    @Override
    public String toString() {
        return new String();
    }

    //TODO implement this constructor to parse an input string and return a new GameStateImpl object representing what you got in the string
    //TODO as above, live cells are '*' and dead cells are '.' Rows are separated by newline ('\n')
    public GameStateImpl(String input) {
        rows = input.split("\n");
        numRows = rows.length;
        numCols = rows[0].length();
        board = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = rows[i].charAt(j);
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.println(board[i][j]);
            }
        }

    }

    //TODO implement this method according to explanation in GameState.java
    public boolean isCellAliveAt(int row, int col) {
        if (row > 0 && row <= numRows && col > 0 && col <= numCols) {
            int decRow = row - 1;
            int incRow = row + 1;
            int decCol = col - 1;
            int incCol = col + 1;
            int neighbours = 0;

            if(decRow> 0){
                if (board[decRow][col] == '*') neighbours++; // Check the left neigbor
            }



            if (decRow > 0 && incCol <= numCols) {
                if (board[decRow][decCol] == '*') neighbours++;
            }
            if (decRow > 0 && decCol > 0) {
                if (board[decRow][decCol] == '*') neighbours++;
            }

            if (incRow <= numRows && decCol <= numCols) {
                if (board[incRow][decCol] == '*') neighbours++;
            }
            if (decRow <= numRows && decCol <= numCols) {
                if (board[decRow][decCol] == '*') neighbours++;
            }

        } else return false;

        return true;
    }


    public int getRows() {
        return numRows;
    }

    public int getCols() {
        return numCols;
    }
}
