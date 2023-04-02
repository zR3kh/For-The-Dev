package Town;

import Hero.Hero;
import Town.Characters.ICharacter;
import Town.Characters.Merchant;
import Town.Characters.Priest;

public class Town {

    public static ICharacter priest = new Priest();
    public static ICharacter merchant = new Merchant();

    /**
     * Handle interaction of Priest with player
     * @param player
     */
    public static void visitPriest(Hero player) {
        priest.interactWithPlayer(player);
    }

    /**
     * Handle interaction of Merchant with player
     * @param player
     */
    public static void visitMerchant(Hero player) {
        merchant.interactWithPlayer(player);
    }
}
