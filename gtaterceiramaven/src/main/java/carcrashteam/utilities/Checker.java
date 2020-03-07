package carcrashteam.utilities;

import carcrashteam.Player;
import carcrashteam.server.Server;

import java.io.PrintStream;

public class Checker {

    public static boolean assaultChecker(Player player, int energyLoss){
        if(player.getEnergy() < energyLoss){
            return false;
        }
        return true;
    }
    public static boolean attackChecker(Player attacker, Player player){
        if(attacker.getHealth()==0 || attacker.getEnergy()==0 || player.getHealth()==0 || player.isJailed()){
            return false;
        }
        return true;
    }
    public static boolean nightlifeChecker(Player player, int cost){
        if(player.getMoney() < cost){
            return false;
        }
        return true;
    }
    public static boolean continenteChecker(Player player, int cost){
        if(player.getMoney() < cost){
            return false;
        }
        return true;
    }


}
