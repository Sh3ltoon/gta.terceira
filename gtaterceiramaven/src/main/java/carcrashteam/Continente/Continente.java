package carcrashteam.Continente;

import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.utilities.Checker;
import carcrashteam.utilities.Messages;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Continente {

    public String[] getContinenteOptions(){
        String[] continenteOptions = new String[Weapons.values().length];
        int counter = 0;

        for (Weapons weapon: Weapons.values()) {
            continenteOptions[counter] = weapon.getDescription() + ", cost: " + weapon.getCost();
            counter++;
        }

        return continenteOptions;
    }

    public MenuInputScanner continenteMenu(){
        MenuInputScanner continenteMenu = new MenuInputScanner(getContinenteOptions());
        continenteMenu.setMessage(Messages.CONTINENTE_RULE);

        return continenteMenu;
    }

    public void startContinente(int userChoice, Player player) {

        switch (userChoice) {
            case 1:
                if(!Checker.continenteChecker(player,500)){
                    break;
                }
                player.addWeapons( WeaponsFactory.createWeapon(Weapons.RUBBER_DUCK));
                player.setMoney(player.getMoney()-500);
                break;
            case 2:
                if(!Checker.continenteChecker(player,1300)){
                    break;
                }
                player.addWeapons(WeaponsFactory.createWeapon(Weapons.KNIFE));
                player.setMoney(player.getMoney()-1300);
                break;
            case 3:
                if(!Checker.continenteChecker(player,5000)){
                    break;
                }
                player.addWeapons(WeaponsFactory.createWeapon(Weapons.LIGHT_SABER));
                player.setMoney(player.getMoney() - 5000);
                break;
            case 4:
                if(!Checker.continenteChecker(player,2500)){
                    break;
                }
                player.addWeapons( WeaponsFactory.createWeapon(Weapons.SHOTGUN));
                player.setMoney(player.getMoney() - 4500);
                break;
        }
    }


}
