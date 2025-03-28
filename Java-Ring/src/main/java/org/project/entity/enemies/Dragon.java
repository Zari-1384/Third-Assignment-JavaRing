package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public class Dragon extends Enemy{
    int maxHP = 600;
    int damage = 150;

    public Dragon(int hp, int mp, Weapon weapon, String name, int damagepower) {
        super(hp, mp, weapon, name, damagepower);
    }

    @Override
    public void attack(Entity target)
    {
        super.setDamagepower(damage);
        target.takeDamage(super.getDamagepower());
    }

    @Override
    public void defend()
    {
        if(super.getHp()/5 <= maxHP)
        {
            defending = true;
            System.out.println("enemy is on defending mode");
        }
    }

    @Override
    public void heal(int health)
    {
        super.setHp(Math.min((super.getHp() + health), maxHP));
    }

    @Override
    public void fillMana(int mana)
    {
        //no mana
    }

    @Override
    public int getMaxHP()
    {
        super.setHp(maxHP);
        return maxHP;
    }

    @Override
    public int getMaxMP() {
        super.setHp(maxHP);
        return maxHP;
    }
}
