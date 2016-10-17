package com.josecode.blackjack.generator;

import java.util.Set;

import com.josecode.blackjack.model.Card;

public interface Player {
    	
	boolean addCard(Card card);
	
	int sumCards(Set<Card> cards);
	
	Set<Card> getCards();
	
	boolean specialCards(int numberValidate,Set<Card> cards);
	
	void addAllCards(Set<Card> cards);
}
