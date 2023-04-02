package Town.Characters;

import Hero.Hero;
import Town.Dialogs.TownDialogs;
import Weapon.Staff.Staff;
import Weapon.Sword.Sword;

public class Merchant implements ICharacter {

    /**
     * Functional method of the merchant
     * @param player
     */
    @Override
    public void interactWithPlayer(Hero player) {
        int userChoice = TownDialogs.showMerchantDialogGlobal();
        switch (userChoice) {
            case 1:
                userChoice = TownDialogs.showMerchantDialogWeapons();
                switch (userChoice) {
                    case 1:
                        player.setGold(player.getGold() - 10);
                        player.setWeapon(new Sword());
                        System.out.println("You bought a Sword.");
                        break;
                    case 2:
                        player.setGold(player.getGold() - 10);
                        player.setWeapon(new Staff());
                        System.out.println("You bought a Staff.");
                        break;
                    case 3:
                        break;
                }
                break;
            case 2:
                break;
        }
    }
}
