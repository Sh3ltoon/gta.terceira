package carcrashteam.Weapons;

public class LightSaber  implements WeaponsInter {

    private final int DAMAGE = 40;

    private final int PRICE = 4350;



    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
