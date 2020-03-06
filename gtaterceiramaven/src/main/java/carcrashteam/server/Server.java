package carcrashteam.server;
import carcrashteam.Game;
import carcrashteam.Player;
import org.academiadecodigo.bootcamp.Prompt;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Server {


    // CLOSE THE SOCKETS
    private ServerSocket server;
   // private InputStream inputStream;
    //private PrintStream printStream;

    private Game game;
    private Prompt prompt;

    private Map<Player,Socket > playersMap;
    private ExecutorService executorService;
    //private Socket clientSocket;
    private Player playerLogged;


    public void init(){

        try {

            server = new ServerSocket(9000);
            executorService = Executors.newCachedThreadPool();
            playersMap = new HashMap<>();
            game = new Game();
            game.init();
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
    public void askPlayerName(InputStream inputStream, PrintStream printStream){

        prompt = new Prompt(inputStream,printStream);
        game.setPrompt(prompt);
        playerLogged = game.createPlayer(); // check if the name isn't taken

    }
    public void servePlayer(InputStream inputStream, PrintStream printStream){

        prompt = new Prompt(inputStream,printStream);
        game.setPrompt(prompt);
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


        public void setSocket(Socket playerSocket){
            this.playerSocket = playerSocket;


        }

        public void run() {

            try {
                System.out.println("\n --- Connection accepted ---");
                inputStream = playerSocket.getInputStream();
                printStream = new PrintStream(playerSocket.getOutputStream());

            }catch (Exception e){
                System.out.println("dass");
            }

            askPlayerName(inputStream,printStream);
            playersMap.put(playerLogged,playerSocket);
            servePlayer(inputStream,printStream );

        }
    }
}