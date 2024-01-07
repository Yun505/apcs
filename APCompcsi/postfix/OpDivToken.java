package postfix;
public class OpDivToken extends OpToken{
    public OpDivToken(){
        super('/');
    }

    public int getPrecedence(){
        return 2;
    }

    public double eval(double a, double b ){
        return a/b;
    }
}
