package carcrashteam.assault;

import carcrashteam.utilities.Messages;

public enum AssaultOptions{
    OLDLADY (Messages.ROB_OLD_LADY, 1),
    GRACARESTAURANT(Messages.SHOPLIFT_GRACA_RESTAURANT, 2) ,
    AC (Messages.HIJACK_AC, 3),
    SERGIOAVILA (Messages.ROB_SERGIO_AVILA, 4);

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
