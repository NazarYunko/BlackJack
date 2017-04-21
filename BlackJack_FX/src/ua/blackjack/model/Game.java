package ua.blackjack.model;

import java.util.List;
import java.util.ListIterator;

public class Game {

	private Deck deck;

	public Game() {
		deck = new Deck();
	}

	public Deck getDeck() {
		return deck;
	}

	// create new deck for next motion
	public Deck overwriteDeck() {
		deck = new Deck();
		return deck;
	}

	// clear player hand
	public void clearPlayerHand(Player player) {
		player.getHand().clear();
	}

	// clear dealer hand
	public void clearDealerHand(Dealer dealer) {
		dealer.getHand().clear();
	}

	public List<Card> deckMix() {
		return deck.deckMix();
	}

	// set cards to hand
	public void givePlayerCard(Player player, Card arg0) {
		ListIterator<Card> listIterator = deck.listIterator();
		player.getHand().add(arg0);
		while (listIterator.hasNext()) {
			Card current = listIterator.next();
			if (current.equals(arg0)) {
				listIterator.remove();
				break;
			}
		}
	}

	// set cards to dealer hand
	public void giveDealerCard(Dealer dealer, Card arg0) {
		ListIterator<Card> listIterator = deck.listIterator();
		dealer.getHand().add(arg0);
		while (listIterator.hasNext()) {
			Card current = listIterator.next();
			if (current.equals(arg0)) {
				listIterator.remove();
				break;
			}
		}
	}

	// count sum of values player and cards on table
	public int sumOfThePlayer(Player player) {
		int sumOfThePlayer = 0;

		boolean foundCardA = false; // found card A
		Card[] cardsA = new Card[4]; // index card a to replace
		int indexOfCardsA = 0;

		for (Card tmp : player.getHand()) {

			if (tmp.getRank().equals("A")) {
				foundCardA = true;
				cardsA[indexOfCardsA] = tmp;
				indexOfCardsA++;
			}

			sumOfThePlayer += tmp.getValue();

		}

		if (foundCardA) {

			for (int i = 0; i < indexOfCardsA; i++) {
				if (sumOfThePlayer > 10) {
					sumOfThePlayer += 1;
				} else {
					sumOfThePlayer += 11;
				}
			}

		}

		return sumOfThePlayer;
	}

	// count sum of values dealer
	public int sumOfTheDealer(Dealer dealer) {

		int sumOfTheDealer = 0;

		boolean foundCardA = false; // found card A
		Card[] cardsA = new Card[4]; // index card a to replace
		int indexOfCardsA = 0;

		for (Card tmp : dealer.getHand()) {

			if (tmp.getRank().equals("A")) {
				foundCardA = true;
				cardsA[indexOfCardsA] = tmp;
				indexOfCardsA++;
			}

			sumOfTheDealer += tmp.getValue();

		}

		if (foundCardA) {

			for (int i = 0; i < indexOfCardsA; i++) {
				if (sumOfTheDealer > 10) {
					sumOfTheDealer += 1;
				} else {
					sumOfTheDealer += 11;
				}
			}

		}

		return sumOfTheDealer;
	}

}
