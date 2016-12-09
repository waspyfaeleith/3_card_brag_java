package card_game;

public class Player {
  String name;
  Hand hand;

  public Player(String name) {
    this.name = name;
    this.hand = new Hand();
  }

  public void takeCard(Card card) {
    hand.addCard(card);
  }

  public void showHand() {
    System.out.println("\n" + this.name + " has:");
    this.hand.show();
    System.out.println("");
  }

  public boolean hasStraightFlush() {
    return hand.handType == HandType.STRAIGHTFLUSH;
  }

  public boolean hasPrial() {
    return hand.handType == HandType.PRIAL;
  }


}