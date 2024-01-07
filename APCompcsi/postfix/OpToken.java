package postfix;
public abstract class OpToken extends Token {
    private final char operator;

    public OpToken(char op){
        operator = op;
    }

    public abstract double eval(double a, double b);

    public abstract int getPrecedence();

    public String toString(){
        return "" + operator; 
    }
}
