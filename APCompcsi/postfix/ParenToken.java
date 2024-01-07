package postfix;

public abstract class ParenToken extends Token {
    private final char paren;

    public ParenToken(char par){
        paren = par;
    }

    public String toString(){
        return "" + paren; 
    }
}
