package unitTests;

import logic.algorithms.FahrenheitToKelvin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FahrenheitToKelvinTest {

    private FahrenheitToKelvin sut;

    @Before
    public void setUp() throws Exception {
        sut = new FahrenheitToKelvin();
    }

    @Test
    public void testConvert() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        sut = null;
    }
}
