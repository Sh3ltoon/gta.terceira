package carcrashteam;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client implements Runnable {

    private PrintWriter serverWriter;
    private BufferedReader serverReader;
    private InputStream inputStream;
    private Socket clientSocket;


    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.in, System.out);
        Client client = new Client();
        StringInputScanner ip = new StringInputScanner();
        ip.setMessage("IP: ");
        String ips = prompt.getUserInput(ip);
        IntegerInputScanner port = new IntegerInputScanner();
        port.setMessage("Port: ");
        int ports = prompt.getUserInput(port);
        client.init(ips, ports);
    }

    public void send() {

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (clientSocket.isBound()) {

                String chat = reader.readLine();
                if (chat == null) {
                    writer.close();
                    reader.close();
                    clientSocket.close();
                    System.exit(1);
                    return;
                } else {
                    writer.write(chat);
                    writer.newLine();
                    writer.flush();
                }
            }


        } catch (IOException ex) {
            ex.getMessage();
        }

    }


    public void init(String ips, Integer ports) {

        try {

            clientSocket = new Socket(ips, ports);
            serverWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            inputStream = clientSocket.getInputStream();


            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.submit(this);
            send();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }


    public void getMenu() {


        try {
            serverReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = serverReader.readLine();
                if (line != null) {
                    System.out.println(line);
                } else {
                    clientSocket.close();
                    System.out.println(clientSocket.isBound());
                    System.exit(1);
                }
            }


        } catch (Exception e) {
            System.out.println("error: " + e);
        }


    }


    @Override
    public void run() {
        if (clientSocket.isBound()) {
            getMenu();
        }
    }
}
