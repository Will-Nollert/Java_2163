/**
 * Name: William, Nollert
 * File: GOL.java
 * Description: Conway's game of life.
 */
public class GOL extends Board {
    // Define constants for the living and dead cells
    final char ALIVE = '*';
    final char DEAD = ' ';

    /** 
     * Constructor for the GOL class.
     * Calls the constructor of the parent Board class with the specified filepath.
     * @param filepath the path of the file containing the initial board state (e.g. numberphile.txt)
     */
    public GOL(String filepath) {
        super(filepath);
    }
    /**
    * Evolves the game board to the next generation
    * Updates the cells of the board with the new generation.
    */
    public void evolve() {
    // Create a copy of the current board to hold the next generation
        char[][] nextGen = this.getCopy();
        // Iterate over each cell of the board and determine its next state
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                int aliveNeighbours = this.countAliveNeighbours(i, j);
                if (this.isAlive(i, j)) {
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        // Current cell dies if it has less than 2 or more than 3 alive neighbours
                        nextGen[i][j] = DEAD;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        // else if exactly 3 a new cell is born
                        nextGen[i][j] = ALIVE;
                    }
                }
            }
        }
        //finally, update the board with the new generation
        this.cells = nextGen;
    }

    /** 
     * Pauses the execution of the program for a specified amount of time.
     * @param milliseconds the time to pause in milliseconds
     */
    public void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

  /**
     * Counts the number of alive neighbours of a cell at the specified indices.
     * @param i the row index of the cell
     * @param j the column index of the cell
     * @return the number of alive neighbours of the cell
     */
    private int countAliveNeighbours(int i, int j) {
        int count = 0;
        int rows = this.cells.length, columns = this.cells[0].length;
        // Iterate over each neighbouring cell and count the number of alive neighbours
        for (int x = Math.max(0, i-1); x <= Math.min(i+1, rows-1); x++) {
            for (int y = Math.max(0, j-1); y <= Math.min(j+1, columns-1); y++) {
                if (x != i || y != j) { // don't count the current cell as a self neighbour
                    if (this.isAlive(x, y)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
//extract logic to determine whether a cell at the specified indices is alive.
    private boolean isAlive(int i, int j) {
        return (this.cells[i][j] == ALIVE);
    }
}
