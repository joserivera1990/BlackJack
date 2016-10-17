package com.josecode.blackjack.generator.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.josecode.blackjack.generator.Deck;
import com.josecode.blackjack.model.Card;
import com.josecode.blackjack.model.Pair;
import com.josecode.blackjack.util.Stick;
import com.josecode.blackjack.util.Util;

public final class SimpleDeck implements Deck {

	private Set<Card> cards;
	
	public SimpleDeck(List<Pair> listValues) {
		cards = new LinkedHashSet<>();
		this.createDeck(listValues);
	}
	
	@Override
	public Card nextRandomCard() {
		Card cardRandom = cards.stream().skip(Util.randomInt(cards.size()))
				.findFirst().get();
		cards.remove(cardRandom);
		return cardRandom;
	}
		
    private void createDeck(List<Pair> listValues) {
		for (Pair number : listValues) {
			for (Stick stick : Stick.values()) {
				cards.add(new Card.CardBuilder(stick, number).build());
			}	
		}
	}
    
    @Override
	public Set<Card> getCards() {
		return cards;
	}
	
}
