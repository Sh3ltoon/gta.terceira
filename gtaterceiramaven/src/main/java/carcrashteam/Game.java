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
import carcrashteam.utilities.Messages;
import carcrashteam.utilities.Checker;
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
        scanner.setMessage(Messages.MAIN_MENU_RULE);

        String name = prompt.getUserInput(scanner);
        Player playerToCreate = new Player(name);

        playerHashMap.put(name, playerToCreate);

        return playerToCreate;

    }

    public void mainMenu(String name) {

        String[] mainOptions = {"Robbery", "NightLife", "Hospital", "Continente", "Status", "Attack"};

        MenuInputScanner scanner = new MenuInputScanner(mainOptions);
        scanner.setMessage("Welcome " + name + " to Grand Theft Auto Techeira. \n Game Menu:");

        int userChoice = prompt.getUserInput(scanner);
        try {
            mainMenuChecker(userChoice, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mainMenuChecker(Integer userChoice, String name) throws IOException {
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
                attack(name);
                break;
        }
    }


    public void displayAssault(MenuInputScanner assaultMenu, String name) {

        int option =  prompt.getUserInput(assaultMenu);

        AssaultOptions assaultOption = null;

        for (AssaultOptions assault : AssaultOptions.values()) {

            if (option == assault.getOption()) {
                assaultOption = assault;
                break;
            }
        }

        assault(assaultOption, playerHashMap.get(name));

        mainMenu(name);

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
        System.out.println(Messages.ENTERING_HOSPITAL);
        Player player = playerHashMap.get(name);
        player.setHealth(200);
        player.setMoney(player.getMoney() - 200);
        System.out.println(Messages.LEAVING_HOSPITAL);
    }

    public void displayStatus(String name) throws IOException {
        Player player = getPlayer(name);
        PrintStream status = new PrintStream(map.get(player).getOutputStream());
        status.println("Name: " + player.getName() + "\n" +
                "Experience: " + player.getExperience() +
                "\nMoney: " + player.getMoney() +
                "\nHealth: " + player.getHealth() +
                "\nEnergy: " + player.getEnergy() +
                "\n Weapons: " + player.getMoney());
        mainMenu(name);
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


    public void attack(String name) {

        Player target = getTarget(name);
        Player attacker = getPlayer(name);
        weaponsToBattle(target);
        weaponsToBattle(attacker);
        Player winner;
        Player looser;

        if( Checker.attackChecker(attacker,target)) {
            if (target.getExperience() > attacker.getExperience()) {
                winner = target;
                looser = attacker;

            } else {
                winner = attacker;
                looser = target;

            }
            looser.setHealth(0);
            looser.looseWeapons();
            winner.setExperience(winner.getExperience() + looser.getExperience() / 10);
            looser.setExperience(looser.getExperience() - looser.getExperience() / 10);
            int robMoney = looser.getMoney() / 3;
            looser.setMoney(looser.getMoney() - robMoney);
            winner.setMoney(winner.getMoney() + robMoney);

            String looserMessage = "You were fucked up by " + winner.getName() + " , Took from you " + robMoney + "$.";
            String winnerMessage = "You won the fight with " + looser.getName() + " , you take from him " + robMoney + "$.";

            playerNotifier(winner, looser, looserMessage, winnerMessage);


            mainMenu(name);
        }else{
            String message = "You can't attack " + target.getName();
            notifier(attacker, message);
            mainMenu(name);

        }




    }


    public Player getTarget(String name) {

        Set<String> names = new HashSet<>();

        for (Player p : map.keySet()) {
            if (name.equals(p.getName())) {
                continue;
            }
            names.add(p.getName());

        }

        StringSetInputScanner scanner = new StringSetInputScanner(names);
        scanner.setMessage(names.toString());

        String answer = prompt.getUserInput(scanner);

        return getPlayer(answer);
    }


    public Player getPlayer(String name) {

        Player target = null;
        for (Player p : map.keySet()) {
            if (p.getName().equals(name)) {
                target = p;
            }
        }
        return target;

    }

    public void weaponsToBattle(Player player) {

        Set<WeaponsInter> weapons = player.getWeapons();

        for (WeaponsInter weapon : weapons) {

            player.setExperience(player.getExperience() + weapon.getDamage());

        }


    }


    public void playerNotifier(Player player1, Player player2, String messageP1, String messageP2) {

        PrintStream p1Output = null;
        PrintStream p2Output = null;

        try {
            p1Output = new PrintStream(map.get(player2).getOutputStream(), true);
            p2Output = new PrintStream(map.get(player1).getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        p1Output.println(messageP1);
        p2Output.println(messageP2);



    }

    public void notifier(Player player, String message){
        PrintStream output = null;

        try {

            output = new PrintStream(map.get(player).getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        output.println(message);
    }

}


