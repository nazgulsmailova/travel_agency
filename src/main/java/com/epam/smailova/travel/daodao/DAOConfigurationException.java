package com.epam.smailova.travel.daodao;

public class DAOConfigurationException extends RuntimeException {
    public static final long serialVersionUID=1L;

    public DAOConfigurationException(String message) {
        super(message);
    }

    public DAOConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOConfigurationException(Throwable cause) {
        super(cause);
    }
}
