package com.josecode.blackjack.generator.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

import com.josecode.blackjack.generator.Judge;
import com.josecode.blackjack.generator.Player;
import com.josecode.blackjack.model.Card;
import com.josecode.blackjack.model.Pair;
import com.josecode.blackjack.util.Stick;

public class SimpleJudgeTest {
    
	@Test
	public void createDeckandGetCards() {
		Judge judge = new SimpleJudge();
		judge.giveWinner(buildCardsPerson(), buildCardsCroupier());
		//assertEquals(52, generateDeck.getCards().size());	
	}
	
	private Player buildCardsPerson() {
		Player person = new Person();
		Set<Card> cards = new LinkedHashSet<>();
		cards.add(new Card.CardBuilder(Stick.CLOVERS, Pair.of("10", 10)).build());
		cards.add(new Card.CardBuilder(Stick.CLOVERS, Pair.of("A", 11)).build());
		person.addAllCards(cards);
		return person;
	}
	
	private Player buildCardsCroupier() {
		Player croupier = new Croupier();
		Set<Card> cards = new LinkedHashSet<>();
		cards.add(new Card.CardBuilder(Stick.CLOVERS, Pair.of("A", 11)).build());
		cards.add(new Card.CardBuilder(Stick.CLOVERS, Pair.of("9", 9)).build());
		croupier.addAllCards(cards);
		return croupier;
	}
}
