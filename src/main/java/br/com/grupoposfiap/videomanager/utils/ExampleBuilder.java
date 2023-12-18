package br.com.grupoposfiap.videomanager.utils;

public class ExampleBuilder {

    public static <T> Example<T> of(T example) {
        ExampleMatcher matcher = ExampleMatcher
            .matching()
            .withIgnoreNullValues()
            .withMatcher("title", exact ())
            .withMatcher("publishDate", exact ());

        return Example.of(example, matcher);
    }
}