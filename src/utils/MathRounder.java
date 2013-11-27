package utils;

import java.math.BigDecimal;

public class MathRounder implements MathRoundable
{
    public double round(double value, int places)
    {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(places, BigDecimal.ROUND_HALF_UP);

        return bigDecimal.doubleValue();
    }
}
