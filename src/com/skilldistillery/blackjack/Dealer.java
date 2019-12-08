package com.skilldistillery.blackjack;

import com.skilldistillery.common.Card;
import com.skilldistillery.common.Deck;

public class Dealer extends Player {

	Deck deck = new Deck();

	public Card drawCard() {
		return deck.dealCard();
	}

	public void giveCard(Player p) {
		p.blackjackHand.addCard(drawCard());
	}

	public boolean to17(Dealer d) {
		while (d.blackjackHand.getHandValue() < 17) {
			d.blackjackHand.addCard(drawCard());
		}

		if (d.blackjackHand.getHandValue() > 21)
			return true;
		return false;
	}

	public void newDeck() {
		deck.creatDeck();

	}

	public void printSecondCard(Dealer d) {
		System.out.println("Dealer's 2nd card is: " + d.blackjackHand.showCard());
	}

}
