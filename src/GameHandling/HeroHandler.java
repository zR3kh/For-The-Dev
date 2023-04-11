package GameHandling;

import Hero.Hero;

import java.util.ArrayList;
import java.util.Arrays;

public class HeroHandler implements IHeroHandler {

    /**
     * Handle the level-up of the player
     */
    @Override
    public void levelUp(Hero player) {
        while (player.getToNextLevel() <= player.getCurrentXp()) {
            player.setCurrentXp(player.getCurrentXp() - player.getToNextLevel());
            player.setToNextLevel(player.getToNextLevel() + 10);
            player.setLevel(player.getLevel() + 1);
            player.setAttrPtsOnLevelUp(player.getAttrPtsOnLevelUp() + 5);
        }
        System.out.println("\nYou earned a lot. To level " + player.getLevel() + " !\n");
        System.out.println("Now you have " + player.getAttrPtsOnLevelUp() + " attributes points to increase your stats. Select wisely.");
        System.out.println("1. Life");
        System.out.println("2. Energy");
        System.out.println("3. Strength");
        System.out.println("4. Intelligence");
        System.out.println("5. Speed");
        while (player.getAttrPtsOnLevelUp() > 0) {
            int userChoice = UserInputHandler.getUserIntInput(new ArrayList(Arrays.asList(1,2,3,4,5)));
            switch (userChoice) {
                case 1:
                    player.setMaxLife(player.getMaxLife() + 1);
                    break;
                case 2:
                    player.setMaxEnergy(player.getMaxEnergy() + 1);
                    break;
                case 3:
                    player.setStrength(player.getStrength() + 1);
                    break;
                case 4:
                    player.setIntelligence(player.getIntelligence() + 1);
                    break;
                case 5:
                    player.setSpeed(player.getSpeed() + 1);
                    break;
            }
            System.out.println("Stat increased.");
            player.setAttrPtsOnLevelUp(player.getAttrPtsOnLevelUp() - 1);
        }
    }
}
