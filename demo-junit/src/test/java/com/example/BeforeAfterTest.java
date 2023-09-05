package com.example;

import static org.junit.jupiter.api.Assertions.*; // 有static->下面唔洗打class名,*->包哂所有method
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BeforeAfterTest {

    private int x;

    @BeforeEach // do once before each test
    void configuration() {
        System.out.println("before each start!!");
        // assertEquals(0, x);
        x += 3;
        System.out.println(x);
    }

    @AfterEach
    void endOfTest() {
        System.out.println("endOfTest start");
        this.x -= 2;
        System.out.println("ended. x=" + x);
    }

    @Test
    void testAdd() {
        System.out.println("testAdd start1");
        // assertEquals(8, App.add(this.x, 5));
        System.out.println(x);
    }

    @Test
    void testAdd2() {
        System.out.println("testAdd start2");
        // assertEquals(8, App.add(this.x, 5));
        System.out.println(x);
    }
}

// PER_CLASS

// before each start!!
// 3
// testAdd start1
// 3
// endOfTest start
// ended. x=1
// before each start!!
// 4
// testAdd start2
// 4
// endOfTest start
// ended. x=2
