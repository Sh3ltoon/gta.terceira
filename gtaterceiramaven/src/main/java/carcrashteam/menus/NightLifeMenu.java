package carcrashteam.menus;


import carcrashteam.nightlife.NightLifeOptions;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class NightLifeMenu {

    public String[] getNighLifeOptions(){
        String[] string = new String[NightLifeOptions.values().length];
        int counter = 0;
        for (NightLifeOptions s: NightLifeOptions.values()) {
            string[counter] = s.getDescription();
            counter++;
        }
        return string;
    }

    public MenuInputScanner nightLifeMenu(){
        MenuInputScanner nightLifeMenu = new MenuInputScanner(getNighLifeOptions());
        nightLifeMenu.setMessage("Choose your robbery:");

        return nightLifeMenu;
    }
}


