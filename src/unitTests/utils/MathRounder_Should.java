package unitTests.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.MathRounder;

public class MathRounder_Should
{
    private final double numToRoundUp = 2.578;

    private final double numToRoundDown = 2.433;

    private static final double DELTA = 1e-8;

    private MathRounder sut;

    @Before
    public void init()
    {
        sut = new MathRounder();
    }

    @Test(expected=IllegalArgumentException.class)
    public void round_throwAnIllegalArgumentExceptionIfPlacesParamIsLessThanZero()
    {
        sut.round(numToRoundUp, -3);
    }

    @Test
    public void round_roundCorrectlyUp_ZeroDP()
    {
        final double expected = 3.0;
        double actual = sut.round(numToRoundUp, 0);

        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void round_roundCorrectlyDown_ZeroDP()
    {
        final double expected = 2.0;
        double actual = sut.round(numToRoundDown, 0);

        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void round_roundCorrectlyUp_OneDP()
    {
        final double expected = 2.6;
        double actual = sut.round(numToRoundUp, 1);

        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void round_roundCorrectlyDown_OneDP()
    {
        final double expected = 2.4;
        double actual = sut.round(numToRoundDown, 1);

        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void round_roundCorrectlyUp_TwoDP()
    {
        final double expected = 2.58;
        double actual = sut.round(numToRoundUp, 2);

        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void round_roundCorrectlyDown_TwoDP()
    {
        final double expected = 2.43;
        double actual = sut.round(numToRoundDown, 2);

        Assert.assertEquals(expected, actual, DELTA);
    }

    @After
    public void tearDown()
    {
        sut = null;
    }
}
