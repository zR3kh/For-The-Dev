package Town.Characters;

import Hero.Hero;
import Town.Dialogs.TownDialogs;
import Weapon.Staff.Types.AshStaff;
import Weapon.Staff.Types.BirchStaff;
import Weapon.Staff.Types.OakStaff;
import Weapon.Sword.Types.BronzeSword;
import Weapon.Sword.Types.IronSword;
import Weapon.Sword.Types.SteelSword;
import Weapon.Weapon;


public class Merchant implements ICharacter {

    public int weaponPrice;
    public Weapon sword;
    public Weapon staff;

    /**
     * Functional method of the merchant
     * @param player
     */
    @Override
    public void interactWithPlayer(Hero player) {
        this.generateStock(player);
        int userChoice = TownDialogs.showMerchantDialogGlobal();
        switch (userChoice) {
            case 1:
                userChoice = TownDialogs.showMerchantDialogWeapons();
                switch (userChoice) {
                    case 1:
                        player.setGold(player.getGold() - this.weaponPrice);
                        player.setWeapon(this.sword);
                        System.out.println("You bought a " + this.sword.getName());
                        break;
                    case 2:
                        player.setGold(player.getGold() - this.weaponPrice);
                        player.setWeapon(this.staff);
                        System.out.println("You bought a " + this.staff.getName());
                        break;
                    case 3:
                        break;
                }
                break;
            case 2:
                break;
        }
    }

    public void generateStock(Hero player) {
        if (player.getLevel() <= 4) {
            this.sword = new BronzeSword();
            this.staff = new OakStaff();
            this.weaponPrice = 10;
        } else if (player.getLevel() <= 8) {
            this.sword = new IronSword();
            this.staff = new AshStaff();
            this.weaponPrice = 20;
        } else {
            this.sword = new SteelSword();
            this.staff = new BirchStaff();
            this.weaponPrice = 40;
        }
    }
}
