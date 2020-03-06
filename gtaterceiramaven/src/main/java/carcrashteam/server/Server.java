package carcrashteam.server;

import carcrashteam.Game;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket server;
    private InputStream inputStream;
    private PrintStream printStream;
    private Game game;

    public void init(){

        try {

            server = new ServerSocket(9000);
            game = new Game();
            game.init();
            startServer();

        }catch (Exception e){
            System.out.println("ERROR: " +e);
        }

    }

    public void startServer(){

        while (server.isBound()) {

            Socket clientSocket;

            try {

                System.out.println("<<< Waiting for connection >>>");

                clientSocket = server.accept();
                inputStream = clientSocket.getInputStream();
                printStream = new PrintStream(clientSocket.getOutputStream());

                System.out.println("\n --- Connection accepted ---");
                serveClient();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }

    public void serveClient(){

        Prompt prompt;

        prompt = new Prompt(inputStream,printStream);
        game.setPrompt(prompt);

        game.createPlayer();
        game.mainMenu("jaime");

    }

    public void close(){

        try{
            inputStream.close();
            printStream.close();
            server.close();
        }catch(Exception e){
            System.out.println("Error: " +e);
        }

    }
}
