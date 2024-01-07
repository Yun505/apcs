package animals;

import java.util.ArrayList;

public class Farm {

    public static void main(String[] args) {
        Cow c = new Cow();
        Penguin p = new Penguin();
        Mammal m = new Dolphin();
        WalkingAnimal w = new Cow();

        ArrayList<Vertebrate> list1 = new ArrayList<>();
        list1.add(c);
        list1.add(p);
        list1.add(m);

        ArrayList<WalkingAnimal> list2 = new ArrayList<>();
        list2.add(c);
        list2.add(p);
        //list2.add((WalkingAnimal)m);

        for (WalkingAnimal w2 : list2) {
            w2.walk();
            ((Vertebrate)w2).celebrateLife();
            System.out.println(w2);
        }
        

    }




    
}
