package plant;

public abstract class Moss extends Plantae{
    public Moss(String type, int days_lived, int life_expectancy){
        super(type, days_lived, life_expectancy);
    }

    public int age(int increase){
        increase *=30;
        return super.age(increase);
    }

    public String toString(){
        String extra = String.format(" ,%s %.1f", "Months Lived:", getDaysLived()/30.0);
        return super.toString() + extra;
    }
}
