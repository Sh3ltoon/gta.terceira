package carcrashteam.assault.options;


import carcrashteam.assault.AssaultOptions;
import carcrashteam.Player;
import carcrashteam.Weapons.WeaponsInter;

public class SergioAvila extends AssaultAbstract {

    public void successRate(Player player) {
        super.successRate(player, AssaultOptions.SERGIO_AVILA);
    }

    public WeaponsInter weaponsRate() {

        return super.weaponsRate(AssaultOptions.SERGIO_AVILA);

    }

    @Override
    public void execute(Player player) {
        successRate(player);
        player.addWeapons(weaponsRate());
    }
}
