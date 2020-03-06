package carcrashteam.nightlife;

public enum NightLifeOptions {

    Delman("Get Drunk at Delman", 1),
    ClassicBar("Find some bitJS at Classic Bar", 2),
    Weed ("Get some Weed In Santa Rita Guetto!", 3);


    private String description;
    private int option;

    NightLifeOptions(String s, int i) {
        description = s;
        option = i;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }
}
