package jdeck;

/**
 * This class defines the value of a card. This class defines a description
 * and a numeric value for a card. My object is for this class to be immutable.
 * 
 * @author jon
 *
 */
public final class FaceValue
{
    // This variable contains a String representation of value of a card
    private final String description;
    // This variable contains a numeric value of a card
    private final int value;

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
        return "Name: " + description + " Value: " + value;
    }
    
    /**
     * This method overrides the default hashCode() method. It computes a unique
     * value for this object given the current description and value fields.
     * 
     * @return an int representing the hash code value of this instance
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((description == null) ? 0 : description.hashCode());
        result = prime * result + value;
        return result;
    }

    /**
     * This method overrides the default equals method. It allows two different
     * instantiated FaceValue objects to be the same if their fields contain the
     * same data.
     * 
     * @param obj is a FaceValue object
     * @return true if the objects are equal and false if not
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
        FaceValue other = (FaceValue) obj;
        if (description == null)
        {
            if (other.description != null)
                return false;
        }
        else if (!description.equals(other.description))
            return false;
        if (value != other.value)
            return false;
        return true;
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
