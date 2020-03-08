package carcrashteam.utilities;

import carcrashteam.Player;

import java.io.PrintStream;

public class PlayerUtils {

    public static PrintStream getPlayerPrintStream(Player player){

        try {
            return new PrintStream(player.getSocket().getOutputStream(), true);
        }catch (Exception e){
            System.out.println("Could not get player stream: " +e);
        }
        return null;

    }

    public static void sendMessage(Player player, String message){

        try{
            PlayerUtils.getPlayerPrintStream(player).println(message);

        }catch (Exception e){
            System.out.println("Error: " +e);
        }

    }
}
