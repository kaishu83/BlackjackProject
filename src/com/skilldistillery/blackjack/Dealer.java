package com.skilldistillery.blackjack;

import com.skilldistillery.common.Card;
import com.skilldistillery.common.Deck;

public class Dealer extends Player {

	Deck deck = new Deck();

	public Card drawCard() {
		return deck.dealCard();
	}

	public Card giveCard(Player p) {
		Card oneCard = drawCard();
		p.blackjackHand.addCard(oneCard);
		return oneCard;
	}

	public boolean to17(Dealer d) {

		int value = d.blackjackHand.getHandValue();
		while (value < 17) {
			d.blackjackHand.addCard(drawCard());
			value = d.blackjackHand.getHandValue();
		}
		if (value > 21)
			return true;
		return false;
	}

	public void newDeck() {
		deck.creatDeck();

	}

	public Card printFirstCard(Dealer d) {
		System.out.println("Dealer's 1st card is: " + d.blackjackHand.showCard());
		return d.blackjackHand.showCard();
	}

}
