package com.skilldistillery.blackjack;

import com.skilldistillery.common.Card;
import com.skilldistillery.common.Hand;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		int aces = hasSoftAce();
		int totalValue = 0;
		for (Card card : cardsInHand) {
			totalValue += card.getValue();
		}
		if (aces == 1 && totalValue > 21) {
			totalValue = totalValue - 10;
		}

		else if (aces == 2 && totalValue - 10 > 21) {
			totalValue = totalValue - 20;
		} else if (aces == 3 && totalValue - 20 > 21) {
			totalValue = totalValue - 30;
		} else if (aces == 4 && totalValue - 30 > 21) {
			totalValue = totalValue - 40;
		}
		return totalValue;
	}

	public boolean isBlackjack() {

		if (cardsInHand.get(0).getValue() == 11 && cardsInHand.get(1).getValue() == 10)
			return true;
		else if (cardsInHand.get(0).getValue() == 10 && cardsInHand.get(1).getValue() == 11)
			return true;
		return false;

	}

	public Card showCard() {

		return cardsInHand.get(0);

	}

	public boolean isBust() {
		if (getHandValue() > 21)
			return true;
		return false;
	}

	public int hasSoftAce() {
		int a = 0;
		for (Card card : cardsInHand) {
			if (card.getValue() == 11) {
				a++;
			}
		}

		return a;
	}
}
