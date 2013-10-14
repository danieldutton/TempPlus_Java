package tests_unit;

import logic.algorithms.FahrenheitToCelsius;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FahrenheitToCelsiusShould {

    private FahrenheitToCelsius sut;

    @Before
    public void setUp() throws Exception {
        sut = new FahrenheitToCelsius();
    }

    @Test
    public void testConvert(){
        sut = null;
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
    }
}
