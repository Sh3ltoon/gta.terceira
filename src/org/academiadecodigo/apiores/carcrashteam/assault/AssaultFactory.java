package org.academiadecodigo.apiores.carcrashteam.assault;

import org.academiadecodigo.apiores.carcrashteam.assault.options.AC;
import org.academiadecodigo.apiores.carcrashteam.assault.options.GracaRestaurant;
import org.academiadecodigo.apiores.carcrashteam.assault.options.OldLady;
import org.academiadecodigo.apiores.carcrashteam.assault.options.SergioAvila;

public class AssaultFactory {

    public static Assault createAssault(AssaultOptions assault){
        switch (assault){
            case OLDLADY:
                return new OldLady();
            case GRACARESTAURANT:
                return new GracaRestaurant();
            case AC:
                return new AC();
            default:
                return new SergioAvila();
        }
    }
}
