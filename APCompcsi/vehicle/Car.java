package vehicle; 

import java.util.List;

public abstract class Car{
    private String make;
    private String model;
    private double startingMileage;
    
    public Car(String make, String model, double startingMileage){
        if (startingMileage < 0){
            throw new IllegalArgumentException();
        }

        this.make = make;
        this.model = model;
        this.startingMileage = startingMileage;
    }

    public Car(String make, String model){
        if (startingMileage < 0){
            throw new IllegalArgumentException();
        }
        
        this.make = make;
        this.model = model;
        this.startingMileage = 0;
    }

    public boolean canDrive(double miles) {
        if (miles < 0 || getRemainingRange() < miles){
            if (getRemainingRange() < miles){
                return false; 
            }
            throw new IllegalArgumentException();
        }
        return true;
    }

    public abstract void drive(double miles);


    public String toString(){
        return String.format("%s %s (%.1f mi)", make, getModel(), startingMileage);
    }

    public double getMileage() {
        return startingMileage;
    }

    public String getModel(){
        return model; 
    }

    public abstract double getRemainingRange();

    protected void addMileage(double miles) {
        if (miles < 0){
            throw new IllegalArgumentException();
        }
        startingMileage +=  miles;
    }

    public int roadTrip(List<Double> milesEachDay) {
        int days = 0;
        for (double distance : milesEachDay) {
            if (!canDrive(distance)) {
                   return days;
            }
            drive(distance);
            days += 1;
        }

        return days;
        
    }

}    
