package com.josecode.blackjack.message;

import com.josecode.blackjack.model.Card;

@FunctionalInterface
public interface Messages {

	String getText(Card card);
	
}