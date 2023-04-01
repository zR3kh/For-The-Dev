package GameHandling;

import Hero.Hero;
import Monster.Monster;

import java.util.Scanner;

public class FightHandler implements IFightHandler {

    public IHeroHandler iHeroHandler;

    public FightHandler() {
        this.iHeroHandler = new HeroHandler();
    }

    /**
     * Display the battle menu at the start of each turn
     */
    public void showBattleMenu(Hero player) {
        System.out.println("What do you want to do ?");
        System.out.println("1. Attack");
        if (player.getWeapon() != null) {
            if (player.getWeapon().isWeaponSkillAvailable()) {
                System.out.println("2. " + player.getWeapon().getSkillName());
            } else {
                System.out.println("2. " + player.getWeapon().getSkillName() + " : " + player.getWeapon().getCurrentSkillCooldown() + " turns remaining.");
            }
        }
    }

    /**
     * Functional part of the fight
     */
    @Override
    public void fightProcess(Hero player, Monster enemy, Scanner scanner) {
        System.out.println("You encounter a savage " + enemy.getName() + " !");
        while (player.getLife() > 0 && enemy.getLife() > 0) {
            boolean validInput = false;
            while (!validInput) {
                this.showBattleMenu(player);
                int userChoice = scanner.nextInt();
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
     * Decrease player cooldowns on weapons & items
     * @param player
     */
    public void decreaseCooldowns(Hero player) {
        player.getWeapon().setCurrentSkillCooldown(player.getWeapon().getCurrentSkillCooldown() - 1);
    }

    /**
     * Resolve the fight
     *
     * @param enemy
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
