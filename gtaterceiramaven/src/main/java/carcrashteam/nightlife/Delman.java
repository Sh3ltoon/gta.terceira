package carcrashteam.nightlife;

import carcrashteam.Player;
import carcrashteam.utilities.Checker;
import carcrashteam.utilities.Messages;

public class Delman implements Nightlife {
    @Override
    public void execute(Player player) {

        if (!Checker.nightlifeChecker(player, 30)) {
            return;
        }

        System.out.println(Messages.DELMAN_WELCOME);
        player.setMoney(player.getMoney() - 30);

        double randomizer = Math.random() * 100;

        if (randomizer < 25) {

            System.out.println(Messages.DELMAN_NO_LUCK_MESSAGE);
            player.setExperience(player.getExperience() - 15);
            player.looseWeapons();
            System.out.println(Messages.DELMAN_NO_LUCK_STATUS + player.getExperience() + ".");

        } else {

            player.setEnergy(player.getEnergy() + 25);
            System.out.println(Messages.DELMAN_LUCK + player.getEnergy() + ".");

        }
    }
}

