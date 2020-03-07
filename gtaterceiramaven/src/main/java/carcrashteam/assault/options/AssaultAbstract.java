package carcrashteam.assault.options;

import carcrashteam.Player;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.Assault;
import carcrashteam.assault.AssaultOptions;
import carcrashteam.utilities.Checker;
import carcrashteam.utilities.Messages;

import java.io.PrintStream;

public class AssaultAbstract implements Assault {

    public void successRate(Player player, AssaultOptions assaultOption){

        if(!Checker.assaultChecker(player,assaultOption.getEnergySpent())){
            return;
        }

        player.setEnergy(player.getEnergy() - assaultOption.getEnergySpent());

        double successProbability = Math.random() * player.getExperience();

        if(successProbability >= assaultOption.getSuccessProbability()){

            System.out.println(Messages.SUCCESS_ASSAULT);
            player.setExperience(player.getExperience() + 6);
            return;

        }

        try{

            getPlayerPrintStream(player).println(Messages.SENT_PRISON + assaultOption.getSentenceTime() / 1000 + " seconds!");
            Thread.sleep(assaultOption.getSentenceTime());

        }catch (InterruptedException ex){
            ex.getMessage();
        }

    }

    public WeaponsInter weaponsRate(){
        return null;
    }

    public void execute(Player player){

    }

    public PrintStream getPlayerPrintStream(Player player){

        try {
            return new PrintStream(player.getSocket().getOutputStream(), true);
        }catch (Exception e){
            System.out.println("Could not get player stream: " +e);
        }
        return null;
    }

}
