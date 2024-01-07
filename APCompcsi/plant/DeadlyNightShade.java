package plant;

public class DeadlyNightShade extends Tree implements Blooms, SpreadsPoison{
    private int flowers;
    private int fruit;

    public DeadlyNightShade(String type, int days_lived, int life_expectancy, int flowers, int fruit){
        super(type, days_lived, life_expectancy);
        if (flowers < 0 || fruit < 0){
            throw new IllegalArgumentException();
        }
        this.flowers = flowers;
        this.fruit = fruit;
    }

    public DeadlyNightShade(String type, int days_lived, int life_expectancy, int fruit){
        super(type, days_lived, life_expectancy);
        flowers = 0;
        if(fruit < 0){
            throw new IllegalArgumentException();
        }
        this.fruit = fruit;
    }

    public int getFruit(){
        return fruit;
    }

    public int getFlowers(){
        return flowers;
    }

    public String toString(){
        String extra = String.format(" ,%s %d, %s, %d", "Deadly NightShade Fruit:", fruit, "Flowers:", flowers);
        return super.toString() + extra;
    }

    public void increaseFlower(int increase){
        if(increase < 0){
            throw new IllegalArgumentException();
        }
        flowers += increase;
    }

    public boolean isDeadly(){
        if(fruit >=20){
            return true;
        }
        return false;
    }

    public void addFruits(){
        if(fruit < 20){
            fruit +=5;
        }
    }


}
