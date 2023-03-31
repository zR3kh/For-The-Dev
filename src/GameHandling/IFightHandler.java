package GameHandling;

import Hero.Hero;
import Monster.Monster;

import java.util.Scanner;

public interface IFightHandler {

    void fightProcess(Hero player, Monster enemy, Scanner scanner);
}
