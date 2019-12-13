
import java.util.ArrayList;

public class Deck{
	//extends PitchDealer{
	private ArrayList<Card> cards;
	private int cardNum;
	//getters and setters
	public ArrayList<Card> getCards()
	{
		return this.cards;
	}
	public int getCardNum()
	{
		return this.cardNum;
	}
	public void setCardNum(int n)
	{
		this.cardNum = n;
	}
	public Card deleteNthCard(int n)
	{
		Card c = this.cards.get(n);
		this.cards.remove(n);
		this.cardNum --;
		return c;
	}
	public Card deleteACard(Card c)
	{
		for(Card aCard : this.cards)
		{
			if(aCard.getsuit() == c.getsuit() && aCard.getValue() == c.getValue())
			{
				this.cards.remove(aCard);
				this.cardNum --;
				return aCard;
			}
		}
		return null;
	}
	public Card getNthCard(int n)
	{
		return this.cards.get(n);
	}
	
	public void addCard(Card newCard)
	{
		this.cards.add(newCard);
		this.cardNum ++;
	}
	
	//constructor
	public Deck()
	{
		this.cards = new ArrayList<Card>();
		this.cardNum = 0;
	}
	
	public void createDeck()
	{
		//Generate cards
		for(Suit cardSuit : Suit.values())
		{
			for(Value cardValue : Value.values())
			{
				//add a new card
				this.cards.add(new Card(cardSuit, cardValue));
			}
		}
		this.cardNum = 52;
	}
	
	public void printCards() 
	{
		for(Card aCard : this.cards)
		{
			System.out.println( aCard.getsuit() + " " + aCard.getValue());
		}
	}
	
	public Card searchValue(Value v)
	{
		for(Card aCard : this.cards)
		{
			if(aCard.getValue() == v)
			{
				return aCard;
			}
		}
		return null;
	}

	public Card searchSuit(Suit s)
	{
		for(Card aCard : this.cards)
		{
			if(aCard.getsuit() == s)
			{
				return aCard;
			}
		}
		return null;
	}
	
	public int searchNumSameSuit(Suit s)
	{
		int i = 0;
		for(Card aCard : this.cards)
		{
			if(aCard.getsuit() == s)
			{
				i++;
			}
		}
		return i;
	}
	public Card findCard(Suit s, Value v)
	{
		
		for(Card aCard : this.cards)
		{
			if(aCard.getsuit() == s && aCard.getValue() == v)
			{
				return aCard;
			}
		}
		return null;
	}
	public boolean isTrumpPlayed(Deck played, Suit s)
	{
		for(Card aCard : played.cards)
		{
			if(aCard.getsuit() == s)
			{
				return true;
			}
		}
		return false;
	}
	public void addBackCards(Deck from, Deck to)
	{
		if(from != null)
		{
			for(Card aCard : from.cards)
			{
				from.deleteACard(aCard);
				to.addCard(aCard);
			}
		}
	}
	public void shuffle()
	{
		ArrayList<Card> tmpDeck = new ArrayList<Card>();
		int randomNum = 0;
		int counter;
		int deckSize = this.cards.size();
		int tmpSize = this.cards.size();
		for(counter = 0; counter < deckSize; counter++)
		{
			//Generate a random number can be use as index 
			 randomNum = (int)(Math.random()* tmpSize);
			 //System.out.println(randomNum);
			 //add to tmp deck
			 tmpDeck.add(this.cards.get(randomNum));
			 //delete from cards deck
			 this.cards.remove(randomNum);
			 tmpSize--;
		}
		this.cards = tmpDeck;//let cards equal to tmpDeck which is shuffled
	}
	
}
