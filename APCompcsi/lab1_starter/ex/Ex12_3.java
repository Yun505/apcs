package lab1_starter.ex;

import java.util.*; 

public class Ex12_3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int[] blue = new int[100]; 
        for (int i = 0; i<blue.length; i++){
            blue[i] = (int)(Math.random() *100)+1; 
        }

        System.out.print("Enter index:");
        try{
            System.out.println("The value is " + blue[input.nextInt()]); 
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Out of Bounds");
        }
         input.close(); 
    }
    
}
