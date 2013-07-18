package jdeck;

public class Suit
{
    private String name;
    private String color;
    
    public Suit(String suitName, String suitColor)
    {
        name = suitName;
        color = suitColor;
    }
    
    public @Override String toString()
    {
        return "Color: " + color + "Name: " + name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getColor()
    {
        return color;
    }
}
