package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.Object;

import java.util.ArrayList;

// TODO: UPDATE IMPLEMENTATION
public abstract class Weapon implements Object {
    private int damage;
    private int manaCost;
    protected int abilityCharge = 0;

    /*
    TODO: ADD OTHER REQUIRED AND BONUS ATTRIBUTES
    */

    public Weapon(int damage, int manaCost)
    {
        this.damage = damage;
        this.manaCost = manaCost;
    }

    @Override
    public void use(Entity target) {
        target.takeDamage(damage);
    }

    public void powerfull_spell(ArrayList<Enemy> targets)
    {
        for (Entity target : targets)
        {
            target.takeDamage(getDamage() * 2);
        }
    }

    public void uniqueAbility(ArrayList<Enemy> targets)
    {
        for (Enemy target : targets)
        {
            target.takeDamage(getDamage());
        }
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setManaCost(int manaCost)
    {
        this.manaCost = manaCost;
    }

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */
}
