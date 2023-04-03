package Weapon.Staff;

import Hero.Hero;
import Monster.Monster;
import Weapon.Weapon;

import java.util.Random;

public abstract class Staff extends Weapon {

    public Staff(String name, int damage) {
        super("Staff", "Fireball", 4, 2);
        this.name = name;
        this.damage = damage;
    }

    @Override
    public boolean useWeaponSkill(Hero player, Monster enemy) {
        if (isWeaponSkillAvailable()) {
            if (this.isAttackSuccessful(player, enemy)) {
                this.inflictDamageOnSkill(player, enemy);
            } else {
                this.failWeaponSkill(player);
            }
            this.setCurrentSkillCooldown(this.getMaxSkillCooldown());
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isAttackSuccessful(Hero player, Monster enemy) {
        int hitRating = this.calculateWeaponSkillAccuracy(player, enemy);
        int rdnNumber = new Random().nextInt(100);
        return rdnNumber <= hitRating;
    }

    @Override
    public void inflictDamageOnSkill(Hero player, Monster enemy) {
        int damage = this.getSkillDamage(player);
        enemy.setLife(enemy.getLife() - damage);
        System.out.println("You hurls a burning fireball on the " + enemy.getName() + " !");
        System.out.println("It dealt the moderate amount of " + damage + " points of damage.");
    }

    @Override
    public void failWeaponSkill(Hero player) {
        System.out.println("Oops, wrong formula.");
    }

    @Override
    public int calculateWeaponSkillAccuracy(Hero player, Monster enemy) {
        return player.calculateHitRating(enemy) - this.getAccuracy();
    }

    @Override
    public int getSkillDamage(Hero player) {
        return (player.getIntelligence()) / 2 + this.getDamage() + (player.getLevel() - 1) * 2;
    }

    @Override
    public int getAttackDamage(Hero player) {
        return (player.getIntelligence()) / 2 + this.getDamage();
    }
}
