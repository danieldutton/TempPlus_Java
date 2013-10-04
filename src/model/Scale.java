package model;

public class Scale {

    private int minimum;

    private int maximum;

    private int scaleBy;

    public Scale(int minimum, int maximum, int scaleBy){
        this.minimum = minimum;
        this.maximum = maximum;
        this.scaleBy = scaleBy;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getScaleBy() {
        return scaleBy;
    }

    public void setScaleBy(int scaleBy) {
        this.scaleBy = scaleBy;
    }




}
