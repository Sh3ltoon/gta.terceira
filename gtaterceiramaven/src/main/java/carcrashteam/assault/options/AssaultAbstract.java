package carcrashteam.assault.options;

import carcrashteam.Player;
import carcrashteam.Weapons.Weapons;
import carcrashteam.Weapons.WeaponsFactory;
import carcrashteam.Weapons.WeaponsInter;
import carcrashteam.assault.Assault;
import carcrashteam.assault.AssaultOptions;
import carcrashteam.utilities.*;

import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AssaultAbstract implements Assault {


    public void successRate(Player player, AssaultOptions assaultOption){

        if(!Checker.assaultChecker(player,assaultOption.getEnergySpent())){
            PlayerUtils.sendMessage(player,"You don't have enough energy for this assault!");
            return;
        }

        player.setEnergy(player.getEnergy() - assaultOption.getEnergySpent());
        player.setExperience(player.getExperience() + assaultOption.getXpWon());

        if(assaultSuccessful(player,assaultOption)){

            int moneyWon = givePlayerMoney(player,assaultOption);
            PlayerUtils.sendMessage(player,Messages.SUCCESS_ASSAULT);
            PlayerUtils.sendMessage(player,"+ " +moneyWon + " money");
            PlayerUtils.sendMessage(player,"+ " +assaultOption.getXpWon() + " XP");

            return;

        }

        PlayerUtils.sendMessage(player,Messages.SENT_PRISON + "Wait " + assaultOption.getSentenceTime() + " seconds");

        goToPrision(player, assaultOption.getSentenceTime());
        PlayerUtils.sendMessage(player,"+ " +assaultOption.getXpWon() + " XP");

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

    private boolean assaultSuccessful(Player player,AssaultOptions assaultOption){

        double successProbability = Math.random() * player.getExperience();
        return successProbability >= assaultOption.getSuccessProbability();
    }

    public int givePlayerMoney(Player player, AssaultOptions assaultOptions){
        int money = RandomNumber.getRandomNumberInRange(assaultOptions.getMinMoney(),assaultOptions.getMaxMoney());
        player.setMoney(player.getMoney() + money);
        return money;
    }

    public void goToPrision(Player player, int sentenceTimer){

        try {
            Chronometer chronometer = new Chronometer();
            chronometer.timer(player, sentenceTimer);
            Thread.sleep(sentenceTimer);
        }catch (Exception e){
            System.out.println("Thread error: "+e);
        }

    }

}
