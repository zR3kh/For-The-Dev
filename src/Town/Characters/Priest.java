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
                player.setGold(player.getGold() - 10);
                player.setLife(player.getMaxLife());
                System.out.println("You feel revived.");
                break;
            case 2:
                break;
        }
    }
}
