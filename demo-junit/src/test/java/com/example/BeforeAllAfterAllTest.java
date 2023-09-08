package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BeforeAllAfterAllTest {

    private int x;

    // @BeforeAll AfterAll can be instance only if PER_CLASS, cos only one obj, run everything once
    // if PER_METHOD must be static, cos run once before after all obj done
    @BeforeAll
    static void beforeAll() { // @BeforeAll methods must have a void return type and must be static by default.
        System.out.println("beforeAll start");
    }

    @AfterAll
    static void afterAll() { // static
        System.out.println("afterAll start");
    }

    @Test
    void test() {
        x++;
        System.out.println("test x=" + x);
        assertTrue(x == 1);
    }

    @Test
    void test2() {
        x++;
        System.out.println("test2 x=" + x);
        assertTrue(x == 2); // per_class -> 2 ; per_method -> 1
    }

}
