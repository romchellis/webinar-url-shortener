package urlshortener;

import static urlshortener.validation.Validation.requireAlphabetic;
import static urlshortener.validation.Validation.requireMaxLength;
import static urlshortener.validation.Validation.requireNonBlank;
import static urlshortener.validation.Validation.requireNonNull;

public class SeoKeyword {
    private final String word;

    private SeoKeyword(String word) {
        requireNonNull(word, "Seokeyword cannot be constructed with null word");
        requireNonBlank(word, "Seokeyword cannot be constructed with blank word");
        requireAlphabetic(word, "Seokeyword cannot be constructed with non aplha characters");
        requireMaxLength(word, 20, "Seokeyword length cannot longer than 20 symbols");
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public static SeoKeyword seoKeyword(String word) {
        return new SeoKeyword(word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeoKeyword)) return false;

        SeoKeyword that = (SeoKeyword) o;

        return getWord() != null ? getWord().equals(that.getWord()) : that.getWord() == null;
    }

    @Override
    public int hashCode() {
        return getWord() != null ? getWord().hashCode() : 0;
    }
}
