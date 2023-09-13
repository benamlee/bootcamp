package com.example;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import lombok.val;

public class ToleranceTest {

    @Test
    void test() {
        double expected = 3.14;
        double tolerance = 0.01;
        assertThat(3.14159, closeTo(expected, tolerance));
        assertThat(3.14999, closeTo(expected, tolerance));
        assertThat(3.15001, not(closeTo(expected, tolerance)));
        assertThat(3.13000, not(closeTo(expected, tolerance)));
        assertThat(3.13001, closeTo(expected, tolerance));
        assertThat(3.15000, closeTo(expected, tolerance));
    }

    @Test
    void test2() {
        double expected = 100.0;
        double tolerance = 1.0;
        assertThat(99.0, closeTo(expected, tolerance));
        assertThat(101.0, closeTo(expected, tolerance));
    }

    @Test
    void test3() {
        float expected = 3.0f;
        float tolerance = 0.1f;
        assertThat(2.9, closeTo(expected, tolerance));
        assertThat(3.1, closeTo(expected, tolerance));
    }
}
