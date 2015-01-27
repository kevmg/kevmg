package games;

public class Card {
	/*  
	 * Field Suit
	 */
	public static final int SPADES = 2;
	public static final int CLUBS = 4;
	public static final int DIAMONDS = 3;
	public static final int HEARTS = 1;
	
	/*
	 * Field number
	 */
	public static final int ACE = 14;
	public static final int KING = 13;
	public static final int QUEEN = 12;
	public static final int JACK = 11;
	
	private int suit;
	private int number;
	
	// Constructor
	public Card (int suit, int number) {
		if (suit == Card.HEARTS || suit == Card.SPADES || suit == Card.DIAMONDS || suit == Card.CLUBS) {
		this.suit = suit;
		} else {
			// so that the suits are correctly used
			System.out.println("Must put in the correct corresponding suit number: ");
			System.out.println("HEARTS = 1: ");
			System.out.println("SPADES = 2: ");
			System.out.println("DIAMONDS = 3: ");
			System.out.println("CLUBS = 4: ");
		}
		
		if (2 <= number && number <= Card.ACE) {
		this.number = number;
		} else {
			System.out.println("Must put in the correct number between 2 - 14");
		}
		return;
	}
	
	//Method
	public int compareTo(Card other) {
		try {
			
		}catch (NullPointerException e) {
			System.out.println("The card can't be empty.");
		}
		return 0;
	}
	
	public boolean equals(Card object) {
		//need to see if they're the same
		int suit1 = this.getSuit();
		int number1 = this.getNumber();
		int suit2 = object.getSuit();
		int number2 = object.getNumber();
		
		boolean match = suit1==suit2 && number1==number2;
		return match;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public int getSuit() {
		return this.suit;
	}
	
	public int setNumber(int number) {
		return number = this.number;
	}
	
	 public int setSuit(int suit) {
		if (suit == Card.HEARTS || suit == Card.SPADES || suit == Card.DIAMONDS || suit == Card.CLUBS) {
		 return suit = this.suit;
		}else{
			System.out.println("Must put in the correct corresponding suit number: ");
			System.out.println("HEARTS = 1: ");
			System.out.println("SPADES = 2: ");
			System.out.println("DIAMONDS = 3: ");
			System.out.println("CLUBS = 4: ");
		}
		return suit;
	}
	
	public String toString() {
		return null;
	}

}
