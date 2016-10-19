package com.josecode.blackjack.generator.impl;

import java.util.Map;

import com.josecode.blackjack.generator.Deck;
import com.josecode.blackjack.generator.Judge;
import com.josecode.blackjack.generator.Player;

public final class SimpleJudge implements Judge {

	@Override
	public void startingCards(Player person,Player croupier,Deck deck) {
	    person.addCard(deck.nextRandomCard());   
        croupier.addCard(deck.nextRandomCard());
        person.addCard(deck.nextRandomCard());
        croupier.addCard(deck.nextRandomCard());
	}
	
	@Override
	public void giveWinner(Player person,Player croupier,Map<String, String> phrases) {	
		int sumCardsPerson = person.sumCards(person.getCards());
		System.out.println(phrases.get("sumPerson") + sumCardsPerson);
		int sumCardsCroupier = croupier.sumCards(croupier.getCards());
		System.out.println(phrases.get("sumCroupier") + sumCardsCroupier);
	    int diference = sumCardsPerson - sumCardsCroupier;
		
		if (diference == 0 || (sumCardsPerson > 21 && sumCardsCroupier > 21) ) {
			System.out.println(phrases.get("tie"));
	    } else if ((sumCardsPerson > 21 || diference < 0) && sumCardsCroupier <= 21) {
	    	System.out.println(phrases.get("winCroupier"));
	    } else {
	    	System.out.println(phrases.get("winPerson"));
	    }	    
	}
}
