package carcrashteam.Continente;

import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Continente {


    String[] weapons = {"Rubber duck: " + 500, "Knife: " + 1300, "Light Saber: " + 4500, "Shotgun: " + 5000};

    MenuInputScanner menuGunShop = new MenuInputScanner(weapons);

    Prompt prompt = new Prompt(System.in, System.out);

    public void startContinente(Player player) {

        int answer = prompt.getUserInput(menuGunShop);
        WeaponsInter weaponToAdd = null;


        switch (answer) {

            case 1:
                weaponToAdd = WeaponsFactory.createWeapon(Weapons.RUBBER_DUCK);
                break;
            case 2:
                weaponToAdd =  WeaponsFactory.createWeapon(Weapons.KNIFE);
                break;
            case 3:
                weaponToAdd = WeaponsFactory.createWeapon(Weapons.LIGHT_SABER);
                break;
            case 4:
                weaponToAdd = WeaponsFactory.createWeapon(Weapons.SHOTGUN);
                break;
        }


    }

}
