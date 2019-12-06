package com.skilldistillery.blackjack;

import com.skilldistillery.common.Card;
import com.skilldistillery.common.Hand;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {

		int totalValue = 0;
		for (Card card : cardsInHand) {
			totalValue += card.getValue();
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

	public boolean isBust() {
		if(getHandValue()>21) return true;
		return false;
				}
}
