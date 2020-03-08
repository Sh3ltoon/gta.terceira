package carcrashteam.nightlife;

import carcrashteam.utilities.Messages;

public enum NightLifeOptions {

    Delman(Messages.GO_DELMAN, 1),
    ClassicBar(Messages.GO_CLASSIC_BAR, 2),
    Weed (Messages.BUY_WEED, 3);


    private String description;
    private int option;

    NightLifeOptions(String s, int i) {
        description = s;
        option = i;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }
}
