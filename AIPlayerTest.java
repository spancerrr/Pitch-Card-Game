import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AIPlayerTest {
	private AIPlayer p;
	@Test
	public void testSetAIBid() {
		//no cards in hand, should bid 0;
		p = new AIPlayer();
		ArrayList<Integer> allBids = new ArrayList();
		ArrayList<Integer> playerBid = new ArrayList();
		allBids.add(2);
		p.setAIBid(allBids, playerBid);
		int bid = 0;
		assertEquals(p.getAIBid(),bid);
	}
	@Test
	public void testSetAIBid2() {
		//only available bid are 0 so should bid 0
		p = new AIPlayer();
		ArrayList<Integer> allBids = new ArrayList();
		ArrayList<Integer> playerBid = new ArrayList();
		Deck d = new Deck();
		d.createDeck();
		p.getAICards(1, d);
		allBids.add(0);
		p.setAIBid(allBids, playerBid);
		int bid = 0;
		assertEquals(p.getAIBid(),bid);
	}
	@Test
	public void testSetAIBid3() {
		// should bid either 4
		p = new AIPlayer();
		ArrayList<Integer> allBids = new ArrayList();
		ArrayList<Integer> playerBid = new ArrayList();
		Deck d = new Deck();
		d.createDeck();
		p.getAICards(1, d);
		allBids.add(4);
		p.setAIBid(allBids, playerBid);
		assertEquals(p.getAIBid(),4);
	}
	@Test
	void testPlayACard() {
		//should have 5 card in hand
		p = new AIPlayer();
		Deck d = new Deck();
		d.createDeck();
		p.getAICards(1, d);
		p.playACard(null, null);
		assertEquals(p.getAIHand().getCardNum(),5);
	}
	@Test
	void testPlayACard2() {
		//should play Club 2
		p = new AIPlayer();
		Deck d = new Deck();
		d.createDeck();
		p.getAICards(1, d);
		Card c = p.playACard(null, null);
		assertEquals(c.getsuit(),Suit.CLUB);
		assertEquals(c.getValue(),Value.TWO);
	}

}
