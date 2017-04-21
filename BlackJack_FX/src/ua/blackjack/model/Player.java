package ua.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String playerName;
	private int playerMoney;
	private List<Card> hand;

	public Player(String playerName, int playerMoney) {
		super();
		this.playerName = playerName;
		this.playerMoney = playerMoney;
		hand = new ArrayList<>();
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerMoney() {
		return playerMoney;
	}

	public void setPlayerMoney(int playerMoney) {
		this.playerMoney = playerMoney;
	}

	public List<Card> getHand() {
		return hand;
	}

	@Override
	public String toString() {
		return playerName + ", money=" + playerMoney;
	}

}
