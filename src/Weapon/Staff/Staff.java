package Weapon.Staff;

import Hero.Hero;
import Monster.Monster;
import Weapon.Weapon;

public class Staff extends Weapon {

    public Staff() {
        super("Staff", 2, 4, "Fireball");
        this.maxSkillCooldown = 2;
    }

    @Override
    public boolean useWeaponSkill(Hero player, Monster enemy) {
        if (isWeaponSkillAvailable()) {
            int hitRating = player.calculateHitRating(enemy) - this.getAccuracy();
            boolean isAttackSuccessful = player.isAttackSuccessful(hitRating);
            this.setCurrentSkillCooldown(this.getMaxSkillCooldown());
            if (isAttackSuccessful) {
                this.inflictDamageOnSkill(player, enemy);
            } else {
                System.out.println("Oops, wrong formula.");
            }
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public void inflictDamageOnSkill(Hero player, Monster enemy) {
        int damage = this.getSkillDamage(player);
        enemy.setLife(enemy.getLife() - damage);
        System.out.println("You hurls a burning fireball on the " + enemy.getName() + " !");
        System.out.println("It dealt the moderate amount of " + damage + " points of damage.");
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
