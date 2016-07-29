import java.util.*;

public class Hand {
  private ArrayList<Card> cards;
  HandType handType;
  Card highCard;

  public Hand() {
    cards = new ArrayList<Card>();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public void show() {
    for (Card card : this.cards) {
      System.out.println(card.getValue().toString() + " OF " + card.getSuit().toString() + "S");
    }
    this.checkHand();
    System.out.println(handType);
    System.out.print("High card is ");
    highCard.show();
  }

  private Card[] getCards() {
    Card card1 = cards.get(0);
    Card card2 = cards.get(1);
    Card card3 = cards.get(2); 

    Card[] cardArray = { card1, card2, card3 };
    return cardArray;
  }

  private boolean isPrial(Card[] cards) {
    if ( (cards[0].getValue() == cards[1].getValue()) 
        &&  (cards[0].getValue() == cards[2].getValue()) ) {
          return true;
        }
    return false;
  }

  private boolean isFlush(Card[] cards) {
    if ( (cards[0].getSuit() == cards[1].getSuit()) 
        &&  (cards[0].getSuit() == cards[2].getSuit()) ) {
          return true;
        }
    return false;
  }

  private boolean isAPair(Card[] cards) {
    if ((cards[0].getValue().compareTo(cards[1].getValue()) == 0) ||
      (cards[0].getValue().compareTo(cards[2].getValue()) == 0) )  {
      return true;
    }
    if ((cards[1].getValue().compareTo(cards[0].getValue()) == 0) ||
      (cards[1].getValue().compareTo(cards[2].getValue()) == 0) )  {
      return true;
    }
    if ((cards[2].getValue().compareTo(cards[0].getValue()) == 0) ||
      (cards[2].getValue().compareTo(cards[1].getValue()) == 0) )  {
      return true;
    }
    return false;
  }

  private Card highCardOfTwo(Card card1, Card card2) {
    if (card1.getValue().compareTo(card2.getValue()) > 0)  {
      return card1;
    }
    return card2;
  }

  private boolean sameValue(Card card1, Card card2) {
    if (card1.getValue().compareTo(card2.getValue()) == 0)  {
      return true;
    }
    return false;
  }

  private boolean twoAdjacentValues(Card card1, Card card2) {
    if ((card1.getValue().ordinal() - card2.getValue().ordinal() == 1) || ((card2.getValue().ordinal() - card1.getValue().ordinal() == 1) )) {
      return true;
    }
    return false;
  }

  private void setHighCard(Card[] cards) {
    if ((highCardOfTwo(cards[0],cards[1]) == cards[0])
          && (highCardOfTwo(cards[0],cards[2]) == cards[0])) {
      highCard = cards[0];
    }
    if ( (highCardOfTwo(cards[1],cards[0]) == cards[1])
          && (highCardOfTwo(cards[1],cards[2]) == cards[1])) {
      highCard = cards[1];
    }
    if ((highCardOfTwo(cards[2],cards[0]) == cards[2])
          && (highCardOfTwo(cards[2],cards[1]) == cards[2])) {
      highCard = cards[2];
    }
    if ((sameValue(cards[0],cards[1])) || (sameValue(cards[0],cards[2]))) {
      highCard = cards[0];
    } 
    if (sameValue(cards[1],cards[2])) {
      highCard = cards[1];
    }
  }

  private Card[] sortCardsByValue(Card[] cards) {
    Card[] tempCards = cards;
    Card tempCard;
    
    if (highCardOfTwo(cards[0],cards[1]) == cards[1])
    {
      tempCard = tempCards[0];
      tempCards[0] = tempCards[1];
      tempCards[1] = tempCard;
    } 
    if (highCardOfTwo(cards[2],cards[1]) == cards[2])
    {
      tempCard = tempCards[1];
      tempCards[1] = tempCards[2];
      tempCards[2] = tempCard;
    } 
    if (highCardOfTwo(cards[0],cards[2]) == cards[2])
    {
      tempCard = tempCards[0];
      tempCards[0] = tempCards[2];
      tempCards[2] = tempCard;
    } 
    /*System.out.println("Sorted Cards:");
    for (Card card : tempCards) {
      card.show();
    }*/
    return tempCards;
  }

  private boolean isAStraight(Card[] cards) { 
    cards = sortCardsByValue(cards);
    if ( twoAdjacentValues(cards[0], cards[1]) 
        && twoAdjacentValues(cards[1], cards[2])
        && !twoAdjacentValues(cards[0], cards[2])
        ){
          return true;
    }
    return false;
  }

  private boolean isAStraightFlush(Card[] cards) {
    if (isFlush(cards) && isAStraight(cards)) {
      return true;
    }
    return false;
  }

  public void checkHand() {
    Card[] cards = this.getCards();
    setHighCard(cards);
    
    if (isPrial(cards)) {
      handType = HandType.PRIAL;
      return;
    }
    if (isFlush(cards)) {
      handType = HandType.FLUSH;
      return;
    }
    if (isAPair(cards)) {
      handType = HandType.PAIR;
      return;
    }
    if (isAStraight(cards)) {
      handType = HandType.STRAIGHT;
      return;
    }
    if (isAStraightFlush(cards)) {
      handType = HandType.STRAIGHTFLUSH;
      return;
    } 
    handType = HandType.HIGHHAND;
  }
}