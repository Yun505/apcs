package animals;

public class Cow extends Mammal implements WalkingAnimal{
    public void walk(){
        System.out.println("Cow walking");
    }
    public String toString(){
        return "I'm a cow. " + super.toString();
    }
}
