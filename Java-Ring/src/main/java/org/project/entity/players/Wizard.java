package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

import java.util.ArrayList;

public class Wizard extends Player{

    //wisard have a simle armor

    public Wizard(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }

    public void spell_attak(ArrayList<Enemy> targets)
    {
        if(super.getMp() >= 30)
        {
            weapon.powerfull_spell(targets);
            super.setMp(super.getMp() - 30);
        }
        else
        {
            System.out.println("you dont have enough mana, you will have a simple attack ");
        }
    }

}


