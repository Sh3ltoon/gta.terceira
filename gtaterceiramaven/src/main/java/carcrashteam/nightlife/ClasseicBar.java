package carcrashteam.nightlife;

import carcrashteam.Player;
import carcrashteam.utilities.Checker;
import carcrashteam.utilities.Messages;

public class ClasseicBar implements Nightlife {
    @Override
    public void execute(Player player) {

        if (!Checker.nightlifeChecker(player,80)){
            return;
        }

        System.out.println(Messages.CLASSIC_BAR_WELCOME);
        player.setMoney(player.getMoney() - 80);

        double randomizer = Math.random() * 100;

        if (randomizer < 40){
            System.out.println(Messages.CLASSIC_BAR_NO_LUCK);
            player.setExperience(player.getExperience() - 25);
        }else{
            player.setEnergy(100);
            System.out.println(Messages.CLASSIC_BAR_LUCK + player.getEnergy() + ".");

        }

    }
}
