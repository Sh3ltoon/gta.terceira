package carcrashteam.nightlife;

import carcrashteam.Player;

public class Delman implements Nightlife{
    @Override
    public void execute(Player player) {
        System.out.println("Welcome to Delman's ");

        double randomizer = Math.random() * 100;

        if(randomizer < 25){

            System.out.println("You got wasted and the Special Chicken toast was rotten! You were sent to the hospital!");
            player.setExperience(player.getExperience() - 15);
            player.looseWeapons();
            System.out.println("You lost 15 exp, you have " + player.getExperience() + ".");

        }else{

            player.setEnergy(player.getEnergy() + 25);
            System.out.println("I gained 25 Energy Points, i have " + player.getEnergy() + ".");

        }

    }
}
