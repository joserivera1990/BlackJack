package com.josecode.blackjack.generator.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.josecode.blackjack.generator.Deck;
import com.josecode.blackjack.model.Card;
import com.josecode.blackjack.util.Stick;
import com.josecode.blackjack.util.Util;

public final class SimpleDeck implements Deck {

	private Set<Card> cards;
	private static final Set<String> NUMBER_CARDS = new HashSet<>(Arrays.asList("A","2","3","4","5","6","7","8","9","10","Q","J","K"));
	
	
	public SimpleDeck() {
		cards = new LinkedHashSet<>();
		this.createDeck();
	}
	
	@Override
	public Card nextRandomCard() {
		Card cardRandom = cards.stream().skip(Util.randomInt(cards.size())).findFirst().get();
		cards.remove(cardRandom);
		return cardRandom;
	}
		
    private void createDeck() {
		for (String numberCards : NUMBER_CARDS) {
			for (Stick stick : Stick.values()) {
				cards.add(new Card.CardBuilder(stick, numberCards).build());
			}	
		}
	}
    
    @Override
	public Set<Card> getCards() {
		return cards;
	}
	
}
