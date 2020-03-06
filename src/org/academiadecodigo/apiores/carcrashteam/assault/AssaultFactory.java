package org.academiadecodigo.apiores.carcrashteam.assault;

import org.academiadecodigo.apiores.carcrashteam.assault.options.AC;
import org.academiadecodigo.apiores.carcrashteam.assault.options.GracaRestaurant;
import org.academiadecodigo.apiores.carcrashteam.assault.options.OldLady;
import org.academiadecodigo.apiores.carcrashteam.assault.options.SergioAvila;

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
