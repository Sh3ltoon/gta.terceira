package carcrashteam.assault;


import carcrashteam.assault.options.AC;
import carcrashteam.assault.options.GracaRestaurant;
import carcrashteam.assault.options.OldLady;
import carcrashteam.assault.options.SergioAvila;

public class AssaultFactory {

    public static Assault createAssault(AssaultOptions assault){
        Assault robbery = null;
        switch (assault){
            case OLDLADY:
                robbery = new OldLady();
            case GRACARESTAURANT:
                robbery = new GracaRestaurant();
            case AC:
                robbery = new AC();
            case SERGIOAVILA:
                robbery = new SergioAvila();
        }

        return robbery;
    }
}
