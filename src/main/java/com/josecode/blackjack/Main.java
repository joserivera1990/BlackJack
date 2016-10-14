package com.josecode.blackjack;

import java.io.IOException;

import com.josecode.blackjack.generator.Deck;
import com.josecode.blackjack.generator.Player;
import com.josecode.blackjack.generator.impl.Croupier;
import com.josecode.blackjack.generator.impl.Person;
import com.josecode.blackjack.generator.impl.SimpleDeck;
import com.josecode.blackjack.model.Card;
import com.josecode.blackjack.properties.Configuration;

public final class Main {

	private Main(){
		throw new AssertionError("The class Main can not be instantied");
	}
	
	public static void main(String[] args) {
        try {
			Configuration conf = new Configuration();
			Deck generator = new SimpleDeck(conf.getValues());
			System.out.println("d");
			Card firstPlayer = generator.nextRandomCard();
			System.out.println("Card player = " + firstPlayer);
	        Player player = new Person();
	        player.addCard(firstPlayer);
	        Player croupier = new Croupier();
			//Card firstCroupier = generator.nextRandomCard();
			//System.out.println("Card croupier = " + firstCroupier);
	        //croupier.addCard(firstCroupier);
	        player.addCard(generator.nextRandomCard());
	        //croupier.addCard(generator.nextRandomCard());
	        while (!player.addCard(generator.nextRandomCard())) {
	        	
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
