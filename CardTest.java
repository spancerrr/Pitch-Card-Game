import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {
	private Card c;
	
	@Test
	void testCard() {
		c = new Card(Suit.DIAMOND, Value.FIVE);
		assertEquals(c.getValue(), Value.FIVE);
		assertEquals(c.getsuit(), Suit.DIAMOND);
	}
	
	@Test
	void testCard2() {
		c = new Card(null, null);
		assertEquals(c.getValue(), null);
		assertEquals(c.getsuit(), null);
	}
	@Test
	void testGetValue() {
		c = new Card(Suit.HEART, Value.JACK);
		assertEquals(c.getValue(), Value.JACK);
	}

	@Test
	void testGetsuit() {
		c = new Card(Suit.HEART, Value.JACK);
		assertEquals(c.getsuit(), Suit.HEART);
	}

	@Test
	void testToString() {
		c = new Card(Suit.CLUB, Value.FIVE);
		assertEquals(c.toString(),"CLUB FIVE");
	}

}
