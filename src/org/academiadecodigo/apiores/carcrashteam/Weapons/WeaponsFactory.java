package org.academiadecodigo.apiores.carcrashteam.Weapons;

import org.academiadecodigo.apiores.carcrashteam.Player;

public class WeaponsFactory {


    public static WeaponsInter CreateWeapon(Weapons weapon) {


        switch (weapon) {

            case KNIFE:
                return new Knife();

            case SHOTGUN:
                return new Shotgun();

            case LIGHT_SABER:
                return new LightSaber();

            default:
                return new RubberDuck();


        }


    }




}
