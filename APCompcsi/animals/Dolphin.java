package animals;

public class Dolphin extends Mammal implements SwimmingAnimal{
    public void swim(){
        System.out.println("Dolphin swimming.");
    }

    public String toString(){
        return "I'm a dolphin. " + super.toString();
    }
}
