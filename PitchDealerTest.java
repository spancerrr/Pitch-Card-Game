import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PitchDealerTest {
	private PitchDealer dealer;
	@Test
	void testSetTrump() {
		dealer = new PitchDealer();
		dealer.setTrump(Suit.CLUB);
		assertEquals(dealer.getTrump(),Suit.CLUB);
	}
	@Test
	void testInitalBids() {
		//first item in allBids should be 2
		dealer = new PitchDealer();
		dealer.initalBids();
		Integer i = 2;
		assertEquals(dealer.getAvaBids().get(0), i);
	}

	@Test
	void testDeleteBids() {
		//delete bid in from and put in to
		dealer = new PitchDealer();
		dealer.initalBids();
		ArrayList<Integer> from = new ArrayList();
		ArrayList<Integer> to = new ArrayList();
		from.add(5);
		dealer.deleteBids(5, from, to);
		Integer i =5;
		assertEquals(to.get(0),i);
	}
	
	@Test
	void testSetwhoStart() {
		dealer = new PitchDealer();
		dealer.setwhoStart(1);
		assertEquals(dealer.getWhoStart(),1);
	}

	@Test
	void testFindLow() {
		dealer = new PitchDealer();
		Deck d1 = new Deck();
		Card c = new Card(Suit.CLUB,Value.ACE);
		Card c2 = new Card(Suit.CLUB,Value.EIGHT);
		Card c3 = new Card(Suit.CLUB,Value.FOUR);
		d1.addCard(c);
		d1.addCard(c2);
		d1.addCard(c3);
		assertEquals(dealer.findLow(d1, Suit.CLUB), Value.FOUR);
	}

	@Test
	void testFindHigh() {
		dealer = new PitchDealer();
		Deck d1 = new Deck();
		Card c = new Card(Suit.CLUB,Value.ACE);
		Card c2 = new Card(Suit.CLUB,Value.EIGHT);
		Card c3 = new Card(Suit.CLUB,Value.FOUR);
		d1.addCard(c);
		d1.addCard(c2);
		d1.addCard(c3);
		assertEquals(dealer.findHigh(d1, Suit.CLUB), Value.ACE);
	}


}
