package tests_unit;

import logic.algorithms.FahrenheitToCelsius;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ParameterisedTests {

    private static FahrenheitToCelsius fahrenheitToCelsius = new FahrenheitToCelsius();

    private double input;
    private double expected;

    public ParameterisedTests(int input, int expected){
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]>data(){
        return Arrays.asList(new Object[][]{
            {5.0,5.0},
            {5.0,10.0},
            {6.0,4.0}
        });
    }

    @Test
    public void testQuotes(){
        assertEquals(expected, fahrenheitToCelsius.Convert(input, true));
    }

}
