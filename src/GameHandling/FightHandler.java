package GameHandling;

import Hero.Hero;
import Monster.BlackLord.BlackLord;
import Monster.Monster;

import java.util.ArrayList;
import java.util.Random;

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
     */
    @Override
    public void fightProcess(Hero player, Monster enemy) {
        if (!(enemy instanceof BlackLord)) {
            System.out.println("You encounter a savage " + enemy.getName() + " !");
        } else {
            System.out.println("Black Lord : 'Looks about you've come to and end...'");
            System.out.println("Black Lord : 'This place is MINE ! Prepare to SUFFER !!");
        }
        while (player.getLife() > 0 && enemy.getLife() > 0) {
            boolean validInput = false;
            while (!validInput) {
                int userChoice = UserInputHandler.getUserIntInput(this.getBattleOptions(player));
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
            if (!(enemy instanceof BlackLord)) {
                if (enemy.getLife() > 0) {
                    enemy.attack(player);
                }
            } else {
                int rdnNumber = new Random().nextInt(10);
                if (enemy.getLife() > 0) {
                   /* if (rdnNumber > 4 && enemy.getWeapon().isWeaponSkillAvailable()) {
                        System.out.println("YOUR SOUL SHALL BURN !");
                        enemy.getWeapon().useWeaponSkill(player, enemy);
                    } else {
                        enemy.attack(player);
                    }*/
                    System.out.println("DIE, INSECT !");
                    enemy.attack(player);

                }
            }

        }
        this.fightTermination(player, enemy);
    }

    /**
     * Decrease player cooldowns on weapons & items
     *
     * @param player
     */
    public void decreaseCooldowns(Hero player) {
        if (player.getWeapon() != null && player.getWeapon().getCurrentSkillCooldown() > 0) {
            player.getWeapon().setCurrentSkillCooldown(player.getWeapon().getCurrentSkillCooldown() - 1);
        }
    }

    /**
     * Resolve the fight
     * @param player
     * @param enemy
     */
    public void fightTermination(Hero player, Monster enemy) {
        if (player.getLife() > 0) {
            System.out.println("Death of the " + enemy.getName() + " gives you " + enemy.getXpGain() + " experience and " + enemy.getGoldGain() + " golds.");
            player.setGold(player.getGold() + enemy.getGoldGain());
            player.setCurrentXp(player.getCurrentXp() + enemy.getXpGain());
            if (player.getCurrentXp() >= player.getToNextLevel()) {
                this.iHeroHandler.levelUp(player);
            }
        } else {
            System.out.println("\nYou lost. Game over.");
        }
    }
}
