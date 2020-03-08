package carcrashteam.nightlife;

import carcrashteam.Player;
import carcrashteam.utilities.AsciiImages;
import carcrashteam.utilities.Checker;
import carcrashteam.utilities.Messages;
import carcrashteam.utilities.PlayerUtils;

public class Weed extends NightLifeAbstract{
    @Override
    public void execute(Player player) {
        super.execute(player,NightLifeOptions.Weed);
    }
}
