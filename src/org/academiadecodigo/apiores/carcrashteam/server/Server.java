package org.academiadecodigo.apiores.carcrashteam.server;

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

    public void init(){

        try {
            server = new ServerSocket(8080);
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

        String [] options = {"Assault","Nightlife","Hospital","Continente","Quit"};

        prompt = new Prompt(inputStream,printStream);

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Welcome to GTA Terceira");

        int number = prompt.getUserInput(scanner);

        if(number == 1){
            System.out.println("You choose to assault");
        }else{
            System.out.println("error");
        }

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
