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
import carcrashteam.utilities.Checker;
import carcrashteam.utilities.Messages;
import carcrashteam.utilities.PlayerUtils;
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

        for(Player player : map.keySet()){
            if(player.getName().toUpperCase().equals(name.toUpperCase())){
                return null;
            }
        }

        Player playerToCreate = new Player(name);

        playerHashMap.put(name, playerToCreate);

        return playerToCreate;
    }

    public void mainMenu(String name) {

        String[] mainOptions = {"Robbery", "NightLife", "Hospital", "Continente", "Status", "Attack", "Quit"};

        MenuInputScanner scanner = new MenuInputScanner(mainOptions);
        scanner.setMessage("Welcome " + name + " to Grand Theft Auto Techeira.\nGame Menu:");
        scanner.setError("Invalid Input");

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
                PlayerUtils.sendMessage(playerHashMap.get(name),Messages.ROBBERY_RULE);
                displayAssault(new AssaultMenu().assaultMenu(), name);
                break;
            case 2:
                PlayerUtils.sendMessage(playerHashMap.get(name),Messages.NIGHTLIFE_RULE);
                displayNightLife(new NightLifeMenu().nightLifeMenu(), name);
                break;
            case 3:
                hospital(name);
                break;
            case 4:
                Continente continente = new Continente();
                continente.startContinente(displayContinente(continente.continenteMenu()), playerHashMap.get(name));
                mainMenu(name);
                break;
            case 5:
                displayStatus(name);
                break;
            case 6:
                attack(name);
                break;
            case 7:
                quit(name);
                break;
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

        mainMenu(name);

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
        mainMenu(name);
    }

    public void hospital(String name) {
        Player player = playerHashMap.get(name);
        try {
            PrintStream stream = new PrintStream(map.get(player).getOutputStream());
            stream.println(Messages.ENTERING_HOSPITAL);
            player.setHealth(200);
            player.setMoney(player.getMoney() - 200);
            stream.println(Messages.LEAVING_HOSPITAL);
            mainMenu(name);

        } catch (IOException ed) {
            ed.printStackTrace();
        }

    }

    public void displayStatus(String name) throws IOException {
        Player player = getPlayer(name);
        PrintStream status = new PrintStream(map.get(player).getOutputStream());
        PlayerUtils.sendMessage(player,Messages.STATUS_RULE);
        status.println("Name: " + player.getName() + "\n" +
                "Experience: " + player.getExperience() +
                "\nMoney: " + player.getMoney() +
                "\nHealth: " + player.getHealth() +
                "\nEnergy: " + player.getEnergy() +
                "\nWeapons: " + player.getWeapons());
        mainMenu(name);
    }

    public int displayContinente(MenuInputScanner continenteMenu) {
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
            Player loser;
            if(attacker == null ){
                mainMenu(name);
            }
            if(target == null){
                mainMenu(name);
            }

            notifier(attacker, Messages.Attack);
            if (Checker.attackChecker(attacker, target)) {

                if (target.getExperience() > attacker.getExperience()) {
                    winner = target;
                    loser = attacker;

                } else {
                    winner = attacker;
                    loser = target;

                }
                loser.setHealth(0);
                loser.loseWeapons();
                winner.setExperience(winner.getExperience() + loser.getExperience() / 10);
                loser.setExperience(loser.getExperience() - loser.getExperience() / 10);
                int robMoney = loser.getMoney() / 3;
                loser.setMoney(loser.getMoney() - robMoney);
                winner.setMoney(winner.getMoney() + robMoney);

                String looserMessage = "You were fucked up by " + winner.getName() + " , Took from you " + robMoney + "$.";
                String winnerMessage = "You won the fight with " + loser.getName() + " , you take from him " + robMoney + "$.";

                playerNotifier(winner, loser, looserMessage, winnerMessage);


                mainMenu(name);
            } else {
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
        names.add("Quit");

        StringSetInputScanner scanner = new StringSetInputScanner(names);
        scanner.setMessage(names.toString() + "\n");

        String answer = prompt.getUserInput(scanner);
        if(answer.equals("Quit")){
            mainMenu(name);
        }
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

        if(player == null){
            return;
        }
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
            System.out.println("hello");
        }

        p1Output.println(messageP1);
        p2Output.println(messageP2);


    }

    public void notifier(Player player, String message) {
        PrintStream output = null;


        try {

            output = new PrintStream(map.get(player).getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();

        }

        output.println(message);

    }

    public void quit(String name) {

        try {
            map.get(getPlayer(name)).close();
            map.remove(getPlayer(name), map.get(getPlayer(name)));
        } catch (IOException ef) {
            ef.printStackTrace();
        }


    }

}


