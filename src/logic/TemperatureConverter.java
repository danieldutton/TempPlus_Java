package logic;

import logic.interfaces.IConversionFormula;

public class TemperatureConverter {

    private final IConversionFormula conversionFormula;

    public TemperatureConverter(IConversionFormula conversionFormula) {
        this.conversionFormula = conversionFormula;
    }

    public double convert(double fahrenheitTemp){
        return conversionFormula.Convert(fahrenheitTemp);
    }
}
