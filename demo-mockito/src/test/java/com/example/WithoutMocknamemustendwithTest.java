package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

// @TestInstance(TestInstance.Lifecycle.PER_METHOD) // default // each method new one obj
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class WithoutMocknamemustendwithTest {



    @Mock
    Calculator calculator; // 在each test new obj, suppost instance is null, @Mock->new that instance

    // @Mock
    @InjectMocks
    Checkout checkout;

    @Test
    void testSubstract() {
        Calculator c1 = new Calculator(3);
        assertEquals(-7, c1.substract(10, 6));
    }

    @Test
    void testAdd1() {
        System.out.println("testAdd1");
        // Checkout checkout = new Checkout(this.calculator); // <=> @InjectMocks Checkout checkout
        // Testign start
        // this.calculator = new Calculator();
        this.checkout = new Checkout(this.calculator);
        // checkout.setCalculator(this.calculator);
        // when(this.calculator.substract(3, 4)).thenReturn(100);
        // this.checkout.setCalculator(this.calculator);
        int result = this.checkout.add(3, 4); // x > 1
        assertEquals(4, result);
        // verify(this.calculator, times(1)).substract(3, 4);
    }

    // @Test
    // void testAdd2() {
    //     System.out.println("testAdd2");
    //     when(this.calculator.substract(1, 4)).thenReturn(1000);
    //     // Checkout checkout = new Checkout(this.calculator); // <=> @InjectMocks Checkout checkout
    //     // Testing Start
    //     int result = this.checkout.add(1, 4);
    //     assertEquals(0, result);
    //     verify(this.calculator, never()).substract(1, 4);
    // }

    // @Test
    // void testMultiply() {
    //     System.out.println("testMultiply");
    //     when(this.calculator.substract(7, 9)).thenReturn(10000);
    //     when(this.calculator.multiply(7, 9)).thenReturn(10000);
    //     int result = this.checkout.multiply(7, 9);
    //     assertEquals(0, result);
    // }

    // @Test
    // void testMultiply2() {

    // }

}
