package carcrashteam.assault;

import carcrashteam.utilities.Messages;

public enum AssaultOptions{
    OLDLADY (Messages.ROB_OLD_LADY, 1, 3000,5),
    GRACARESTAURANT(Messages.SHOPLIFT_GRACA_RESTAURANT, 2, 4000, 10) ,
    AC (Messages.HIJACK_AC, 3, 5000, 20),
    SERGIOAVILA (Messages.ROB_SERGIO_AVILA, 4, 7000, 40);

    private String description;
    private int option;
    private int sentenceTime;
    private int successProbability;

    AssaultOptions(String s, int i, int sentenceTime, int successProbability) {
        this.description = s;
        this.option = i;
        this.sentenceTime = sentenceTime;
        this.successProbability = successProbability;
    }

    public String getDescription() {
        return description;
    }

    public int getOption() {
        return option;
    }

    public int getSentenceTime(){
        return sentenceTime;
    }

    public int getSuccessProbability() {
        return successProbability;
    }
}
