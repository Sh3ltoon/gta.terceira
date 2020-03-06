package carcrashteam.Weapons;

public class WeaponsFactory {


    public static WeaponsInter createWeapon(Weapons weapon) {


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
