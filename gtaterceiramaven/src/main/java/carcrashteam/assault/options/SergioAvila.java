package carcrashteam.assault.options;


import carcrashteam.assault.AssaultOptions;
import carcrashteam.Player;
import carcrashteam.Weapons.WeaponsInter;

public class SergioAvila extends AssaultAbstract {

    public boolean successRate(Player player) {
        return super.successRate(player, AssaultOptions.SERGIO_AVILA);
    }

    public WeaponsInter weaponsRate() {

        return super.weaponsRate(AssaultOptions.SERGIO_AVILA);

    }

    @Override
    public void execute(Player player) {
        if(successRate(player)) {
            player.addWeapons(weaponsRate());
        }
    }
}
