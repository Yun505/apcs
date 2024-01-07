package vehicle; 

public abstract class GasPoweredCar extends Car {
    private double mpg;
    private double fuelCapacityGallons;
    private double fuelLevel;

    public GasPoweredCar(String make, String model, double startingMileage, double mpg, double fuelCapacityGallons){
        super(make, model, startingMileage);
        if (mpg <= 0 || fuelCapacityGallons <= 0){
            throw new IllegalArgumentException();
        }
        this.mpg = mpg;
        this.fuelCapacityGallons = fuelCapacityGallons;
        this.fuelLevel = fuelCapacityGallons;
    }

    public GasPoweredCar(String make, String model, double mpg, double fuelCapacityGallons) {
        super(make, model);
        if (mpg < 0 || fuelCapacityGallons < 0) {
            throw new IllegalArgumentException();
        }
        this.mpg = mpg;
        this.fuelCapacityGallons = fuelCapacityGallons;
        this.fuelLevel = fuelCapacityGallons;
    }

    public void drive(double miles) {
        if (miles < 0){
            throw new IllegalArgumentException();
        }

        if (!canDrive(miles)){
            throw new IllegalArgumentException();
        }

        decreaseFuelLevel(miles/getMPG());
        addMileage(miles);
    }

    public double getMPG() {
        return mpg;
    }
    
    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getFuelCapacity() {
        return fuelCapacityGallons;
    }

    public void refillTank() {
        fuelLevel = fuelCapacityGallons;
    }

    public double getRemainingRange() {
        return fuelLevel * mpg;
    }

    public void refillTank(double gallons) {
        if (gallons < 0){
            throw new IllegalArgumentException();
        }

        if (fuelLevel + gallons > fuelCapacityGallons){
            throw new IllegalArgumentException();
        }

        fuelLevel += gallons;
    }

    protected void decreaseFuelLevel(double miles) {
        fuelLevel -= miles;
    }
}
