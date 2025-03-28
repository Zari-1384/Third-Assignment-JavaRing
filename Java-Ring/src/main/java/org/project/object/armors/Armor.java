package org.project.object.armors;

import org.project.object.Object;

// TODO: UPDATE IMPLEMENTATION
public abstract class Armor implements Object{
    private int defense;
    private int maxDefense;
    private int durability;
    private int maxDurability;

    private boolean isBroke;

    public Armor(int defense, int durability) {
        this.defense = defense;
        this.durability = durability;
    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    // TODO: (BONUS) UPDATE THE REPAIR METHOD
    public void repair() {
        isBroke = false;
        defense = getMaxDefense();
        durability = getMaxDurability();
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBroke() {
        return isBroke;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setDurability(int durability) {
        this.durability = durability;
        checkBreak();
    }

    public void setMaxDefense(int maxDefense) {
        this.maxDefense = maxDefense;
    }

    public void setMaxDurability(int maxDurability) {
        this.maxDurability = maxDurability;
    }
}
