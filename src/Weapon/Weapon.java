package Weapon;

import Hero.Hero;
import Monster.Monster;

public abstract class Weapon {

    public String name;
    public String type;
    public String skillName;
    public int damage;
    public int accuracy;
    public int currentSkillCooldown;
    public int maxSkillCooldown;

    public Weapon(String type, String skillName, int accuracy, int maxSkillCooldown) {
        this.type = type;
        this.skillName = skillName;
        this.accuracy = accuracy;
        this.maxSkillCooldown = maxSkillCooldown;
        this.currentSkillCooldown = 0;
    }

    /**
     * Check if player can execute his weapon skill
     * @return
     */
    public boolean isWeaponSkillAvailable() {
        return this.currentSkillCooldown == 0;
    }

    /**
     * Functional method for weapon skill use
     * @param player
     * @param enemy
     * @return
     */
    public abstract boolean useWeaponSkill(Hero player, Monster enemy);

    /**
     * Check if the weapon skill is a success or not
     * @param player
     * @param enemy
     * @return
     */
    public abstract boolean isAttackSuccessful(Hero player, Monster enemy);

    /**
     * Deal damage on enemy with weapon skill
     * @param player
     * @param enemy
     */
    public abstract void inflictDamageOnSkill(Hero player, Monster enemy);

    /**
     * Miss weapon skill
     * @param player
     */
    public abstract void failWeaponSkill(Hero player);

    /**
     * Calculate chances to hit with weapon skill
     * @param player
     * @param enemy
     * @return
     */
    public abstract int calculateWeaponSkillAccuracy(Hero player, Monster enemy);

    /**
     * Calculate weapon skill damage
     * @param player
     * @return
     */
    public abstract int getSkillDamage(Hero player);

    /**
     * Calculate weapon attack damage
     * @param player
     * @return
     */
    public abstract int getAttackDamage(Hero player);

    public int getAccuracy() {
        return accuracy;
    }

    public String getSkillName() {
        return skillName;
    }

    public int getCurrentSkillCooldown() {
        return currentSkillCooldown;
    }

    public void setCurrentSkillCooldown(int currentSkillCooldown) {
        this.currentSkillCooldown = currentSkillCooldown;
    }

    public int getMaxSkillCooldown() {
        return maxSkillCooldown;
    }

    public void setMaxSkillCooldown(int maxSkillCooldown) {
        this.maxSkillCooldown = maxSkillCooldown;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
