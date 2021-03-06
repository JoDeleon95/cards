package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;

public class SimpleWar {

  private Deck deck;
  private Random rng;
  private int tally1;
  private int tally2;
  private Referee referee;

  public SimpleWar(Random rng){
    this.rng = rng;
    deck = new Deck();
    deck.shuffle(rng);
    referee = new Referee();
  }

  public void play() {
    boolean tied;
    int pairsDealt = 0;
    do {
      Card card1 = deck.deal();
      Card card2 = deck.deal();
      System.out.printf("%s : %s", card1, card2);
      pairsDealt++;
      int comparison = referee.compare(card1, card2);
      if (comparison == 0) {
        tied = true;
        System.out.println(" (push)");
        for (int i = 0; i < 3; i++) {
          deck.deal();
          deck.deal();
          pairsDealt++;
        }
      } else if (comparison > 0) {
        tied = false;
        System.out.println(" (player1");
        tally1 += 2 * pairsDealt;
      } else {
        tied = false;
        System.out.println("(Player2");
        tally2 += 2 * pairsDealt;
      }
    } while (tied);
  }

  protected Deck getDeck() {
    return deck;
  }

  protected Random getRng() {
    return rng;
  }

  protected Referee getReferee() {
    return referee;
  }

  protected int getTally1() {
    return tally1;
  }

  protected void setTally1(int tally1) {
    this.tally1 = tally1;
  }

  protected int getTally2() {
    return tally2;
  }

  protected void setTally2(int tally2) {
    this.tally2 = tally2;
  }

  public static void main(String[] args) {
    SimpleWar war = new SimpleWar(new SecureRandom());
    try {
      while (true) { // The while will loop forever and the try catch finally with catch the end and start it over.
        war.play();
      }
    } catch (Deck.DeckEmptyException e) {
      // Do Nothing!
    } finally {
      System.out.printf("Player1: %d. Player 2: %d.%n", war.tally1, war.tally2);
      if (war.tally1 > war.tally2) {
        System.out.println("Player 1 wins!");
      } else if (war.tally1 < war.tally2) {
        System.out.println("Player 2 wins!");
      } else {
        System.out.println("Tie!");
      }

    }

  }

  protected static class Referee implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
      if (card1.getRank() != Rank.ACE && card2.getRank() != Rank.ACE) {
        return card1.getRank().compareTo(card2.getRank());
      } else if (card1.getRank() != Rank.ACE) {
        return -1;
      } else if (card2.getRank() != Rank.ACE) {
        return 1;
      }
      return 0;
    }

  }

}
