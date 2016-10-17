package com.josecode.blackjack.generator.impl;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.josecode.blackjack.message.Message;
import com.josecode.blackjack.model.Card;

public final class Croupier extends AbstractPlayer implements  Message {
   
	
	private Set<Card> cards;
	
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
		getText(card);
		return false;	
	}
		
	@Override
	public String getText(Card card) {
		//System.out.println("Coupier -> "+ card);
		if (cards.size() == 2) {
			System.out.println("Coupier -> "+ "XXXXXX");
		} else {
			System.out.println("Coupier -> "+ card);
		}
		return ""; 
	}
	
	@Override
	public Set<Card> getCards() {
		return Collections.unmodifiableSet(cards);
	}
	
	@Override
	public void addAllCards(Set<Card> cards) {
		this.cards.addAll(cards);
	}
}
