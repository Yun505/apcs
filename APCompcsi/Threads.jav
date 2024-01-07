public class Threads{
    public static void main(String[] args) {
        Counter a = new Counter("A");
        Thread t1 = new Thread(a);

        //////////////

        Runnable b = new Counter("B");
        Thread t2 = new Thread(b)

        ///////////
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10; i ++){
                System.out.println("C: " + i)
            }
        });

        //////
        Runnable d = ()->{
            for (int i = 0; i < 10; i ++){
                System.out.println("D: " + i)
            }
        };
        Thread t4 = new Thread(d);

        t1.start();
        t2.start();
        t3.start();
        t4.start(); 

        System.out.println("Main done!");
    }
}

class Counter implements Runnable{
    private String name;

    Counter (String name){
        this.name = name;
    }

    public void run(){
        for (int i = 0; i <10; i++){
            System.out.println(name + ": " + i);
        }
    }
    //thread exits
}