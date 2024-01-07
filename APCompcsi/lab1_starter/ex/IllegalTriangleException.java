package lab1_starter.ex;

public class IllegalTriangleException extends Exception{
    /**
     *
     */
    //one line added to not see probelsm
    private static final long serialVersionUID = 1L;

    public IllegalTriangleException() {
        super("The sum of any two sides is greater than the other side.");
    }
}
