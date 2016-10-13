package com.josecode.blackjack.model;

import com.josecode.blackjack.util.Stick;

public final class Card {

	private Stick stick;
	private String number;
	
	private Card(CardBuilder cardBuilder) {
		this.stick = cardBuilder.stick;
		this.number = cardBuilder.number;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((stick == null) ? 0 : stick.hashCode());
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
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (stick != other.stick)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [stick=" + stick + ", number=" + number + "]";
	}
	
	public Stick getStick() {
		return stick;
	}
	public String getNumber() {
		return number;
	}
	
	public static class CardBuilder {
		private Stick stick;
		private String number;

	    public CardBuilder(Stick stick, String number) {
	      this.stick = stick;
	      this.number = number;
	    }

	    public Card build() {
	      return new Card(this);
	    }

	  }
	
}
