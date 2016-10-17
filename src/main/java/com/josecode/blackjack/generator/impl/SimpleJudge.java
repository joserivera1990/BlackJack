package com.josecode.blackjack.generator.impl;

import com.josecode.blackjack.generator.Deck;
import com.josecode.blackjack.generator.Judge;
import com.josecode.blackjack.generator.Player;

public class SimpleJudge implements Judge {

	@Override
	public void startingCards(Player person,Player croupier,Deck deck) {
	    person.addCard(deck.nextRandomCard());   
        croupier.addCard(deck.nextRandomCard());
        person.addCard(deck.nextRandomCard());
        croupier.addCard(deck.nextRandomCard());
	}
	
	@Override
	public void giveWinner(Player person,Player croupier) {	
		int sumCardsPerson = person.sumCards(person.getCards());
		System.out.println("Sumatoria Person: "+ sumCardsPerson);
		int sumCardsCroupier = croupier.sumCards(croupier.getCards());
		System.out.println("Sumatoria Croupier: "+ sumCardsCroupier);
	    int diference = sumCardsPerson - sumCardsCroupier;
		
		if (diference == 0 || (sumCardsPerson > 21 && sumCardsCroupier > 21) ) {
			System.out.println("!!!!EMPATE!!!!!");
	    } else if ((sumCardsPerson > 21 || diference < 0) && sumCardsCroupier <= 21) {
	    	System.out.println("!!!!!!GANA CROUPIER!!!!!");
	    } else {
	    	System.out.println("!!!!!!GANA JUGADOR!!!!!!");
	    }	    
	}
}
