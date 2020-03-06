package org.academiadecodigo.apiores.carcrashteam;

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


    public int getEnergyPoints() {
        return energyPoints;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        this.energyPoints = energyPoints;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }


}
