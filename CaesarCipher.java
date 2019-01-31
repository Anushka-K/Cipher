import java.io.PrintWriter;

public class CaesarCipher {

    public static void main (String[] args) {

        //create "encode" and "decode" strings to check for equality in command line arguments.
        String param1enc = new String("encode");
        String param1dec = new String("decode");

        PrintWriter pen = new PrintWriter(System.out, true);

        //Depending on user input, encode, decode, or print appropriate error message.
        if (args.length < 2) {
            pen.println("The program expects two parameters. 1st: encode or decode, 2nd: string");
        }   
        
        else if (param1enc.equals(args[0])) {
            for (int n = 0; n < 26; n++) {
                encode(args[1], n);
            }
        }

        else if (param1dec.equals(args[0])) {
            for (int n = 0; n < 26; n++)
                decode(args[1], n);
        }

        else {
            pen.println("Valid options for the first parameter are 'encode' and 'decode'.");    
        }
        
    }//main

    //this method encrypts a string with shift value n.
    public static void encode (String plaintext, int n) {

        //create new character array to store encrypted characters.
        char[] ciphertext = new char[plaintext.length()];

        //encrypt
        for (int i = 0; i < plaintext.length(); i++) {

            ciphertext[i] = (char)(((int)plaintext.charAt(i) +
                                    n - 97) % 26 +97);
        }

        //create new string storing encrypted string.
        String ciphered = new String(ciphertext);
        //print out encrypted string.
        PrintWriter pen = new PrintWriter(System.out, true);
        pen.println("n = " + n + ": " + ciphered);
        
    }//encode

    //this method decrypts a string with shift value n.
    public static void decode (String ciphertext, int n) {

        //create new character array to store decrypted characters.
        char[] plaintext = new char[ciphertext.length()];

        //decrypt
        for (int i = 0; i < ciphertext.length(); i++) {

            if ((int)(ciphertext.charAt(i) - n) < 97) {

                plaintext[i] = (char) (((int)ciphertext.charAt(i) -
                                        n + 122 - 97 + 1));
            }

            else { 
                plaintext[i] = (char) (((int)ciphertext.charAt(i) -
                                        n - 97) % 26 + 97);
            }
        }

        //create new String containing decrypted string.
        String deciphered = new String(plaintext);
        //print out decrypted string.
        PrintWriter pen = new PrintWriter(System.out, true);
        pen.println("n = " + n + ": " + deciphered);
        
    }//decode

}
