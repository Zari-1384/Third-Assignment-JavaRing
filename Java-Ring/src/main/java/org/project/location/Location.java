package org.project.location;

import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

public class Location {
    private String name;
    private boolean visited = false;

    private ArrayList<Enemy> LocationEnemies = new ArrayList<Enemy>();

    public Location(ArrayList<Enemy> enemies, String name) {
        this.LocationEnemies.addAll(enemies);
        this.name = name;
    }

    /*
    TODO: (BONUS) RESET EACH LOCATION AFTER PLAYER LEAVES
    */

    public String getName() {
        return name;
    }

    public ArrayList<Enemy> getEnemies() {
        return LocationEnemies;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
