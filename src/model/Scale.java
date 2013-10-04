package model;

public class Scale<T> {

    private T minimum;

    private T maximum;

    private int scaleBy;

    public Scale(T minimum, T maximum, int scaleBy){
        this.minimum = minimum;
        this.maximum = maximum;
        this.scaleBy = scaleBy;
    }
}
