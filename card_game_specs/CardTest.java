import static org.junit.Assert.assertEquals;
import org.junit.*;
import card_game.*;

public class CardTest {
  Card card;

  @Before
  public void before() {
    card = new Card(Suit.SPADE, Value.ACE);
  }

  @Test
  public void hasSuit() {
    assertEquals(Suit.SPADE, card.getSuit());
  }

  @Test 
  public void hasValue() {
    assertEquals(Value.ACE, card.getValue());
  }

  @Test
  public void testToString() {
    assertEquals("ACE OF SPADES", card.toString());
  }
}
