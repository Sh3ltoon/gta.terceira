package carcrashteam.nightlife;

import carcrashteam.Player;

public class Weed implements Nightlife{
    @Override
    public void execute(Player player) {
        System.out.println("Welcome to Santa Rita guetto! We have the best Weed for you sir!");

        double randomizer = Math.random() * 100;

        if(randomizer < 30){

            System.out.println("You got a bad trip and you were sent to the Hospital!");
            player.setExperience(player.getExperience() - 20 );
            player.looseWeapons();

        }else{

            player.setEnergy(player.getEnergy() + 50);
            System.out.println("Woot woot! Nice blunt! I'm Fliyng! Gained 50 Energy points" + player.getEnergy() + ".");
        }
    }
}
