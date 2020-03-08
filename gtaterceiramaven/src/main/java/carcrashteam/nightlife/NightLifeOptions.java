package carcrashteam.nightlife;

import carcrashteam.utilities.Messages;

public enum NightLifeOptions {

    Delman(Messages.GO_DELMAN, 1,30,25,
            Messages.DELMAN_LUCK,Messages.DELMAN_NO_LUCK_MESSAGE,
            75,20),

    ClassicBar(Messages.GO_CLASSIC_BAR, 2, 60,40,
            Messages.CLASSIC_BAR_LUCK,Messages.CLASSIC_BAR_NO_LUCK,
            150,20),

    Weed (Messages.BUY_WEED, 3, 45,30,
            Messages.WEED_LUCK,Messages.WEED_NO_LUCK,
            100,20);

    private String description;
    private int option;
    private int cost;
    private int successRate;

    private String luckMessage;
    private String noLuckMessage;

    private int energyGain;
    private int experienceLoss;

    NightLifeOptions(String description, int option, int cost, int successRate,
                     String luckMessage, String noLuckMessage,int energyGain,
                     int experienceLoss) {

        this.description = description;
        this.option = option;
        this.cost = cost;
        this.successRate = successRate;
        this.luckMessage = luckMessage;
        this.noLuckMessage = noLuckMessage;
        this.energyGain = energyGain;
        this.experienceLoss = experienceLoss;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public int getSuccessRate() {
        return successRate;
    }

    public String getLuckMessage() {
        return luckMessage;
    }

    public String getNoLuckMessage() {
        return noLuckMessage;
    }

    public int getEnergyGain() {
        return energyGain;
    }

    public int getExperienceLoss() {
        return experienceLoss;
    }
}
