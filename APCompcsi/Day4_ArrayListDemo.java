import java.util.ArrayList; 
public class Day4_ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("eric");
        list.add("natalie");
        list.add("kevin");
        list.add("michele");
        
        System.out.println(list);
        
        list.add(1, "alessandro");
        System.out.println(list); 

        list.remove("kevin");
        System.out.println(list); 

        /////for loop
        for (int i = 0; i< list.size(); i++){
            System.out.println(list.get(i));
        }

        for (String name : list){
            System.out.println(name); 
            
        }
    }
}
