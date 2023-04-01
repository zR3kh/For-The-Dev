package Weapon.Sword;

import Hero.Hero;
import Monster.Monster;
import Weapon.Weapon;

public class Sword extends Weapon {

    public Sword() {
        this.type = "Sword";
        this.damage = 4;
        this.accuracy = 10;
        this.skillName = "Slash";
        this.maxSkillCooldown = 4;
        this.currentSkillCooldown = 0;
    }

    @Override
    public boolean useWeaponSkill(Hero player, Monster enemy) {
        if (isWeaponSkillAvailable()) {
            int hitRating = player.calculateHitRating(enemy) - this.getAccuracy();
            boolean isAttackSuccessful = player.isAttackSuccessful(hitRating);
            this.setCurrentSkillCooldown(this.getMaxSkillCooldown());
            if (isAttackSuccessful) {
                this.inflictDamage(player, enemy);
            } else {
                player.setLife(player.getLife() - 5);
                System.out.println("You tripped on your sword, hurting yourself for " + 5 + " damages.");
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void inflictDamage(Hero player, Monster enemy) {
        int damage = player.getStrength() + this.getDamage() + (player.getLevel() - 1) * 2;
        enemy.setLife(enemy.getLife() - damage);
        System.out.println("You perform a powerful slash towards the " + enemy.getName() + " !");
        System.out.println("It dealt the honest amount of " + damage + " points of damage.");
    }

    @Override
    public boolean isWeaponSkillAvailable() {
        return this.getCurrentSkillCooldown() == 0;
    }
}
