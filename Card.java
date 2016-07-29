//package card;

public class Card {
  Suit suit;
  Value value;

  public Card (Suit suit, Value value)
  {
    this.suit = suit;
    this.value = value;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public Value getValue() {
    return this.value;
  }
  public void show() {
    System.out.println(this.value.toString() + " OF " + this.suit.toString() + "S");
  }
}