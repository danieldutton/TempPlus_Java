package logic.algorithms;

import logic.interfaces.IConversionFormula;

public class FahrenheitToCelsius implements IConversionFormula {

    public double Convert(double fahrenheitTemp) {

        double result = ((fahrenheitTemp - 32) * 5/9);

        return result;
    }
}
