import java.util.Scanner;

public class NollertWilliam extends Dictionary {
    /**
     * The main method of the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NollertWilliam dictionary = new NollertWilliam();

        // Display a welcome message to the user and prompt for input
        System.out.println("Welcome to William Nollert's dictionary! Enter a word to get started (type 'q' at anytime to quit):");

        while (true) {
            // Read the user's input and trim leading/trailing whitespace
            String input = scanner.nextLine().trim().toLowerCase();

            // If the input is 'q', exit the program
            if (input.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }

            // Get the possible definitions of the input word
            String[] definitions = dictionary.definitions(input);

            // If no definitions are found, print a message saying so
            if (definitions.length == 0) {
                System.out.println("No definitions found.");
            } else {
                // Otherwise, print the definitions in a nicely formatted way
                System.out.println("Definitions:");

                for (String definition : definitions) {
                    dictionary.printFormattedDefinitions(definition);
                }
            }

            // Prompt the user for another word
            System.out.println("Enter another word:");
        }
    }

    /**
     * Prints the given definition formatted in
     * compliance with the rubric.
     * 
     * @param word The definition to print.
     */
    @Override
    public void printFormattedDefinitions(String word) {
        // Wrap the definition to a maximum line length of 60 characters and print it with a "-" bullet point
        System.out.println(wrap("- " + word, "  ", 60));
    }

    /**
     * Wraps the given text to a maximum line length of width and returns the wrapped text.
     * 
     * @param text The text to wrap.
     * @param hanging The hanging indent for wrapped lines.
     * @param width The maximum line length.
     * @return The wrapped text.
     */
    @Override
    public String wrap(String text, String hanging, int width) {
        StringBuilder sb = new StringBuilder(text.length() + 16);

        // Split the text into words
        String[] words = text.split("\\s+");

        sb.append(hanging);
        int lineLength = hanging.length();

        // Loop over each word and wrap the text
        for (String word : words) {
            // If the current line plus the length of the next word plus a space exceeds the width,
            // add a newline and the hanging indent, and reset the line length
            if (lineLength + word.length() + 1 > width) {
                sb.append('\n').append(hanging);
                lineLength = hanging.length();
            }

            // Append the current word and a space to the line
            sb.append(word).append(' ');
            lineLength += word.length() + 1;
        }

        // Trim leading/trailing whitespace from the wrapped text and return it
        return sb.toString().trim();
    }
}
