package carcrashteam.assault;

public enum AssaultOptions{

    OLD_LADY ("Rob Old Lady", 1,3000, 5 ),
    GRACA_RESTAURANT("Shoplift Graça Restaurant", 2,4000,10 ) ,
    AC ("Hijack <Academia de Código>", 3,5000,20),
    SERGIO_AVILA ("Rob Sergio Avila's Wallet", 4, 7000,40);

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
