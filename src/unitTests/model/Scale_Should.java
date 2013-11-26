package unitTests.model;

import junit.framework.Assert;
import model.Scale;
import org.junit.Test;

public class Scale_Should
{
    @Test
    public void toString_ReturnTheCorrectValue()
    {
        Scale sut = new Scale(5, 10);

        final String expected = "[model.Scale] minimum: 5 maximum: 10";

        Assert.assertEquals(expected, sut.toString());
    }
}
