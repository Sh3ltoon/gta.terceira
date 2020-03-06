package org.academiadecodigo.apiores.carcrashteam.Continente;

import org.academiadecodigo.apiores.carcrashteam.Player;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Continente {


    String[] weapons = {"Rubber duck: " + 500, "Knife: " + 1300, "Light Saber: " + 4500, "Shotgun: " + 5000};

    MenuInputScanner menuGunShop = new MenuInputScanner(weapons);

    Prompt prompt = new Prompt(System.in, System.out);

    public void startContinente(Player player) {

        int answer = prompt.getUserInput(menuGunShop);

        switch (answer) {

            case 1:
                player.getWeapons.put(WeaponsFactory.create(RUBBER_DUCK));
            case 2:
                player.getWeapons.put(WeaponsFactory.create(KNIFE));
            case 3:
                player.getWeapons.put(WeaponsFactory.create(LIGHT_SABER));
            case 4:
                player.getWeapons.put(WeaponsFactory.create(SHOTGUN));
        }


    }

}
