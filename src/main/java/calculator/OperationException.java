package calculator;

public class OperationException extends Exception{
    private String msg;

    public OperationException(String msg){
        this.msg = msg;
    }

    public String getMessage(){
        return msg;
    }

}
