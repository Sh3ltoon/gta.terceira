package carcrashteam;


import carcrashteam.Continente.Continente;
import carcrashteam.assault.Assault;
import carcrashteam.assault.AssaultFactory;
import carcrashteam.assault.AssaultOptions;
import carcrashteam.menus.AssaultMenu;
import carcrashteam.menus.NightLifeMenu;
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

    public Player createPlayer() {


        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("Insert Your Nickname; \n");

        String name = prompt.getUserInput(scanner);
        Player playerToCreate = new Player(name);

        playerHashMap.put(name, playerToCreate);

        return playerToCreate;

    }

    public void mainMenu(String name) {

        String[] mainOptions = {"Robbery", "NightLife", "Hospital", "Continente", "Status", "Combat", "Quit"};

        MenuInputScanner scanner = new MenuInputScanner(mainOptions);
        scanner.setMessage("Welcome " + name + " to Grand Theft Auto Tech4eira \n");
        int userChoice = prompt.getUserInput(scanner);
        mainMenuChecker(userChoice, name);
    }

    public void mainMenuChecker(Integer userChoice, String name) {
        switch (userChoice) {
            case 1:
                displayAssault(new AssaultMenu().assaultMenu(), name);
                break;
            case 2:
                displayNightLife(new NightLifeMenu().nightLifeMenu(), name);
                break;
            case 3:
                hospital(name);
                break;
            case 4:
                Continente continente = new Continente();
                continente.startContinente(displayContinente(continente.continenteMenu(), name), playerHashMap.get(name));
                break;
            case 5:
                displayStatus(name);
                break;
            case 6:
            case 7:
                System.exit(0);
        }
    }


    public void displayAssault(MenuInputScanner assaultMenu, String name) {

        int option = prompt.getUserInput(assaultMenu);
        AssaultOptions assaultOption = null;

        for (AssaultOptions assault : AssaultOptions.values()) {

            if (option == assault.getOption()) {
                assaultOption = assault;
                break;
            }
        }
        assault(assaultOption, playerHashMap.get(name));

    }

    public void displayNightLife(MenuInputScanner nightLifeMenu, String name) {
        int option = prompt.getUserInput(nightLifeMenu);
        NightLifeOptions nightLifeOption = null;

        for (NightLifeOptions nightEvent : NightLifeOptions.values()) {

            if (option == nightEvent.getOption()) {
                nightLifeOption = nightEvent;
                break;
            }
        }
        nightLifeExecute(nightLifeOption, playerHashMap.get(name));
    }

    public void hospital(String name) {
        System.out.println("Welcome to Praia da Vitoria Health Center! Here we will take good care of your wounds!");
        Player player = playerHashMap.get(name);
        player.setHealth(200);
        player.setMoney(player.getMoney() - 200);
        System.out.println("Your're healed, charged you 200$! Good luck avoid COVID-19!");
    }

    public void displayStatus(String name) {
        Player player = playerHashMap.get(name);
        System.out.println(name + "you have :\n" +
                player.getExperience() + " of experience.\n" +
                player.getEnergy() + " of energy.\n" +
                player.getMoney() + " of money.\n" +
                player.getHealth() + "of health.");
    }

    public int displayContinente(MenuInputScanner continenteMenu, String name) {
        return prompt.getUserInput(continenteMenu);
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
