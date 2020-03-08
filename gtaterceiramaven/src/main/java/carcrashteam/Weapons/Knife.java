package carcrashteam.Weapons;

import carcrashteam.utilities.Messages;

public class Knife implements WeaponsInter {


    private final int DAMAGE = 25;

    private final int PRICE = 1300;

    private final String name = Messages.KNIFE_DESCRIPTION;

    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
    @Override
    public String toString() {
        return name;
    }
}
