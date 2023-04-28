
public class CaesarCipher {

    //private used for encapsulation so that key wont be muttable
    private int key; // The key used to shift the characters

    //majorKey ;) 
    public CaesarCipher(int key) {
        this.key = key;
    }

    /**
     * takes a plain text string as input and returns its encrypted form using a shift based on the 
     * users key.
     * @param plainText the plain text to be encrypted
     * @return the encrypted text
     */
    public String encrypt(String plainText) {
        //use StringBuilder to avoid creating a new string object each time a character is appended
        StringBuilder cipherText = new StringBuilder();

        // Iterate over each character in the plain text string
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            // Check if the character is a letter
            if (Character.isLetter(ch)) {
                // Shift the letter based on the key
                if (Character.isUpperCase(ch)) {
                    ch = (char) ((ch + key - 'A' + 26) % 26 + 'A');
                } else {
                    ch = (char) ((ch + key - 'a' + 26) % 26 + 'a');
                }
            }

            // Append the shifted character to the cipher text
            cipherText.append(ch);
        }

        // Return the cipher text as a string
        return cipherText.toString();
    }

    /**
     *  takes a cipher text string as input and returns its decrypted form using the user specified shift.
     * @param cipherText the cipher text to be decrypted
     * @return the decrypted text
     */
    public String decrypt(String cipherText) {
        //use StringBuilder to avoid creating a new string object each time a character is appended
        StringBuilder plainText = new StringBuilder();

        // Iterate over each character in the cipher text string
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);

            // Check if the character is a letter
            if (Character.isLetter(ch)) {
                // Shift the letter back to its original position based on the key
                if (Character.isUpperCase(ch)) {
                    ch = (char) ((ch - key - 'A' + 26) % 26 + 'A');
                } else {
                    ch = (char) ((ch - key - 'a' + 26) % 26 + 'a');
                }
            }

            // Append the shifted character to the plain text
            plainText.append(ch);
        }

        // Return the plain text as a string
        return plainText.toString();
    }
}
