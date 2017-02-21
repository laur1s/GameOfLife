package bbc.codingtests.gameoflife.gamestate;


public class GameStateImpl implements GameState {
    private int numRows;
    private int numCols;


    private char board[][];
    private String rows[];
    GameStateImpl state;


    //TODO implement this method such    that live cells are represented as a '*' and dead cells are represented by a '.'
    //TODO use newline ('\n') to separate rows
    @Override
    public String toString() {
        return new String();
    }

    //TODO implement this constructor to parse an input string and return a new GameStateImpl object representing what you got in the string
    //TODO as above, live cells are '*' and dead cells are '.' Rows are separated by newline ('\n')
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

    //TODO implement this method according to explanation in GameState.java
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

    private boolean evolveCell(int row, int col) {
        int neighbours = checkCellNeighbours(row, col);
        return neighbours == 3;
    }


    public char[][] evolveState() {
        char[][] newState = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (evolveCell(i, j)) {
                    newState[i][j] = '*';
                } else newState[i][j] = '-';

            }
        }
        board =newState;
        return  newState;
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
