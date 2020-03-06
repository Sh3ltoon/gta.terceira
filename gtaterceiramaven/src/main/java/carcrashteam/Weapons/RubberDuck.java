package carcrashteam.Weapons;

public class RubberDuck implements WeaponsInter {

    private final int DAMAGE = 10;

    private final int PRICE = 500;


    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
