package carcrashteam.assault;

import carcrashteam.utilities.Messages;

public enum AssaultOptions{

    OLD_LADY (Messages.ROB_OLD_LADY, 1,3000, 0.7,
            15,6,3,1,
            0,40,25,2),

    GRACA_RESTAURANT(Messages.SHOPLIFT_GRACA_RESTAURANT, 2,4000,0.6,
            20,10,4,2,
             40,120,75,4),

    AC (Messages.HIJACK_AC, 3,5000,0.45,
            25,12,6,3,
            120, 230,150,8),

    SERGIO_AVILA (Messages.ROB_SERGIO_AVILA, 4, 7000,0.3,
            30,23,15,6,
            230,480,200,16);

    private String description;
    private int option;
    private int sentenceTime;
    private double successProbability;

    private int chanceGetRDuck;
    private int chanceGetKnife;
    private int chanceGetShotgun;
    private int chanceGetLSaber;

    private int minMoney;
    private int maxMoney;
    private int energySpent;
    private double xpWon;

    AssaultOptions(String s, int i, int sentenceTime, double successProbability,
                   int chanceGetRDuck, int chanceGetKnife, int chanceGetShotgun, int chanceGetLSaber,
                   int minMoney,int maxMoney, int energySpent, double xpWon) {

        this.description = s;
        this.option = i;
        this.sentenceTime = sentenceTime;
        this.successProbability = successProbability;

        this.chanceGetRDuck = chanceGetRDuck;
        this.chanceGetKnife = chanceGetKnife;
        this.chanceGetShotgun = chanceGetShotgun;
        this.chanceGetLSaber = chanceGetLSaber;

        this.minMoney = minMoney;
        this.maxMoney = maxMoney;
        this.energySpent = energySpent;
        this.xpWon = xpWon;
    }

    public String getDescription() {
        return description;
    }

    public int getOption() {
        return option;
    }

    public int getSentenceTime(){
        return sentenceTime;
    }

    public double getSuccessProbability() {
        return successProbability;
    }

    public int getChanceGetRDuck() {
        return chanceGetRDuck;
    }

    public int getChanceGetKnife() {
        return chanceGetKnife;
    }

    public int getChanceGetShotgun() {
        return chanceGetShotgun;
    }

    public int getChanceGetLSaber() {
        return chanceGetLSaber;
    }

    public int getMinMoney() {
        return minMoney;
    }

    public int getMaxMoney() {
        return maxMoney;
    }

    public int getEnergySpent() {
        return energySpent;
    }

    public double getXpWon() {
        return xpWon;
    }
}
