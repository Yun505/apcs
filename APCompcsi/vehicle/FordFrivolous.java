package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{
    public FordFrivolous(double startingMileage){
        super("Ford", "Frivolous", startingMileage, 23.6, 20);
    }
    public FordFrivolous(){
        super("Ford", "Frivolous", 23.6, 20);
    }

    public void driveAutonomously(double miles){
        if (miles > super.getRemainingRange()/2){
            miles = super.getRemainingRange()/2;
        }
        super.drive(miles*2);
    }

    public void fly(double miles){
        if (canFly(miles)){
            decreaseFuelLevel((miles * 3)/getMPG());
        }
    }

    public boolean canFly(double miles){
        return super.canDrive(miles*3);
    }
}
 