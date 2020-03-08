package carcrashteam.nightlife;

import carcrashteam.utilities.Messages;

public enum NightLifeOptions {

    Delman(Messages.GO_DELMAN, 1,30,25,Messages.DELMAN_LUCK,Messages.DELMAN_NO_LUCK_MESSAGE),
    ClassicBar(Messages.GO_CLASSIC_BAR, 2, 60,40,Messages.CLASSIC_BAR_LUCK,Messages.DELMAN_NO_LUCK_STATUS),
    Weed (Messages.BUY_WEED, 3, 120,30,Messages.WEED_LUCK,Messages.WEED_NO_LUCK);

    private String description;
    private int option;
    private int cost;
    private int successRate;

    private String luckMessage;
    private String noLuckMessage;

    NightLifeOptions(String description, int option, int cost, int successRate, String luckMessage, String noLuckMessage) {

        this.description = description;
        this.option = option;
        this.cost = cost;
        this.successRate = successRate;
        this.luckMessage = luckMessage;
        this.noLuckMessage = noLuckMessage;
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
}
