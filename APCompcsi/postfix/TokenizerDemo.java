package postfix;
import java.util.Scanner;

public class TokenizerDemo{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        System.out.println("Enter a string of numbers and operators.");
        
        String line = input.nextLine();

        Tokenizer tk = new Tokenizer(line); 

        try{    
            double sum = 0;
            while (tk.hasMoreTokens()){
                Token t = tk.nextToken();

                System.out.println(t);

                if (t instanceof NumToken){
                    NumToken nt = (NumToken) t;
                    sum+= nt.value;
                }
                else if (t instanceof OpToken){
                    OpToken ot = (OpToken) t;
                    double result = ot.eval(16,3); 
                    System.out.println("Result: " + result);
                }
            }
            System.out.println("Sum: "+ sum);
        }
        catch (InvalidExpressionException ex){
            System.out.println(" Invalid expression" + ex);
        }
        //added below cuz annoying problme
        input.close();
    }
    
}