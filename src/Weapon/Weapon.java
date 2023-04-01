package Weapon;

import Hero.Hero;
import Monster.Monster;

public abstract class Weapon {

    public String type;
    public int damage;
    public int accuracy;
    public String skillName;
    public int currentSkillCooldown;
    public int maxSkillCooldown;

    public abstract boolean useWeaponSkill(Hero player, Monster enemy);

    public abstract void inflictDamage(Hero player, Monster enemy);

    public abstract boolean isWeaponSkillAvailable();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
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
