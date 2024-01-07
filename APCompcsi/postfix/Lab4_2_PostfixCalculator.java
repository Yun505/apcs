package postfix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//smth I decided to add
import java.util.Stack;

 


public class Lab4_2_PostfixCalculator {

    /**
     * calculatePostfix calculates and returns the value for the postfix
     * expression "postfixExp".  This method throws exceptions in the following
     * cases:
     * 1) If there are illegal characters in the input.
     * 2) If there are not enough values for a given operator.
     * 3) If there is more than 1 value remaining on the stack after the calculation completes.
     */
    public static double calculatePostfix(String postfixExp) throws Exception {
        Stack<Token> stack = new Stack<Token>(); 
        Tokenizer tk = new Tokenizer(postfixExp); 
        while (tk.hasMoreTokens()){
            Token t = tk.nextToken();

            if (t instanceof NumToken){
                NumToken nt = (NumToken) t;
                stack.push(nt); 
            }
            else if (t instanceof OpToken){
                OpToken ot = (OpToken) t;
                if (stack.size() <2){
                    String message = "Too few values on the stack for operator "+ ot.toString() +".";
                    throw new InvalidExpressionException(message);
                }
                else{
                    Token first = stack.pop(); 
                    NumToken first_NumToken = (NumToken) first;
                    double first_value = first_NumToken.value; 

                    Token second = stack.pop(); 
                    NumToken second_NumToken = (NumToken) second;
                    double second_value = second_NumToken.value;

                    double result = ot.eval(second_value, first_value);
                    stack.push(new NumToken(result));
                }
            }
        }
        if (stack.size()> 1){
            String message = "Too few operators in the expression. Stack has " + stack.size() + " elements at the end of the expression";
            throw new InvalidExpressionException(message);
        }
        else{
            return ((NumToken) stack.pop()).value; 
        }
    }   

    /**
     * Main opens the file specified in the first paramenter.  It then reads
     * through the file one line at a time.  For each line, it prints the original
     * line from the input and then prints the result.  If an exception occurs when
     * evaluating a specific link, print the message for the exception (using getMessage)
     * and then continue to the next line.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("./postfix/postfix.in"));

        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println("\n" + line);

            try {
                double answer = calculatePostfix(line);
                System.out.println(answer);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
