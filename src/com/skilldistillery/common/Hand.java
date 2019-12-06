package com.skilldistillery.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cardsInHand = new ArrayList<>();
	

	public void addCard(Card card) {
		cardsInHand.add(card);
	}

	public void clear() {
		cardsInHand.clear();
	}

	public  abstract int getHandValue();

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cardsInHand.size(); i++) {

			sb.append(
					"You No." + i + " card: " + cardsInHand.get(i).getValue() + " of " + cardsInHand.get(i).toString());
		}

		return sb.toString();

	}

}
