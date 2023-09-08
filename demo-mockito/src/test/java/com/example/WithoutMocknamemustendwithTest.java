package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) // default // each method new one obj

public class WithoutMocknamemustendwithTest {

    @Mock
    Calculator calculator; // 在each test new obj, suppost instance is null, @Mock->new that instance

    Checkout checkout;

    @Test
    void testMultiply2() {
        System.out.println("bbebkajsfakhrao");
        // Mockito.when(calculator.substract(3, 8)).thenReturn(10000);
        // Mockito.when(calculator.substract(4123, 1238)).thenReturn(10000); // whatever i write, .multiply =0
        Checkout c = new Checkout(new Calculator());
        assertEquals(32, c.multiply(3, 8)); // return y + this.calculator.multiply(x, y); -> 8+0
    }
 // 未試完.....
}
