

public class RaceCondition {

    static MyInt count = new MyInt();
    public static void main(String[] args) {
        for ( int i =0; i < 10; i ++){
            Thread t = new Thread(() -> {
                for (int j = 0; j < 100; j++){
                    count.increment();
                }
            });
            
            t.start(); 
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex){}
        System.out.println("After 1 second, count is " + count.getCount());
    }
}

class MyInt {
    private int count = 0;

    public synchronized void increment(){
        int newcount = count + 1;
        System.out.println(count + "->" + newcount);
        count = newcount;
    }

    public int getCount(){
        return count;
    }
}
