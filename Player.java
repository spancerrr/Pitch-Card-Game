import java.util.ArrayList;
import java.util.Iterator;

public class Player extends PitchDealer{

	private Deck hand = new Deck();
	private Deck winCard = new Deck();
	private int numPlayer = 0;
	private int score = 0;
	private int roundScore = 0;
	private int bid = 0;
	private String card;
	
	
	public void setWinCard(Card win)
	{
		this.winCard.addCard(win);
	}
	public Deck getWinCard()
	{
		return this.winCard;
	}
	public void setBid(int b)
	{
		this.bid = b;
	}
	public int getBid()
	{
		return this.bid;
	}
	
	public void addRoundScore()
	{
		this.roundScore ++;
	}
	public void setRoundScore(int s)
	{
		this.roundScore = s;
	}
	public int getRoundScore()
	{
		System.out.println("roundScore: " + this.roundScore);
		return this.roundScore;
	}
	public void setScore(int s)
	{
		this.score = s;
		System.out.println("Score: " + this.score);
	}
	public int getScore()
	{
		return this.score;
	}
	
	public void setNumPlayer(int number)
	{
		numPlayer = number;
	}
	public int getNumPlayer()
	{
		return numPlayer;
	}
	
	public Deck getHand()
	{
		return this.hand;
	}
	
	public void setHand(Deck h)
	{
		hand = h;
	}
	public void getCards(int number,Deck coming)
	{
		dealCards(number,hand,coming,"player");
	}
	public String cardLabel(int n)
	{
		card = hand.getNthCard(n).toString();
		return card;
	}
}
