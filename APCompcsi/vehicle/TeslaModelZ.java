package vehicle;

public class TeslaModelZ extends ElectricCar implements SelfDriving {
    private int modelNum;

    public TeslaModelZ(double startingMileage, int modelNum) {
        super("Tesla", "Model Z", startingMileage, 340);
        this.modelNum = modelNum;
    }

    public TeslaModelZ(int modelNum) {
        super("Tesla", "Model Z", 340);
        this.modelNum = modelNum;
    }

    public int getModelNum(){ 
        return modelNum;
    } 

    public String getModel(){
        return "Z" + getModelNum();
    }

    public void driveAutonomously(double miles){
        if (miles > super.getRemainingRange()){
            miles = super.getRemainingRange();
        }
        super.drive(miles);
    }

}
