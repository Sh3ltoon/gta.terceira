package carcrashteam.assault;

public enum AssaultOptions{
    OLDLADY ("Rob Old Lady", 1),
    GRACARESTAURANT("Shoplift Graça Restaurant", 2) ,
    AC ("Hijack <Academia de Código>", 3),
    SERGIOAVILA ("Rob Sergio Avila's Wallet", 4);

    private String description;
    private int option;

    AssaultOptions(String s, int i) {
        this.description = s;
        this.option = i;
    }

    public String getDescription() {
        return description;
    }

    public int getOption() {
        return option;
    }
}
