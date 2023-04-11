package GameHandling;

import Hero.Hero;
import Monster.Monster;

public interface IFightHandler {

    void fightProcess(Hero player, Monster enemy);
}
