package Weapon;

import Hero.Hero;
import Monster.Monster;

public abstract class Weapon {

    public Weapon(String type, int damage, int accuracy, String skillName) {
        this.type = type;
        this.damage = damage;
        this.accuracy = accuracy;
        this.skillName = skillName;
        this.currentSkillCooldown = 0;
    }

    public final String type;
    public final int damage;
    public final int accuracy;
    public final String skillName;
    public int currentSkillCooldown;
    public int maxSkillCooldown;

    public abstract boolean useWeaponSkill(Hero player, Monster enemy);

    public abstract void inflictDamageOnSkill(Hero player, Monster enemy);

    public abstract int getSkillDamage(Hero player);

    public abstract int getAttackDamage(Hero player);

    public boolean isWeaponSkillAvailable() {
        return this.currentSkillCooldown == 0;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

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
}
