package urlshortener;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static urlshortener.SeoKeyword.seoKeyword;
import static urlshortener.common.UrlBuilder.url;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class RandomSeoUrlShortenerTest {

    public static final String RANDOM_SEO = "cycleriders";
    private RandomSeoUrlShortener randomSeoUrlShortener;
    private SeoUrlShortener seoUrlShortener;
    private Supplier<String> randomSeoGenerator;

    @BeforeEach
    void setUp() {
        randomSeoGenerator = () -> RANDOM_SEO;
        seoUrlShortener = mock(SeoUrlShortener.class);
        randomSeoUrlShortener = new RandomSeoUrlShortener(seoUrlShortener, randomSeoGenerator);
    }

    @Test
    void should_short_to_specified_random_url() {
        var expectedUrl = url("http://short.com/" + RANDOM_SEO);
        var url = url("http://ok.ru/group/412581283");
        var randomGeneratedSeo = seoKeyword(RANDOM_SEO);
        when(seoUrlShortener.shortUrl(url, randomGeneratedSeo)).thenReturn(expectedUrl);

        var actual = randomSeoUrlShortener.shortUrl(url);

        assertThat(actual).isEqualTo(expectedUrl);
    }
}