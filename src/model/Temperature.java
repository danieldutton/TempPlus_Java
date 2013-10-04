package model;


public class Temperature<T> {

    public T getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(T fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public T getCelcius() {
        return celcius;
    }

    public void setCelcius(T celcius) {
        this.celcius = celcius;
    }

    public T getKelvin() {
        return kelvin;
    }

    public void setKelvin(T kelvin) {
        this.kelvin = kelvin;
    }

    private T fahrenheit;

    private T celcius;

    private T kelvin;

    public Temperature(T fahrenheit, T celcius, T kelvin){
        this.fahrenheit = fahrenheit;
        this.kelvin = kelvin;
        this.celcius = celcius;
    }

}
