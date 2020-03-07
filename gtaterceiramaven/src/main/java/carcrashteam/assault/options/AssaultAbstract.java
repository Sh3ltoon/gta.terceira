package carcrashteam.assault.options;

import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.Assault;
import carcrashteam.assault.AssaultOptions;
import carcrashteam.utilities.Checker;
import carcrashteam.utilities.Messages;
import carcrashteam.utilities.RandomNumber;

import java.io.PrintStream;

public abstract class AssaultAbstract implements Assault {

    public void successRate(Player player, AssaultOptions assaultOption){

        if(!Checker.assaultChecker(player,assaultOption.getEnergySpent())){
            sendMessage(player,"You don't have enough energy for this assault!",assaultOption);
            return;
        }

        player.setEnergy(player.getEnergy() - assaultOption.getEnergySpent());
        player.setExperience(player.getExperience() + assaultOption.getXpWon());

        if(assaultSuccessful(player,assaultOption)){

            int moneyWon = givePlayerMoney(player,assaultOption);
            sendMessage(player,Messages.SUCCESS_ASSAULT,assaultOption);
            sendMessage(player,"+ " +moneyWon + " money",assaultOption);
            sendMessage(player,"+ " +assaultOption.getXpWon() + " XP",assaultOption);

            return;

        }

        sendMessage(player,Messages.SENT_PRISON + "Wait " + assaultOption.getSentenceTime() + " seconds", assaultOption);
        sendMessage(player,"+ " +assaultOption.getXpWon() + " XP",assaultOption);

    }

    public WeaponsInter weaponsRate(AssaultOptions assaultOption){

        double chanceGetWeapon = Math.ceil(Math.random()*100);

        if(chanceGetWeapon > 0 && assaultOption.getChanceGetLSaber() < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.LIGHT_SABER);
        }

        if(chanceGetWeapon > assaultOption.getChanceGetLSaber() && assaultOption.getChanceGetShotgun() < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.SHOTGUN);
        }

        if(chanceGetWeapon > assaultOption.getChanceGetShotgun() && assaultOption.getChanceGetKnife() < chanceGetWeapon){
            return WeaponsFactory.createWeapon(Weapons.KNIFE);
        }

        if(chanceGetWeapon > assaultOption.getChanceGetKnife() && chanceGetWeapon < assaultOption.getChanceGetRDuck()){
            return WeaponsFactory.createWeapon(Weapons.RUBBER_DUCK);
        }

        return null;
    }

    public void execute(Player player){ }

    private PrintStream getPlayerPrintStream(Player player){

        try {
            return new PrintStream(player.getSocket().getOutputStream(), true);
        }catch (Exception e){
            System.out.println("Could not get player stream: " +e);
        }
        return null;
    }

    private void sendMessage(Player player, String message, AssaultOptions assaultOption){

        try{

            getPlayerPrintStream(player).println(message);
            Thread.sleep(assaultOption.getSentenceTime());

        }catch (InterruptedException ex){
            ex.getMessage();
        }

    }

    private boolean assaultSuccessful(Player player,AssaultOptions assaultOption){

        double successProbability = Math.random() * player.getExperience();
        return successProbability >= assaultOption.getSuccessProbability();
    }

    public int givePlayerMoney(Player player, AssaultOptions assaultOptions){
        int money = RandomNumber.getRandomNumberInRange(assaultOptions.getMinMoney(),assaultOptions.getMaxMoney());
        player.setMoney(player.getMoney() + money);
        return money;
    }

}
