package carcrashteam.assault.options;

import carcrashteam.assault.AssaultOptions;
import carcrashteam.utilities.Messages;
import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.Assault;

public class AC extends AssaultAbstract {

    public boolean successRate(Player player) {
       return super.successRate(player, AssaultOptions.AC);
    }

    public WeaponsInter weaponsRate() {
        return super.weaponsRate(AssaultOptions.AC);
    }

    @Override
    public void execute(Player player) {
        if(successRate(player)) {
            player.addWeapons(weaponsRate());
        }
    }
}
