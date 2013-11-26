package model;

public class Scale
{
    private int minimum;

    private int maximum;


    public Scale(int minimum, int maximum)
    {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getMinimum()
    {
        return minimum;
    }

    public int getMaximum()
    {
        return maximum;
    }
}
