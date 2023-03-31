package Monster.Zombie;

import Monster.Monster;

public class Zombie extends Monster {

    public Zombie() {
        super();
        this.name = "Zombie";
        this.life = 10 + this.getLevel() - 1;
        this.strength = 5 + this.getLevel() - 1;
        this.speed = 5 + this.getLevel() - 1;
        this.xpGain = 10 + this.getLevel() - 1;
    }
}
