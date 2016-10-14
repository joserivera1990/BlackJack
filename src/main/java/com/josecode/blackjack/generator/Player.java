package com.josecode.blackjack.generator;

import com.josecode.blackjack.model.Card;

public interface Player {
    
	int tellSumCards();
	
	boolean automaticallyPlant();
	
	boolean addCard(Card card);
}
