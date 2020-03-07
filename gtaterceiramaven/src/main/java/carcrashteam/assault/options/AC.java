package carcrashteam.assault.options;

import carcrashteam.utilities.Messages;
import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.Assault;

import java.io.PrintStream;

public class AC implements Assault {

    @Override
    public void successRate(Player player) {
        double successProbability = Math.random() * player.getExperience();

        if(successProbability >= 20){
            System.out.println(Messages.SUCCESS_ASSAULT + " AC.");
            player.setExperience(player.getExperience() + 10);
            player.setEnergy(player.getEnergy() -12);
            return;
        }

        try{
            System.out.println(Messages.SENT_PRISON);
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.getMessage();
        }
    }

    @Override
    public WeaponsInter weaponsRate() {
        double chanceGetWeapon = Math.random() * 100;

        if(chanceGetWeapon > 0 && 3 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.LIGHT_SABER);
        }

        if(chanceGetWeapon > 3 && 6 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.SHOTGUN);
        }

        if(chanceGetWeapon > 6 && 12 < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.KNIFE);
        }

        if(chanceGetWeapon > 12 && chanceGetWeapon < 25){
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
