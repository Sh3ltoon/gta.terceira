package carcrashteam.menus;

import carcrashteam.assault.AssaultOptions;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class AssaultMenu {


    public String[] getAssaultOptions(){
        String[] string = new String[AssaultOptions.values().length];
        int counter = 0;
        for (AssaultOptions s: AssaultOptions.values()) {
            string[counter] = s.getDescription();
            counter++;
        }
        return string;
    }

    public MenuInputScanner assaultMenu(){
        MenuInputScanner assaultMenu = new MenuInputScanner(getAssaultOptions());
        assaultMenu.setMessage("Choose your robbery:");

        return assaultMenu;

    }
}
