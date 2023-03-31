package Hero;

import Monster.Monster;
import Weapon.Weapon;

import java.util.Random;

public class Hero {

    public String name;
    public int level = 1;
    public int toNextLevel = 10;
    public int currentXp = 0;
    public int attrPtsOnLevelUp = 0;
    public int gold;
    public int life;
    public int maxLife;
    public int energy;
    public int maxEnergy;
    public int strength;
    public int intelligence;
    public int speed;
    public Weapon weapon;

    /**
     * Hero Constructor
     *
     * @param name
     */
    public Hero(String name) {
        this.name = name;
        this.gold = 10;
    }

    /**
     * Calculate Hit Rating for the attack
     *
     * @param enemy
     * @return
     */
    public int calculateHitRating(Monster enemy) {
        int hitRating = 60 + (this.getSpeed() / 2) - (enemy.getSpeed() / 2);
        return hitRating;
    }

    /**
     * Determine if the attack lands or not
     *
     * @param hitRating
     * @return
     */
    public boolean isAttackSuccessful(int hitRating) {
        int rdnNumber = new Random().nextInt(100);
        return rdnNumber <= hitRating;
    }

    /**
     * Calculate the amount of damage dealt
     *
     * @param enemy
     */
    public void inflictDamage(Monster enemy) {
        int damage = this.getStrength();
        enemy.setLife(enemy.getLife() - damage);
        System.out.println(this.getName() + " hit the " + enemy.getName() + " for " + damage + " damages !");
    }

    /**
     * Check if the enemy is dead after landing a strike
     *
     * @param enemy
     */
    public void isEnemyDead(Monster enemy) {
        if (enemy.getLife() <= 0) {
            System.out.println("The " + enemy.getName() + " fall on the ground. Dead.");
        }
    }

    /**
     * Basic attack of the player
     *
     * @param enemy
     */
    public void attack(Monster enemy) {
        int hitRating = this.calculateHitRating(enemy);
        boolean isAttackSuccess = isAttackSuccessful(hitRating);
        if (isAttackSuccess) {
            this.inflictDamage(enemy);
            this.isEnemyDead(enemy);
        } else {
            System.out.println(this.getName() + " tries his best but fail miserably.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getToNextLevel() {
        return toNextLevel;
    }

    public void setToNextLevel(int toNextLevel) {
        this.toNextLevel = toNextLevel;
    }

    public int getCurrentXp() {
        return currentXp;
    }

    public void setCurrentXp(int currentXp) {
        this.currentXp = currentXp;
    }

    public int getAttrPtsOnLevelUp() {
        return attrPtsOnLevelUp;
    }

    public void setAttrPtsOnLevelUp(int attrPtsOnLevelUp) {
        this.attrPtsOnLevelUp = attrPtsOnLevelUp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
