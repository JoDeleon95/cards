package edu.cnm.deepdive;

/**
 * This enum implements suits of a standard playing cards. Each enumerated value
 * uses the standard symbol for that suit (taken from unicode) as its string
 * representation.
 *
 * @author Josh DeLeon &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */
public enum Suit { // enum cant change the instances once its been loaded into memory.

  CLUBS("C"),
  DIAMONDS("D"),
  HEARTS("H"),
  SPADES("S");

  private final String symbol;

  private Suit(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return symbol;
  }
}
