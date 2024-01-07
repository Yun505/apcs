import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class BCAQueue<E>{
    private List<E> list = new LinkedList<E>();

    public BCAQueue(){}

    public void enqueue(E e){
        list.add(e); 
    }

    public E dequeue(){
        if (list.isEmpty()){
            throw new NoSuchElementException();
        }
        return list.remove(0); 
    }

    public E peek(){
        if (list.isEmpty()){
            throw new NoSuchElementException();
        }
        return list.get(0); 
    }

    public int size(){
        return list.size(); 
    }

    public boolean isEmpty(){
        return list.isEmpty(); 
    }

    public void clear(){
        list.clear();
    }
}