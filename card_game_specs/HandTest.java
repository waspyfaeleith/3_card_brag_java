import static org.junit.Assert.assertEquals;
import org.junit.*;
import card_game.*;

public class HandTest {
  Hand hand;

  @Before
  public void before() {

    hand = new Hand();
    Card card1 = new Card(Suit.HEART, Value.SEVEN);
    Card card2 = new Card(Suit.HEART, Value.EIGHT);
    Card card3 = new Card(Suit.HEART, Value.NINE);

    hand.addCard(card2);
    hand.addCard(card3);
    hand.addCard(card1);
  }

  private void createHand(Card card1, Card card2, Card card3) {
    hand = new Hand();
    hand.addCard(card1);
    hand.addCard(card2);
    hand.addCard(card3);
  }

  @Test
  public void handIsStraightFlush() {
    hand.checkHand();
    assertEquals(HandType.STRAIGHTFLUSH, hand.getHandType());
  }

  @Test
  public void handIsPrial() {
    Card card1 = new Card(Suit.CLUB, Value.ACE);
    Card card2 = new Card(Suit.DIAMOND, Value.ACE);
    Card card3 = new Card(Suit.HEART, Value.ACE);

    createHand(card1, card2, card3);

    hand.checkHand();
    assertEquals(HandType.PRIAL, hand.getHandType());
  }

  @Test
  public void handIsStraight() {
    Card card1 = new Card(Suit.CLUB, Value.THREE);
    Card card2 = new Card(Suit.DIAMOND, Value.FIVE);
    Card card3 = new Card(Suit.HEART, Value.FOUR);

    createHand(card1, card2, card3);

    hand.checkHand();
    assertEquals(HandType.STRAIGHT, hand.getHandType());
  }

  @Test
  public void handIsFlush() {
    Card card1 = new Card(Suit.CLUB, Value.THREE);
    Card card2 = new Card(Suit.CLUB, Value.KING);
    Card card3 = new Card(Suit.CLUB, Value.TEN);

    createHand(card1, card2, card3);

    hand.checkHand();
    assertEquals(HandType.FLUSH, hand.getHandType());
  }

  @Test
  public void handIsPair() {
    Card card1 = new Card(Suit.CLUB, Value.THREE);
    Card card2 = new Card(Suit.DIAMOND, Value.FIVE);
    Card card3 = new Card(Suit.HEART, Value.THREE);

    createHand(card1, card2, card3);
    
    hand.checkHand();
    assertEquals(HandType.PAIR, hand.getHandType());
  }

  @Test
  public void handIsHighHand() {
    Card card1 = new Card(Suit.CLUB, Value.THREE);
    Card card2 = new Card(Suit.DIAMOND, Value.FIVE);
    Card card3 = new Card(Suit.HEART, Value.JACK);

    createHand(card1, card2, card3);
    
    hand.checkHand();
    assertEquals(HandType.HIGHHAND, hand.getHandType());
  }
}