package plant;

public abstract class Plantae{
    private String type;
    private int days_lived;
    private int life_expectancy;

    public Plantae(String type, int days_lived, int life_expectancy){
        if (life_expectancy <= 0 || days_lived < 0){
            throw new IllegalArgumentException();
        }
       this.type = type;
       this.days_lived = days_lived;
       this.life_expectancy = life_expectancy;
    }

    public Plantae(String type, int life_expectancy){
        if (life_expectancy <=0){
            throw new IllegalArgumentException();
        }
        days_lived = 0;
        this.type = type;
        this.life_expectancy = life_expectancy;
    }

    public boolean alive(int days_lived){
        if (days_lived <= life_expectancy){
            return true;
        }
        return false;
    }

    public String toString(){
        return "Type: " + type;
    }

    public int getDaysLived(){
        return days_lived;
    }

    public int age(int increase){        
        if (days_lived + increase > life_expectancy)
        {
            System.out.println("Plant will die! Don't age it that much!");
            return days_lived;
        }
        days_lived = days_lived + increase;
        return days_lived;
    }

    public int getLifeExpectancy(){
        return life_expectancy; 
    }
}