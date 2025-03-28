package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

import java.util.ArrayList;

public class Assasin extends Player {

    //assasin have a simle armor
    public boolean isvisibility = true;

    public Assasin(String name, int hp, int mp, Weapon weapon, Armor armor)
    {
        super(name, hp, mp, weapon, armor);
    }

    public void becomesInvisible ()
    {
        if (this.getMp() >= 20)
        {
            this.isvisibility = false;
            super.visibilityMp();
            System.out.println(this.name + " fades into the shadows, becoming undetectable for the next strike.");
        }
        else
        {
            System.out.println(this.name + " lacks sufficient mana to vanish!");
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (!isvisibility) {
            System.out.println(this.name + " is hidden and dodges the attack!");
        }
        else
        {
            if (super.getDefends())
            {
                super.setHp(super.getHp()- damage + armor.getDefense());
                armor.setDurability(armor.getDurability() - 20);
            }
            else
            {
                super.setHp(super.getHp()- damage);
            }
        }
    }
}