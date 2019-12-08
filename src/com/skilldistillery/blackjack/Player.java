package com.skilldistillery.blackjack;

import com.skilldistillery.common.Card;

public class Player {

	public String name;
	BlackjackHand blackjackHand=new BlackjackHand();

	// Dealer dealer = new Dealer();

	



	public int stay() {
		return blackjackHand.getHandValue();
	}
}
