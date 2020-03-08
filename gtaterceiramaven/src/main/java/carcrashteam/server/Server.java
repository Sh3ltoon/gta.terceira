package carcrashteam.server;

import carcrashteam.Game;
import carcrashteam.Player;
import carcrashteam.utilities.Messages;
import org.academiadecodigo.bootcamp.Prompt;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static Map<Player, Socket> playersMap;
    private Socket clientSocket;
    private ServerSocket server;
    private ExecutorService executorService;
    private Player playerLogged;

    public void init() {

        try {

            server = new ServerSocket(8000);
            executorService = Executors.newCachedThreadPool();
            playersMap = new HashMap<>();
            startServer();

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }

    }

    public void startServer() {

        try {

            while (server.isBound()) {

                System.out.println("<<< Waiting for connection >>>");
                clientSocket = server.accept();
                PlayerThread playerThread = new PlayerThread();
                playerThread.setSocket(clientSocket);
                executorService.submit(playerThread);

            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void askPlayerName(Game game, PrintStream printStream) {

        playerLogged = game.createPlayer();

        if (playerLogged == null) {
            printStream.println(Messages.EXISTING_NAME);
            askPlayerName(game, printStream);
        }

        game.getPlayerHashMap().put(playerLogged.getName(), playerLogged);

    }

    public void servePlayer(Game game) {

        game.mainMenu(playerLogged.getName());
    }

    public void close() {

        try {
            server.close();
            clientSocket.close();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public class PlayerThread implements Runnable {

        Socket playerSocket;
        InputStream inputStream;
        PrintStream printStream;
        Game game;


        public void setSocket(Socket playerSocket) {
            this.playerSocket = playerSocket;
        }

        public void run() {

            try {

                if (playerSocket.isBound()) {

                    System.out.println("\n --- Connection accepted ---");
                    inputStream = playerSocket.getInputStream();
                    printStream = new PrintStream(playerSocket.getOutputStream());

                    game = new Game(playersMap);
                    game.init();
                    game.setPrompt(new Prompt(inputStream, printStream));
                    askPlayerName(game, printStream);
                    playerLogged.setSocket(playerSocket);

                    game.getMap().put(playerLogged, playerSocket);
                    servePlayer(game);
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
}