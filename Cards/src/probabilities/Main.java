package probabilities;

import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    Deck testDeck = new Deck();
    
//    for(Card card : testDeck.getAvailableCards()) {
//      System.out.println(card.getSuit() + " " + card.getRank() + " " + card.getName());
//    }
//    for(HashMap.Entry<Character, Double> suit : testDeck.getSuitProbabilities().entrySet()) {
//      System.out.println(suit);
//    }
//    for(double rank : testDeck.getRankProbabilities()) {
//      System.out.println(rank);
//    }
//    for(double blackjackRank : testDeck.getBlackjackProbabilities()) {
//      System.out.println(blackjackRank);
//    }
//    Card nextCard = testDeck.getAvailableCards().get(0);
//    System.out.println(nextCard.getSuit() + " " + nextCard.getRank() + " " + nextCard.getName());
////    testDeck.playCard();
////    Card nextCardAgain = testDeck.getAvailableCards().get(0);
////    System.out.println(nextCardAgain.getSuit() + " " + nextCardAgain.getRank() + " " + nextCardAgain.getName());
//    for(HashMap.Entry<Character, Double> suit : testDeck.getSuitProbabilities().entrySet()) {
//      System.out.println(suit);
//    }
//    for(double rank : testDeck.getRankProbabilities()) {
//      System.out.println(rank);
//    }
//    for(double blackjackRank : testDeck.getBlackjackProbabilities()) {
//      System.out.println(blackjackRank);
//    }
    testDeck.burnCard();
    for(HashMap.Entry<Character, Double> suit : testDeck.getSuitProbabilities().entrySet()) {
      System.out.println(suit);
    }
    for(double rank : testDeck.getRankProbabilities()) {
      System.out.println(rank);
    }
    for(double blackjackRank : testDeck.getBlackjackProbabilities()) {
      System.out.println(blackjackRank);
    }
    testDeck.playCard();
    testDeck.playCard();
    for(HashMap.Entry<Character, Double> suit : testDeck.getSuitProbabilities().entrySet()) {
      System.out.println(suit);
    }
    for(double rank : testDeck.getRankProbabilities()) {
      System.out.println(rank);
    }
    for(double blackjackRank : testDeck.getBlackjackProbabilities()) {
      System.out.println(blackjackRank);
    }
  }

}
