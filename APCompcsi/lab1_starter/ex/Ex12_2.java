package lab1_starter.ex;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ex12_2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); 
        int num = 0;
        int num_2 = 0; 
        boolean yee = false;
        while (!yee){
            try{
                num = input.nextInt(); 
                num_2 = input.nextInt(); 
                yee = true; 
            } 
            catch (InputMismatchException ex){
                input.nextLine();
                System.out.println("WRONG");
                System.out.println("Enter two integers:");
            }
        }
        System.out.println(num + " + " + num_2 + " = " + (num + num_2)); 
        input.close(); 
    }
}

