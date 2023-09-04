package com.ms.exception;

/**
 * This is @IncorrectPasswordException class.
 */
public class IncorrectPasswordException extends RuntimeException {
    /**
     * This is serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * This is @IncorrectPasswordException constructor.
     * @param message
     */
    public IncorrectPasswordException(final String message) {
        super(String.format("%s", message));
    }
}
