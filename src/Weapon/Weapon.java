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

    public abstract int calculateWeaponSkillAccuracy(Hero player, Monster enemy);

    public abstract boolean useWeaponSkill(Hero player, Monster enemy);

    public abstract void inflictDamageOnSkill(Hero player, Monster enemy);

    public abstract int getSkillDamage(Hero player);

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
}
