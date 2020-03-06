package carcrashteam.Weapons;

public class Shotgun implements WeaponsInter{

    private final int DAMAGE = 60;

    private final int PRICE = 2500;

    private final String name = "Shotgun";

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
}
