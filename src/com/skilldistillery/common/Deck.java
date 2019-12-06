package com.skilldistillery.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cardList = new ArrayList<>(52);

	public Deck() {
		creatDeck();

	}
	public List<Card> creatDeck(){
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cardList.add(new Card(s, r));
			}
		}
		return cardList;
	}

	public int checkDeckSize() {
		return cardList.size();
	}

	public Card dealCard() {
		return cardList.remove(0);
	}

	public void wash() {
		Collections.shuffle(cardList);
	}
}
