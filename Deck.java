//package card;
import java.util.*;

public class Deck {
  ArrayList<Card> cards;

  public Deck() {
    this.cards = new ArrayList<Card>();
    this.populateDeck();
    Collections.shuffle(cards);
  }

  private void populateDeck() {
    for (Suit suit : Suit.values()) {
      for (Value value : Value.values()) {
        Card card = new Card(suit, value);
        this.cards.add(card);
      }
    }
  }

  public void printDeck() {
    for (Card card : cards) {
      card.show();
    }
  }

  public ArrayList<Card> getDeck() {
    ArrayList<Card> tempDeck = new ArrayList<Card>(cards);
    return tempDeck;
  }
}