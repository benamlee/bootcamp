package com.example;

import static org.junit.jupiter.api.Assertions.*; // 有static->下面唔洗打class名,*->包哂所有method
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

// @TestInstance(TestInstance.Lifecycle.PER_CLASS) // use only one obj to run all method
@TestInstance(TestInstance.Lifecycle.PER_METHOD) // default // each method new one obj
public class AssertTest {

    private int x;

    // each one is instance method and has its x
    // so each test create new object and each x++ then = 1
    @Test
    void testAssertEqual() {
        // Assertions.assertEquals(expected value, actual value)
        assertEquals(5, App.add(2, 3));
        assertEquals(5, App.add(2, 3));
        x++;
        assertEquals(1, x);
    }

    @Test
    void testAssertNotEqual() {
        assertNotEquals(4, App.add(1, 2));
        x++;
        assertEquals(1, x);
    }

    @Test
    void testAssertTrue() {
        assertTrue(12 == App.add(7, 5));
    }

    @Test
    void testAssertFalse() {
        assertFalse(13 == App.add(2, 3));
    }

    @Test
    void testAssertNull() {
        String str = null;
        assertNull(str);
    }

    @Test
    void testAssertNotNull() {
        Student student = new Student();
        assertNotNull(student.getSubjects());
    }

    @Test
    void testAssertThrows() {
        assertThrows(ArithmeticException.class, () -> {
            App.divide(10, 0);
        });
        assertDoesNotThrow(() -> {
            App.divide(10, 5);
        });
    }

    @Test
    void testAssertTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50); // ms
        });
    }

    @Test
    void testCombine() {
        assertAll( //
                () -> assertTrue(10 > 3), //
                () -> assertEquals(10, App.add(4, 6)), //
                () -> assertNull(null) //
        );
    }

    @Test
    void testSame() {
        String s1 = new String("JUnit");
        String s2 = new String("JUnit");
        assertNotSame(s1, s2); // check reference
        assertEquals(s1, s2); // check value

        String s3 = "JUnit";
        String s4 = "JUnit";
        assertSame(s3, s4);
        assertEquals(s3, s4);
    }

    // public static void main(String[] args) {
    // AppTest t1 = new AppTest();
    // t1.testAssertEqual();
    // AppTest t2 = new AppTest();
    // t2.testAssertNotEqual();
    // }
}
