package com.example;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class TypeTest {
    @Test
    void testType() {
        Object object = "Hello world";
        assertThat(object, instanceOf(String.class));
        assertThat(object, not(instanceOf(Integer.class))); // input object
    }

    @Test
    void testIfClassIsCompatibleWith() {
        assertThat(Integer.class, is(typeCompatibleWith(Number.class)));
        assertThat(Integer.class, is(typeCompatibleWith(Object.class)));
        assertThat(Number.class, is(not(typeCompatibleWith(Integer.class)))); // have to input a class
    }
}
