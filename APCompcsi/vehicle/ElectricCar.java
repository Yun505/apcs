package vehicle;

public abstract class ElectricCar extends Car {
    private double milesOnMaxCharge;
    private double remainingRange;

    public ElectricCar(String make, String model, double startingMileage, double milesOnMaxCharge){
        super(make, model, startingMileage);
        if (startingMileage < 0 || milesOnMaxCharge < 0){
            throw new IllegalArgumentException();
        }
        this.milesOnMaxCharge = milesOnMaxCharge;
        remainingRange = milesOnMaxCharge;
    }

    public ElectricCar(String make, String model, double milesOnMaxCharge) {
        super(make, model);
        if (milesOnMaxCharge < 0) {
            throw new IllegalArgumentException();
        }
        this.milesOnMaxCharge = milesOnMaxCharge;
        remainingRange = milesOnMaxCharge;
    }

    public void drive(double miles){
        if (miles < 0 || miles > getRemainingRange()){
            throw new IllegalArgumentException(); 
        }
        addMileage(miles); 
        decreaseCharge(miles);
    }
    
    public double getRemainingRange() {
        return remainingRange;
    }
    
    public double getMaxRange() {
        return milesOnMaxCharge;
    }

    public void recharge() {
        remainingRange = milesOnMaxCharge;
    }
    
    protected void decreaseCharge(double miles) {
        remainingRange -= miles;
    }
}
