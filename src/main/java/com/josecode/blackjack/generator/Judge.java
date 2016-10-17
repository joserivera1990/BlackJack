package com.josecode.blackjack.generator;

public interface Judge {

	void startingCards(Player person,Player croupier,Deck deck);
	
	void giveWinner(Player person,Player croupier);
}
