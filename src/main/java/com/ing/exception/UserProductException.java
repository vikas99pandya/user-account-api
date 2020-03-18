package com.ing.exception;

/**
 * Exception info for user product micro-service
 */
public class UserProductException extends Exception {

    private static final long serialVersionUID = -4908881206111894083L;

    private final String errorCode;


    /**
     * Constructor
     *
     * @param message a message for the exception
     * @param cause a cause for the exception
     * @param errorCode a Error code for the exception
     */
    public UserProductException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
