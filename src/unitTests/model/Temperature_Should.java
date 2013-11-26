package unitTests.model;

import junit.framework.Assert;
import model.Temperature;
import org.junit.Test;

public class Temperature_Should
{
    @Test
    public void toString_ReturnTheCorrectValue()
    {
        Temperature sut = new Temperature(1.0, 2.0, 3.0);

        final String expected = "[model.Temperature] Fahrenheit: 1.0 Celsius: 2.0 Kelvin: 3.0";

        Assert.assertEquals(expected, sut.toString());
    }
}
