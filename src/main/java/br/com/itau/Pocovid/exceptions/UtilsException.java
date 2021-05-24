package br.com.itau.Pocovid.exceptions;

public class UtilsException extends ServiceException {

    public UtilsException(String message) {
        super(message);
    }

    public UtilsException(String message, Throwable cause) {
        super(message, cause);
    }
}
