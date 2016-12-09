package card_game;

public class Runner {
  public static void main(String[] args) {
    Dealer dealer = new Dealer();

    Player jack = new Player("Jack");
    Player victor = new Player("Victor");
    Player tam = new Player("Tam");
    Player winston = new Player("Winston");
    Player isa = new Player("Isa");
    Player naveed = new Player("Naveed");
    Player boaby = new Player("Boaby");

    Player[] players = { jack , victor, winston } ;//, tam, naveed, isa, boaby } ;


    for (int i = 0; i < 3; i++) {
      for (Player player : players) {
        dealer.dealCard(player);
      }
    }

    for (Player player : players) {
      player.showHand();
    }

/*
    int numHandsDealt = 0;

    while (true) {
      dealer = new Dealer();
      jack = new Player("Jack");
      for (int i = 0; i < 3; i++) {
        dealer.dealCard(jack);
      }
      jack.showHand();
      numHandsDealt++;
      if (jack.hasStraightFlush() )//|| jack.hasPrial())
        break;
    }

    System.out.println(numHandsDealt + " hands were dealt");
*/

  }
}