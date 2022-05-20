package urlshortener.common;

import java.net.MalformedURLException;
import java.net.URL;

import urlshortener.exception.UrlConstructionException;
import urlshortener.validation.Validation;

public class UrlBuilder {

    public static URL url(String input) {
        Validation.requireNonNull(input, "URL cannot be null");

        try {
            return new URL(input);
        } catch (MalformedURLException e) {
            throw new UrlConstructionException("Something went wrong with construction: " + input);
        }
    }
}
