import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DeckTest {

	private Deck d;

	@Test
	void testSetCardNum() {
		d  = new Deck();
		d.setCardNum(10);
		assertEquals(d.getCardNum(),10);
	}

	@Test
	void testDeleteNthCard() {
		d = new Deck();
		d.createDeck();
		assertEquals(d.deleteNthCard(0).getsuit(),Suit.CLUB);
	}

	@Test
	void testDeleteACard() {
		d = new Deck();
		d.createDeck();
		Card c = new Card(Suit.CLUB, Value.ACE);
		assertEquals(d.deleteACard(c).getValue(),Value.ACE);
	}
	@Test
	void testDeleteACard2() {
		d = new Deck();
		d.createDeck();
		Card c = new Card(Suit.CLUB, Value.ACE);
		assertEquals(d.deleteACard(c).getsuit(),Suit.CLUB);
	}
	@Test
	void testGetNthCard() {
		d = new Deck();
		d.createDeck();
		assertEquals(d.getNthCard(1).getValue(),Value.THREE);
	}
	@Test
	void testGetNthCard2() {
		d = new Deck();
		d.createDeck();
		assertEquals(d.getNthCard(1).getsuit(),Suit.CLUB);
	}
	@Test
	void testAddCard() {
		d = new Deck();
		Card c = new Card(Suit.CLUB,Value.JACK);	
		d.addCard(c);
		assertEquals(d.findCard(Suit.CLUB, Value.JACK), c);
	}
	
	@Test
	void testCreateDeck() {
		d = new Deck();
		d.createDeck();
		assertEquals(d.getCardNum(),52);
	}

	@Test
	void testSearchValue() {
		d = new Deck();
		d.createDeck();
		assertEquals(d.searchValue(Value.FOUR).getValue(),Value.FOUR);
	}

	@Test
	void testSearchSuit() {
		d = new Deck();
		d.createDeck();
		assertEquals(d.searchSuit(Suit.HEART).getsuit(),Suit.HEART);
	}

	@Test
	void testSearchNumSameSuit() {
		d = new Deck();
		d.createDeck();
		assertEquals(d.searchNumSameSuit(Suit.DIAMOND),13);
	}

	@Test
	void testFindCard() {
		d = new Deck();
		d.createDeck();
		assertEquals(d.findCard(Suit.SPADE, Value.ACE).getsuit(),Suit.SPADE);
	}

	@Test//test after shuffle cards, the number of card remains the same
	void testShuffle() {
		d = new Deck();
		d.createDeck();
		d.shuffle();
		assertEquals(d.getCardNum(), 52);
	}

}
