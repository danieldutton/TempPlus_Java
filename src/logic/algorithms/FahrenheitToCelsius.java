package logic.algorithms;

import logic.interfaces.IConversionFormula;
import utils.MathRoundable;

public class FahrenheitToCelsius implements IConversionFormula
{
    private final MathRoundable mathRounder;

    public FahrenheitToCelsius(MathRoundable mathRounder){
        this.mathRounder = mathRounder;
    }

    public double Convert(double fahrenheitTemp, boolean isRounded)
    {
        if(!isRounded)
            return mathRounder.round(((fahrenheitTemp - 32) * 5/9), 2);
        else
            return mathRounder.round((((fahrenheitTemp - 32) * 5/9)), 0);
    }
}
