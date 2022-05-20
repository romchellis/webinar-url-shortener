package urlshortener.exception;

public class UrlConstructionException extends IllegalArgumentException {
    public UrlConstructionException(String s) {
        super(s);
    }
}
