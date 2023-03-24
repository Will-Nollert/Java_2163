/**
 * Name: Nollert, William
 * File: WilliamNollert.java
 * Description : Random number guessing game.
 */
 public class WilliamNollert { 
     public static void main( String [] args) {
     int lower = 0;
     int upper = 9+1; // exclusive
     int randomInt = (int) (( upper - lower ) * Math. random () + lower );
     String formatString = " Random number between %d and %d: %d";
     System .out. printf ( formatString , lower , upper -1, randomInt );
     }
 }