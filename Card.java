
public class Card {
	private Suit suit;
	private Value value;
	
	//getters
	public Value getValue()
	{
		return this.value;
	}
	public Suit getsuit()
	{
		return this.suit;
	}
	//constructor
	public Card(Suit s, Value v)
	{
		this.suit = s;
		this.value = v;
	}
	public String toString()
	{
		return this.suit.toString() + " " + this.value.toString(); 
	}
	
	
}
