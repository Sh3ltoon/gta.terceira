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

    @Override
    public WeaponsInter weaponsRate() {
        double chanceGetWeapon = Math.ceil(Math.random()*100);

        if(chanceGetWeapon > 0 && 1 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.LIGHT_SABER);
        }

        if(chanceGetWeapon > 1 && 3 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.SHOTGUN);
        }

        if(chanceGetWeapon > 3 && 6 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.KNIFE);
        }

        if(chanceGetWeapon > 6 && chanceGetWeapon < 15){
            return WeaponsFactory.createWeapon(Weapons.RUBBER_DUCK);
        }

        return null;
    }

    @Override
    public void execute(Player player) {
        successRate(player);
        player.addWeapons(weaponsRate());
    }
}
