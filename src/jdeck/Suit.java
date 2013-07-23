package jdeck;

/**
 * This class defines a card's suit. The suit contains a name describing it
 * and a color. This class should be immutable.
 * 
 * @author jon
 *
 */
public final class Suit
{
    // This variable contains the description of this suit
    private final String name;
    // This variable contains the color of the suit
    private final String color;
    
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
    @Override
    public String toString()
    {
        return "Color: " + color + " Name: " + name;
    }
    
    /**
     * This method creates a hash code unique to this Suit object based on
     * the values it contains.
     * 
     * @return an int representing the Suit object
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * This method overrides the default equals method. It determines if two
     * Suits are equal or not.
     * 
     * @param obj is a Suit object
     * @return true if the passed in Suit object equates to this
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Suit other = (Suit) obj;
        if (color == null)
        {
            if (other.color != null)
                return false;
        }
        else if (!color.equals(other.color))
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        return true;
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
