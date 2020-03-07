package carcrashteam.server;

import org.academiadecodigo.bootcamp.Prompt;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client implements Runnable {

    private PrintWriter serverWriter;
    private BufferedReader serverReader;
    private InputStream inputStream;
    private Socket clientSocket;
    private Prompt prompt;

    public static void main(String[] args) {

        Client client = new Client();
        client.init();
    }

    public void send() {

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (clientSocket.isBound()) {
                String chat = reader.readLine();
                if (chat != null) {
                    writer.write(chat);
                    writer.newLine();
                    writer.flush();
                } else {
                    writer.close();
                    reader.close();
                    clientSocket.close();
                }
                if (chat.equals("/quit")) {
                    writer.close();
                    reader.close();
                    clientSocket.close();
                    return;
                }
            }
            writer.close();
            reader.close();
            clientSocket.close();
            System.out.println(clientSocket.isClosed());

        } catch (IOException ex) {
            ex.getMessage();
        }

    }


    public void init() {

        try {

            clientSocket = new Socket("localhost", 8000);
            serverWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            inputStream = clientSocket.getInputStream();
            serverReader = new BufferedReader(new InputStreamReader(inputStream));
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.submit(this);
            send();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }


    public void getMenu() {

        String buffer = "gg";

        try {

            while (clientSocket.isBound()) {

                buffer = serverReader.readLine();
                System.out.println(buffer);

            }
            serverReader.close();
            System.out.println(clientSocket.isClosed());
            clientSocket.close();

        } catch (Exception e) {
            System.out.println("error:" + e);
        }


    }


    @Override
    public void run() {
        getMenu();

    }
}
