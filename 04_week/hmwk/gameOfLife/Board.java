/**
 * Name: Tashfeen, Ahmad
 * File: Board.java
 * Description: Representation of the game's board.
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Board {
    char[][] cells;

    public Board(String filepath) {
        this.assignCells(filepath);
    }

    public String toString() {
        String ret = "";
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++)
                ret += this.cells[i][j];
            ret += '\n';
        }
        return ret;
    }

    public char[][] getCopy() {
        int rows = this.cells.length, columns = this.cells[0].length;
        char[][] ret = new char[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                ret[i][j] = this.cells[i][j];
        return ret;
    }

    private void assignCells(String filepath) {
        String lines = "";
        try {
            File file = new File(filepath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                lines += sc.nextLine() + "\n";
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        String[] rows = lines.split("\n");
        this.cells = new char[rows.length][rows[0].length()];
        for (int i = 0; i < this.cells.length; i++)
            this.cells[i] = rows[i].toCharArray();
    }
}