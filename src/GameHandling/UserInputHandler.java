package GameHandling;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputHandler {

    public static Scanner scanner = new Scanner(System.in);

    public static int getUserInput(ArrayList validInputsList) {
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
}
