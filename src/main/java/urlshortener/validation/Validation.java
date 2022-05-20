package urlshortener.validation;

import urlshortener.exception.ValidationException;

public class Validation {

    public static <T> T requireNonNull(T o, String errMsg) {
        if (o == null) {
            throw new ValidationException(errMsg);
        }
        return o;
    }

    public static String requireNonBlank(String input, String errMsg) {
        if (input.isBlank()) {
            throw new ValidationException(errMsg);
        }
        return input;
    }

    public static String requireAlphabetic(String input, String errMsg) {
        if (!input.matches("[a-zA-Z]+")) {
            throw new ValidationException(errMsg);
        }
        return input;
    }

    public static String requireMaxLength(String input, int length, String errMsg) {
        if (input.length() > length) {
            throw new ValidationException(errMsg);
        }
        return input;
    }
}
