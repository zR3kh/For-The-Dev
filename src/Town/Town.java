package Town;

import Hero.Hero;

import java.util.Scanner;

public class Town {

    public static void visitPriest(Hero player, Scanner scanner) {
        System.out.println("There you are, my dear child.");
        System.out.println("I can fully restore your power if you desire, for the cheap price of ten gold.");
        System.out.println("Accept the offer ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                player.setGold(player.getGold() - 10);
                player.setLife(player.getMaxLife());
                System.out.println("You feel revived.");
                break;
            case 2:
                break;
        }

    }
}
