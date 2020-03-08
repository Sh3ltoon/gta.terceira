package carcrashteam.utilities;

public class RandomNumber {

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min!");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

}
