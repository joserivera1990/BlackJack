package com.josecode.blackjack.generator;

import java.util.Set;

import com.josecode.blackjack.model.Card;

public interface Deck {
 
	  Card nextRandomCard();
	  Set<Card> getCards();
}
