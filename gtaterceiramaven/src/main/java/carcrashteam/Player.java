package carcrashteam;

import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsInter;
import org.academiadecodigo.bootcamp.Prompt;


import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Player {


    private String name;
    private int experience;
    private int healthPoints;
    private int energyPoints;
    private int money;
    private Prompt prompt;
    private Set<WeaponsInter> weapons;
    private Socket socket;
    //set weapons







    public Player(String name) {
        money = 100;
        experience = 5;
        healthPoints = 200;
        energyPoints = 200;
        weapons = new HashSet<>();
        this.name = name;

    }

    public Prompt getPrompt() {
        return prompt;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
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

    public Set<WeaponsInter> getWeapons() {
        return weapons;
    }
}



