package com.josecode.blackjack.generator.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import com.josecode.blackjack.generator.Player;
import com.josecode.blackjack.model.Card;

public final class Person implements Player{
	
	private Set<Card> cards;
	
	
	public Person() {
		cards = new LinkedHashSet<>();
	}
	
	@Override
	public int tellSumCards() {
		return 0;
		
	}
	
	@Override
	public boolean automaticallyPlant() {
		return false;
	}
	
	@Override
	public boolean addCard(Card card) {
		cards.add(card);
		int sum = cards.stream().map(i->i.getValor().getNumber())
								.mapToInt(Integer::intValue)
								.sum();
		System.out.println("sum"+sum);
		if (sum == 21 || sum > 21 ) {
			return true;
		} 
		return false;	
	}
}
