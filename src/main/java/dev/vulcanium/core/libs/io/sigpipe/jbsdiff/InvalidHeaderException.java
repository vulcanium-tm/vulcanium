package dev.vulcanium.core.libs.io.sigpipe.jbsdiff;

public class InvalidHeaderException extends Exception {
    private static final long serialVersionUID = -3712364093810940826L;

    public InvalidHeaderException() {
    }

    public InvalidHeaderException(String detail) {
        super(detail);
    }

    public InvalidHeaderException(String fieldName, int value) {
        super("Invalid header field; " + fieldName + " = " + value);
    }
}
