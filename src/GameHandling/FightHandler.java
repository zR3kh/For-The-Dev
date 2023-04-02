package GameHandling;

import Hero.Hero;
import Monster.Monster;

import java.util.ArrayList;
import java.util.Scanner;

public class FightHandler implements IFightHandler {

    public IHeroHandler iHeroHandler;
    public final int action1 = 1;
    public final int action2 = 2;

    public FightHandler() {
        this.iHeroHandler = new HeroHandler();
    }

    /**
     * Store the possible fight actions
     *
     * @param player
     * @return
     */
    public ArrayList<Integer> getBattleOptions(Hero player) {
        ArrayList<Integer> actions = new ArrayList<>();
        System.out.println("What do you want to do ?");
        System.out.println("1. Attack");
        actions.add(this.action1);
        if (player.getWeapon() != null) {
            if (player.getWeapon().isWeaponSkillAvailable()) {
                System.out.println("2. " + player.getWeapon().getSkillName());
            } else {
                System.out.println("2. " + player.getWeapon().getSkillName() + " : " + player.getWeapon().getCurrentSkillCooldown() + " turns remaining.");
            }
            actions.add(this.action2);
        }
        return actions;
    }

    /**
     * Process the fight
     *
     * @param player
     * @param enemy
     * @param scanner
     */
    @Override
    public void fightProcess(Hero player, Monster enemy, Scanner scanner) {
        System.out.println("You encounter a savage " + enemy.getName() + " !");
        while (player.getLife() > 0 && enemy.getLife() > 0) {
            boolean validInput = false;
            while (!validInput) {
                int userChoice = this.handleUserInput(player, scanner);
                switch (userChoice) {
                    case 1:
                        validInput = player.attack(enemy);
                        break;
                    case 2:
                        validInput = player.getWeapon().useWeaponSkill(player, enemy);
                        break;
                    default:
                        break;
                }
            }

            this.decreaseCooldowns(player);
            if (enemy.getLife() > 0) {
                enemy.attack(player);
            }
        }
        this.fightTermination(player, enemy, scanner);
    }

    /**
     * Process user input
     *
     * @param player
     * @param scanner
     * @return
     */
    public int handleUserInput(Hero player, Scanner scanner) {
        ArrayList<Integer> actions = this.getBattleOptions(player);
        int userChoice = -1;
        do {
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                if (!actions.contains(userChoice)) {
                    System.out.println("This is not a valid action.");
                }
            } else {
                System.out.println("This is not a valid choice.");
                scanner.next();
            }
        } while (!actions.contains(userChoice));
        return userChoice;
    }

    /**
     * Decrease player cooldowns on weapons & items
     *
     * @param player
     */
    public void decreaseCooldowns(Hero player) {
        if (player.getWeapon().getCurrentSkillCooldown() > 0) {
            player.getWeapon().setCurrentSkillCooldown(player.getWeapon().getCurrentSkillCooldown() - 1);
        }
    }

    /**
     * Resolve the fight
     * @param player
     * @param enemy
     * @param scanner
     */
    public void fightTermination(Hero player, Monster enemy, Scanner scanner) {
        if (player.getLife() > 0) {
            System.out.println("Death of the " + enemy.getName() + " gives you " + enemy.getXpGain() + " experience and " + enemy.getGoldGain() + " golds.");
            player.setGold(player.getGold() + enemy.getGoldGain());
            player.setCurrentXp(player.getCurrentXp() + enemy.getXpGain());
            if (player.getCurrentXp() >= player.getToNextLevel()) {
                this.iHeroHandler.levelUp(player, scanner);
            }
        } else {
            System.out.println("\nYou lost. Game over.");
        }
    }
}
