package urlshortener;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import urlshortener.exception.ValidationException;

public class SeoKeywordTest {

    @Test
    void should_fail_if_seo_is_blank() {
        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() -> SeoKeyword.seoKeyword("    "))
                .withMessage("Seokeyword cannot be constructed with blank word");
    }

    @Test
    void should_fail_if_seo_is_null() {
        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() -> SeoKeyword.seoKeyword(null))
                .withMessage("Seokeyword cannot be constructed with null word");
    }

    @Test
    void should_fail_if_seo_is_non_alphabetic() {
        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() -> SeoKeyword.seoKeyword(" a 1 az /"))
                .withMessage("Seokeyword cannot be constructed with non aplha characters");
    }

    @Test
    void should_fail_if_length_more_than_20_symbols() {
        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() -> SeoKeyword.seoKeyword("qwertyuiopasdfghjkcxczxvgasdgag"))
                .withMessage("Seokeyword length cannot longer than 20 symbols");
    }

    @Test
    void should_construct_with_alphabetic_symbols() {
        var samsung = SeoKeyword.seoKeyword("samsung");
        var word = samsung.getWord();

        assertNotNull(samsung);
        assertThat(word).isEqualTo("samsung");
    }
}