package lab.games;

import static org.junit.Assert.*;
import games.Card;

import java.util.Random;

import org.junit.Test;

public class CardTest 
{
    @Test
    public void testJACK() 
    {
	assertEquals(11, Card.JACK);
    }

    @Test
    public void testQUEEN() 
    {
	assertEquals(12, Card.QUEEN);
    }

    @Test
    public void testKING() 
    {
	assertEquals(13, Card.KING);
    }

    @Test
    public void testACE() 
    {
	assertEquals(14, Card.ACE);
    }

    @Test
    public void testHEARTS() 
    {
	assertEquals(1, Card.HEARTS);
    }

    @Test
    public void testSPADES() 
    {
	assertEquals(2, Card.SPADES);
    }

    @Test
    public void testDIAMONDS() 
    {
	assertEquals(3, Card.DIAMONDS);
    }

    @Test
    public void testCLUBS() 
    {
	assertEquals(4, Card.CLUBS);
    }

    @Test
    public void testGetSuit() 
    {
	for (int number = 2; number <= Card.ACE; number++)
	{
	    final int[] SUIT = { Card.HEARTS, Card.SPADES, Card.DIAMONDS, Card.CLUBS };
	    
	    for (int suit : SUIT)
	    {
		Card card = new Card(suit, number);
		assertEquals(suit, card.getSuit());
	    }
	}
    }

    @Test
    public void testGetNumber() 
    {
	for (int number = 2; number <= Card.ACE; number++)
	{
	    final int[] SUIT = { Card.HEARTS, Card.SPADES, Card.DIAMONDS, Card.CLUBS };
	    
	    for (int suit : SUIT)
	    {
		Card card = new Card(suit, number);
		assertEquals(number, card.getNumber());
	    }
	}
    }

    @Test
    public void testsetSuit() 
    {
	final int[] SUIT = { Card.HEARTS, Card.SPADES, Card.DIAMONDS, Card.CLUBS };

	Random random = new Random(System.currentTimeMillis());
	int suit = SUIT[random.nextInt(SUIT.length)];
	int number = 2 + random.nextInt(Card.ACE - 1);
	Card card = new Card(suit, number);

	for (int s : SUIT)
	{
	    card.setSuit(s);
	    assertEquals(s, card.getSuit());
	}
    }

    @Test
    public void testsetNumber() 
    {
	final int[] SUIT = { Card.HEARTS, Card.SPADES, Card.DIAMONDS, Card.CLUBS };

	Random random = new Random(System.currentTimeMillis());
	int suit = SUIT[random.nextInt(SUIT.length)];
	int number = 2 + random.nextInt(Card.ACE - 1);
	Card card = new Card(suit, number);

	for (int n = 2; n <= Card.ACE; n++)
	{
	    card.setNumber(n);
	    assertEquals(n, card.getNumber());
	}
    }

    @Test
    public void testEquals() 
    {
	final int[] SUIT = { Card.HEARTS, Card.SPADES, Card.DIAMONDS, Card.CLUBS };

	for (int suit1 : SUIT)
	{
	    for (int suit2 : SUIT) // very risky to use very similar variable names such as suit1 and suit2
	    {
		for (int number1 = 2; number1 <= Card.ACE; number1++)
		{
		    Card card1 = new Card(suit1, number1);
				
		    for (int number2 = 2; number2 <= Card.ACE; number2++)
		    {
			Card card2 = new Card(suit2, number2);
			if (suit1 == suit2 && number1 == number2)
			{
			    assertTrue(card1.equals(card2));
			}
			else
			{
			    assertFalse(card1.equals(card2));
			}
		    }

		    Object object = new Object();
		    assertFalse(card1.equals(object));
		    assertFalse(card1.equals(null));
		}
	    }
	}
    }

    @Test
    public void testToString()
    {
	for (int number = 2; number <= Card.ACE; number++)
	{
	    final int[] SUIT = { Card.HEARTS, Card.SPADES, Card.DIAMONDS, Card.CLUBS };
	    
	    for (int suit : SUIT)
	    {
		Card card = new Card(suit, number);
		StringBuffer representation = new StringBuffer(card.toString());
		
		switch (representation.charAt(0))
		{
		case 'J' :
		    assertEquals(number, Card.JACK);
		    break;
		case 'Q' :
		    assertEquals(number, Card.QUEEN);
		    break;
		case 'K' :
		    assertEquals(number, Card.KING);
		    break;
		case 'A' :
		    assertEquals(number, Card.ACE);
		    break;
		case '1' :
		    assertEquals(number, 10);
		    assertEquals('0', representation.charAt(1));
		    representation.deleteCharAt(0);
		    break;
		default:
		    assertEquals(number, representation.charAt(0) - '0');
		    break;
		}
		
		switch ((int) representation.charAt(1))
		{
		case 9829 :
		    assertEquals(Card.HEARTS, suit);
		    break;
		case 9824 :
		    assertEquals(Card.SPADES, suit);
		    break;
		case 9830 :
		    assertEquals(Card.DIAMONDS, suit);
		    break;
		case 9827 :
		    assertEquals(Card.CLUBS, suit);
		    break;
		default :
		    fail();
		}
	    }
	}
    }

    @Test
    public void testCompareTo() 
    {
	final int[] SUIT = { Card.HEARTS, Card.SPADES, Card.DIAMONDS, Card.CLUBS };

	for (int suit1 : SUIT)
	{
	    for (int suit2 : SUIT)
	    {
		for (int number1 = 2; number1 <= Card.ACE; number1++)
		{
		    Card card1 = new Card(suit1, number1);
		    
		    for (int number2 = 2; number2 <= Card.ACE; number2++)
		    {
			Card card2 = new Card(suit2, number2);
			if (suit1 < suit2)
			{
			    assertTrue(card1.compareTo(card2) < 0);
			}
			else if (suit1 == suit2)
			{
			    if (number1 < number2)
			    {
				assertTrue(card1.compareTo(card2) < 0);
			    }
			    else if (number1 == number2)
			    {
				assertEquals(0, card1.compareTo(card2));
			    }
			    else
			    {
				assertTrue(card1.compareTo(card2) > 0);
			    }
			}
			else
			{
			    assertTrue(card1.compareTo(card2) > 0);
			}
		    }
		}
	    }
	}
    }

    @Test(expected=NullPointerException.class)
    public void testCompareToException() 
    {
	final int[] SUIT = { Card.HEARTS, Card.SPADES, Card.DIAMONDS, Card.CLUBS };

	Random random = new Random(System.currentTimeMillis());
	int suit = SUIT[random.nextInt(SUIT.length)];
	int number = 2 + random.nextInt(Card.ACE - 1);
	Card card = new Card(suit, number);

	card.compareTo(null);
    }
}