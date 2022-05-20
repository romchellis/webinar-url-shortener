package urlshortener;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RandomSeoGenerator implements Supplier<String> {

    public final static String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    @Override
    public String get() {
        return ThreadLocalRandom.current()
                .ints(20, 0, alphabet.length())
                .mapToObj(it -> alphabet.charAt(it))
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();
    }

}
