package carcrashteam.nightlife;

import carcrashteam.Player;
import carcrashteam.utilities.Messages;

public class Weed implements Nightlife{
    @Override
    public void execute(Player player) {
        System.out.println(Messages.WEED_WELCOME);
        player.setMoney(player.getMoney() - 60);

        double randomizer = Math.random() * 100;

        if(randomizer < 30){

            System.out.println(Messages.WEED_NO_LUCK);
            player.setExperience(player.getExperience() - 20 );
            player.looseWeapons();

        }else{

            player.setEnergy(player.getEnergy() + 50);
            System.out.println(Messages.WEED_LUCK + player.getEnergy() + ".");
        }
    }
}
