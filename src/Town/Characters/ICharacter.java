package Town.Characters;

import Hero.Hero;

public interface ICharacter {

    /**
     * Global method for each town character
     * @param player
     */
    void interactWithPlayer(Hero player);
}
