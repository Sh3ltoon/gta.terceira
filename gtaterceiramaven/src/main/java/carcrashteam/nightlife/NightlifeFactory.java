package carcrashteam.nightlife;

public class NightlifeFactory {

    public static Nightlife createNightlife(NightLifeOptions option){

        Nightlife event = null;

        switch (option){
            case Delman:
                return  new Delman();
            case Weed:
                return new Weed();
            default:
                return new ClasseicBar();
        }
    }
}
