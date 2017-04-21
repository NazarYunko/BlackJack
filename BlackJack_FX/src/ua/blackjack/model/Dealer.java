package ua.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

	private String dealerName;
	private int dealerMoney;
	private List<Card> hand = new ArrayList<>();

	public Dealer(String dealerName, int dealerMoney) {
		super();
		this.dealerName = dealerName;
		this.dealerMoney = dealerMoney;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public int getDealerMoney() {
		return dealerMoney;
	}

	public void setDealerMoney(int dealerMoney) {
		this.dealerMoney = dealerMoney;
	}

	public List<Card> getHand() {
		return hand;
	}

	@Override
	public String toString() {
		return dealerName + ", money: " + dealerMoney;
	}

}
