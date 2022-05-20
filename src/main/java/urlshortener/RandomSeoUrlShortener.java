package urlshortener;

import static urlshortener.SeoKeyword.seoKeyword;
import static urlshortener.validation.Validation.requireNonNull;

import java.net.URL;
import java.util.function.Supplier;

public class RandomSeoUrlShortener {

    private final SeoUrlShortener seoUrlShortener;
    private final Supplier<String> randomSeoGenerator;

    public RandomSeoUrlShortener(SeoUrlShortener seoUrlShortener) {
        this(seoUrlShortener, new RandomSeoGenerator());
    }

    RandomSeoUrlShortener(SeoUrlShortener seoUrlShortener,
                          Supplier<String> randomSeoGenerator) {
        this.seoUrlShortener = requireNonNull(seoUrlShortener, "Seo shortener cannot be" + " null");
        this.randomSeoGenerator = requireNonNull(randomSeoGenerator, "");
    }

    public URL shortUrl(URL longUrl) {
        requireNonNull(longUrl, "Url cannot be null");

        var randomWord = randomSeoGenerator.get();
        var randomSeo = seoKeyword(randomWord);
        return seoUrlShortener.shortUrl(longUrl, randomSeo);
    }
}
