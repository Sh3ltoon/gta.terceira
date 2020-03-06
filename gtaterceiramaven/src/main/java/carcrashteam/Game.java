package carcrashteam;


import carcrashteam.assault.Assault;
import carcrashteam.assault.AssaultFactory;
import carcrashteam.assault.AssaultOptions;
import carcrashteam.nightlife.NightLifeOptions;
import carcrashteam.nightlife.Nightlife;
import carcrashteam.nightlife.NightlifeFactory;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.HashMap;

public class Game {

    private HashMap<String, Player> playerHashMap;
    private Prompt prompt = new Prompt(System.in, System.out);

    public void init() {
        playerHashMap = new HashMap<>();
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public void createPlayer() {


        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("Insert Your Nickname; \n");

        String name = prompt.getUserInput(scanner);

        playerHashMap.put(name, new Player(name));

    }

    public void mainMenu(String name) {

        String[] mainOptions = {"Robbery", "NightLife", "Hospital", "Continente", "Status"};

        MenuInputScanner scanner = new MenuInputScanner(mainOptions);
        scanner.setMessage("Welcome " + playerHashMap.get(name) + " to Grand Theft Auto Techeira \n");
        prompt.getUserInput(scanner);

    }

    public void AssaultMenu() {

        String[] options = {"Old Lady", "Shoplift Graça", "Hijack <AC>", "Steal Sergio Ávila wallet"};


        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Wich Robbery you want to make:\n ");

        prompt.getUserInput(scanner);
    }

    public void continenteMenu() {


    }


    public void assault(AssaultOptions assaultOptions, Player player) {

        Assault assault = AssaultFactory.createAssault(assaultOptions);
        assault.execute(player);

    }

    public void nightLifeExecute(NightLifeOptions option, Player player) {

        Nightlife nightlifeEvent = NightlifeFactory.createNightlife(option);
        nightlifeEvent.execute(player);

    }


}
