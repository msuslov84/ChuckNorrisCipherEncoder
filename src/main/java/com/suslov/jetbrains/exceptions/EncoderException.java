package com.suslov.jetbrains.exceptions;

/**
 * @author Mikhail Suslov
 */
public class EncoderException extends RuntimeException {

    public EncoderException(String message) {
        super(message);
    }

    public EncoderException(String message, Throwable cause) {
        super(message, cause);
    }
}
