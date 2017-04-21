package ua.blackjack.model;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Deck {

	private List<Card> cards = new LinkedList<>();

	public Deck() {
		createDeck();
	}

	// card write
	private void createDeck() {

		for (int i = 0; i < CardComponents.getRanksSize(); i++) {
			for (int j = 0; j < CardComponents.getSuitsSize(); j++) {
				Card card = new Card(CardComponents.getSuit(j), CardComponents.getRank(i));

				if (CardComponents.getRank(i).matches("\\d+")) {

					card.setValue(Integer.parseInt(CardComponents.getRank(i)));
				} else if (!CardComponents.getRank(i).equals("A")) {
					card.setValue(10);
				}
				cards.add(card);
			}
		}

	}

	public Card getCard(int i) {
		return cards.get(i);
	}

	public int deckSize() {
		return cards.size();
	}

	public ListIterator<Card> listIterator() {
		return cards.listIterator();
	}

	// cards mix
	public List<Card> deckMix() {

		int mixIndex = 0;
		Card tmp;

		for (int i = 0; i < cards.size(); i++) {
			mixIndex = ((int) ((Math.random() * (cards.size() - i) + 0) + i));
			tmp = cards.get(i);
			cards.set(i, cards.get(mixIndex));
			cards.set(mixIndex, tmp);
		}

		return cards;
	}

}
