package org.project.object.armors;

import org.project.entity.Entity;

public class SimpleArmor extends Armor{

    public SimpleArmor(int defense, int durability) {
        super(defense, durability);
    }


    @Override
    public void use(Entity target)
     {
    }
}
