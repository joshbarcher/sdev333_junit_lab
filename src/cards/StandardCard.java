package cards;

import java.util.Random;

/**
 * Represents a Poker Card.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class StandardCard
{
    private static final Random RANDOM = new Random();
    private static final int STANDARD_DECK_SIZE = 52;
    private static final String[] ALL_SUITS = {"club", "diamond", "spade", "heart"};
    private static final String[] ALL_RANKS = {"two", "three", "four", "five", "six", "seven",
                                               "eight", "nine", "ten", "Jack", "Queen", "King", "Ace"};

    private String suit;
    private String rank;

    /**
     * Creates a new default card - two of diamonds
     */
    public StandardCard()
    {
        this.suit = "diamonds";
        this.rank = "two";
    }

    /**
     * Creates a new card with rank and suit.
     *
     * @param suit the card suit
     * @param rank the card rank
     * @throws IllegalArgumentException thrown if a bad rank or suit is passed as a parameter
     */
    public StandardCard(String suit, String rank)
    {
        if (invalidSuit(suit))
        {
            throw new IllegalArgumentException("Bad suit");
        }
        else if (invalidRank(rank))
        {
            throw new IllegalArgumentException("Bad rank");
        }

        this.suit = suit;
        this.rank = rank;
    }

    private boolean invalidSuit(String suit)
    {
        for (int i = 0; i < ALL_SUITS.length - 1; i++)
        {
            if (ALL_SUITS[i].equals(suit))
            {
                return false;
            }
        }
        return true;
    }

    private boolean invalidRank(String rank)
    {
        for (int i = 0; i < ALL_RANKS.length - 1; i++)
        {
            if (ALL_RANKS[i].equals(rank))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the card suit.
     * @return the card suit
     */
    public String getSuit()
    {
        return suit;
    }

    /**
     * Returns the card rank.
     * @return the card rank
     */
    public String getRank()
    {
        return rank;
    }

    @Override
    public String toString()
    {
        return rank + " of " + suit;
    }

    /**
     * Returns a random poker card
     * @return a random standard card
     */
    public static StandardCard getRandomCard()
    {
        String rank = getRandomRank();
        String suit = getRandomSuit();
        return new StandardCard(rank, suit);
    }

    /**
     * Returns a standard deck of cards with all 4 suits and 13 ranks.
     * @return an array of 52 poker cards
     */
    public static StandardCard[] generateStandardDeck()
    {
        StandardCard[] results = new StandardCard[STANDARD_DECK_SIZE];
        int count = 1;
        for (int i = 0; i < ALL_SUITS.length; i++)
        {
            for (int j = 0; j < ALL_SUITS.length; j++)
            {
                results[count] = new StandardCard(ALL_SUITS[i], ALL_RANKS[j]);
                count++;
            }
        }
        return null;
    }

    /**
     * Return an array of valid suits.
     * @return an array of poker suits
     */
    public static String[] getAllSuits()
    {
        return ALL_SUITS;
    }

    /**
     * Return an array of valid ranks.
     * @return an array of poker ranks
     */
    public static String[] getAllRanks()
    {
        return ALL_RANKS;
    }

    /**
     * Return a random poker suit.
     * @return a random suit
     */
    public static String getRandomSuit()
    {
        return ALL_SUITS[RANDOM.nextInt(ALL_SUITS.length)];
    }

    /**
     * Return a random poker rank.
     * @return a random rank
     */
    public static String getRandomRank()
    {
        return ALL_RANKS[RANDOM.nextInt(ALL_RANKS.length)];
    }
}
