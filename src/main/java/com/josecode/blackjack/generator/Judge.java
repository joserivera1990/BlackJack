package com.josecode.blackjack.generator;

import java.util.Map;

public interface Judge {

	void startingCards(Player person,Player croupier,Deck deck);
	
	void giveWinner(Player person,Player croupier,Map<String, String> phrases);
}
