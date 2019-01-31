package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * <code>Deck</code> implements a single deck of standard playing cards. Methods
 * are included for shuffling and dealing cards from the deck.
 *
 * @author Josh DeLeon  &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

public class Deck {

  private List<Card> stock; //generic type when using "<>".
  private List<Card> discard;

  /**
   * Initializes the deck with all 52 cards in order. The {@link #shuffle(Random)}
   * method must be invoked after initialization, prior to dealing any cards
   * via the the {@link #deal()} method.
   *
   */

  public Deck() {  //The constructor "Deck" initializes the instance.
    stock = new ArrayList<>();
    discard = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
       Card c = new Card(r,s);
       discard.add(c);
      }
    }
  }

  /**
   *Returns all cards to th pile and shuffles it, readying it for dealing.
   * @param rng <Strong>required</strong> source of randomness.
   */
  public void shuffle(Random rng) { // Void means its not going to return a value
    stock.addAll(discard); // take everything from discard and add it to stock
    discard.clear(); //takes and actually removes the cards from discard
    Collections.shuffle(stock, rng); //helps with collections such as our list
  }

  /**
   * Deals and returns one card from the top of the pile. If no cards are in
   * the pile, a {@link DeckEmptyException} will be thrown.
   * @return single card from the top of the pile.
   * @throws DeckEmptyException if no cards are in the pile.
   */
  public Card deal() throws DeckEmptyException { //since no void then it will return a value
    try {
      Card c = stock.remove(0); //this is now getting the card
      discard.add(c);
      return c;
    } catch (IndexOutOfBoundsException e) { // e is the name of the exception variable
      throw new DeckEmptyException();
    }
  }

  /**
   * This exception is thrown when {@link #deal ()} is invoked on an empty deck.
   */
  public static class DeckEmptyException extends IllegalStateException { //its not ok to deal from an empty deck

    public DeckEmptyException() {
      super();
    }

    public DeckEmptyException(String message) { //giving the super class a shot at doing an initialization which is always before I do
      super(message);
    }

    public DeckEmptyException(String message, Throwable cause) {
      super(message, cause); //invoke the super class that invokes the string and throwable constructor
    }

    public DeckEmptyException(Throwable cause) {
      super(cause); // means invoke the super class constructor
    }
  }
}
