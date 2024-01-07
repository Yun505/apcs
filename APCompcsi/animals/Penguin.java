package animals;

public class Penguin extends Bird implements WalkingAnimal, SwimmingAnimal{
    public void walk(){
        System.out.println("Penguin walking");
    }
    public void swim(){
        System.out.println("Penguin swimming.");
    }
    public String toString(){
        return "I'm a penguin. " + super.toString();
    }
}
