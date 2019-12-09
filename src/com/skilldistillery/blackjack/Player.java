package com.skilldistillery.blackjack;

import com.skilldistillery.common.Card;

public class Player {

	private int money;
	BlackjackHand blackjackHand = new BlackjackHand();

	public Player() {

	}

	public Player(int money) {

		this.money = money;
	}

	public int stay() {
		return blackjackHand.getHandValue();
	}
}
