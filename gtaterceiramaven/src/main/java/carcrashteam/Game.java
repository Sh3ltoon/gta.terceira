package carcrashteam;


import carcrashteam.Continente.Continente;
import carcrashteam.Weapons.WeaponsInter;
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
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Game {

    private HashMap<String, Player> playerHashMap;
    private Prompt prompt;
    private Map<Player, Socket> map;


    public Game(Map map) {

        this.map = map;

    }

    public HashMap<String, Player> getPlayerHashMap() {
        return playerHashMap;
    }

    public Map<Player, Socket> getMap() {
        return map;
    }

    public void init() {
        playerHashMap = new HashMap<>();
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public Player createPlayer() {


        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("" +
                "" +
                "\n" +
                "\n" +
                "Insert Your Nickname: \n");

        String name = prompt.getUserInput(scanner);
        Player playerToCreate = new Player(name);

        playerHashMap.put(name, playerToCreate);

        return playerToCreate;

    }

    public void mainMenu(String name) {

        String[] mainOptions = {"Robbery", "NightLife", "Hospital", "Continente", "Status", "Attack","Quit"};

        MenuInputScanner scanner = new MenuInputScanner(mainOptions);
        scanner.setMessage("Welcome " + name + " to Grand Theft Auto Techeira. \n Game Menu:");

        int userChoice = prompt.getUserInput(scanner);
        mainMenuChecker(userChoice, name);
        mainMenu(name);
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
                menu(name);
                break;
            case 7:
                System.exit(0);
        }
    }


    public void displayAssault(MenuInputScanner assaultMenu, String name) {

        int option = playerHashMap.get(name).getPrompt().getUserInput(assaultMenu);
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
        int option = playerHashMap.get(name).getPrompt().getUserInput(nightLifeMenu);
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


    public void attack(Player attacker, Player target) {


        while (attacker.getHealth() < 0 || target.getHealth() < 0) {


            int random = (int) (Math.random() * attacker.getWeapons().size());

            if (target.getHealth() > 0) {

                WeaponsInter[] weapons = new WeaponsInter[attacker.getWeapons().size()];
                attacker.getWeapons().toArray(weapons);

                target.setHealth(target.getHealth() - weapons[random].getDamage());
                System.out.println(attacker.getName() + " attacked you with " + weapons[random].getName());


            }


        }

    }

    public void menu(String name) {

        Set<String> names = new HashSet<>();


       /* for(int i = 0; i<names.length;i++){

            names[i] = map.values().toArray(Player[] :: new)[i].getName();
        }*/


        for (Player p : map.keySet()) {
            if (name.equals(p.getName())) {
                continue;
            }
            names.add(p.getName());

        }
        String[] nam = names.toArray(String[]::new);
        StringSetInputScanner scanner = new StringSetInputScanner(names);
        scanner.setMessage(names.toString());


        String answer = prompt.getUserInput(scanner);


        Player target = null;
        for (Player p: map.keySet()) {
            if(p.getName().equals(answer)){
                target = p;
            }


        }


        try {

            System.out.println("teste map");



            PrintStream p1Output = new PrintStream(map.get(target).getOutputStream(), true);

            System.out.println("TESTE 1");
            target.setHealth(-10);
            System.out.println("estou dentro do if");
            p1Output.println("you have been atacked by " + name + " you have " + target.getHealth() + " reamining points!");
            mainMenu(name);

        } catch (Exception e) {
            System.out.println("dass:" +e);
        }
    }
}
