package carcrashteam.Weapons;

import carcrashteam.utilities.Messages;

public enum Weapons{

    KNIFE(Messages.KNIFE_DESCRIPTION, 1300),
    SHOTGUN(Messages.SHOTGUN_DESCRIPTION,2500),
    RUBBER_DUCK(Messages.RUBBER_DUCK_DESCRIPTION, 500),
    LIGHT_SABER(Messages.LIGHT_SABER_DESCRIPTION, 5000);

    private String description;
    private int cost;

    Weapons(String weapon, int price) {
        this.description = weapon;
        this.cost = price;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

}
