package probabilities;

import java.util.ArrayList;
import java.util.HashMap;

public class Deck {
  private ArrayList<Card> availableCards;
//  private HashMap<String, Card> availableCards;
  private ArrayList<Card> playedCards; //TODO possibly not needed
  private ArrayList<Card> burnedCards; //TODO possibly not needed
  private int[] rankCounts;
  private double[] rankProbabilities;
//  private int[] suitCounts;
//  private double[] suitProbabilities;
  private double[] blackjackProbabilities;
//  private HashMap<Integer, Double> rankProbabilities;
//  private HashMap<Integer, Double> blackjackProbabilities;
//  private HashMap<Integer, Integer> rankCounts;
  private HashMap<Character, Double> suitProbabilities;
  private HashMap<Character, Integer> suitCounts;
  private double[] burnedRankCounts;
  private double[] burnedRankProbabilities;
  private HashMap<Character, Double> burnedSuitCounts;
  private HashMap<Character, Double> burnedSuitProbabilities;

  public Deck() {
    burnedRankCounts = new double[15];
    burnedRankProbabilities = new double[15];
    burnedSuitProbabilities = new HashMap<>();
    rankCounts = new int[15];
    rankProbabilities = new double[15];
    blackjackProbabilities = new double[15];
    suitCounts = new HashMap<>();
    suitProbabilities = new HashMap<>();
    availableCards = new ArrayList<>();
    playedCards = new ArrayList<>();
    burnedCards = new ArrayList<>();
    
    suitCounts.put('H', 13);
    suitCounts.put('D', 13);
    suitCounts.put('C', 13);
    suitCounts.put('S', 13);
    burnedSuitProbabilities.put('H', 0.0);
    burnedSuitProbabilities.put('D', 0.0);
    burnedSuitProbabilities.put('C', 0.0);
    burnedSuitProbabilities.put('S', 0.0);
    suitProbabilities.put('H', 25.0);
    suitProbabilities.put('D', 25.0);
    suitProbabilities.put('C', 25.0);
    suitProbabilities.put('S', 25.0);
    
    for(int i = 2; i < 15; i++) {
      rankCounts[i] = 4;
      burnedRankProbabilities[i] = 0.0;
      Card heart = new Card('H', i);
      Card diamond = new Card('D', i);
      Card club = new Card('C', i);
      Card spade = new Card('S', i);
      heart.setName();
      diamond.setName();
      club.setName();
      spade.setName();
      availableCards.add(heart);
      availableCards.add(diamond);
      availableCards.add(club);
      availableCards.add(spade);
    }
    updateProbabilities();
  }
  
  public void shuffle() {
    for(int i = 0; i < availableCards.size(); i++) {
      int randomIndex = 0; //TODO
      Card temp = availableCards.get(randomIndex);
      availableCards.set(randomIndex, availableCards.get(i));
      availableCards.set(i, temp);
    }
  }
  public ArrayList<Card> getAvailableCards() {
    return availableCards;
  }
  public ArrayList<Card> getPlayedCards() {
    return playedCards;
  }
  public void playCard() {
    Card playedCard = availableCards.get(0);
    availableCards.remove(0);
    playedCards.add(playedCard);
    rankCounts[playedCard.getRank()]--;
    suitCounts.replace(playedCard.getSuit(), suitCounts.get(playedCard.getSuit()) - 1);
    updateProbabilities();
  }
  
  public void burnCard() {
    Card burnedCard = availableCards.get(0);
    burnedCards.add(burnedCard);
    
    //iterate through all suit counts
    for(HashMap.Entry<Character, Integer> suit : suitCounts.entrySet()) {
      double unplayedProbability = (suit.getValue()*1.0/availableCards.size())/52;
      double burnedProbability = burnedSuitProbabilities.get(suit.getKey());
      burnedSuitProbabilities.replace(suit.getKey(), unplayedProbability + burnedProbability);
    }
    for(int i = 2; i < 15; i++) {
      burnedRankProbabilities[i] += rankProbabilities[i]/52;
    }
    availableCards.remove(0);
    updateProbabilities();
    
  }
  public void updateProbabilities() {
    double suitProbabilitiesSum = 0.0;
    double rankProbabilitiesSum = 0.0;
    double blackjackProbabilitiesSum = 0.0;
    int rankCountsSum = 0;
    int suitCountsSum = 0;
    double burnedRankProbabilitiesSum = 0.0;
        
    for(HashMap.Entry<Character, Integer> suit : suitCounts.entrySet()) {
      double unplayedProbability = suit.getValue()*1.0/availableCards.size();
      double burnedProbability = burnedSuitProbabilities.get(suit.getKey());
      suitProbabilities.replace(suit.getKey(), unplayedProbability - burnedProbability);
      suitProbabilitiesSum += unplayedProbability - burnedProbability;
    }
//    System.out.println("suit probability " + suitProbabilitiesSum);
    
    double getTenProbability = 0;
    for(int i = 2; i < 15; i++) {
      rankProbabilities[i] = (rankCounts[i] * 1.0 / availableCards.size()) - burnedRankProbabilities[i];
      if(i < 10 || i > 13) {
        blackjackProbabilities[i] = rankProbabilities[i];
      } else {
        getTenProbability += rankProbabilities[i];
      }
      
    }
    blackjackProbabilities[10] = getTenProbability;
    
  }
  
  public double[] getRankProbabilities() {
    return rankProbabilities;
  }
  public HashMap<Character, Double> getSuitProbabilities() {
    return suitProbabilities;
  }
  public double[] getBlackjackProbabilities() {
    return blackjackProbabilities;
  }
}
