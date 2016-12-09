package card_game;

public class Dealer {
  Deck deck;

  public Dealer() {
    this.deck = new Deck();
  }

  public void dealCard(Player player)
  {
    Card card = this.deck.getCard();
    this.deck.cards.remove(0);
    player.takeCard(card);
  }
}