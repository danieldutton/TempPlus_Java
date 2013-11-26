package logic.algorithms;

import logic.interfaces.IConversionFormula;

public class FahrenheitToCelsius implements IConversionFormula {

    public double Convert(double fahrenheitTemp, boolean isRounded) {

        if(!isRounded)
            return ((fahrenheitTemp - 32) * 5/9);

        else
            return Math.round(((fahrenheitTemp - 32) * 5/9));
    }
}
