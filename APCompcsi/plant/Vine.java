package plant;

public abstract class Vine extends Plantae{

    public Vine(String type, int days_lived, int life_expectancy){
        super(type, days_lived, life_expectancy);
    }

    public int age(int increase){
        increase *= 7;
        return super.age(increase);
    }

    public String toString(){
        String extra = String.format(" ,%s %.1f", "Weeks Lived:", getDaysLived()/7.0);
        return super.toString() + extra;
    }
}
