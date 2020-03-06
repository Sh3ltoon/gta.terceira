package org.academiadecodigo.apiores.carcrashteam;

import java.util.Set;

public class Player {


    private String name;
    private int experience;
    private int healthPoints;
    private int energyPoints;
    //set weapons


    public Player(String name){
        experience = 5;
        healthPoints = 200;
        energyPoints = 200;
        this.name = name;

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




}
