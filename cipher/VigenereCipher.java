import java.io.PrintWriter;

public class VigenereCipher {
    
    /*
    This program encrypts or decrypts a given string using a key. This cipher style is called the Vigenere Cipher.
    This program takes three command line arguments: param0, param1, param2.
    param0: instruction - 'encode' or 'decode'
    param1: String to be encrypted/decrypted
    param2: String to be used as the key.
    */
    public static void main (String[] args) {

        //create encode and decode strings to check for equality in command line arguments
        String param1enc = new String("encode");
        String param2dec = new String("decode");

        //depending on user input, either encode or decode string with key.
        if (param1enc.equals(args[0])) {
            encode(args[1], args[2]);
        }
        else if (param2dec.equals(args[0])) {
            decode(args[1], args[2]);
        }
    } //main

    /*
    *This method encrypts plaintext, a String, using key, also a String. This cipher style is Vigenere Cipher.
    *
    * @paramleft
    *   The String to be encrypted
    * @paramright
    *   The String to be used as the key.
    */
    public static void encode (String plaintext, String key) {

        //Create a string the same length as original string, containing repetitions of the key.
        //Example: If String = "booboo", and key = "cap", then cyclic = "capcap". 
        char[] cyclic = new char[plaintext.length()];
        int j = 0;
        for (int i = 0; i < plaintext.length(); i++) {
            cyclic[i] = key.charAt(j);
            if (j == key.length() - 1) {
                j = 0;
            }
            else {
                j++;
            }
        }

        //create new character array to store encoded characters.
        char[] encoded = new char[plaintext.length()];

        for (int i = 0; i < plaintext.length(); i++){

            encoded[i] = (char) (((((int)cyclic[i] - 97) +
                                   ((int)plaintext.charAt(i) - 97)) % 26) + 97); 
        }

        //create new string which is the encrypted string.
        String encrypted = new String(encoded);
        PrintWriter pen = new PrintWriter(System.out, true);

        //print out encrytped string
        pen.println(encrypted);
        
    }//encode

    /*
    *This method decrypts ciphertext, a String, using key, also a String. This cipher style is Vigenere Cipher.
    *
    * @paramleft
    *   The String to be decrypted
    * @paramright
    *   The String to be used as the key.
    */
    public static void decode (String ciphertext, String key) {

        //Create a string the same length as original string, containing repetitions of the key.
        //Example: If String = "booboo", and key = "cap", then cyclic = "capcap".
        char[] cyclic = new char[ciphertext.length()];
        int j = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            cyclic[i] = key.charAt(j);
            if (j == key.length() - 1) {
                j = 0;
            }
            else {
                j++;
            }
        }

        //create new character array to store decoded characters.
        char[] decoded = new char[ciphertext.length()];

        //decode each character and store into char[] decoded.
        for (int i = 0; i < ciphertext.length(); i++) {

            if ((int)ciphertext.charAt(i) < (int)cyclic[i]) {
                
                decoded[i] = (char) (97 + (26 - (java.lang.Math.abs(((int)ciphertext.charAt(i) - 97) -
                                                                    ((int)cyclic[i] - 97)))));
            }
            else {
                decoded[i] = (char) (97 +((((int)ciphertext.charAt(i) - 97) - 
                                           ((int)cyclic[i] - 97)) % 26));
            }                  
        }

        //Create new string containing the decrypted string.
        String decrypted = new String(decoded);
        PrintWriter pen = new PrintWriter(System.out, true);

        //print out decrypted string.
        pen.println(decrypted);
        
    }//decode
}//VigenereCipher
