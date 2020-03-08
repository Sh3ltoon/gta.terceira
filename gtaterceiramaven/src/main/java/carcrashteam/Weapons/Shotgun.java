package carcrashteam.Weapons;

import carcrashteam.utilities.Messages;

public class Shotgun implements WeaponsInter{

    private final int DAMAGE = 60;

    private final int PRICE = 2500;

    private final String name = Messages.SHOTGUN_DESCRIPTION;

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
