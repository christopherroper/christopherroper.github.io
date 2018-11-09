package probabilities;

public class Card {
  private char suit;
  private String name;
  private int rank;
  
  public Card(char suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }
  public char getSuit() {
    return this.suit;
  }
  public String getName() {
    return this.name;
  }
  public int getRank() {
    return this.rank;
  }
  public void setName() {
    if(rank < 11) {
      this.name = String.valueOf(rank);
    } else if(rank == 11) {
      this.name = "Jack";
    } else if(rank == 12) {
      this.name = "Queen";
    } else if(rank == 13) {
      this.name = "King";
    } else if(rank == 14) {
      this.name = "Ace";
    }
    return;
  }
}
