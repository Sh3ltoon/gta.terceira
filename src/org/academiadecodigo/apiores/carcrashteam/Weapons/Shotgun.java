package org.academiadecodigo.apiores.carcrashteam.Weapons;

public class Shotgun implements WeaponsInter{

    private final int DAMAGE = 60;

    private final int PRICE = 5000;

    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
