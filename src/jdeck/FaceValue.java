package jdeck;

/**
 * This class defines the value of a card. This class defines a description
 * and a numeric value for a card.
 * 
 * @author jon
 *
 */
public class FaceValue
{
    // This variable contains a String representation of value of a card
    private String description;
    // This variable contains a numeric value of a card
    private int value;

    /**
     * This constructor assigns a description and numeric value.
     * 
     * @param name is a String representing the description of the card's value
     * @param numericValue is an integer representation of the card's value 
     */
    public FaceValue(String name, int numericValue)
    {
        description = name;
        value = numericValue;
    }
    
    /**
     * This method overrides the default toString() method.
     * It returns a string representation of the value of the card.
     * 
     * @return a String representing the value of the card
     */
    public @Override String toString()
    {
        return "Name: " + description + "\nValue: " + value;
    }

    /**
     * This getter returns the description of the value of this card.
     * 
     * @return a String representing the value of the card
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * This getter returns the numeric representation of the value of this card.
     * 
     * @return an int representation of the card
     */
    public int getValue()
    {
        return value;
    }
}
