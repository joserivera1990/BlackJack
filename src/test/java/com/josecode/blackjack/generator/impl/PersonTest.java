package com.josecode.blackjack.generator.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.josecode.blackjack.model.Card;
import com.josecode.blackjack.model.Pair;
import com.josecode.blackjack.util.Stick;

public class PersonTest {

	@Test
	public void createDeckandGetCards() {
		Person person = new Person();
		person.addCard(new Card.CardBuilder(Stick.CLOVERS, Pair.of("A", 11)).build());
		assertEquals(11, person.getCards().stream().skip(0).findFirst().get().getValor().getNumber().intValue());
		assertEquals("A", person.getCards().stream().skip(0).findFirst().get().getValor().getCodeCard());	
	}
	
}
