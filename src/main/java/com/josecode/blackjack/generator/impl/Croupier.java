package com.josecode.blackjack.generator.impl;

import java.util.HashSet;
import java.util.Set;

import com.josecode.blackjack.generator.Player;
import com.josecode.blackjack.model.Card;

public final class Croupier implements Player {
   
	
	private Set<Card> card;
	
	public Croupier() {
		card = new HashSet<>();
	}
	
	@Override
	public int tellSumCards() {
		return 0;		
	}
	
	@Override
	public boolean automaticallyPlant() {
		return false;
	}
}
