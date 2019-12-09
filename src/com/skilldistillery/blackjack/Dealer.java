package com.skilldistillery.blackjack;

import com.skilldistillery.common.Card;
import com.skilldistillery.common.Deck;

public class Dealer extends Player {

	private Deck deck;

	public Card drawCard() {
		return deck.dealCard();
	}

	public Card giveCard(Player p) {
		Card oneCard = drawCard();
		p.blackjackHand.addCard(oneCard);
		return oneCard;
	}

	public void to17(Dealer d) {
		
		int value = d.blackjackHand.getHandValue();
	
		while (value < 17) {
			d.blackjackHand.addCard(drawCard());
			value = d.blackjackHand.getHandValue();
		}
		
	}

	public void newDeck() {
		deck.creatDeck();

	}

	public Card printFirstCard(Dealer d) {
		System.out.println("Dealer's 1st card is: " + d.blackjackHand.showCard());
		return d.blackjackHand.showCard();
	}

}
