package ua.blackjack.model;

public final class CardComponents {

	private static final String[] SUITS = { "CLUBS", "DIAMONDS", "HEARTS", "SPADES" };
	private static final String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	private CardComponents() {
	};

	public static String getSuit(int i) {
		return SUITS[i];
	}

	public static String getRank(int i) {
		return RANKS[i];
	}

	public static int getSuitsSize() {
		return SUITS.length;
	}

	public static int getRanksSize() {
		return RANKS.length;
	}

}
