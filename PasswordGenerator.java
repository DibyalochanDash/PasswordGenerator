package Task_4;

import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the  Length of the Password: ");
            int length = scanner.nextInt();

            System.out.print("Include numbers? (yes/no): ");
            boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

            System.out.print("Include lowercase letters? (yes/no): ");
            boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

            System.out.print("Include uppercase letters? (yes/no): ");
            boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

            System.out.print("Include special characters? (yes/no): ");
            boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

            // Generate and display the password
            String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
            System.out.println("Generated Password: " + password);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        } finally {
            scanner.close();
        }
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase,
                                           boolean includeUppercase, boolean includeSpecialChars) {
        String numbers = "0123456789";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'<>,.?/";

        StringBuilder validChars = new StringBuilder();
        if (includeNumbers) validChars.append(numbers);
        if (includeLowercase) validChars.append(lowercaseChars);
        if (includeUppercase) validChars.append(uppercaseChars);
        if (includeSpecialChars) validChars.append(specialChars);

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
