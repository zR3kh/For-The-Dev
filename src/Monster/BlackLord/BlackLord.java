package Monster.BlackLord;

import Monster.Monster;
import Weapon.Staff.Types.BirchStaff;

import java.util.Random;

public class BlackLord extends Monster {

    public BlackLord() {
        super();
        this.name = "The Black Lord";
        this.life = 100 + this.getLevel() - 1;
        this.strength = 15 + this.getLevel() - 1;
        this.speed = 15 + this.getLevel() - 1;
        this.xpGain = 100 + this.getLevel() - 1;
        this.goldGain = new Random().nextInt(100 + 1);
        this.weapon = new BirchStaff();
    }
}
