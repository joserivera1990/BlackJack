package com.josecode.blackjack.generator;

import org.junit.Test;

import com.josecode.blackjack.generator.impl.SimpleDeck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeckTest {
   	
	@Test
	public void createDeckandGetCards() {
		Deck generateDeck = new SimpleDeck();
		assertEquals(52, generateDeck.getCards().size());	
	}
	
	@Test
	public void getRandomCard() {
		Deck generateDeck = new SimpleDeck();
		assertNotNull(generateDeck.nextRandomCard());
	}
}
