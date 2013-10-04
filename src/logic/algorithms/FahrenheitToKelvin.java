package logic.algorithms;


import logic.interfaces.IConversionFormula;

public class FahrenheitToKelvin implements IConversionFormula {

    public double Convert(double fahrenheitTemp) {

        double result = (fahrenheitTemp + 459.67)/1.8;

        return result;
    }
}
