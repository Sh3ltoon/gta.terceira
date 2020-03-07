package carcrashteam.assault.options;


import carcrashteam.assault.AssaultOptions;
import carcrashteam.utilities.Messages;
import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.Assault;

public class SergioAvila extends AssaultAbstract {

    public void successRate(Player player) {
        super.successRate(player, AssaultOptions.SERGIO_AVILA);
    }

    @Override
    public WeaponsInter weaponsRate() {
        double chanceGetWeapon = Math.random() * 100;


        if(chanceGetWeapon > 0 && 6 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.LIGHT_SABER);
        }

        if(chanceGetWeapon > 6 && 15 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.SHOTGUN);
        }

        if(chanceGetWeapon > 15 && 23 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.KNIFE);
        }

        if(chanceGetWeapon > 23 && chanceGetWeapon < 30){
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
