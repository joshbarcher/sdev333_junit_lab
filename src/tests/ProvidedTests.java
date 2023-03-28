package tests;

import cards.StandardCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProvidedTests
{
    @Test
    public void newCardTest()
    {
        StandardCard card = new StandardCard("spade", "king");
        assertEquals(card.toString(), "king of spade");
    }

    @Test
    public void defaultCardTest()
    {
        StandardCard defaultCard = new StandardCard();
        assertEquals(defaultCard.toString(), "two of diamond");
    }

    @Test
    public void invalidCardTest()
    {
        //instantiate a new card with bad parameters
        assertThrows(IllegalArgumentException.class, () -> new StandardCard("hearts", "7"));
    }
}
