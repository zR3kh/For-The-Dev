package Town.Characters;

import Hero.Hero;
import Town.Dialogs.TownDialogs;

public class Priest implements ICharacter {

    /**
     * Functional method of the Priest
     * @param player
     */
    @Override
    public void interactWithPlayer(Hero player) {
        int userChoice = TownDialogs.showPriestDialogGlobal();
        switch (userChoice) {
            case 1:
                if (player.havePlayerEnoughGold(10)) {
                    player.setGold(player.getGold() - 10);
                    player.setLife(player.getMaxLife());
                    player.setEnergy(player.getMaxEnergy());
                    System.out.println("You feel revived. Life and energy fully restored.");
                } else {
                    System.out.println("You don't have enough gold.");
                }
                break;
            case 2:
                break;
        }
    }
}
