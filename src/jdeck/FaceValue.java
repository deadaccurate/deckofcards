package jdeck;

public class FaceValue
{
    private String description;
    private int value;

    public FaceValue(String name, int numericValue)
    {
        description = name;
        value = numericValue;
    }

    public String getDescription()
    {
        return description;
    }

    public int getValue()
    {
        return value;
    }
}
