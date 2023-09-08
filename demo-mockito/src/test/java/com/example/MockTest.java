package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MockTest {

    @Mock
    Calculator calculator; // 在each test new obj, suppost instance is null, @Mock->new that instance

    @InjectMocks
    Checkout checkout;

    @Test
    void testSubstract() {
        Calculator c1 = new Calculator(3);
        assertEquals(-7, c1.substract(10, 6));
    }

    @Test
    void testAdd1() {
        Mockito.when(this.calculator.substract(3, 4)).thenReturn(100);
        // Checkout checkout = new Checkout(this.calculator); // <=> @InjectMocks Checkout checkout
        // Testing Start
        int result = checkout.add(3, 4); // x > 1
        assertEquals(104, result);
        verify(this.calculator, times(1)).substract(3, 4);
    }

    @Test
    void testAdd2() {
        Mockito.when(this.calculator.substract(1, 4)).thenReturn(1000);
        // Checkout checkout = new Checkout(this.calculator); // <=> @InjectMocks Checkout checkout
        // Testing Start
        int result = checkout.add(1, 4);
        assertEquals(5, result);
        verify(calculator, Mockito.never()).substract(1, 4);
    }

    @Test
    void testMultiply() {
        Mockito.when(calculator.substract(7, 9)).thenReturn(10000);
        Mockito.when(calculator.multiply(7, 9)).thenReturn(10000);
        int result = checkout.multiply(7, 9);
        assertEquals(10009, result);
    }

    @Test
    void testMultiply2() {
        System.out.println("bbebkajsfakhrao");
        // Mockito.when(calculator.substract(3, 8)).thenReturn(10000);
        // Mockito.when(calculator.substract(4123, 1238)).thenReturn(10000); // whatever i write, .multiply =0
        int result = checkout.multiply(3, 8); // cos here have when .substract -> .multiply will assume = 0
        assertEquals(8, result); // return y + this.calculator.multiply(x, y); -> 8+0
    }

    @Test
    void testBen() {
        // Mockito.when(calculator.substract(1, 2)).thenReturn(500);

    }
}
