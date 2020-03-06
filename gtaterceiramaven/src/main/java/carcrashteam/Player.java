package carcrashteam;

import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsInter;


import java.util.Set;

public class Player {


    private String name;
    private int experience;
    private int healthPoints;
    private int energyPoints;
    private int money;
    private Set<WeaponsInter> weapons;
    //set weapons



    public Player(String name) {
        money = 100;
        experience = 5;
        healthPoints = 200;
        energyPoints = 200;
        this.name = name;

    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energyPoints;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return healthPoints;
    }

    public void setEnergy(int energyPoints) {
        this.energyPoints = energyPoints;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealth(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void addWeapons(WeaponsInter weapon){
        weapons.add(weapon);
    }

    public void looseWeapons(){
        weapons.removeAll(weapons);
    }
}



