package carcrashteam;

import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.utilities.PlayerUtils;
import org.academiadecodigo.bootcamp.Prompt;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Player {

    private String name;
    private double experience;
    private int healthPoints;
    private int energyPoints;
    private int money;
    private Set<WeaponsInter> weapons;
    private Socket socket;
    private boolean jailed;
    private boolean hospitalized;

    public Player(String name) {

        money = 1000;
        experience = 5;
        healthPoints = 100;
        energyPoints = 100;
        weapons = new HashSet<>();
        this.name = name;
        jailed = false;
        hospitalized = false;

    }

    public boolean isJailed() {
        return jailed;
    }

    public boolean isHospitalized() {
        return hospitalized;
    }

    public void setJailed(boolean jailed) {
        this.jailed = jailed;
    }

    public void setHospitalized(boolean hospitalized) {
        this.hospitalized = hospitalized;
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

    public double getExperience() {
        return experience;
    }

    public int getHealth() {
        return healthPoints;
    }

    public void setEnergy(int energyPoints) {
        if(energyPoints <= 0){
            this.energyPoints = 0;
            return;
        }
        this.energyPoints = energyPoints;
    }

    public void setExperience(double experience) {

        if(experience <= 0){
            this.experience = 0;
            return;
        }
        this.experience = experience;

    }

    public void setHealth(int healthPoints) {
        if(healthPoints <= 0){
            this.healthPoints = 0;
            return;
        }
        this.healthPoints = healthPoints;
    }

    public void addWeapons(WeaponsInter weapon){

        if(weapon != null) {
            weapons.add(weapon);
            PlayerUtils.sendMessage(this,"You just got a "+weapon.getName());
        }

    }

    public void loseWeapons(){
        weapons.removeAll(weapons);
    }

    public Set<WeaponsInter> getWeapons() {
        return weapons;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public String toString() {
        return getName();
    }
}



