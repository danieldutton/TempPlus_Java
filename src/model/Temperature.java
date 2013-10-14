package model;


public class Temperature {

    private double fahrenheit;
    private double celsius;
    private double kelvin;


    public Temperature(double fahrenheit, double celsius, double kelvin){
        this.fahrenheit = fahrenheit;
        this.kelvin = kelvin;
        this.celsius = celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celcius) {
        this.celsius = celcius;
    }

    public double getKelvin() {
        return kelvin;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }
}
