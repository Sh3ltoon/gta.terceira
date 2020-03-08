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

    public Player(String name) {

        money = 1000;
        experience = 300; // 5
        healthPoints = 100;
        energyPoints = 1000;
        weapons = new HashSet<>();
        this.name = name;

    }

    public boolean isJailed() {
        return jailed;
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
        this.energyPoints = energyPoints;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public void setHealth(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void addWeapons(WeaponsInter weapon){

        if(weapon != null) {
            weapons.add(weapon);
            PlayerUtils.sendMessage(this,"You just got a "+weapon.getName());
        }

    }

    public void looseWeapons(){
        weapons.removeAll(weapons);
    }

    public Set<WeaponsInter> getWeapons() {
        return weapons;
    }

    public String[] getWeaponsName() {
        String[] weaponsName = new String[weapons.size()];
        int counter = 0;
        for (WeaponsInter w: weapons) {
            weaponsName[counter] = w.getName();
            counter++;
        }
        return weaponsName;
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



