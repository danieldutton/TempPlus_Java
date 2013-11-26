package model;

public class Temperature
{
    private double fahrenheit;
    private double celsius;
    private double kelvin;


    public Temperature(double fahrenheit, double celsius, double kelvin)
    {
        this.fahrenheit = fahrenheit;
        this.kelvin = kelvin;
        this.celsius = celsius;
    }

    public double getFahrenheit()
    {
        return fahrenheit;
    }

    public double getCelsius()
    {
        return celsius;
    }

    public double getKelvin()
    {
        return kelvin;
    }

    public String toString()
    {
        return "[" + getClass().getName() + "] " + "Fahrenheit: " + getFahrenheit() + " Celsius: "
                   + getCelsius() + " Kelvin: " + getKelvin();
    }
}
