package carcrashteam.assault;


import carcrashteam.Player;
import carcrashteam.Weapons.WeaponsInter;

public interface Assault {

    void successRate(Player player);

    WeaponsInter weaponsRate();

    void execute(Player player);
}
