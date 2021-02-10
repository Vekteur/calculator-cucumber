package calculator;

public class DivisionByZeroException extends OperationException{
    public DivisionByZeroException() {
        super("Cannot divide by zero.");
    }
}
