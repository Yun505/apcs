package postfix;
public class InvalidExpressionException extends Exception{
    /**
     *
     */
    //one line below added to not see problems
    /*private static final long serialVersionUID = 1L;

    public InvalidExpressionException() {
        super();
    }*/

    public InvalidExpressionException(String str){
        super(str);
    }
}
