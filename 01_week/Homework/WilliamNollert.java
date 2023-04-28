
/**
 * Name: Nollert, William
 * File: WilliamNollert.java
 * Description : Random number guessing game.
 */

import java.util.Scanner; //Scanner is one of the many tools in the util toolshed. 

public class WilliamNollert {
    public static void main(String[] args) {
        // lower bound
        int lower = 0;
        // upper bound
        int upper = 9 + 1; // exclusive
        // Generate a random Int between upper and lower bound
        int randomInt = (int) ((upper - lower) * Math.random() + lower);

        // Create a new Scanner object called input
        Scanner input = new Scanner(System.in);

        // promot the user to enter a number between 0 and 9.
        System.out.println("Guess a number bewteen 0 and 9: ");
        // Read the user input and store it in a new variable called Userguess.
        int Userguess = input.nextInt();

        // Test 0
        // check if the users guess is equal to the int 69 and if so return the string
        // "Nice" + " But also out of range" continue.
        if (Userguess == 69) {
            System.out.println("Nice but...");
        }
        ;

        // Test 1
        // check if the users guess is within the range of 0 and 9. If not return the
        // string "Out of range" and continue.
        if (Userguess < 0 || Userguess > 9) {
            System.out.println("Out of range");
        }
        ;

        // Test 2
        // check if the users guess is both in range and not equal to the random number.
        // If so return the string "Incorrect, the correct number was " + randomInt and
        // continue.
        if (Userguess != randomInt && Userguess >= 0 && Userguess <= 9) {
            System.out.println("Incorrect, the correct number was " + randomInt);
        }
        ;

        // Victory condition
        // check if the users guess is equal to the random number. If so return the
        // string "Correct" and continue.
        if (Userguess == randomInt) {
            System.out.println("Correct");
        }
        ;

        // close the scanner
        input.close();
    }
}