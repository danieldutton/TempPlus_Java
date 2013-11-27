package unitTests;

import logic.algorithms.FahrenheitToCelsius;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class FahrenheitToCelcius_Should {

    private static FahrenheitToCelsius fahrenheitToCelsius = new FahrenheitToCelsius();

    private double input;
    private double expected;
    private static final double DELTA = 1e-8;

    public FahrenheitToCelcius_Should(double input, double expected){
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]>data(){
        return Arrays.asList(new Object[][]{
            {0,-18},
            {1.0,-17},
            {2.0,-17}
        });
    }

    @Test
    public void testQuotes(){
        assertEquals(expected, fahrenheitToCelsius.Convert(input, true), DELTA);
    }

}
