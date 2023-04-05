package GameHandling;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputHandler {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * Handle user input when it should be int
     * @param validInputsList
     * @return
     */
    public static int getUserIntInput(ArrayList validInputsList) {
        int userChoice = -1;
        do {
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                if (!validInputsList.contains(userChoice)) {
                    System.out.println("This is not a valid action, sir.");
                    scanner.next();
                }
            } else {
                System.out.println("This is not a valid key, sir.");
                scanner.next();
            }
        } while (!validInputsList.contains(userChoice));
        return userChoice;
    }

    /**
     * Handle user input when it should be a String
     * @return
     */
    public static String getUserStringInput() {
        String userChoice = "";
        do {
            if (scanner.hasNextInt()) {
                System.out.println("This is not a valid action, sir.");
                scanner.next();
            } else {
                userChoice = scanner.nextLine();
            }
        } while (scanner.hasNextLine());

        return userChoice;
    }
}
