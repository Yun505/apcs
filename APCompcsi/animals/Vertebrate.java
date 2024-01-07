package animals;

public abstract class Vertebrate {
    public void celebrateLife(){
        System.out.println("Yea! Good to be alive.");
    }

    public String toString(){
        return "I have a spine!";
    }
}

abstract class Bird extends Vertebrate{
    public String toString(){
        return super.toString() + "And I have feathers!";
    }
}

abstract class Mammal extends Vertebrate{
    public String toString(){
        return super.toString() + "And I have hair/fur!";
    }
}

interface SwimmingAnimal{
    public void swim();
}


interface FlyingAnimal{
    public void fly();
}

interface WalkingAnimal{
    public void walk();
}
