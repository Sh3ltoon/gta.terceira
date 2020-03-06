package carcrashteam.nightlife;

import carcrashteam.Player;

public class ClasseicBar implements Nightlife {
    @Override
    public void execute(Player player) {

        System.out.println("Welcome to Classic Bar! Get laid or die trying!");

        double randomizer = Math.random() * 100;

        if (randomizer < 40){
            System.out.println("That hooker was dirty as fuck! You got AIDS and you were sent to the Hospital!");
            player.setExperience(player.getExperience() - 25);
        }else{
            player.setEnergy(100);
            System.out.println("So good to get laid! My energy is " + player.getEnergy() + ".");

        }

    }
}
