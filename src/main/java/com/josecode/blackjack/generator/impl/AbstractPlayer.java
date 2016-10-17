package com.josecode.blackjack.generator.impl;

import java.util.Set;

import com.josecode.blackjack.generator.Player;
import com.josecode.blackjack.model.Card;
import com.josecode.blackjack.model.Pair;

public abstract class AbstractPlayer implements Player {
    
    private static final String CARD_A = "A";
	
	@Override
	public int sumCards(Set<Card> cards) {
		return cards.stream().map(i->i.getValor().getNumber())
				.mapToInt(Integer::intValue)
				.sum();
	}
    	
	@Override
	public boolean specialCards(int numberValidate,Set<Card> cards) {
		boolean hasA = cards.stream().anyMatch(c->c.getValor().getCodeCard().
					equals(CARD_A) && c.getValor().getNumber() == 11);
		if (hasA) {
			Card cardForChange = getCardForChange(cards);
		    Card newCard = new Card.CardBuilder(cardForChange.getStick(), 
		    		Pair.of(CARD_A, 1))
		    		.build();
			cards.remove(cardForChange);
			cards.add(newCard);
			if (sumCards(cards) < numberValidate ) {
				return false;
			}
		} 
		return true;
	}
	
	
	private Card getCardForChange(Set<Card> cards) {
		return cards.stream()
				   .filter(c -> c.getValor().getCodeCard().equals(CARD_A) && c.getValor().getNumber() == 11)
				   .findFirst().get();
	}
}
