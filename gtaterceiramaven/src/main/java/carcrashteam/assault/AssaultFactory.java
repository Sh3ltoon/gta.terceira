package carcrashteam.assault;


import carcrashteam.assault.options.AC;
import carcrashteam.assault.options.GracaRestaurant;
import carcrashteam.assault.options.OldLady;
import carcrashteam.assault.options.SergioAvila;

public class AssaultFactory {

    public static Assault createAssault(AssaultOptions assault){

        Assault robbery = null;

        switch (assault){
            case OLD_LADY:
                robbery = new OldLady();
                break;
            case GRACA_RESTAURANT:
                robbery = new GracaRestaurant();
                break;
            case AC:
                robbery = new AC();
                break;
            case SERGIO_AVILA:
                robbery = new SergioAvila();
                break;
        }

        return robbery;
    }
}
