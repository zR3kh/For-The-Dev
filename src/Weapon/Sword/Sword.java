package Weapon.Sword;

import Hero.Hero;
import Monster.Monster;
import Weapon.Weapon;

public abstract class Sword extends Weapon {

    public Sword(String name, int damage) {
        super("Sword", "Slash", 10, 4);
        this.name = name;
        this.damage = damage;
    }

    /**
     * Functional method for weapon skill use
     * @param player
     * @param enemy
     * @return
     */
    @Override
    public boolean useWeaponSkill(Hero player, Monster enemy) {
        if (isWeaponSkillAvailable()) {
            int accuracy = this.calculateWeaponSkillAccuracy(player, enemy);
            boolean isAttackSuccessful = player.isAttackSuccessful(accuracy);
            if (isAttackSuccessful) {
                this.inflictDamageOnSkill(player, enemy);
            } else {
                player.setLife(player.getLife() - 5);
                System.out.println("You tripped on your sword, hurting yourself for " + 5 + " damages.");
            }
            this.setCurrentSkillCooldown(this.getMaxSkillCooldown());
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Calculate chances to hit with weapon skill
     * @param player
     * @param enemy
     * @return
     */
    @Override
    public int calculateWeaponSkillAccuracy(Hero player, Monster enemy) {
        return player.calculateHitRating(enemy) - this.getAccuracy();
    }

    /**
     * Deal damage on enemy with weapon skill
     * @param player
     * @param enemy
     */
    @Override
    public void inflictDamageOnSkill(Hero player, Monster enemy) {
        int damage = this.getSkillDamage(player);
        enemy.setLife(enemy.getLife() - damage);
        System.out.println("You perform a powerful slash towards the " + enemy.getName() + " !");
        System.out.println("It dealt the honest amount of " + damage + " points of damage.");
    }

    /**
     * Calculate weapon skill damage
     * @param player
     * @return
     */
    @Override
    public int getSkillDamage(Hero player) {
        return player.getStrength() + this.getDamage() + (player.getLevel() - 1) * 2;
    }

    /**
     * Calculate weapon attack damage
     * @param player
     * @return
     */
    @Override
    public int getAttackDamage(Hero player) {
        return player.getStrength() + this.getDamage();
    }
}
