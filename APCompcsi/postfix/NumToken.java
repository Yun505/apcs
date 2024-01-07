package postfix;
public class NumToken extends Token{
    public double value;

    public NumToken(double value){
        this.value= value;
    }
    public String toString(){
        return "" + value; 
    }
}