package carcrashteam.nightlife;

import carcrashteam.Player;
import carcrashteam.utilities.Checker;
import carcrashteam.utilities.Messages;

public class Delman extends NightLifeAbstract {
    @Override
    public void execute(Player player) {
        super.execute(player, NightLifeOptions.Delman);
    }
}

