package carcrashteam.assault.options;


import carcrashteam.utilities.Messages;
import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.Assault;

public class OldLady implements Assault {
    @Override
    public void successRate(Player player) {
        double successProbability = Math.random() * player.getExperience();

        if (successProbability >= 5) {
            System.out.println(Messages.SUCCESS_ASSAULT + " OldLady.");
            player.setExperience(player.getExperience() + 3);
            player.setEnergy(player.getEnergy() - 3);
            return;
        }

        try {
            System.out.println("You were sent to prison. Now you have to wait to be released.");
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
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
