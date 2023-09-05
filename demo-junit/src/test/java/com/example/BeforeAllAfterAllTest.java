package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class BeforeAllAfterAllTest {

    private int x;

    @BeforeAll
    static void beforeAll() { // static
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
        assertTrue(x == 2);
    }

}
