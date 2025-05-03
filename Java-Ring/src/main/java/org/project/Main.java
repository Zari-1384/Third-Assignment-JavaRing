package org.project;

import org.project.location.Location;
import org.project.entity.enemies.Enemy;
import org.project.entity.enemies.Skeleton;
import org.project.entity.enemies.Goblin;
import org.project.entity.enemies.Dragon;
import org.project.entity.players.Player;
import org.project.entity.players.Knight;
import org.project.entity.players.Assasin;
import org.project.entity.players.Wizard;
import org.project.object.armors.Armor;
import org.project.object.armors.KnightArmor;
import org.project.object.armors.SimpleArmor;
import org.project.object.weapons.Weapon;
import org.project.object.weapons.Sword;
import org.project.object.weapons.Knife;
import org.project.object.weapons.Wand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: ADD SOME LOCATIONS TO YOUR GAME
        boolean GameOver = false;

        List<Location> locations = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        Enemy skelet1 = new Skeleton(100, 0, new Knife(10, 0), "skelet1", 20);
        Enemy skelet2 = new Skeleton(100, 0, new Knife(10, 0), "skelet2", 20);
        Enemy skelet3 = new Skeleton(100, 0, new Knife(10, 0), "skelet3", 20);
        Enemy goblin1 = new Goblin(200, 0, new Sword(30, 0), "goblin1", 30);
        Enemy goblin2 = new Goblin(200, 0, new Sword(30, 0), "goblin2", 30);
        Enemy goblin3 = new Goblin(200, 0, new Sword(30, 0), "goblin3", 30);
        Enemy dragon = new Dragon(600, 0, new Sword(60, 0), "dragon", 150);
        Weapon skeletKnife = new Knife(20, 0);
        Weapon goblinSword = new Sword(30, 0);
        Weapon dragonSword = new Sword(100, 0);

        ArrayList<Enemy> DesertEnemies = new ArrayList<>();
        DesertEnemies.add(skelet1);
        DesertEnemies.add(skelet2);
        DesertEnemies.add(skelet3);

        ArrayList<Enemy> ForestEnemies = new ArrayList<>();
        ForestEnemies.add(goblin1);
        ForestEnemies.add(goblin2);
        ForestEnemies.add(goblin3);

        ArrayList<Enemy> HellEnemies = new ArrayList<>();
        HellEnemies.add(skelet1);
        HellEnemies.add(skelet2);
        HellEnemies.add(goblin1);
        HellEnemies.add(goblin2);
        HellEnemies.add(dragon);

        locations.add(new Location(DesertEnemies, "Desert"));
        locations.add(new Location(ForestEnemies, "Forest"));
        locations.add(new Location(HellEnemies, "Hell"));

        System.out.println("Welcome to the EldenRing game, Adventure!");
        System.out.println("some hints:\n" +
                "health: it is your chracter health. when it become half your defending mode will be on. " +
                "mana: it is your character mana(knight dont have any mana. " );
        System.out.println("\nSelect your hero:");
        System.out.println("1. murderer Assassin.\n name : Kazem\n HP : 1200\n MP: 120\n" +
                " Weapon : Knife\n Armor : simple armor\n simple damage = 50\n" +
                " special ability : disappiers (needs 20 mana)\n");
        System.out.println("2. Skillful Witch.\n name : Belgheis\n HP : 1500\n MP: 300\n" +
                " Weapon : her magic with Wand\n Armor : simple armor\n simple damage = 50\n" +
                " special ability spell damage : 100 (needs 30 mana)\n");
        System.out.println("3. Strong Knight.\n name : Borzoo\n HP : 2000\n MP: 80\n" +
                " Weapon : Sword\n Armor : Knight armorr\n simple damage = 50\n" +
                " special ability damage : 100 (needs 10 mana)\n");

        int character = input.nextInt();
        Weapon KazemKnife = new Knife(50, 0);
        Weapon BelgheisWand = new Wand(50, 0);
        Weapon BorzooSword = new Sword(50, 0);
        Armor KazemArmor = new SimpleArmor(20, 100);
        Armor BelgheisArmor = new SimpleArmor(20, 100);
        Armor BorzooArmor = new KnightArmor(40, 100);

        Player hero = null;

            switch (character)
            {
                case 1:
                    hero = new Assasin("Kazem", 1200, 120, KazemKnife, KazemArmor);
                    System.out.println("You have chosen the Assassin: " + hero.getName());
                    break;
                case 2:
                    hero = new Wizard("Belgheis", 1500, 300, BelgheisWand, BelgheisArmor);
                    System.out.println("You have chosen the Witch: " + hero.getName());
                    break;
                case 3:
                    hero = new Knight("Borzoo", 2000, 80, BorzooSword, BorzooArmor);
                    System.out.println("You have chosen the Knight: " + hero.getName());
                    break;
                default:
                    while(character > 3 || character < 1)
                    {
                        System.out.println("Invalid choice, please select a valid hero. enter a valid number ");
                        character = input.nextInt();
                    }
                    break;
            }

        while (!GameOver)
        {
            System.out.println("\n Select your next location : \n * i suggest you first desert, " +
                    "secend forest and third hell*");
            for (int i = 0; i < locations.size(); i++)
            {
                System.out.println((i + 1) + ". " + locations.get(i).getName());
            }

            int locationChoice = input.nextInt();

            if (locationChoice < 1 || locationChoice > locations.size())
            {
                System.out.println("Invalid choice. Please choose a valid location.");
                continue;
            }

            Location currentPlace = locations.get(locationChoice - 1);
            ArrayList<Enemy> currentEnemies = currentPlace.getEnemies();
            if (currentPlace.getVisited())
            {
                System.out.println("You have already explored this place. Choose another.");
                continue;
            }

            System.out.println("You have arrived at " + currentPlace.getName() + "!");
            if(currentPlace.getName() == "Desert")
            {
                System.out.println("Here has three skelets\n");
            }
            if(currentPlace.getName() == "Forest")
            {
                System.out.println("Here has three goblins\n");
            }
            if(currentPlace.getName() == "Hell")
            {
                System.out.println("Here has two skelets, two goblins and one gragon\n");
            }

            boolean heroAlive = true;
            boolean flask_used = false;

            for(Enemy enemy : currentEnemies)
            {
                boolean skelet_rised = false;
                boolean ability_used = false;

                if(heroAlive)
                {
                    System.out.println("A dangerous " + enemy.getName() + " has been seen");
                    boolean enemyAlive = true;

                    while (heroAlive && enemyAlive)
                    {
                        System.out.println("Hero Status : " + hero.getHp() + " HP. " +
                                hero.getMp() + " MP.  \nEnemy Status : "+ enemy.getName()
                                + " has " + enemy.getHp() + " HP\n");
                        if(flask_used)
                        {
                            System.out.println("you used your flask");
                        }
                        else
                        {
                            System.out.println("you still didnt use your flask");
                        }
                        System.out.println("What would you like to do?");
                        System.out.println("1. Attack");
                        System.out.println("2. Use Special Ability(needed 30 mana for wizard, 20 for assasin and 10 for knight)");
                        System.out.println("3. use flask(take hafl maxhp) *you can use it only once*");
                        int actionChoice = input.nextInt();

                        if(hero instanceof Assasin)
                        {
                            if(!((Assasin) hero).isvisibility && ability_used)
                            {
                                ((Assasin) hero).isvisibility = true;
                            }
                        }

                        switch (actionChoice)
                        {
                            case 1:
                                System.out.println("You attack the " + enemy.getName() + "!");
                                enemy.defend();
                                hero.attack(enemy);
                                if (enemy.getHp() <= 0)
                                {
                                    if(enemy instanceof Skeleton && !skelet_rised)
                                    {
                                        System.out.println("Skeleton has been rised again!");
                                        enemy.setDefending(false);
                                        enemy.getMaxHP();
                                        skelet_rised = true;
                                    }
                                    else
                                    {

                                        System.out.println("You have defeated the " + enemy.getName() + "!");

                                        enemyAlive = false;
                                    }
                                }
                                else
                                {
                                    System.out.println("The " + enemy.getName() + " is still standing!");
                                    System.out.println("The " + enemy.getName() + " strikes back with " + enemy.getDamagepower() + " damage! ");
                                    hero.defend();
                                    enemy.attack(hero);
                                    if (hero.getHp() <= 0)
                                    {
                                        System.out.println("You have been defeated by the " + enemy.getName() + "!");
                                        System.out.println("---------------GameOver--------------");
                                        heroAlive = false;
                                        GameOver = true;
                                        break;
                                    }
                                }
                                ability_used = true;
                                break;

                            case 2:
                                if (hero instanceof Assasin)
                                {
                                    ((Assasin) hero).becomesInvisible();
                                }
                                if (hero instanceof Wizard)
                                {
                                    ((Wizard) hero).spell_attak(currentEnemies);
                                }
                                if (hero instanceof Knight)
                                {
                                    ((Knight) hero).heavy_attack(currentEnemies);
                                }
                                if (enemy.getHp() <= 0)
                                {
                                    System.out.println("You have defeated the " + enemy.getName() + "!");
                                    enemyAlive = false;
                                }
                                else
                                {
                                    System.out.println("The " + enemy.getName() + " is still standing strong!");
                                }
                                break;

                            case 3:
                                if(flask_used)
                                {
                                   System.out.println("you already used your flask, do something else");
                                }
                                else
                                {
                                    hero.heal(hero.getMaxHP()/2);
                                    flask_used = true;
                                    System.out.println("you are drinking and will get HP");
                                }
                                break;
                            default:
                                System.out.println("Invalid choice. Please select a valid action.");
                                break;
                        }
                    }
                }
            }
            currentPlace.setVisited(true);
            if (locations.stream().allMatch(Location::getVisited))
            {
                System.out.println("You have explored all locations. Game over!");
                GameOver = true;
            }
        }
        // TODO: IMPLEMENT GAMEPLAY
    }
}