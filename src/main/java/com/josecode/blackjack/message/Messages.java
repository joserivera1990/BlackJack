package com.josecode.blackjack.message;

import com.josecode.blackjack.model.Card;

@FunctionalInterface
public interface Messages {

	void printText(Card card);
	
}