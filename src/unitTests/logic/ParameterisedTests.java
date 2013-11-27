package unitTests.logic;

import junit.framework.Assert;
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

    private static double input;
    private static double expected;

    public ParameterisedTests(int input, int expected){
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]>data(){
        return Arrays.asList(new Object[][]{
            {0,32},

        });
    }

    @Test
    public void testQuotes(){
        Assert.assertEquals(expected, fahrenheitToCelsius.Convert(input, true));

    }

}
