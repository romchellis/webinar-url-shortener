package urlshortener;

import static org.assertj.core.api.Assertions.assertThat;
import static urlshortener.SeoKeyword.seoKeyword;
import static urlshortener.common.UrlBuilder.url;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeoUrlShortenerTest {

    private SeoUrlShortener seoUrlShortener;

    @BeforeEach
    void setUp() {
        seoUrlShortener = new SeoUrlShortener();
    }

    @Test
    void should_shorten_to_specified_url_with_given_seo() {
        var url = url("http://vk.com/id1245125125123");
        var expectedUrl = url("http://short.com/digitalhabbits");
        var seoKeyword = seoKeyword("digitalhabbits");

        var actual = seoUrlShortener.shortUrl(url, seoKeyword);

        assertThat(actual).isEqualTo(expectedUrl);
    }
}