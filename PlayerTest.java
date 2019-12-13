import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {
	private Player p;

	@Test
	void testSetBid() {
		p = new Player();
		p.setBid(2);
		assertEquals(p.getBid(),2);
	}

	@Test
	void testGetRoundScore() {
		p = new Player();
		p.setRoundScore(100);
		assertEquals(p.getRoundScore(),100);
	}

	@Test
	void testSetScore() {
		p = new Player();
		p.setScore(100);
		assertEquals(p.getScore(),100);
	}

	@Test
	void testSetNumPlayer() {
		p = new Player();
		p.setNumPlayer(4);
		assertEquals(p.getNumPlayer(),4);
	}

	@Test
	void testGetCardsIntDeck() {
		p = new Player();
		Deck d = new Deck();
		d.createDeck();
		p.getCards(1, d);
		assertEquals(p.getHand().getNthCard(0).getsuit(),Suit.CLUB);
	}
	
}
