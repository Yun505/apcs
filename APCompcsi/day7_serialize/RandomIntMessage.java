package day7_serialize;

import java.io.Serializable;


public class RandomIntMessage implements Serializable{
    public static final long serialVersionUID = 1L;

    private final double maxInt;
    private double randInt;

    public RandomIntMessage(double maxInt) {
        this.maxInt = maxInt;
    }

    public double getRandInt() {
        return randInt;
    }

    public void setRandInt(double randInt) {
        this.randInt = randInt;
    }

    public double getMaxInt() {
        return maxInt;
    }
}


