package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

// TODO: UPDATE IMPLEMENTATION
public class Sword extends Weapon{
    /*
    THIS IS AN EXAMPLE OF A WEAPON DESIGN.
    */

    public Sword(int damage, int manaCost)
    {
        super(damage, manaCost);
        // TODO: DESIGN SWORD'S ATTRIBUTES IMPLEMENT THE CONSTRUCTOR
    }

    // TODO: (BONUS) UPDATE THE UNIQUE ABILITY
    public void uniqueAbility(ArrayList<Enemy> targets)
    {
        for (Enemy target : targets)
        {
            target.takeDamage(getDamage() * 2);
        }
    }

}
