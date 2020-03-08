package carcrashteam.nightlife;

public class NightlifeFactory {

    public static Nightlife createNightlife(NightLifeOptions option){

        Nightlife event = null;

        switch (option){
            case Delman:
                event = new Delman();
                break;
            case Weed:
                event =  new Weed();
                break;
            case ClassicBar:
                event = new ClasseicBar();
                break;
        }
        return event;
    }
}
