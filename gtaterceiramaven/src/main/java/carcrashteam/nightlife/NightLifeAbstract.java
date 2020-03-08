package carcrashteam.nightlife;

import carcrashteam.Player;
import carcrashteam.utilities.*;


public abstract class NightLifeAbstract implements Nightlife{

    public void execute(Player player, NightLifeOptions nightLifeOption) {

        if(!Checker.nightlifeChecker(player,nightLifeOption.getCost())){
            PlayerUtils.sendMessage(player,Messages.NOT_ENOUGH_MONEY);
            return;
        }

        player.setMoney(player.getMoney() - nightLifeOption.getCost());

            if(goodNight(nightLifeOption)) {

                player.setEnergy(player.getEnergy() + nightLifeOption.getEnergyGain());
                PlayerUtils.sendMessage(player,nightLifeOption.getLuckMessage());
                PlayerUtils.sendMessage(player,"Energy:" + player.getEnergy());
                return;

            }

            PlayerUtils.sendMessage(player,nightLifeOption.getNoLuckMessage() + " Wait 10 seconds");
            player.setExperience(player.getExperience() - nightLifeOption.getExperienceLoss());
            player.loseWeapons();
            goToHospital(player);

    }

    private boolean goodNight(NightLifeOptions nightLifeOption){

        double luckyNumber = RandomNumber.getRandomNumberInRange(0,100);
        return luckyNumber > nightLifeOption.getSuccessRate();

    }
    public void goToHospital(Player player){

        try {
            Chronometer chronometer = new Chronometer();
            chronometer.timer(player, 10000);
        }catch (Exception e){
            System.out.println("Thread error: "+e);
        }

    }

}
