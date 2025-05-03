package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

public class Knife extends Weapon {

    public Knife(int damage, int manaCost)
    {
        super(damage, manaCost);
    }

    @Override
    public void uniqueAbility(ArrayList<Enemy> targets)
    {
        for (Enemy target : targets)
        {
            target.takeDamage(getDamage());
        }
    }
}
