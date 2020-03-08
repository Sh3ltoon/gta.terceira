package carcrashteam.assault.options;


import carcrashteam.assault.AssaultOptions;
import carcrashteam.utilities.Messages;
import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.Assault;
import org.academiadecodigo.bootcamp.Prompt;

import java.io.PrintStream;

public class OldLady extends AssaultAbstract {

    public void successRate(Player player) {
        super.successRate(player, AssaultOptions.OLD_LADY);
    }

    public WeaponsInter weaponsRate() {
        return super.weaponsRate(AssaultOptions.OLD_LADY);
    }

    @Override
    public void execute(Player player) {
        successRate(player);
        player.addWeapons(weaponsRate());
    }
}
