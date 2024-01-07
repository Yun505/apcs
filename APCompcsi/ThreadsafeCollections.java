

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadsafeCollections {
    
    static List<Integer> regularList = new ArrayList<Integer>();

    // https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#synchronizedList-java.util.List-
    public static void main(String[] args) throws InterruptedException {

        List<Integer> synchronizedList = Collections.synchronizedList(regularList);

        Thread a = new Thread(new ListFiller(0, 1000, synchronizedList));
        Thread b = new Thread(new ListFiller(1000, 2000, synchronizedList));
        Thread c = new Thread(new ListFiller(2000, 3000, synchronizedList));

        a.start();
        b.start();
        c.start();

        //wait for threads to finish
        a.join();
        b.join();
        c.join();

        // The list should be empty!
        System.out.println("Size: " + regularList.size());
        for (int i : regularList) {
            System.out.print(i + ",");
        }
    }
    
}

class ListFiller implements Runnable {
    private int start;
    private int end;
    private List<Integer> list;

    public ListFiller(int start, int end, List<Integer> list){
        this.start = start;
        this.end = end;
        this.list = list;
    }

    @Override
    public void run() {
        // Add a bunch of things and then remove them.  There should be nothing left!
        
        for (int i=start; i<end; i++) {
            list.add(Integer.valueOf(i));
        }

        for (int i=start; i<end; i++) {
            list.remove(Integer.valueOf(i));
        }

    }
} 