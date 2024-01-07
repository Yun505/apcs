import java.util.ArrayList; 
import java.util.EmptyStackException; 

public class BCAStack<Element> {
    private ArrayList<Element> list = new ArrayList<>();

    public BCAStack(){

    }

    public void push(Element e){
        list.add(e);
    }

    public Element pop(){
        if (list.isEmpty()){
            throw new EmptyStackException();
        }
        return list.remove(list.size()-1);
    }

    public Element peak(){
        if (list.isEmpty()){
            throw new EmptyStackException();
        }
        return list.get(list.size()-1);
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
