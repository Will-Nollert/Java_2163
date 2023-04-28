/**
 * Name: Tashfeen, Ahmad
 * File: TashfeenAhamd.java
 * Description: Main method class for Conway's game of life.
 * Note: Your console should be 80x24.
 */
public class TashfeenAhmad {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a file name with initial state.");
        } else {
            GOL automaton = new GOL(args[0]);
            int i = 0;
            do {
                System.out.print(automaton);
                automaton.evolve();
                automaton.pause(100); // pause for a milliseconds
                i++;
            } while (i < 500);
        }
    }
}