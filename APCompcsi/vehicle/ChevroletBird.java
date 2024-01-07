
package vehicle;

public class ChevroletBird extends ElectricCar implements Flying{
    private boolean extended;

    public ChevroletBird(double startingMileage){
        super("Chevrolet", "Bird", startingMileage, 250);
        extended = false;
    }

    public ChevroletBird(){
        super("Chevrolet", "Bird", 250);
        extended = false;
    }

    public boolean checkWingsExtended(){
        return extended; 
    }

    public void drive(double miles){
        extended = false;
        super.drive(miles);
    }

    public void fly(double miles){
        extended = true;
        if(canFly(miles)){
            decreaseCharge(miles);
        }
        else{
            throw new IllegalArgumentException();
        }
        
    }

    public boolean canFly(double miles){
        return super.canDrive(miles);
    } 
}
