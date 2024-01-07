package plant;

public abstract class Tree extends Plantae{

    public Tree(String type, int days_lived, int life_expectancy){
        super(type, days_lived, life_expectancy);
    }

    public Tree(String type, int life_expectancy){
        super(type, life_expectancy);
    }

    public int age(int increase){
        increase *= 365;
        return super.age(increase);
    }



    public String toString(){
        String extra = String.format(" ,%s %.1f", "Years Lived:", getDaysLived()/365.0);
        return super.toString() + extra;
    }
}
