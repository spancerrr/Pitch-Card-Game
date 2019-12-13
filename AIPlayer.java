import java.util.ArrayList;

public class AIPlayer extends Player{

	private Deck handAI = new Deck();
	private int score = 0;
	private int bid = 0;
	
	
	public Deck getAIHand()
	{
		return this.handAI;
	}
	public int getAIBid()
	{
		return this.bid;
	}
	public void setAIScore(int s)
	{
		this.score = s;
	}
	public int getAIScore()
	{
		return this.score;
	}
	public void getAICards(int numPlayer,Deck coming)
	{
		dealCards(numPlayer,handAI,coming,"AI");
	}
	public void setAIBid(ArrayList<Integer> allBid,ArrayList<Integer> playerBid)
	{	
		if(handAI.searchValue(Value.ACE) != null)
		{
			if(handAI.findCard(handAI.searchValue(Value.ACE).getsuit(),Value.KING) != null)
			{
				if(handAI.findCard(handAI.searchValue(Value.ACE).getsuit(),Value.QUEEN) != null)
				{
					if(handAI.findCard(handAI.searchValue(Value.ACE).getsuit(),Value.JACK) != null)
					{
						if(handAI.findCard(handAI.searchValue(Value.ACE).getsuit(),Value.TEN) != null)
						{
							if(handAI.findCard(handAI.searchValue(Value.ACE).getsuit(),Value.TWO) != null)
							{
								//has ace, king, queen, jack, 10 and 2 all in same suit
								if(isAvaliable(5,allBid))//check if bid 5 is taken
								{
									this.bid = 5;
									deleteBids(2,allBid,playerBid);
									deleteBids(3,allBid,playerBid);
									deleteBids(4,allBid,playerBid);
									deleteBids(5,allBid,playerBid);
									return;
								}
								this.bid = 0;//5 is taken, so pass
								deleteBids(0,allBid,playerBid);
								return;
							}
						}
					}
				}
			}
		}
		
		if(handAI.searchValue(Value.ACE) != null)//check if has ace
		{
			if(handAI.findCard(handAI.searchValue(Value.ACE).getsuit(),Value.JACK) != null)//check if has ace and jack in same suit
			{
				//has ace, king and jack in same suit
				if(handAI.findCard(handAI.searchValue(Value.ACE).getsuit(),Value.TWO) != null)
				{
					if(handAI.findCard(handAI.searchValue(Value.ACE).getsuit(),Value.KING) != null)
					{
						//has ace, king, jack and 2 in same suit
						if(isAvaliable(4,allBid))//check if bid 4 is taken
						{
							this.bid = 4;
							deleteBids(2,allBid,playerBid);
							deleteBids(3,allBid,playerBid);
							deleteBids(4,allBid,playerBid);
							return;
						}
						this.bid = 0;//4 is taken, so pass
						deleteBids(0,allBid,playerBid);
						return;
					}else
					{
						//has ace, jack and 2 in same suit
						if(isAvaliable(3,allBid))
						{
							this.bid = 3;
							deleteBids(2,allBid,playerBid);
							deleteBids(3,allBid,playerBid);
							return;
						}
						this.bid = 0;//3 is taken, so pass
						deleteBids(0,allBid,playerBid);
						return;
					}
				}else
				{
					//has ace and jack in the same suit
					if(isAvaliable(3,allBid))
					{
						this.bid = 3;
						deleteBids(2,allBid,playerBid);
						deleteBids(3,allBid,playerBid);
						return;
					}
					this.bid = 0;//3 is taken, so pass
					deleteBids(0,allBid,playerBid);
					return;
				}
			}else if(handAI.findCard(handAI.searchValue(Value.ACE).getsuit(),Value.TWO) != null)
			{
				//has ace and 2 in the same suit
				if(isAvaliable(3,allBid))
				{
					this.bid = 3;
					deleteBids(2,allBid,playerBid);
					deleteBids(3,allBid,playerBid);
					return;
				}
				this.bid = 0;//3 is taken, so pass
				deleteBids(0,allBid,playerBid);
				return;
			}
			//has ace
			if(isAvaliable(2,allBid))
			{
				this.bid = 2;
				deleteBids(2,allBid,playerBid);
				return;
			}
			this.bid = 0;//2 is taken, so pass
			deleteBids(0,allBid,playerBid);
			return;
		}else if(handAI.searchValue(Value.KING) != null)
		{
			if(handAI.findCard(handAI.searchValue(Value.KING).getsuit(),Value.JACK) != null)
			{
				//has king and jack in same suit
				if(handAI.findCard(handAI.searchValue(Value.KING).getsuit(),Value.TWO) != null)
				{
					//has king, jack and 2 in same suit
					if(isAvaliable(3,allBid))
					{
						this.bid = 3;
						deleteBids(2,allBid,playerBid);
						deleteBids(3,allBid,playerBid);
						return;
					}
					this.bid = 0;//3 is taken, so pass
					deleteBids(0,allBid,playerBid);
					return;
				}else
				{
					//has king and jack
					if(isAvaliable(2,allBid))
					{
						this.bid = 2;
						deleteBids(2,allBid,playerBid);
						return;
					}
					this.bid = 0;//2 is taken, so pass
					deleteBids(0,allBid,playerBid);
					return;
				}
			}else if(handAI.findCard(handAI.searchValue(Value.KING).getsuit(),Value.TWO) != null)
			{
				//has king and two in the same suit
				if(isAvaliable(2,allBid))
				{
					this.bid = 2;
					deleteBids(2,allBid,playerBid);
					return;
				}
				this.bid = 0;//2 is taken, so pass
				deleteBids(0,allBid,playerBid);
				return;
			}
		}
		
		int a =0,b = 0,c = 0,d = 0;
		a = this.handAI.searchNumSameSuit(Suit.CLUB);
		b = this.handAI.searchNumSameSuit(Suit.DIAMOND);
		c = this.handAI.searchNumSameSuit(Suit.HEART);
		d = this.handAI.searchNumSameSuit(Suit.SPADE);
		System.out.println("a:"+ a+" b:" + b+ " c:"+ c+ " d" +d);
		if(a > 5 || b > 5 || c > 5 || d > 5)
		{
			//all cards same suit
			if(isAvaliable(4,allBid))
			{
				this.bid = 4;
				deleteBids(4,allBid,playerBid);
				return;
			}
			this.bid = 0;//4 is taken, so pass
			deleteBids(0,allBid,playerBid);
			return;
		}else if(a > 4 || b > 4 || c > 4 || d > 4)
		{
			//five cards same suit
			if(isAvaliable(3,allBid))
			{
				this.bid = 3;
				deleteBids(3,allBid,playerBid);
				return;
			}
			this.bid = 0;//3 is taken, so pass
			deleteBids(0,allBid,playerBid);
			return;
		}else if(a > 3 || b > 3 || c > 3 || d > 3)
		{
			//four cards same suit
			if(isAvaliable(2,allBid))
			{
				this.bid = 2;
				deleteBids(2,allBid,playerBid);
				return;
			}
			this.bid = 0;//2 is taken, so pass
			deleteBids(0,allBid,playerBid);
			return;
		}else
		{
			this.bid = 0;//worst case
			deleteBids(0,allBid,playerBid);
		}
	}
	public void passBid()
	{
		this.bid = 0;
	}
	public Card playACard(Deck played,Suit trump)
	{
		Card tmp;
		System.out.println("###########Trump: " + trump);
		if( trump == null)
		{
			//no card has played yet, trump is not set, player is starting the hand
			//the player hand has either king or ace or both
			System.out.println("no card has played yet, trump is not set");
			tmp = handAI.searchValue(Value.ACE);
			if(tmp!= null)
			{
				//has ace in hand
				handAI.deleteACard(tmp);
				System.out.println("has ace");
				return tmp;
				
			}
			tmp = handAI.searchValue(Value.KING);
			if(tmp!= null)
			{
				//no ace but has king
				handAI.deleteACard(tmp);
				System.out.println("no ace, has king");
				return tmp;
			}
		}else if(played.getCards().isEmpty() == true)//trump is set, but start first
		{
			System.out.println("empty");
			System.out.println("###########Trump: " + trump);
			tmp = handAI.findCard(trump,Value.ACE);//trump ace
			if(tmp != null)
			{
				handAI.deleteACard(tmp);
				System.out.println("has trump ace");
				return tmp;
			}
			tmp = handAI.findCard(trump,Value.KING);//trump king
			if(tmp != null)
			{
				handAI.deleteACard(tmp);
				System.out.println("no trump ace, has trump king");
				return tmp;
			}
			//play a card has values
			tmp = handAI.searchValue(Value.ACE);//ace with any suit
			if(tmp != null)
			{
				handAI.deleteACard(tmp);
				System.out.println("no trump ace, no trump king, has ace in other suit");
				return tmp;
			}
			tmp = handAI.searchValue(Value.KING);//king with any suit
			if(tmp != null)
			{
				handAI.deleteACard(tmp);
				System.out.println("no trump ace, no trump king, has king in other suit");
				return tmp;
			}
			tmp = handAI.searchValue(Value.QUEEN);//queen with any suit
			if(tmp != null)
			{
				handAI.deleteACard(tmp);
				System.out.println("no trump ace, no trump king, has queen in other suit");
				return tmp;
			}
			tmp = handAI.searchValue(Value.JACK);//jack with any suit
			if(tmp != null)
			{
				handAI.deleteACard(tmp);
				System.out.println("no trump ace, no trump king, has jack in other suit");
				return tmp;
			}
			tmp = handAI.searchValue(Value.TEN);//king with any suit
			if(tmp != null)
			{
				handAI.deleteACard(tmp);
				System.out.println("no trump ace, no trump king, has ten in other suit");
				return tmp;
			}
		}else
		{
			//not the first one to play card and trump suit is set
			if(isTrumpPlayed(played,trump) == true)//check if trump is played in this round
			{
				if(played.getNthCard(0).getsuit() == trump)//check if trump card is played first
				{
					tmp = handAI.findCard(trump, Value.ACE);//trump ace
					if(tmp != null)
					{
						//trump card is played first, has trump ace
						handAI.deleteACard(tmp);
						System.out.println("trump card is played first, has trump ace");
						return tmp;
					}
					if(played.getNthCard(0).getValue() != Value.ACE)
					{
						tmp = handAI.findCard(trump, Value.KING);//trump king
						if(tmp != null)
						{
							//trump card is played first but it's not trump ace, has trump king
							handAI.deleteACard(tmp);
							System.out.println("trump card is played first but it's not trump ace, has trump king");
							return tmp;
						}
					}
					tmp = handAI.searchSuit(trump);
					if(tmp != null)
					{
						//trump card is played first, no trump ace or king, play other trump card
						handAI.deleteACard(tmp);
						System.out.println("trump card is played first, no trump ace or king, play other trump card");
						return tmp;
					}
				}

				//trump jack is played 
				if(played.findCard(trump, Value.JACK) != null)
				{
					tmp = handAI.findCard(trump, Value.ACE);//trump ace
					if(tmp != null)
					{
						//trump jack is played, has trump ace
						handAI.deleteACard(tmp);
						System.out.println("trump jack is played, has trump ace");
						return tmp;
					}
					if(played.findCard(trump, Value.ACE) == null)
					{
						//trump jack is played, no trump ace is played, has trump king
						tmp = handAI.findCard(trump, Value.KING);//trump king
						if(tmp != null)
						{
							handAI.deleteACard(tmp);
							System.out.println("trump jack is played, no trump ace is played, has trump king");
							return tmp;
						}
					}
				}
				//trump two is played
				if(played.findCard(trump, Value.TWO) != null)
				{
					tmp = handAI.findCard(trump, Value.ACE);//trump ace
					if(tmp != null)
					{
						//trump two is played, has trump ace
						handAI.deleteACard(tmp);
						System.out.println("trump two is played, has trump ace");
						return tmp;
					}
					if(played.findCard(trump, Value.ACE) == null)
					{
						//trump two is played, no trump ace is played, has trump king
						tmp = handAI.findCard(trump, Value.KING);//trump king
						if(tmp != null)
						{
							handAI.deleteACard(tmp);
							System.out.println("trump two is played, no trump ace is played, has trump king");
							return tmp;
						}
					}
				}
			}//else if(played.getCards().isEmpty() == false)
			else if(played.searchSuit(trump) == null) 
			{
				//no trump card is played in this round yet
				tmp = handAI.findCard(trump, Value.TWO);//trump two
				if(tmp != null)
				{
					handAI.deleteACard(tmp);
					System.out.println("no trump card is played, has trump two");
					return tmp;
				}
			
				tmp = handAI.findCard(played.getNthCard(0).getsuit(), Value.JACK);
				if(tmp != null)
				{
					//ace with same suit as first card played in this round
					handAI.deleteACard(tmp);
					System.out.println("ace with same suit as first card played in this round");
					return tmp;
				}
			}
			
	}
		
		tmp = handAI.searchSuit(Suit.CLUB);
		if(tmp != null)
		{
			System.out.println("" + tmp);
			handAI.deleteACard(tmp);
			return tmp;
		}
		tmp = handAI.searchSuit(Suit.DIAMOND);
		if(tmp != null)
		{
			handAI.deleteACard(tmp);
			return tmp;
		}
		tmp = handAI.searchSuit(Suit.HEART);
		if(tmp != null)
		{
			handAI.deleteACard(tmp);
			return tmp;
		}
		tmp = handAI.searchSuit(Suit.SPADE);
		handAI.deleteACard(tmp);
		return tmp;
	}
}

