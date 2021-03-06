package com.josecode.blackjack.model;

import java.util.Objects;

public final class Pair {
   
	private final String codeCard;

	private final Integer number;
    	
	private Pair(final String codeCard, final Integer number) {
		this.codeCard = codeCard;
		this.number = number;
	}
	
	public static Pair of(final String codeCard, final Integer number) {
		return new Pair(codeCard, number);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codeCard,number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (codeCard == null) {
			if (other.codeCard != null)
				return false;
		} else if (!codeCard.equals(other.codeCard))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	public String getCodeCard() {
		return codeCard;
	}
	public Integer getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return codeCard;
	}
}
