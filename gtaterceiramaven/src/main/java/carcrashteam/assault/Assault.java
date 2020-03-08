package carcrashteam.assault;


import carcrashteam.Player;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.options.AssaultAbstract;

public interface Assault {

    boolean successRate(Player player, AssaultOptions assaultOptions);

    WeaponsInter weaponsRate(AssaultOptions assaultOption);

    void execute(Player player);
}
