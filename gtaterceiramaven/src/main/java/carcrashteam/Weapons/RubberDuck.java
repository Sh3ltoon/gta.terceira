package carcrashteam.Weapons;

import carcrashteam.utilities.Messages;

public class RubberDuck implements WeaponsInter {

    private final int DAMAGE = 10;

    private final int PRICE = 500;

    private final String name = Messages.RUBBER_DUCK_DESCRIPTION;

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
