package com.josecode.blackjack.generator.impl;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.josecode.blackjack.message.Messages;
import com.josecode.blackjack.model.Card;

public final class Person extends AbstractPlayer implements  Messages {
	
	 Set<Card> cards;
	
	public Person() {
		cards = new LinkedHashSet<>();
	}
			
	@Override
	public boolean addCard(Card card) {
		cards.add(card);
		printText(card);
		int sumCards = sumCards(cards);
		if (sumCards == 21) {
			return true;
		} else if (sumCards > 21){
			return specialCards(21, cards);
		}
		return false;	
	}
		
	@Override
	public void printText(Card card) {
		System.out.println("Person -> "+ card);
	}
	
	@Override
	public Set<Card> getCards() {
		return  Collections.unmodifiableSet(cards);
	}
	
	@Override
	public void addAllCards(Set<Card> cards) {
		this.cards.addAll(cards);
	}
		
}
