package com.josecode.blackjack.generator.impl;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.josecode.blackjack.message.Messages;
import com.josecode.blackjack.model.Card;

public final class Croupier extends AbstractPlayer implements  Messages {
   
	
	Set<Card> cards;
	
	public Croupier() {
		cards = new LinkedHashSet<>();
	}
		
	@Override
	public boolean addCard(Card card) {
		int sumCards = sumCards(cards);
		if (sumCards >= 17 && sumCards <= 21 ) {
			return true;
		} else if (sumCards > 21) {
			return specialCards(17, cards);
		}
		cards.add(card);
		printText(card);
		return false;	
	}
		
	@Override
	public void printText(Card card) {
		if (cards.size() == 2) {
			System.out.println("Coupier -> "+ "XXXXXX");
		} else {
			System.out.println("Coupier -> "+ card);
		}
	}
	
	@Override
	public Set<Card> getCards() {
		return Collections.unmodifiableSet(cards);
	}
	
}
