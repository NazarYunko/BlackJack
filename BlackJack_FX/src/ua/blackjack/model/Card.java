package ua.blackjack.model;

public class Card {

	private String suit;
	private String rank;
	private int value;

	public Card(String suit, String rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getRank() {
		return rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return rank + suit;
	}

}
