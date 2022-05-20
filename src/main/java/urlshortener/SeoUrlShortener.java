package urlshortener;

import static urlshortener.common.UrlBuilder.url;
import static urlshortener.validation.Validation.requireNonNull;

import java.net.URL;

public class SeoUrlShortener {

    public URL shortUrl(URL longUrl, SeoKeyword seoKeyword) {
        requireNonNull(longUrl, "Url cannot be null");
        requireNonNull(seoKeyword, "seoKeyword cannot be null");

        return url("http://short.com/" + seoKeyword.getWord());
    }

}
