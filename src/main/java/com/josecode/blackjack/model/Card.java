package com.josecode.blackjack.model;

import java.util.Objects;

import com.josecode.blackjack.util.Stick;

public final class Card {

	private final Stick stick;
	private final Pair valor;
	
	public Stick getStick() {
		return stick;
	}


	public Pair getValor() {
		return valor;
	}
  
	@Override
	public int hashCode() {
		return Objects.hash(valor,stick);
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
