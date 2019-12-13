import java.util.ArrayList;
import java.util.Iterator;

public class PitchDealer extends Deck implements Iterator{

	private Card myDeck;
	private Deck played = new Deck();
	private Deck winDeck = new Deck();
	private Deck trumpPlayed = new Deck();
	private int cardNumber;
	private ArrayList<Integer> allBids = new ArrayList();
	int[] is = {2,3,4,5,0,0,0,0};
	private ArrayList<Integer> playerBids = new ArrayList();
	private Suit trump;
	private int whoStart = 0;
	
	
//functions for place bids
	public void setTrump(Suit trumps)
	{
		trump = trumps;
	}
	public Suit getTrump()
	{
		return trump;
	}
	public void initalBids()
	{
		allBids.clear();
		for(int i: is)
		{
			allBids.add(i);
		}
		playerBids.clear();
		playerBids = new ArrayList();
	}
	public ArrayList<Integer> getAvaBids()
	{
		return allBids;
	}
	public ArrayList<Integer> getPlayerBids()
	{
		return playerBids;
	}
	public boolean deleteBids(int bids,ArrayList<Integer> from, ArrayList<Integer> to)
	{
		for(Integer bid : from)
		{
			if(bid.equals(bids))
			{
				from.remove(bid);
				to.add(bid);
				System.out.println("allBids: " + from);

				System.out.println("playerBids: " + to);
				return true;
			}
		}
		return false;
	}
	public void addPlayerBids(int bids,ArrayList<Integer> to)
	{
		to.add(bids);
		System.out.println("playerBids: " + to);
	}
	public boolean isAvaliable(int bids,ArrayList<Integer> allBid)
	{
		for(Integer bid : allBid)
		{
			if(bid.equals(bids))
			{
				return true;
			}
		}
		return false;
	}

//functions for card that players played
	public void resetCardPlayed()
	{
		played.getCards().clear();
		played = new Deck();
	}
	public void addCardPlayed(Card c)
	{
		played.addCard(c);
		System.out.println("Card Played: ");
		played.printCards();
	}
	
