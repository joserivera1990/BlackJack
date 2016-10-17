package com.josecode.blackjack.message;

import com.josecode.blackjack.model.Card;

@FunctionalInterface
public interface Message {

	String getText(Card card);
	
}