package Task5;

import java.io.*;

public class TextFileEncryptionDecryption {
    public static void main(String[] args) {
        try {
            // Encryption
            encryptFile("input.txt", "encrypted.txt", 3);

            // Decryption
            decryptFile("encrypted.txt", "decrypted.txt", 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encryptFile(String inputFile, String outputFile, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char encryptedChar = (char) (ch + key);
                writer.write(encryptedChar);
            }
        }
        System.out.println("File encrypted successfully.");
    }

    private static void decryptFile(String inputFile, String outputFile, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char decryptedChar = (char) (ch - key);
                writer.write(decryptedChar);
            }
        }
        System.out.println("File decrypted successfully.");
    }
}
