package day1;

import java.io.IOException;

public class FileFormatException extends IOException {
    /**
     *
     */
    //added to avoid problem this one line below
    private static final long serialVersionUID = 1L;

    public FileFormatException(String str) {
            super(str);
        }
        
    
    public FileFormatException(Throwable t) {
        super(t);
    }
}