	public Deck getCardPlayed()
	{
		return this.played;
	}
	public void setwhoStart(int s)
	{
		this.whoStart = s;
	}
	public int getWhoStart()
	{
		return this.whoStart;
	}
	public int deterRound(Deck cardPlayed,Suit trump,int n)
	{
		Card c1 = cardPlayed.getNthCard(0);
		Card c2 = cardPlayed.getNthCard(1);
		Card c3 = null;
		if(n > 2)
			c3 = cardPlayed.getNthCard(2);
		Card c4 = null;
		if(n > 3)
			c4 = cardPlayed.getNthCard(3);
		if(n == 4)
		{
		if(c1.getsuit() == trump && c2.getsuit() == trump && c3.getsuit() == trump && c4.getsuit() == trump)
		{
			if(c1.getValue().compareTo(c2.getValue()) > 0 && c1.getValue().compareTo(c3.getValue()) > 0 &&c1.getValue().compareTo(c4.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 3)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 4)
				{
					whoStart = 4;
					return 4;
				}
			}
			if(c2.getValue().compareTo(c1.getValue()) > 0 && c2.getValue().compareTo(c3.getValue()) > 0 &&c2.getValue().compareTo(c4.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 2)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 3)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 4)
				{
					whoStart = 1;
					return 1;
				}
			}
			if(c3.getValue().compareTo(c1.getValue()) > 0 && c3.getValue().compareTo(c2.getValue()) > 0 &&c3.getValue().compareTo(c4.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 2)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 3)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 4)
				{
					whoStart = 2;
					return 2;
				}
			}
			if(c4.getValue().compareTo(c1.getValue()) > 0 && c4.getValue().compareTo(c2.getValue()) > 0 &&c4.getValue().compareTo(c3.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 2)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 3)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 4)
				{
					whoStart = 3;
					return 3;
				}
			}
		}
		if(c1.getsuit() == trump && c2.getsuit() == trump && c3.getsuit() == trump && c4.getsuit() != trump)
		{
			if(c1.getValue().compareTo(c2.getValue()) > 0 && c1.getValue().compareTo(c3.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 3)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 4)
				{
					whoStart = 4;
					return 4;
				}
			}
			if(c2.getValue().compareTo(c1.getValue()) > 0 && c2.getValue().compareTo(c3.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 2)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 3)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 4)
				{
					whoStart = 1;
					return 1;
				}
			}
			if(c3.getValue().compareTo(c1.getValue()) > 0 && c3.getValue().compareTo(c2.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 2)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 3)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 4)
				{
					whoStart = 2;
					return 2;
				}
			}
		}
		if(c1.getsuit() == trump && c2.getsuit() == trump && c4.getsuit() == trump && c3.getsuit() != trump)
		{
			if(c1.getValue().compareTo(c2.getValue()) > 0 && c1.getValue().compareTo(c4.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 3)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 4)
				{
					whoStart = 4;
					return 4;
				}
			}
			if(c2.getValue().compareTo(c1.getValue()) > 0 && c2.getValue().compareTo(c4.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 2)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 3)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 4)
				{
					whoStart = 1;
					return 1;
				}
			}
			if(c4.getValue().compareTo(c1.getValue()) > 0 && c4.getValue().compareTo(c2.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 2)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 3)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 4)
				{
					whoStart = 3;
					return 3;
				}
			}
		}
		if(c1.getsuit() == trump && c4.getsuit() == trump && c3.getsuit() == trump && c2.getsuit() != trump)
		{
			if(c1.getValue().compareTo(c4.getValue()) > 0 && c1.getValue().compareTo(c3.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 3)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 4)
				{
					whoStart = 4;
					return 4;
				}
			}
			if(c4.getValue().compareTo(c1.getValue()) > 0 && c4.getValue().compareTo(c3.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 2)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 3)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 4)
				{
					whoStart = 3;
					return 3;
				}
			}
			if(c3.getValue().compareTo(c1.getValue()) > 0 && c3.getValue().compareTo(c4.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 2)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 3)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 4)
				{
					whoStart = 2;
					return 2;
				}
			}
		}
		if(c4.getsuit() == trump && c2.getsuit() == trump && c3.getsuit() == trump && c1.getsuit() != trump)
		{
			if(c4.getValue().compareTo(c2.getValue()) > 0 && c4.getValue().compareTo(c3.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 2)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 3)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 4)
				{
					whoStart = 3;
					return 3;
				}
			}
			if(c2.getValue().compareTo(c4.getValue()) > 0 && c2.getValue().compareTo(c3.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 2)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 3)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 4)
				{
					whoStart = 1;
					return 1;
				}
			}
			if(c3.getValue().compareTo(c4.getValue()) > 0 && c3.getValue().compareTo(c2.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 2)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 3)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 4)
				{
					whoStart = 2;
					return 2;
				}
			}
		}
		if(c1.getsuit()==trump && c2.getsuit()==trump && c3.getsuit() != trump && c4.getsuit() != trump)
		{
			if(c1.getValue().compareTo(c2.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 3)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 4)
				{
					whoStart = 4;
					return 4;
				}	
			}
			if(c2.getValue().compareTo(c1.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 2)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 3)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 4)
				{
					whoStart = 1;
					return 1;
				}
			}
		}
		if(c1.getsuit()==trump && c3.getsuit()==trump && c2.getsuit() != trump && c4.getsuit() != trump)
		{
			if(c1.getValue().compareTo(c3.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 3)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 4)
				{
					whoStart = 4;
					return 4;
				}	
			}
			if(c3.getValue().compareTo(c1.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 2)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 3)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 4)
				{
					whoStart = 3;
					return 3;
				}
			}
		}
		if(c1.getsuit()==trump && c4.getsuit()==trump && c2.getsuit() != trump && c3.getsuit() != trump)
		{
			if(c1.getValue().compareTo(c4.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 3)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 4)
				{
					whoStart = 4;
					return 4;
				}	
			}
			if(c4.getValue().compareTo(c1.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 2)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 3)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 4)
				{
					whoStart = 3;
					return 3;
				}
			}
		}
		if(c2.getsuit()==trump && c3.getsuit()==trump && c1.getsuit() != trump && c4.getsuit() != trump)
		{
			if(c2.getValue().compareTo(c3.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 2)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 3)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 4)
				{
					whoStart = 1;
					return 1;
				}	
			}
			if(c3.getValue().compareTo(c2.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 2)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 3)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 4)
				{
					whoStart = 3;
					return 3;
				}
			}
		}
		if(c4.getsuit()==trump && c3.getsuit()==trump && c2.getsuit() != trump && c1.getsuit() != trump)
		{
			if(c4.getValue().compareTo(c3.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 2)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 3)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 4)
				{
					whoStart = 3;
					return 3;
				}	
			}
			if(c3.getValue().compareTo(c4.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 2)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 3)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 4)
				{
					whoStart = 3;
					return 3;
				}
			}
		}
		if(c2.getsuit()==trump && c4.getsuit()==trump && c1.getsuit() != trump && c3.getsuit() != trump)
		{
			if(c2.getValue().compareTo(c4.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 2)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 3)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 4)
				{
					whoStart = 1;
					return 1;
				}	
			}
			if(c4.getValue().compareTo(c2.getValue())>0)
			{
				if(whoStart == 1)
				{
					whoStart = 4;
					return 4;
				}
				else if(whoStart == 2)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 3)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 4)
				{
					whoStart = 3;
					return 3;
				}
			}
		}
		if(c1.getsuit() == trump)
		{
			if(whoStart == 1)
			{
				whoStart = 1;
				return 1;
			}
			else if(whoStart == 2)
			{
				whoStart = 2;
				return 2;
			}
			else if(whoStart == 3)
			{
				whoStart = 3;
				return 3;
			}
			else if(whoStart == 4)
			{
				whoStart = 4;
				return 4;
			}	
		}
		if(c2.getsuit() == trump)
		{
			if(whoStart == 1)
			{
				whoStart = 2;
				return 2;
			}
			else if(whoStart == 2)
			{
				whoStart = 3;
				return 3;
			}
			else if(whoStart == 3)
			{
				whoStart = 4;
				return 4;
			}
			else if(whoStart == 4)
			{
				whoStart = 1;
				return 1;
			}
		}
		if(c3.getsuit() == trump)
		{
			if(whoStart == 1)
			{
				whoStart = 3;
				return 3;
			}
			else if(whoStart == 2)
			{
				whoStart = 4;
				return 4;
			}
			else if(whoStart == 3)
			{
				whoStart = 1;
				return 1;
			}
			else if(whoStart == 4)
			{
				whoStart = 3;
				return 3;
			}
		}
		if(c4.getsuit() == trump)
		{
			if(whoStart == 1)
			{
				whoStart = 4;
				return 4;
			}
			else if(whoStart == 2)
			{
				whoStart = 1;
				return 1;
			}
			else if(whoStart == 3)
			{
				whoStart = 2;
				return 2;
			}
			else if(whoStart == 4)
			{
				whoStart = 3;
				return 3;
			}
		}
		if(c1.getsuit() == c2.getsuit() && c1.getValue().compareTo(c2.getValue()) <0 )
		{
			if(c2.getsuit() == c3.getsuit() && c2.getValue().compareTo(c3.getValue()) <0 )
			{
				if(c3.getsuit() == c4.getsuit() && c3.getValue().compareTo(c4.getValue()) <0 )
				{
					if(whoStart == 1)
					{
						whoStart = 4;
						return 4;
					}
					else if(whoStart == 2)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 3)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 4)
					{
						whoStart = 3;
						return 3;
					}
				}else
				{
					if(whoStart == 1)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 2)
					{
						whoStart = 4;
						return 4;
					}
					else if(whoStart == 3)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 4)
					{
						whoStart = 3;
						return 3;
					}
				}
			}else
			{
				if(c2.getsuit() == c4.getsuit() && c2.getValue().compareTo(c4.getValue()) <0 )
				{
					if(whoStart == 1)
					{
						whoStart = 4;
						return 4;
					}
					else if(whoStart == 2)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 3)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 4)
					{
						whoStart = 3;
						return 3;
					}
				}else
				{
					if(whoStart == 1)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 2)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 3)
					{
						whoStart = 4;
						return 4;
					}
					else if(whoStart == 4)
					{
						whoStart = 1;
						return 1;
					}
				}
			}
		}else
		{
			if(c1.getsuit() == c3.getsuit() && c1.getValue().compareTo(c3.getValue())<0)
			{
				if(c3.getsuit() == c4.getsuit() && c3.getValue().compareTo(c4.getValue()) <0 )
				{
					if(whoStart == 1)
					{
						whoStart = 4;
						return 4;
					}
					else if(whoStart == 2)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 3)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 4)
					{
						whoStart = 3;
						return 3;
					}
				}else
				{
					if(whoStart == 1)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 2)
					{
						whoStart = 4;
						return 4;
					}
					else if(whoStart == 3)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 4)
					{
						whoStart = 3;
						return 3;
					}
				}
			}else
			{
				if(c1.getsuit() == c4.getsuit() && c1.getValue().compareTo(c4.getValue())<0)
				{
					if(whoStart == 1)
					{
						whoStart = 4;
						return 4;
					}
					else if(whoStart == 2)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 3)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 4)
					{
						whoStart = 3;
						return 3;
					}
				}else
				{
					if(whoStart == 1)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 2)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 3)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 4)
					{
						whoStart = 4;
						return 4;
					}	
				}
			}
		}
		if(c1.getValue().compareTo(c2.getValue()) > 0 && c1.getValue().compareTo(c3.getValue()) > 0 &&c1.getValue().compareTo(c4.getValue()) > 0)
		{
			if(whoStart == 1)
			{
				whoStart = 1;
				return 1;
			}
			else if(whoStart == 2)
			{
				whoStart = 2;
				return 2;
			}
			else if(whoStart == 3)
			{
				whoStart = 3;
				return 3;
			}
			else if(whoStart == 4)
			{
				whoStart = 4;
				return 4;
			}
		}
		if(c2.getValue().compareTo(c1.getValue()) > 0 && c2.getValue().compareTo(c3.getValue()) > 0 &&c2.getValue().compareTo(c4.getValue()) > 0)
		{
			if(whoStart == 1)
			{
				whoStart = 2;
				return 2;
			}
			else if(whoStart == 2)
			{
				whoStart = 3;
				return 3;
			}
			else if(whoStart == 3)
			{
				whoStart = 4;
				return 4;
			}
			else if(whoStart == 4)
			{
				whoStart = 1;
				return 1;
			}
		}
		if(c3.getValue().compareTo(c1.getValue()) > 0 && c3.getValue().compareTo(c2.getValue()) > 0 &&c3.getValue().compareTo(c4.getValue()) > 0)
		{
			if(whoStart == 1)
			{
				whoStart = 3;
				return 3;
			}
			else if(whoStart == 2)
			{
				whoStart = 4;
				return 4;
			}
			else if(whoStart == 3)
			{
				whoStart = 1;
				return 1;
			}
			else if(whoStart == 4)
			{
				whoStart = 2;
				return 2;
			}
		}
		if(c4.getValue().compareTo(c1.getValue()) > 0 && c4.getValue().compareTo(c2.getValue()) > 0 &&c4.getValue().compareTo(c3.getValue()) > 0)
		{
			if(whoStart == 1)
			{
				whoStart = 4;
				return 4;
			}
			else if(whoStart == 2)
			{
				whoStart = 1;
				return 1;
			}
			else if(whoStart == 3)
			{
				whoStart = 2;
				return 2;
			}
			else if(whoStart == 4)
			{
				whoStart = 3;
				return 3;
			}
		}
		}
		if(n == 3)
		{
			if(c1.getsuit() == trump && c2.getsuit() == trump && c3.getsuit() == trump)
			{
				if(c1.getValue().compareTo(c2.getValue()) > 0 && c1.getValue().compareTo(c3.getValue()) > 0)
				{
					if(whoStart == 1)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 2)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 3)
					{
						whoStart = 3;
						return 3;
					}
				}
				if(c2.getValue().compareTo(c1.getValue()) > 0 && c2.getValue().compareTo(c3.getValue()) > 0)
				{
					if(whoStart == 1)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 2)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 3)
					{
						whoStart = 1;
						return 1;
					}
				}
				if(c3.getValue().compareTo(c1.getValue()) > 0 && c3.getValue().compareTo(c2.getValue()) > 0)
				{
					if(whoStart == 1)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 2)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 3)
					{
						whoStart = 2;
						return 2;
					}
				}
			}
			if(c1.getsuit() == trump && c2.getsuit() == trump && c3.getsuit() != trump)
			{
				if(c1.getValue().compareTo(c2.getValue()) > 0)
				{
					if(whoStart == 1)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 2)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 3)
					{
						whoStart = 3;
						return 3;
					}
				}
				if(c2.getValue().compareTo(c1.getValue()) >0)
				{
					if(whoStart == 1)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 2)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 3)
					{
						whoStart = 1;
						return 1;
					}
				}
			}
			if(c2.getsuit() == trump && c3.getsuit() == trump && c1.getsuit() != trump)
			{
				if(c2.getValue().compareTo(c3.getValue()) > 0)
				{
					if(whoStart == 1)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 2)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 3)
					{
						whoStart = 1;
						return 1;
					}
				}
				if(c3.getValue().compareTo(c2.getValue()) >0)
				{
					if(whoStart == 1)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 2)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 3)
					{
						whoStart = 2;
						return 2;
					}
				}
			}
			if(c1.getsuit() == trump && c3.getsuit() == trump && c2.getsuit() != trump)
			{
				if(c1.getValue().compareTo(c3.getValue()) > 0)
				{
					if(whoStart == 1)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 2)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 3)
					{
						whoStart = 3;
						return 3;
					}
				}
				if(c3.getValue().compareTo(c1.getValue()) >0)
				{
					if(whoStart == 1)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 2)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 3)
					{
						whoStart = 2;
						return 2;
					}
				}
			}
			
			
			if(c1.getsuit() == c2.getsuit() && c1.getValue().compareTo(c2.getValue()) <0 )
			{
				if(c2.getsuit() == c3.getsuit() && c2.getValue().compareTo(c3.getValue()) <0 )
				{
					if(whoStart == 1)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 2)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 3)
					{
						whoStart = 2;
						return 2;
					}
				}else
				{
					if(whoStart == 1)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 2)
					{
						whoStart = 3;
						return 3;
					}
					else if(whoStart == 3)
					{
						whoStart = 1;
						return 1;
					}	
				}
			}else
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 3)
				{
					whoStart = 3;
					return 3;
				}
			}
			
			if(c1.getValue().compareTo(c2.getValue()) > 0 && c1.getValue().compareTo(c3.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 3)
				{
					whoStart = 3;
					return 3;
				}
			}
			if(c2.getValue().compareTo(c1.getValue()) > 0 && c2.getValue().compareTo(c3.getValue()) > 0 )
			{
				if(whoStart == 1)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 2)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 3)
				{
					whoStart = 1;
					return 1;
				}
				
			}
			if(c3.getValue().compareTo(c1.getValue()) > 0 && c3.getValue().compareTo(c2.getValue()) > 0)
			{
				if(whoStart == 1)
				{
					whoStart = 3;
					return 3;
				}
				else if(whoStart == 2)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 3)
				{
					whoStart = 2;
					return 2;
				}
			}
			
			
			
		}
		if(n == 2)
		{
			if(c1.getsuit() == trump && c2.getsuit() == trump)
			{
				if(c1.getValue().compareTo(c2.getValue()) > 0)
				{
					if(whoStart == 1)
					{
						whoStart = 1;
						return 1;
					}
					else if(whoStart == 2)
					{
						whoStart = 2;
						return 2;
					}
				}
				if(c2.getValue().compareTo(c1.getValue()) >0)
				{
					if(whoStart == 1)
					{
						whoStart = 2;
						return 2;
					}
					else if(whoStart == 2)
					{
						whoStart = 1;
						return 1;
					}
				}
			}
			if(c1.getsuit() == trump && c2.getsuit() != trump)
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
			}
			if(c2.getsuit() == trump && c1.getsuit() != trump)
			{
				if(whoStart == 1)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 2)
				{
					whoStart = 1;
					return 1;
				}
			}
			if(c1.getsuit() == c2.getsuit() && c1.getValue().compareTo(c2.getValue()) <0 )
			{
				if(whoStart == 1)
				{
					whoStart = 2;
					return 2;
				}
				else if(whoStart == 2)
				{
					whoStart = 1;
					return 1;
				}
			}else
			{
				if(whoStart == 1)
				{
					whoStart = 1;
					return 1;
				}
				else if(whoStart == 2)
				{
					whoStart = 2;
					return 2;
				}
			}
		}
		return 0;
	}
	public void addWinDeck(Deck d)
	{
		for(Card aCard : d.getCards())
		{
			winDeck.addCard(aCard);
		}
		d.getCards().clear();
		System.out.println("Winner Deck: ");
		winDeck.printCards();
	}
	public Deck getWinDECK()
	{
		return this.winDeck;
	}
	public int getCardsPoint()
	{
		int points = 0;
		for(Card aCard : winDeck.getCards())
		{
			if(aCard.getValue() == Value.ACE)//ace 4 points
			{
				points = points + 4;
			}
			else if(aCard.getValue() == Value.KING)//king 3 points
			{
				points = points + 3;
			}
			else if(aCard.getValue() == Value.QUEEN)//jack 2 points
			{
				points = points + 2;
			}
			else if(aCard.getValue() == Value.JACK)//king 3 points
			{
				points = points + 3;
			}
			else if(aCard.getValue() == Value.TEN)//king 3 points
			{
				points = points + 3;
			}
		}
		System.out.println("Card Points: "+ points);
		return points;
	}
	
	public Value findHigh(Deck dealerDeck,Suit trump)
	{
		Card tmp;
		tmp = dealerDeck.findCard(trump, Value.ACE);
		if(tmp != null)
		{
			return Value.ACE;
		}else
		{
			tmp = dealerDeck.findCard(trump, Value.KING);
			if(tmp != null)
			{ 
				return Value.KING;
			}else
			{
				tmp = dealerDeck.findCard(trump, Value.QUEEN);
				if(tmp != null)
				{
					return Value.QUEEN;
				}else
				{
					tmp = dealerDeck.findCard(trump, Value.JACK);
					if(tmp != null)
					{
						return Value.JACK;
					}else
					{
						tmp = dealerDeck.findCard(trump, Value.TEN);
						if(tmp != null)
						{
							return Value.TEN;
						}else
						{
							tmp = dealerDeck.findCard(trump, Value.NINE);
							if(tmp != null)
							{
								return Value.NINE;
							}else
							{
								tmp = dealerDeck.findCard(trump, Value.EIGHT);
								if(tmp != null)
								{
									return Value.EIGHT;
								}else
								{
									tmp = dealerDeck.findCard(trump, Value.SEVEN);
									if(tmp != null)
									{
										return Value.SEVEN;
									}else
									{
										tmp = dealerDeck.findCard(trump, Value.SIX);
										if(tmp != null)
										{
											return Value.SIX;
										}else
										{
											tmp = dealerDeck.findCard(trump, Value.FIVE);
											if(tmp != null)
											{
												return Value.FIVE;
											}else
											{
												tmp = dealerDeck.findCard(trump, Value.FOUR);
												if(tmp != null)
												{
													return Value.FOUR;
												}else
												{
													tmp = dealerDeck.findCard(trump, Value.THREE);
													if(tmp != null)
													{
														return Value.THREE;
													}else
													{
														tmp = dealerDeck.findCard(trump, Value.TWO);
														if(tmp != null)
														{
															return Value.TWO;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return null;
	}
	public Value findLow(Deck dealerDeck,Suit trump)
	{
		Card tmp;
		tmp = dealerDeck.findCard(trump, Value.TWO);
		if(tmp != null)
		{
			return Value.TWO;
		}else
		{
			tmp = dealerDeck.findCard(trump, Value.THREE);
			if(tmp != null)
			{ 
				return Value.THREE;
			}else
			{
				tmp = dealerDeck.findCard(trump, Value.FOUR);
				if(tmp != null)
				{
					return Value.FOUR;
				}else
				{
					tmp = dealerDeck.findCard(trump, Value.FIVE);
					if(tmp != null)
					{
						return Value.FIVE;
					}else
					{
						tmp = dealerDeck.findCard(trump, Value.SIX);
						if(tmp != null)
						{
							return Value.SIX;
						}else
						{
							tmp = dealerDeck.findCard(trump, Value.SEVEN);
							if(tmp != null)
							{
								return Value.SEVEN;
							}else
							{
								tmp = dealerDeck.findCard(trump, Value.EIGHT);
								if(tmp != null)
								{
									return Value.EIGHT;
								}else
								{
									tmp = dealerDeck.findCard(trump, Value.NINE);
									if(tmp != null)
									{
										return Value.NINE;
									}else
									{
										tmp = dealerDeck.findCard(trump, Value.TEN);
										if(tmp != null)
										{
											return Value.TEN;
										}else
										{
											tmp = dealerDeck.findCard(trump, Value.JACK);
											if(tmp != null)
											{
												return Value.JACK;
											}else
											{
												tmp = dealerDeck.findCard(trump, Value.QUEEN);
												if(tmp != null)
												{
													return Value.QUEEN;
												}else
												{
													tmp = dealerDeck.findCard(trump, Value.KING);
													if(tmp != null)
													{
														return Value.KING;
													}else
													{
														tmp = dealerDeck.findCard(trump, Value.ACE);
														if(tmp != null)
														{
															return Value.ACE;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return null;											
	}
	
	public boolean hasLow(Deck d1,Deck d2, Deck d3, Deck d4, Suit trump,int n)
	{
		Value l = findLow(d1, trump);
		Value l2 = findLow(d2,trump);
		Value l3 = null,l4 = null,target = null;
		if(l != null && l2 != null)
		{
			if(l.compareTo(l2) < 0 )
			{
				target = l;
			}else 
			{
				target = l2;
			}
		}else if(l != null)
		{
			target = l;
		}else
		{
			target = l2;
		}
		if(n > 2)
		{
			l3 = findLow(d3,trump);
			if(target != null && l3 != null)
			{
				if(target.compareTo(l3) > 0)
				{
					target = l3;
				}
			}else if(l3 != null && target == null)
			{
				target = l3;
			}
		}
		if(n > 3)
		{
			l4 = findLow(d3,trump);
			if(target != null && l4 != null)
			{
				if(target.compareTo(l4) > 0)
				{
					target = l4;
				}
			}else if(l4 != null && target == null)
			{
				target = l4;
			}
		}
		System.out.println("l " + l + "l2 " + l2 + "l3 " + l3 + "l4" + l4 );
		System.out.println("Low: " + target + " ");
		this.winDeck.printCards();
		if(this.winDeck.findCard(trump, target) != null)
		{
			return true;
		}
		return false;
	}
	public boolean hasHigh(Deck d1, Deck d2, Deck d3, Deck d4,Suit trump,int n)
	{
		Value l = findHigh(d1, trump);
		Value l2 = findHigh(d2,trump);
		Value l3 = null,l4 = null,target = null;
		if(l != null && l2 != null)
		{
			if(l.compareTo(l2) < 0 )
			{
				target = l;
			}else 
			{
				target = l2;
			}
		}else if(l != null)
		{
			target = l;
		}else
		{
			target = l2;
		}
		if(n > 2)
		{
			l3 = findHigh(d3,trump);
			if(target != null && l3 != null)
			{
				if(target.compareTo(l3) > 0)
				{
					target = l3;
				}
			}else if(l3 != null && target == null)
			{
				target = l3;
			}
		}
		if(n > 3)
		{
			l4 = findHigh(d3,trump);
			if(target != null && l4 != null)
			{
				if(target.compareTo(l4) > 0)
				{
					target = l4;
				}
			}else if(l4 != null && target == null)
			{
				target = l4;
			}
		}
		System.out.println("High: " + target + " ");
		if(this.winDeck.findCard(trump, target) != null)
		{
			return true;
		}
		return false;
	}
	public boolean hasJack(Suit trump)
	{
		if(this.winDeck.findCard(trump, Value.JACK) != null)
		{
			return true;
		}
		return false;
	}
	public boolean winAll(int n)
	{
		if(this.winDeck.getCardNum() == n * 6)
		{
			return true;
		}
		return false;
	}

//functions for deal cards for one player
	public void dealCards(int numPlayer, Deck dealDeck,Deck coming,String type)
	{
		System.out.println("card number: " + coming.getCardNum());
		int counter = 0;	
		while(counter < 6)
		{
			dealDeck.addCard(coming.getNthCard(0));
			coming.deleteNthCard(0);	
			counter++;
			setCardNum(coming.getCardNum() - 1);
		}
		
		System.out.println("card number: " + coming.getCardNum());
		System.out.println("#######Player Deck ######");
		dealDeck.printCards();
	}

	public boolean hasNext() {
		 return false;
	}
	
	public Object next() {
		// TODO Auto-generated method stub
		
		return null;
	}
}

