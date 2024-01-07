package postfix;
public class OpMultiToken extends OpToken{
    public OpMultiToken(){
        super('*');
    }

    public int getPrecedence(){
        return 2;
    }

    public double eval(double a, double b ){
        return a*b;
    }
}
