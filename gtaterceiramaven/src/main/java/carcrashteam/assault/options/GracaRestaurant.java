package carcrashteam.assault.options;


import carcrashteam.assault.AssaultOptions;
import carcrashteam.utilities.Messages;
import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.Assault;

public class GracaRestaurant extends AssaultAbstract {

    public void successRate(Player player){
        super.successRate(player, AssaultOptions.GRACA_RESTAURANT);
    }

    @Override
    public WeaponsInter weaponsRate() {
        double chanceGetWeapon = Math.ceil(Math.random()*100);

        if(chanceGetWeapon > 0 && 2 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.LIGHT_SABER);
        }

        if(chanceGetWeapon > 2 && 4 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.SHOTGUN);
        }

        if(chanceGetWeapon > 4 && 10 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.KNIFE);
        }

        if(chanceGetWeapon > 10 && chanceGetWeapon < 20){
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
