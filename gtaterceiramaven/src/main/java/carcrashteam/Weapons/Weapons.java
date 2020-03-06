package carcrashteam.Weapons;

public enum Weapons{

    KNIFE("Knife", 1300),
    SHOTGUN("Shotgun",2500),
    RUBBER_DUCK("Rubber Duck", 500),
    LIGHT_SABER("Light Saber", 5000);

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
