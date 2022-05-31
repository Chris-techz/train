package rest.train;

public class BadArgumentException extends RuntimeException{
    
    BadArgumentException() {
        super("Bad argument provided");
    }
}
