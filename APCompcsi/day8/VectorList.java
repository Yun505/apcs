package day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class VectorList {
    public static void main(String[] args) {
        Random r = new Random(25);
        ArrayList<Vector> list = new ArrayList<>();

        for (int i=0; i<10; i++) {
            Vector v = new Vector(r.nextInt(360), r.nextInt(50));
            list.add(v);
            System.out.println(v);
        }

        Vector v = new Vector(35, 37.0);
        System.out.println("index: " + list.indexOf(v));

        Collections.sort(list);

        for (Vector w : list) {
            System.out.println(w);
        }
    }
}
