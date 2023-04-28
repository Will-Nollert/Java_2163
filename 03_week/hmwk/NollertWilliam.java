import java.util.Scanner;

public class NollertWilliam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher cipher;

        while (true) {
            // ask for for a string
            System.out.print("[TXT]");
            String input = scanner.nextLine();

            // Check if the user wants to quit
            if (input.equals("q")) {
                System.out.println("Goodbye!");
                scanner.close();
                return;
            }

            // ask for a key
            System.out.print("[KEY]");
            int key = scanner.nextInt();
            scanner.nextLine(); // deelte the remaining newline character

            // Create a cipher object with the given key
            cipher = new CaesarCipher(key);

            // Encrypt the input string using the cipher object
            String cipherText = cipher.encrypt(input);
            System.out.println("[TXT]" + cipherText);

            // Allow the user to apply additional keys
            while (true) {
                System.out.print("[KEY]");
                input = scanner.nextLine();

                // Check if the user wants to quit
                if (input.equals("q")) {
                    scanner.close();
                    return;
                }

                //Allow for the user to input a second key to sift the cipher text
                int additionalKey = Integer.parseInt(input);

                // Apply the additional key to the cipher text
                cipher = new CaesarCipher(additionalKey);
                cipherText = cipher.encrypt(cipherText);
                System.out.println("[TXT]" + cipherText);
            }
        }
    }
}
