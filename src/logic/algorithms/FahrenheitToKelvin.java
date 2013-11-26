package logic.algorithms;

import logic.interfaces.IConversionFormula;

public class FahrenheitToKelvin implements IConversionFormula {

    public double Convert(double fahrenheitTemp, boolean isRounded) {

        if(isRounded)
            return (fahrenheitTemp + 459.67)/1.8;

        else
            return Math.round(fahrenheitTemp + 459.67)/1.8;
    }
}
