package org.academiadecodigo.apiores.carcrashteam.Weapons;

public class Knife implements WeaponsInter {


    private final int DAMAGE = 25;

    private final int PRICE = 1300;


    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
