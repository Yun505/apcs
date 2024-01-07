package plant;

public class AppleTree extends Tree{
    private int apples;
    private String appleColor;

    public AppleTree(String type, int days_lived, int life_expectancy, int apples, String appleColor){
        super(type, days_lived, life_expectancy);
        if (apples < 0){
            throw new IllegalArgumentException();
        }
        this.apples = apples;
        this.appleColor = appleColor;
    }

    public AppleTree(String type, int days_lived, int life_expectancy){
        super(type, days_lived);
        apples = 0;
        appleColor = "red";
    }

    public int getApples(){
        return apples;
    }

    public String getAppleColor(){
        return appleColor;
    }

    public String toString(){
        String extra = String.format(" ,%s %d, %s, %s", "Apples:", apples, "Apple Color:", appleColor);
        return super.toString() + extra;
    }

    
}
