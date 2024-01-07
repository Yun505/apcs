package postfix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Lab4_3_InfixConverter {


	/* Translates the provided String "s" from infix notation to
		postfix notation.  Returns the postfix formatted string.

		This method assumes that "s" is a properly written infix expression.  It
		is not expected to detect all syntax errors in "s".  However, it may
		throw an exception for some improperly formatted inputs.
	 */
	public static String infixToPostfix(String s) throws Exception {
		Stack<Token> opstack = new Stack<Token>(); 
		String output = "";
		Tokenizer tk = new Tokenizer(s);

		while(tk.hasMoreTokens()){
			Token t = tk.nextToken();

			if (t instanceof NumToken){
				output+= (int) ((NumToken)t).value; 
				output+= " ";
			}

			else if (t instanceof LeftParenToken){
				LeftParenToken a = (LeftParenToken) t;
                opstack.push(a); 
			}

			else if (t instanceof RightParenToken){
				while(!	(opstack.peek() instanceof LeftParenToken)){
					Token a = opstack.pop(); 
					output += a; 
					output+= " ";
				}
				opstack.pop(); 
			}

			else if (t instanceof OpToken){
				OpToken b = (OpToken) t;
				while(!opstack.isEmpty() && opstack.peek() instanceof OpToken){
					OpToken a = (OpToken) opstack.peek();

					if (a.getPrecedence() < b.getPrecedence()){
						break;
					}

					else{
						output += a;
						output+= " ";
						opstack.pop(); 
					}
				}
				opstack.push(t); 
			}
		}
		while (!opstack.empty()){
			if(opstack.peek() instanceof OpToken){
				output+= opstack.pop();
				output+= " ";
			}
		}
		return output;
	}

	/**
	 * Main opens the file 'infix.in'.  It then reads
	 * through the file one line at a time.  For each line, it prints the original
	 * line from the input, then the postfix equivalent, and then prints the
	 * simplified answer.
	 *
	 * If an exception occurs when evaluating a specific line, the exception is
	 * printed and then execution continues with the next line.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("./postfix/infix.in"));

		while (in.hasNextLine()) {
			String line = in.nextLine();
			System.out.println("\n" + line);

			try {
				String postfix = infixToPostfix(line);
				System.out.println("\t Postfix: " + postfix);

				double answer = Lab4_2_PostfixCalculator.calculatePostfix(postfix);
				System.out.println("\t Answer: " + answer);
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
}

