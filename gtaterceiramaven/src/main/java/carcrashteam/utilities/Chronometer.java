package carcrashteam.utilities;

import carcrashteam.Player;

import java.util.Date;

public class Chronometer extends Thread{


    public void timer(Player player,int sentenceTime ) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        int endTime = sentenceTime;

        while (elapsedTime < endTime) {
            elapsedTime = (new Date().getTime() - startTime);
            String seconds = "" + (int) (elapsedTime/1000);
            Thread.sleep(1000);
            PlayerUtils.sendMessage(player, seconds);
        }



    }



}
