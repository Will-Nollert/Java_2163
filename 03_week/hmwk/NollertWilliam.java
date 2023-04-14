import java.util.Scanner;

/**
 * This class interacts with the user to prompt for a string and a key,
 * then outputs the shifted (cipher) text and allows the user to apply additional keys.
 */
public class NollertWilliam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher cipher;

        while (true) {
            // Prompt the user for a string
            System.out.print("Enter a string (or 'q' to quit): ");
            String input = scanner.nextLine();

            // Check if the user wants to quit
            if (input.equals("q")) {
                System.out.println("Goodbye!");
                scanner.close();
                return;
            }

            // Prompt the user for a key
            System.out.print("Enter a key between -25 and 25: ");
            int key = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline character

            // Create a CaesarCipher object with the given key
            cipher = new CaesarCipher(key);

            // Encrypt the input string using the cipher object
            String cipherText = cipher.encrypt(input);
            System.out.println("Shifted cipher text: " + cipherText);

            // Allow the user to apply additional keys
            while (true) {
                System.out.print("Enter another key to apply (or 'q' to quit): ");
                input = scanner.nextLine();

                // Check if the user wants to quit
                if (input.equals("q")) {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }

                // Parse the key input as an integer
                int additionalKey = Integer.parseInt(input);

                // Apply the additional key to the cipher text
                cipher = new CaesarCipher(additionalKey);
                cipherText = cipher.encrypt(cipherText);
                System.out.println("Shifted cipher text with additional key: " + cipherText);
            }
        }
    }
}
