package trondg.task1;

public class TooNegativeException extends Throwable {
    public TooNegativeException(String errorMessage){
        super(errorMessage);
    }
}
