package carcrashteam.utilities;

import carcrashteam.Player;
import carcrashteam.server.Server;

import java.io.PrintStream;

public class Checker {



    public static boolean assaultChecker(Player attacker,Player player){
        if(attacker.getHealth()==0 || attacker.getEnergy()==0 || player.getHealth()==0 || player.isJailed()){
            return false;
        }
        return true;
    }


}
