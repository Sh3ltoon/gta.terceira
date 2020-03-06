package org.academiadecodigo.apiores.carcrashteam.assault.options;

import org.academiadecodigo.apiores.carcrashteam.Player;
import org.academiadecodigo.apiores.carcrashteam.assault.Assault;

public class OldLady implements Assault {
    @Override
    public void successRate(Player player) {
        double probability = Math.random() * player.getExperience();

        if (probability >= 5) {
            System.out.println("Success! You manage to assault the ");
            player.setExperience(player.getExperience + 3);
            player.setEnergy(player.getEnergy - 3);
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
    public Weapons weaponsRate() {
        double random = Math.ceil(Math.random()*100);

        if(random > 0 && 1 < random){
            return WeaponsFactory.create(LIGHT_SABER);
        }

        if(random > 1 && 3 < random){
            return WeaponsFactory.create(SHOTGUN);
        }

        if(random > 3 && 6 < random){
            return WeaponsFactory.create(KNIFE);
        }

        if(random > 6 && random < 15){
            return WeaponsFactory.create(RUBBER_DUCK);
        }

        return null;
    }

    @Override
    public void execute(Player player) {
        successRate(player);
        player.addWeapon(weaponsRate());
    }
}
