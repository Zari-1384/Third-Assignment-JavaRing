package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public abstract class Enemy implements Entity {
    Weapon weapon;
    private int hp;
    private int mp;
    protected String name;
    protected int damagepower;
    protected boolean defending = false;

    public Enemy(int hp, int mp, Weapon weapon, String name, int damagepower) {
        this.hp = hp;
        this.mp = mp;
        this.name = name;
        this.damagepower = damagepower;
        this.weapon = weapon;
    }

    // TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    @Override
    public void takeDamage(int damage) {
        if(defending)
        {
            hp -= (damage/2);
        }
        else
        {
            hp -= damage;
        }
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getDamagepower() {
        return damagepower;
    }

    public void setDamagepower(int damagepower) {
        this.damagepower = damagepower;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setDefending(boolean defending) {
        this.defending = defending;
    }
}
