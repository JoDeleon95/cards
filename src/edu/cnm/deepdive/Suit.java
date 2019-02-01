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

  CLUBS("\u2663", Color.BLACK),
  DIAMONDS("\u2662", Color.RED),
  HEARTS("\u2661", Color.RED),   // CONSTANTS
  SPADES("\u2660", Color.BLACK);

  private final String symbol;    //FIELDS
  private final Color color;

  Suit(String symbol, Color color) {  //STRING
    this.symbol = symbol;
    this.color = color;
  }
  public Color getColor () {   //GETTER: Encapsulates
    return color;
  }
  @Override
  public String toString() {
    return symbol;
  }

  public enum Color {
    RED, BLACK;
  }

}
