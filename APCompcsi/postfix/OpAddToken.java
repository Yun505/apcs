package postfix;
public class OpAddToken extends OpToken{
    public OpAddToken(){
        super('+');
    }

    public int getPrecedence(){
        return 1;
    }
    
    public double eval(double a, double b ){
        return a+b;
    }
}
