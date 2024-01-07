package postfix;
public class OpSubToken extends OpToken{
    public OpSubToken(){
        super('-');
    }
    public int getPrecedence(){
        return 1;
    }

    public double eval(double a, double b ){
        return a-b;
    }
}
