package carcrashteam.server;

import org.academiadecodigo.bootcamp.Prompt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private PrintWriter serverWriter;
    private BufferedReader serverReader;
    private InputStream inputStream;
    private Socket clientSocket;
    private Prompt prompt;

    public static void main(String[] args) {

        Client client = new Client();
        client.init();
    }

    public void init(){

        try {

            clientSocket = new Socket("localhost", 8000);
            serverWriter = new PrintWriter(clientSocket.getOutputStream(),true);
            inputStream = clientSocket.getInputStream();
            serverReader = new BufferedReader(new InputStreamReader(inputStream));
            getMenu();

        }catch (Exception e){
            System.out.println("Error: " +e);
        }

    }


    public void getMenu(){

        byte[] byteReader;

       try {

           serverWriter.write(1);

           byteReader = inputStream.readAllBytes();

           String s = new String(byteReader);

           System.out.println(s +"caralho que te foda");


       }catch (Exception e){
            System.out.println("error:" +e);
        }


    }


}
