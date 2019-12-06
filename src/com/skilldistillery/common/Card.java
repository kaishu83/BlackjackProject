package com.skilldistillery.common;

public class Card {
	private Suit s;
	private Rank r;

	public Card(Suit s, Rank r) {
		this.s = s;
		this.r = r;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((r == null) ? 0 : r.hashCode());
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (r != other.r)
			return false;
		if (s != other.s)
			return false;
		return true;
	}

	public String toString() {
		return r + " of " + s;
	}
	
	public int getValue() {
		return r.getValue();
	}

}
