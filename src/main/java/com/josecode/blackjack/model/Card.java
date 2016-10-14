package com.josecode.blackjack.model;

import com.josecode.blackjack.util.Stick;

public final class Card {

	private Stick stick;
	private Pair valor;
	
	public Stick getStick() {
		return stick;
	}


	public Pair getValor() {
		return valor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (stick != other.stick)
			return false;
		return true;
	}


	private Card(CardBuilder cardBuilder) {
		this.stick = cardBuilder.stick;
		this.valor = cardBuilder.number;
	}
	

	@Override
	public String toString() {
		return stick + " " + valor;
	}
	

	
	public static class CardBuilder {
		private Stick stick;
		private Pair number;

	    public CardBuilder(Stick stick, Pair number) {
	      this.stick = stick;
	      this.number = number;
	    }

	    public Card build() {
	      return new Card(this);
	    }

	  }
	
}
