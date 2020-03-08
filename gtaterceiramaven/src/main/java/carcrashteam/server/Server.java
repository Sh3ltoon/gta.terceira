package carcrashteam.server;
import carcrashteam.Game;
import carcrashteam.Player;
import org.academiadecodigo.bootcamp.Prompt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Server {


    private ServerSocket server;
    public static Map<Player,Socket > playersMap;
    private ExecutorService executorService;
    private Player playerLogged;

    public void init(){

        try {

            server = new ServerSocket(8000);
            executorService = Executors.newCachedThreadPool();
            playersMap = new HashMap<>();
            startServer();

        }catch (Exception e){
            System.out.println("ERROR: " +e);
        }

    }
    public void startServer(){

        try {
            while(true) {

                System.out.println("<<< Waiting for connection >>>");
                Socket clientSocket = server.accept();
                PlayerThread playerThread = new PlayerThread();
                playerThread.setSocket(clientSocket);
                executorService.submit(playerThread);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void askPlayerName(Game game){

        if(game.createPlayer() == null){
            askPlayerName(game);
        }

        playerLogged = game.createPlayer();
        game.getPlayerHashMap().put(playerLogged.getName(), playerLogged);

    }
    public void servePlayer(Game game){


        game.mainMenu(playerLogged.getName());

    }
    public void close(){
        try{

            server.close();

        }catch(Exception e){
            System.out.println("Error: " +e);
        }
    }
    public class PlayerThread implements Runnable{

        Socket playerSocket;
        InputStream inputStream;
        PrintStream printStream;
        Game game;


        public void setSocket(Socket playerSocket){
            this.playerSocket = playerSocket;


        }

        public void run() {

            try {
                System.out.println("\n --- Connection accepted ---");
                inputStream = playerSocket.getInputStream();
                printStream = new PrintStream(playerSocket.getOutputStream());
            }catch (Exception e){
                System.out.println(e);
            }
            game = new Game(playersMap);
            game.init();
            game.setPrompt(new Prompt(inputStream, printStream));
            askPlayerName(game);
            playerLogged.setSocket(playerSocket);
            game.getMap().put(playerLogged, playerSocket);

            servePlayer(game);

        }
    }
}