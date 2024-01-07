package plant;

public class AppleMoss extends Moss{
    private String color;

    public AppleMoss(String type, int days_lived, int life_expectancy, String color){
        super(type, days_lived, life_expectancy);
        this.color = color;
    }

    public AppleMoss(String type, int days_lived, int life_expectancy){
        super(type, days_lived, life_expectancy);
        color = "green";
    }
    public String getColor(){
        return color;
    }
    public String toString(){
        return super.toString() + " Color: " + color;
    }
}
