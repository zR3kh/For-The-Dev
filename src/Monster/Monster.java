package Monster;

import GameHandling.SharedDataSingleton;
import Hero.Hero;

import java.util.Random;

public class Monster {

    public String name;

    public int level;
    public int life;
    public int strength;
    public int speed;
    public int xpGain;

    public SharedDataSingleton sharedDataSingleton;
    public Hero player;

    public Monster() {
        this.sharedDataSingleton = SharedDataSingleton.getInstance();
        this.player = this.sharedDataSingleton.getPlayer();
        this.setLevel(this.player.getLevel());
    }

    public void attack(Hero player) {
        int rdnNumber = new Random().nextInt(10);
        int hitRating = 60 + (player.speed / 2) - (this.speed / 2);
        boolean isAttackSuccess = rdnNumber <= hitRating;
        System.out.println(this.name + " attack " + player.name + " !");
        if (isAttackSuccess) {
            player.life -= this.strength;
            System.out.println(this.name + " hit " + player.name + " for " + this.strength + " damage !");
            if (player.life <= 0) {
                System.out.println(player.name + " fall on the ground. Dead.");
            }
        } else {
            System.out.println(this.name + " tries his best but fail miserably.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getXpGain() {
        return xpGain;
    }

    public void setXpGain(int xpGain) {
        this.xpGain = xpGain;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
