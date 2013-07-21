package jdeck;

/**
 * This class defines a card's suit. The suit contains a name describing it
 * and a color.
 * 
 * @author jon
 *
 */
public class Suit
{
    // This variable contains the description of this suit
    private String name;
    // This variable contains the color of the suit
    private String color;
    
    /**
     * This constructor assigns the suit name and color.
     * 
     * @param suitName is String containing the name of the this suit
     * @param suitColor is a String describing the color of this suit
     */
    public Suit(String suitName, String suitColor)
    {
        name = suitName;
        color = suitColor;
    }
    
    /**
     * Override the toString() method to print the suit's color and name.
     * 
     * @return a String containing the object's color and name
     */
    public @Override String toString()
    {
        return "Color: " + color + "\nName: " + name;
    }
    
    /**
     * A getter to retrieve the description of the suit.
     * 
     * @return a String representing the description of the suit
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * A getter to retrieve the color of the suit.
     * 
     * @return a String representing the color of the suit
     */
    public String getColor()
    {
        return color;
    }
}
