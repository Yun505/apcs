package postfix;

import java.util.NoSuchElementException;

public class Tokenizer {
    private char[] tokenStr;
    private int pos = 0;

    public Tokenizer (String line) {
        tokenStr = line.toCharArray();
    }

    public boolean hasMoreTokens() {
        skipSpaces();
        return pos < tokenStr.length;
    }

    private NumToken getNumberToken() {
        int val = 0;

        while (pos < tokenStr.length && Character.isDigit(tokenStr[pos])) {
            val = val*10 + tokenStr[pos] - '0';
            pos++;
        }
        return new NumToken(val);
    }

    private void skipSpaces() {
        while (pos < tokenStr.length && Character.isWhitespace(tokenStr[pos])) {
            pos++;
        }
    }

    private OpToken getOpToken() throws InvalidExpressionException {
        char op = tokenStr[pos];
        pos++;

        if (op == '+') {
            return new OpAddToken();
        }
        else if (op == '-') {
            return new OpSubToken();
        }
        else if (op == '*') {
            return new OpMultiToken();
        }
        else if (op == '/') {
            return new OpDivToken();
        }
        else {
            throw new InvalidExpressionException("Found " + op + " expecting an operator at position " +
                                                    pos + ".");
        }
    }
    //also smth I added
    private ParenToken getParenToken(){
        char par = tokenStr[pos];
        pos++;

        if (par == ')') {
            return new RightParenToken();
        }
        else {
            return new LeftParenToken();
        }
        
    }

    public Token nextToken() throws InvalidExpressionException {
        skipSpaces();

        if (pos >= tokenStr.length) {
            throw new NoSuchElementException("No more tokens remaining.");
        }

        if (Character.isDigit(tokenStr[pos])) {
            return getNumberToken();
        }

        //smth I added
        if (tokenStr[pos] == '(' || tokenStr[pos] == ')'){
            return getParenToken(); 
        }

        else {
            return getOpToken();
        }
    }
}
