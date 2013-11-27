package logic.algorithms;

import logic.interfaces.IConversionFormula;
import utils.MathRoundable;

public class FahrenheitToKelvin implements IConversionFormula
{
    private final MathRoundable mathRounder;

    public FahrenheitToKelvin(MathRoundable mathRounder){
        this.mathRounder = mathRounder;
    }

    public double Convert(double fahrenheitTemp, boolean isRounded)
    {
        if(!isRounded)
            return mathRounder.round(((fahrenheitTemp + 459.67)/1.8),2);
        else
            return mathRounder.round(((fahrenheitTemp + 459.67)/1.8), 0);
    }
}
