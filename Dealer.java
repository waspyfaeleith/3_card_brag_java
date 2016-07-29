public class Dealer {
  Deck deck;

  public Dealer() {
    this.deck = new Deck();
  }

  public void dealCard(Player player)
  {
    Card card = this.deck.cards.get(0);
    this.deck.cards.remove(0);
    player.takeCard(card);
  }
}