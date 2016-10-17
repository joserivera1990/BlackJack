package com.josecode.blackjack.generator.impl;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

import com.josecode.blackjack.generator.Player;
import com.josecode.blackjack.model.Card;
import com.josecode.blackjack.model.Pair;
import com.josecode.blackjack.util.Stick;

public class PersonTest {

	@Test
	public void createDeckandGetCards() {
		Player player = new Person();
		player.specialCards(21, buildCardsPerson());
		//assertEquals(52, generateDeck.getCards().size());	
	}
	
	private Set<Card> buildCardsPerson() {
		Set<Card> cards = new LinkedHashSet<>();
		cards.add(new Card.CardBuilder(Stick.CLOVERS, Pair.of("A", 11)).build());
		cards.add(new Card.CardBuilder(Stick.CLOVERS, Pair.of("2", 2)).build());
		return cards;
	}
}
