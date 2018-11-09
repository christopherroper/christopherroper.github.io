package probabilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {
  Deck testDeck;

  @BeforeEach
  void setUp() throws Exception {
    testDeck = new Deck();
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testDeck() {
//    fail("Not yet implemented");
  }

  @Test
  void testShuffle() {
//    fail("Not yet implemented");
  }

  @Test
  void testGetAvailableCards() {
//    fail("Not yet implemented");
  }

  @Test
  void testGetPlayedCards() {
//    fail("Not yet implemented");
  }

  @Test
  void testPlayCard() {
    int previousSize = testDeck.getAvailableCards().size();
    testDeck.playCard();
    int newSize = testDeck.getAvailableCards().size();
    assertEquals(previousSize - 1, newSize);
  }

}
