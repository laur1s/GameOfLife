package bbc.codingtests.gameoflife.gamestate;


import java.util.Arrays;

public class GameStateImpl implements GameState {
    private int numRows;
    private int numCols;


    private char board[][];
    private String rows[];



    public String toString() {
       return Arrays.deepToString(board);
    }

    /**
     * Constructor for game state. Takes an input string and creates a game of life board from it
     * @param input input string each row is separated by \n symbol, lines must be of equal length
     */
    public GameStateImpl(String input) {
        this.rows = input.split("\n");
        this.numRows = rows.length;
        this.numCols = rows[0].length();
        this.board = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = rows[i].charAt(j);
            }
        }

    }

    /**
     * Checks if the cell is allive at the current position
     * @param row cell's row
     * @param col cells column
     * @return true if cell at given coordinates is alive, else otherwise
     */
    public boolean isCellAliveAt(int row, int col) {
        if (row >= 0 && row <= numRows && col >= 0 && col <= numCols) {
            if (board[row][col] == '*') return true;
        }
        return false;
    }

    /**
     * Counts the number of cell's Neighbours
     *
     * @param row row to check
     * @param col column to check
     * @return the number of cell's Neighbours
     */
    private int checkCellNeighbours(int row, int col) {
        int neighbours = 0;
        if (row >= 0 && row <= numRows && col >= 0 && col <= numCols) {
            int decRow = row - 1;
            int incRow = row + 1;
            int decCol = col - 1;
            int incCol = col + 1;


            if (decRow >= 0) {
                if (board[decRow][col] == '*') neighbours++; // Check the below neighbour
                if (incCol < numCols) {
                    if (board[decRow][incCol] == '*') neighbours++; // check the bellow right neighbour
                }
                if (decCol >= 0) {
                    if (board[decRow][decCol] == '*') neighbours++; // check the bellow left neighbour
                }
            }

            if (incRow < numRows) {
                if (board[incRow][col] == '*') neighbours++; // Check the upper neighbour
                if (incCol < numCols) {
                    if (board[incRow][incCol] == '*') neighbours++; //check upper right neighbour
                }
                if (decCol >= 0) {
                    if (board[incRow][decCol] == '*') neighbours++; //check upper left neighbour
                }
            }

            if (decCol >= 0) {
                if (board[row][decCol] == '*') neighbours++; // Check the left neighbour
            }

            if (incCol < numCols) {
                if (board[row][incCol] == '*') neighbours++; // Check the right neighbour
            }
            return neighbours;
        }
        return 0;
    }

    /**
     *
     * @param row
     * @param col
     * @return true if cell is alive after evolution, else otherwise
     */
    private boolean evolveCell(int row, int col) {
        int neighbours = checkCellNeighbours(row, col);
        return isCellAliveAt(row, col) && neighbours == 2 || neighbours == 3;
    }

    /**
     * Evloves the board
     * @return char array of board
     */
    public char[][] evolveBoard() {
        char[][] newState = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (evolveCell(i, j)) {
                    newState[i][j] = '*';
                } else newState[i][j] = '-';

            }
        }
        board = newState;
        return newState;
    }

    public int getRows() {
        return numRows;
    }

    public int getCols() {
        return numCols;
    }

    public char[][] getBoard() {
        return board;
    }
}
