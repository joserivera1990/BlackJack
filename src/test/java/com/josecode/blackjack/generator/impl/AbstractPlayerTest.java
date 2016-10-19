package com.josecode.blackjack.generator.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.josecode.blackjack.model.Card;
import com.josecode.blackjack.model.Pair;
import com.josecode.blackjack.util.Stick;

public class AbstractPlayerTest {

	@Test
	public void changeCardAfromoElevenToOne() {
		Person person = new Person();
		Set<Card> setCards = buildCards();
		person.cards = setCards;
		person.specialCards(21, setCards);
		assertEquals(1, person.cards.stream().skip(1).findFirst().get().getValor().getNumber().intValue());	
	}
	
	@Test
	public void noChangeCards() {
		Person person = new Person();
		Set<Card> setCards = buildCardsOne();
		person.cards = setCards;
		person.specialCards(21, setCards);
		assertEquals(7, person.cards.stream().skip(0).findFirst().get().getValor().getNumber().intValue());
		assertEquals(10, person.cards.stream().skip(1).findFirst().get().getValor().getNumber().intValue());	
	}
	
	private Set<Card> buildCards() {
		Set<Card> cards = new LinkedHashSet<>();
		cards.add(new Card.CardBuilder(Stick.CLOVERS, Pair.of("A", 11)).build());
		cards.add(new Card.CardBuilder(Stick.CLOVERS, Pair.of("2", 2)).build());
		return cards;
	}
	
	private Set<Card> buildCardsOne() {
		Set<Card> cards = new LinkedHashSet<>();
		cards.add(new Card.CardBuilder(Stick.CLOVERS, Pair.of("7", 7)).build());
		cards.add(new Card.CardBuilder(Stick.CLOVERS, Pair.of("J", 10)).build());
		return cards;
	}
}
