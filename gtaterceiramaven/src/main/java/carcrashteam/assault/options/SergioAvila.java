package carcrashteam.assault.options;


import carcrashteam.utilities.Messages;
import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.Assault;

public class SergioAvila implements Assault {

    @Override
    public void successRate(Player player) {
        double successProbability = Math.random() * player.getExperience();

        if(successProbability >= 40){
            System.out.println(Messages.SUCCESS_ASSAULT + " Sérgio Avila.");
            player.setExperience(player.getExperience() + 20);
            player.setEnergy(player.getEnergy() - 25);
            return;
        }

        try{
            System.out.println(Messages.SENT_PRISON);
            Thread.sleep(3000);
        }catch (InterruptedException ex){
            ex.getMessage();
        }

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
