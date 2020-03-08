package carcrashteam.nightlife;

import carcrashteam.Player;
import carcrashteam.utilities.Checker;
import carcrashteam.utilities.PlayerUtils;
import carcrashteam.utilities.RandomNumber;


public abstract class NightLifeAbstract implements Nightlife{

    public void execute(Player player, NightLifeOptions nightLifeOption) {

        if(!Checker.nightlifeChecker(player,nightLifeOption.getCost())){
            return;
        }
        player.setMoney(player.getMoney() - nightLifeOption.getCost());

        double luckyNumber = RandomNumber.getRandomNumberInRange(0,100);

            if(luckyNumber < nightLifeOption.getSuccessRate()) { // make a function

                PlayerUtils.sendMessage(player,nightLifeOption.getNoLuckMessage());
                player.setExperience(player.getExperience() - 20 );
                player.looseWeapons();

            }else{

                player.setEnergy(player.getEnergy() + 50);
                PlayerUtils.sendMessage(player,nightLifeOption.getLuckMessage());
                PlayerUtils.sendMessage(player,"Energy:" + player.getEnergy());

            }
        }


}
