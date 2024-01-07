package plant;

public class GrapeVine extends Vine implements Blooms{
    private int grapes;
    private String grapeColor;
    public GrapeVine(String type, int days_lived, int life_expectancy, int grapes, String grapeColor){
        super(type, days_lived, life_expectancy);
        if(grapes < 0){
            throw new IllegalArgumentException();
        }
        this.grapes = grapes;
        this.grapeColor = grapeColor;
    }

  
    public GrapeVine(String type, int days_lived, int life_expectancy){
        super(type, days_lived, life_expectancy);
        grapes = 0;
        grapeColor = "purple";
    }
    public int getGrapes(){
        return grapes;
    }
    public String getGrapeColor(){
        return grapeColor;
    }
    //not actually flowers just increases grapes rather
    public void increaseFlower(int increase){
        if(increase < 0){
            throw new IllegalArgumentException();
        }
        grapes += increase;
    }
    public String toString(){
        return super.toString() + " Grapes: " + grapes + ", Grape Color: " + grapeColor; 
    }
}
