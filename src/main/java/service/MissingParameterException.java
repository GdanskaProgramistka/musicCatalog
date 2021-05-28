package service;

public class MissingParameterException extends Exception {

    public MissingParameterException() {}
    public MissingParameterException(String exceptionResponse) {
        super(exceptionResponse);
    }
}
